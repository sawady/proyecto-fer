package model.excel;

import java.util.List;

import model.entities.Empleado;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import persistencia.HibernateApplication;
import persistencia.Home;
import persistencia.hibernateHome.HibernateHome;

public class WriteExcel {
	HSSFWorkbook libro = new HSSFWorkbook();
	HSSFSheet hoja = libro.createSheet();
	private void crearFilas(){
		HibernateHome<Empleado> empleadoHome = (HibernateHome<Empleado>) HibernateApplication.getInstance().getHome(Empleado.class);
		List<Empleado>listaDeEmpleados = empleadoHome.getAllEntities();
		for (int i = 0; i < listaDeEmpleados.size(); i++) {
			
		}
	}

}
