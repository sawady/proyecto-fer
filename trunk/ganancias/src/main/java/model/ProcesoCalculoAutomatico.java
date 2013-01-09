package model;

import java.io.IOException;
import java.util.List;

import model.calculo.CalculoAutomatico;
import model.entities.Empleado;
import model.entities.ResultadoDeCalculo;
import model.excel.ReadExcel;
import model.excel.WriteExcel;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.EmpleadoHibernateHome;
import persistencia.hibernateHome.HibernateHome;

public class ProcesoCalculoAutomatico {
	
	ReadExcel read = new ReadExcel();
	WriteExcel write = new WriteExcel();
	EmpleadoHibernateHome homeEmpleado = (EmpleadoHibernateHome) HibernateApplication
			.getInstance().getHome(Empleado.class);
	List<Empleado>listaDeEmpleados =homeEmpleado.getAllEntities();
	HibernateHome <ResultadoDeCalculo>homeDeResultados = (HibernateHome <ResultadoDeCalculo>) HibernateApplication
		.getInstance().getHome(ResultadoDeCalculo.class);
	
	public ProcesoCalculoAutomatico(String ruta) throws SecurityException, IOException, FormatoEmpleadoException, NoSuchMethodException {
		super();
		this.proceso(ruta);
	}

	public void proceso(String ruta) throws SecurityException, IOException, FormatoEmpleadoException, NoSuchMethodException{
		read.leerArchivo(ruta);
		this.generarResultados();
		write.crear();
		this.limpiarTablas();
	}

	private void generarResultados() {
		for (Empleado e:listaDeEmpleados) {
			CalculoAutomatico calculo = new CalculoAutomatico(e);
			ResultadoDeCalculo r =new ResultadoDeCalculo();
			r.setCUIL(e.getCUIL());
			r.setNom_y_ape(r.getNom_y_ape());
			r.setGananciaA(calculo.gananciaNetaA());
			r.setGananciaB(calculo.gananciaNetaB());
			r.setGananciaC(calculo.gananciaNetaC());
			r.setImp_ganan_periodo(calculo.impuestoAPagarEnElAnio());
			if(calculo.impuestoAPagarPorMes()>=0){
				r.setImp_ganan_a_pagar_mes(calculo.impuestoAPagarPorMes());
				r.setDev_IIGG(0);
			}
			else{
				r.setImp_ganan_a_pagar_mes(0);
				r.setDev_IIGG(calculo.impuestoAPagarPorMes());
			}
			homeDeResultados.agregar(r);
			
		}		
	}

	private void limpiarTablas() {
		homeEmpleado.deleteAllEntities();
		homeDeResultados.deleteAllEntities();
	}
	

}
