package model.calculo;

import java.util.Date;

import persistencia.HibernateApplication;
import persistencia.Actions.Action;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.HibernateHome;

import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionC;
import model.entities.Empleado;

public class CalculoAutomatico implements Action{
	
	private Empleado empleado;
	private float rnif;
	private DeduccionA deduccionA;
	private DeduccionC deduccionC;
	private CamposParaCalculoAnual calculo_anual;
	private CamposParaCalculoAnualHibernateHome calculo_anual_home;


	//constructor	
	public CalculoAutomatico() {
		super();
	}

	public CalculoAutomatico(Empleado empleado) {
		super();
		this.empleado = empleado;
		this.rnif = this.empleado.getRem_net_imp() + this.getEmpleado().getRem_net_imp_acum_temp();
	;


	}
	//metodos

	@Override
	public void execute() {
		calculo_anual_home = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);
		HibernateHome<DeduccionA> temporal = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		this.deduccionA = temporal.getFirst();
		HibernateHome<DeduccionC> temporal2 = (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		this.deduccionC = temporal2.getFirst();
		
	}
	//ganancia neta A
	public float gananciaNetaA(){
		return this.getRnif() - this.deduccionesA();
	}
	
	private float deduccionesA(){
		int mesActual= new Date().getMonth() + 1 ;
		float retorno = this.getDeduccionA().getMin_no_imp() 
						+ this.getDeduccionA().getDedu_espe() 
						+ this.calculoConyuge()
						+ (this.getDeduccionA().getHijos() * this.getEmpleado().getCant_hij_anual())
						* this.calculoPropHijos()
						+ (this.getDeduccionA().getOtros() * this.getEmpleado().getCant_pers_a_carg_anual())
						+ calculoPersACargoProp()
						+ this.getEmpleado().getGast_sepe()
						+ this.getEmpleado().getSeg_vida()
						+ this.getEmpleado().getServ_dom()
						+ this.getEmpleado().getInt_cred_hip();
		return(retorno/12)*mesActual;
	}
	

	private float calculoConyuge() {
		if(this.getEmpleado().getEstad_civil()==1){
			if(this.getEmpleado().getMes_cas()==0){
				return this.getDeduccionA().getConyuge();
			}
			else{
				return (this.getDeduccionA().getConyuge()/12) - (this.getEmpleado().getMes_cas()-1);
			}
		}
		return 0;
	}
	//ivn de representacion: si el valor de los hijos no es cargado, se guardara como =0;
	private float calculoPropHijos() {
		float retorno = 0; 
		if(this.getEmpleado().getMes_nac_hij_1() != 0){
			retorno += this.propHijosAux(this.getEmpleado().getMes_nac_hij_1(), this.getEmpleado().getCant_hij_nac_1());
		}
		if(this.getEmpleado().getMes_nac_hij_2() != 0){
			retorno += this.propHijosAux(this.getEmpleado().getMes_nac_hij_2(), this.getEmpleado().getCant_hij_nac_2());
		}
		if(this.getEmpleado().getMes_baja_hij_1() !=0){
			retorno += this.propHijosAux2(this.getEmpleado().getMes_baja_hij_1(), this.getEmpleado().getCant_hij_baja_1());
		}
		if(this.getEmpleado().getMes_baja_hij_2() !=0){
			retorno += this.propHijosAux2(this.getEmpleado().getMes_baja_hij_2(), this.getEmpleado().getCant_hij_baja_2());
		}
		return retorno;
	}

	private float propHijosAux(int mesNacimiento, int cantHijosNacidos){
		return ((this.getDeduccionA().getHijos()/12) * (mesNacimiento - 1)) * cantHijosNacidos; 
	}
	
	private float propHijosAux2(int mesBaja, int cantHijosBaja){
		return ((this.getDeduccionA().getHijos()/12) * mesBaja)*cantHijosBaja;
	}
	
	private float calculoPersACargoProp() {
		float retorno  = 0;
		if(this.getEmpleado().getMes_alta_pers_a_carg_1() != 0){
			retorno += this.personasACargoAux(this.getEmpleado().getMes_alta_pers_a_carg_1(), this.getEmpleado().getCant_pers_a_carg_1());
		}
		if(this.getEmpleado().getMes_alta_pers_a_carg_2() != 0){
			retorno += this.personasACargoAux(this.getEmpleado().getMes_alta_pers_a_carg_2(), this.getEmpleado().getCant_pers_a_carg_2());
		}
		if(this.getEmpleado().getMes_baja_pers_a_carg_1() != 0){
			retorno += this.personasACargoAux(this.getEmpleado().getMes_baja_pers_a_carg_1(), this.getEmpleado().getCant_pers_a_carg_baja_1());
		}
		if(this.getEmpleado().getMes_baja_pers_a_carg_2() != 0){
			retorno += this.personasACargoAux2(this.getEmpleado().getMes_baja_pers_a_carg_2(), this.getEmpleado().getCant_pers_a_carg_baja_2());
		}
		return retorno;
	}
	
	private float personasACargoAux(int mes,int cant){
		return (this.getDeduccionA().getOtros()/12)*(12-(mes-1))*cant;
	}
	
	private float personasACargoAux2(int mes,int cant){
		return (this.getDeduccionA().getOtros()/12) * mes *cant;
	}

	//ganancia neta B

	public float gananciaNetaB(){
		return this.gananciaNetaA()-this.auxGananciaNetaB();
	}
	
	private float auxGananciaNetaB(){
		return (this.getDeduccionC().getCout_med_asist_anu()* this.getEmpleado().getCuot_med_asist()) 
				+ ((this.getEmpleado().getDonac() * this.getDeduccionC().getDonac_anu())/100);
	}
		
	//ganancia neta
	
	public float gananciaNetaC(){
		return this.gananciaNetaB() - this.auxGananciaNetaC();
	}
	
	public float auxGananciaNetaC(){
		return (this.getEmpleado().getHonor_med() * this.getDeduccionC().getHonor_med_anu())
			+ ((((this.getEmpleado().getImp_cheq_cred() * this.getDeduccionC().getImp_cheq_cred_anu())/100)* this.getDeduccionC().getDeb_total_imp_cheq_cred_anu())/100);
	}
	
	
	//impuesto a pagar en el año
	public float impuestoAPagarEnElAnio(){
  	   this.calculo_anual =  this.calculo_anual_home.getByInRango(this.gananciaNetaC());
		return (this.getCalculo_anual().getBase() 
				+ ((this.getCalculo_anual().getPor_extra()
				* (this.gananciaNetaC() - this.getCalculo_anual().getSobre_exced()))/100)) - this.auxImpAPagarAnio(); 	
	}
	
	private float auxImpAPagarAnio() {
		int mesActual = (new Date()).getMonth();
		return (this.getEmpleado().getDev_compra_exter()/12)*mesActual;
	}

	// impuesto a pagar por mes
	public float impuestoAPagarPorMes(){
		return this.impuestoAPagarEnElAnio() - this.getEmpleado().getTot_pag_ant_temp();
	}
	
	//GET & SET
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public float getRnif() {
		return rnif;
	}

	public void setRnif(float rnif) {
		this.rnif = rnif;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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
	
}
