package model.calculo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.FormatoEmpleadoException;
import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionC;
import model.entities.Empleado;
import model.entities.ResultadoDeCalculo;
import model.entities.TopeSalarial;
import model.entities.WsAux;
import model.excel.ReadExcel;
import model.excel.WriteExcel;
import persistencia.HibernateApplication;
import persistencia.Actions.Action;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.EmpleadoHibernateHome;
import persistencia.hibernateHome.HibernateHome;
import persistencia.hibernateHome.WsAuxHibernateHome;
import wsClient.ClienteOperix;

public class ActionCalculoAutomatico implements Action {

	private ReadExcel read = new ReadExcel();
	private EmpleadoHibernateHome homeEmpleado;
	private List<Empleado> listaDeEmpleados;
	private HibernateHome<ResultadoDeCalculo> homeDeResultados;
	private DeduccionA deduccionA;
	private DeduccionC deduccionC;
	private TopeSalarial tope;
	private CamposParaCalculoAnual calculo_anual;
	private CamposParaCalculoAnualHibernateHome calculo_anual_home;
	private WsAuxHibernateHome homeWs; //TODO borrar home
	private String ruta;
	private float rnif;
	private int mesActual;

	public ActionCalculoAutomatico(String ruta) throws SecurityException,
			IOException, FormatoEmpleadoException, NoSuchMethodException {
		super();
		this.ruta = ruta;
	}

	@Override
	public void execute() {
		this.homeEmpleado = (EmpleadoHibernateHome) HibernateApplication
				.getInstance().getHome(Empleado.class);
		this.homeDeResultados = (HibernateHome<ResultadoDeCalculo>) HibernateApplication
				.getInstance().getHome(ResultadoDeCalculo.class);
		this.calculo_anual_home = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		HibernateHome<DeduccionA> temporal = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		this.deduccionA = temporal.getFirst();
		HibernateHome<DeduccionC> temporal2 = (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		this.deduccionC = temporal2.getFirst();
		HibernateHome<TopeSalarial> temporal3 = (HibernateHome<TopeSalarial>) HibernateApplication
				.getInstance().getHome(TopeSalarial.class);
		this.tope = temporal3.getFirst();
		//TODO borrar home
		this.homeWs =(WsAuxHibernateHome) HibernateApplication.getInstance().getHome(WsAux.class);
		this.proceso(this.ruta);
	}

	public void proceso(String ruta) {
		List<Empleado> empleados = read.leerArchivo(ruta);
		for (Empleado e : empleados) {
			homeEmpleado.agregar(e);
		}
		this.generarResultados();
		WriteExcel w = new WriteExcel(homeDeResultados.getAllEntities());
		w.write();
		if (read.getCuilSinProcesar().size() > 0) {
			generarLog();
		}
		this.limpiarTablas();
	}

	private void generarLog() {
		File f;
		f = new File(System.getProperty("user.home") + File.separator
				+ "ImpuestoALasGananciasLog.txt");

		// Escritura
		try {
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write("Empleados que no fueron encontrados en operix, por favor verifique el nro de cuil.\n");// escribimos
			for (String s : read.getCuilSinProcesar()) {
				wr.append(" " + s + "\n");
			}
			wr.close();
			bw.close();
		} catch (IOException e) {
		}
		;
	}

	private void generarResultados() {
		listaDeEmpleados = homeEmpleado.getAllEntities();
		for (Empleado e : listaDeEmpleados) {
			ResultadoDeCalculo r = new ResultadoDeCalculo();
			r.setCUIL(e.getCUIL());
			r.setNom_y_ape(e.getNom_y_ape());
			this.actualizarWS(e);
			//valido si esta por debejo o no de los topes minimos
			if ((e.getEstad_civil() == 0 
					&& e.getRem_net_imp() <= tope.getSoltero())
				|| (e.getEstad_civil() == 1 
					&& e.getRem_net_imp() <= tope.getCasado())) {
				r.setGananciaA(0);
				r.setGananciaB(0);
				r.setGananciaC(0);
				r.setImp_ganan_periodo(0);
				r.setImp_ganan_a_pagar_mes(0);
				r.setDev_IIGG(0);
			//si esta por encima de los topes...
			} else {
				r.setGananciaA(gananciaNetaA(e));
				r.setGananciaB(gananciaNetaB(e));
				r.setGananciaC(gananciaNetaC(e));
				r.setImp_ganan_periodo(impuestoAPagarEnElAnio(e));
				//si no efectuo ningun pago anterior paga el impuesto y la devolucion es 0
				float impuestoAPagarPorMes = impuestoAPagarPorMes(e);
				if(e.getTot_pag_ant_temp()<=0){
					if (impuestoAPagarPorMes >= 0) {
						r.setImp_ganan_a_pagar_mes(impuestoAPagarPorMes);
						r.setDev_IIGG(0);
					} else {
						r.setImp_ganan_a_pagar_mes(0);
						r.setDev_IIGG(0);
					}
				}
				//si efectuo pagos anteriores
				else{
					//si no hay devolucion
					if (impuestoAPagarPorMes >= 0) {
						r.setImp_ganan_a_pagar_mes(impuestoAPagarPorMes);
						r.setDev_IIGG(0);
					//si hay devolucion comparo y actualizo valores
					} else {
						r.setImp_ganan_a_pagar_mes(0);
						WsAux ws = homeWs.getByCuil(e.getCUIL());
						if(e.getTot_pag_ant_temp()<(impuestoAPagarPorMes * -1)){
							r.setDev_IIGG(e.getTot_pag_ant_temp());
							e.setTot_pag_ant_temp(0);
							//Actualizar aqui el ws. 
							//TODO descomentar
							//ClienteOperix.actualizarPagosAnteriores(e.getCUIL(), 0);
							ws.setTot_pag_ant_temp(0);
							homeWs.actualizar(ws);
						}
						else{
							r.setDev_IIGG((impuestoAPagarPorMes * -1));
							e.setTot_pag_ant_temp(e.getTot_pag_ant_temp() + impuestoAPagarPorMes);
							//TODO descomentar cdo funcione el ws
							//ClienteOperix.actualizarPagosAnteriores(e.getCUIL(),(e.getTot_pag_ant_temp() + impuestoAPagarPorMes));
							ws.setTot_pag_ant_temp((e.getTot_pag_ant_temp() + impuestoAPagarPorMes));
							homeWs.actualizar(ws);
						}
						
					}
				}
			}
			homeDeResultados.agregar(r);
		}
	}

	private void limpiarTablas() {
		homeEmpleado.deleteAllEntities();
		homeDeResultados.deleteAllEntities();
	}

	// Metodos para el calculo
	private void actualizarWS(Empleado e){
		this.rnif = e.getRem_net_imp_acum_temp() + e.getRem_net_imp();
		//ClienteOperix.actualizarRemNetAcum(e.getCUIL(), (int)this.rnif);
		WsAux ws = homeWs.getByCuil(e.getCUIL());
		ws.setRem_net_imp_acum_temp(rnif);
		homeWs.actualizar(ws);
	}
	public float gananciaNetaA(Empleado e) {
		return this.getRnif() - this.deduccionesA(e);
	}

	private float deduccionesA(Empleado e) {
		//TODO para cambiar la fecha
		int mesActual = 1;
		//int mesActual = new Date().getMonth() + 1;
		float retorno = this.getDeduccionA().getMin_no_imp()
				+ this.getDeduccionA().getDedu_espe()
				+ this.calculoConyuge(e)
				+ (this.getDeduccionA().getHijos() * e.getCant_hij_anual())
				+ this.calculoPropHijos(e)
				+ (this.getDeduccionA().getOtros() * e
						.getCant_pers_a_carg_anual())
				+ calculoPersACargoProp(e) + e.getGast_sepe() + e.getSeg_vida()
				+ e.getServ_dom() + e.getInt_cred_hip();
		return (retorno / 12) * mesActual;
	}

	private float calculoConyuge(Empleado e) {
		if (e.getEstad_civil() == 1) {
			if (e.getMes_cas() == 0) {
				return this.getDeduccionA().getConyuge();
			} else {
				return (this.getDeduccionA().getConyuge() / 12)
						- (e.getMes_cas() - 1);
			}
		}
		return 0;
	}

	// ivn de representacion: si el valor de los hijos no es cargado, se
	// guardara como =0;
	private float calculoPropHijos(Empleado e) {
		float retorno = 0;
		if (e.getMes_nac_hij_1() != 0) {
			retorno += this.propHijosAux(e.getMes_nac_hij_1(),
					e.getCant_hij_nac_1());
		}
		if (e.getMes_nac_hij_2() != 0) {
			retorno += this.propHijosAux(e.getMes_nac_hij_2(),
					e.getCant_hij_nac_2());
		}
		if (e.getMes_baja_hij_1() != 0) {
			retorno += this.propHijosAux2(e.getMes_baja_hij_1(),
					e.getCant_hij_baja_1());
		}
		if (e.getMes_baja_hij_2() != 0) {
			retorno += this.propHijosAux2(e.getMes_baja_hij_2(),
					e.getCant_hij_baja_2());
		}
		return retorno;
	}

	private float propHijosAux(int mesNacimiento, int cantHijosNacidos) {
		return ((this.getDeduccionA().getHijos() / 12) * (12 - (mesNacimiento - 1)))
				* cantHijosNacidos;
	}

	private float propHijosAux2(int mesBaja, int cantHijosBaja) {
		return ((this.getDeduccionA().getHijos() / 12) * mesBaja)
				* cantHijosBaja;
	}

	private float calculoPersACargoProp(Empleado e) {
		float retorno = 0;
		if (e.getMes_alta_pers_a_carg_1() != 0) {
			retorno += this.personasACargoAux(e.getMes_alta_pers_a_carg_1(),
					e.getCant_pers_a_carg_1());
		}
		if (e.getMes_alta_pers_a_carg_2() != 0) {
			retorno += this.personasACargoAux(e.getMes_alta_pers_a_carg_2(),
					e.getCant_pers_a_carg_2());
		}
		if (e.getMes_baja_pers_a_carg_1() != 0) {
			retorno += this.personasACargoAux(e.getMes_baja_pers_a_carg_1(),
					e.getCant_pers_a_carg_baja_1());
		}
		if (e.getMes_baja_pers_a_carg_2() != 0) {
			retorno += this.personasACargoAux2(e.getMes_baja_pers_a_carg_2(),
					e.getCant_pers_a_carg_baja_2());
		}
		return retorno;
	}

	private float personasACargoAux(int mes, int cant) {
		return (this.getDeduccionA().getOtros() / 12) * (12 - (mes - 1)) * cant;
	}

	private float personasACargoAux2(int mes, int cant) {
		return (this.getDeduccionA().getOtros() / 12) * mes * cant;
	}

	// ganancia neta B

	public float gananciaNetaB(Empleado e) {
		return this.gananciaNetaA(e) - this.auxGananciaNetaB(e);
	}

	private float auxGananciaNetaB(Empleado e) {
		return (((this.getDeduccionC().getCout_med_asist_anu() * e
				.getCuot_med_asist()) / 100) + ((e.getDonac() * this
				.getDeduccionC().getDonac_anu()) / 100));
	}

	// ganancia neta

	public float gananciaNetaC(Empleado e) {
		return this.gananciaNetaB(e) - this.auxGananciaNetaC(e);
	}

	public float auxGananciaNetaC(Empleado e) {
		return ((e.getHonor_med() * this.getDeduccionC().getHonor_med_anu()) / 100)
				+ (((e.getImp_cheq_cred()) * this.getDeduccionC()
						.getDeb_total_imp_cheq_cred_anu()) / 100);

	}

	// impuesto a pagar en el año
	public float impuestoAPagarEnElAnio(Empleado e) {
		this.calculo_anual = this.calculo_anual_home.getByInRango(this
				.gananciaNetaC(e));
		return (this.getCalculo_anual().getBase() + ((this.getCalculo_anual()
				.getPor_extra() * (this.gananciaNetaC(e) - this
				.getCalculo_anual().getSobre_exced())) / 100))
				- this.auxImpAPagarAnio(e);
	}

	private float auxImpAPagarAnio(Empleado e) {
		//int mesActual = (new Date()).getMonth() + 1;
		//TODO 
		int mesActual = 1;
		return (e.getDev_compra_exter() / 12) * mesActual;
	}

	// impuesto a pagar por mes
	public float impuestoAPagarPorMes(Empleado e) {
		return this.impuestoAPagarEnElAnio(e) - e.getTot_pag_ant_temp();
	}

	// GET&SET
	public float getRnif() {
		return rnif;
	}

	public void setRnif(float rnif) {
		this.rnif = rnif;
	}

	public ReadExcel getRead() {
		return read;
	}

	public void setRead(ReadExcel read) {
		this.read = read;
	}

	public EmpleadoHibernateHome getHomeEmpleado() {
		return homeEmpleado;
	}

	public void setHomeEmpleado(EmpleadoHibernateHome homeEmpleado) {
		this.homeEmpleado = homeEmpleado;
	}

	public List<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public void setListaDeEmpleados(List<Empleado> listaDeEmpleados) {
		this.listaDeEmpleados = listaDeEmpleados;
	}

	public HibernateHome<ResultadoDeCalculo> getHomeDeResultados() {
		return homeDeResultados;
	}

	public void setHomeDeResultados(
			HibernateHome<ResultadoDeCalculo> homeDeResultados) {
		this.homeDeResultados = homeDeResultados;
	}

	public DeduccionA getDeduccionA() {
		return deduccionA;
	}

	public void setDeduccionA(DeduccionA deduccionA) {
		this.deduccionA = deduccionA;
	}

	public DeduccionC getDeduccionC() {
		return deduccionC;
	}

	public void setDeduccionC(DeduccionC deduccionC) {
		this.deduccionC = deduccionC;
	}

	public CamposParaCalculoAnual getCalculo_anual() {
		return calculo_anual;
	}

	public void setCalculo_anual(CamposParaCalculoAnual calculo_anual) {
		this.calculo_anual = calculo_anual;
	}

	public CamposParaCalculoAnualHibernateHome getCalculo_anual_home() {
		return calculo_anual_home;
	}

	public void setCalculo_anual_home(
			CamposParaCalculoAnualHibernateHome calculo_anual_home) {
		this.calculo_anual_home = calculo_anual_home;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
