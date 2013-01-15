package model.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.FormatoEmpleadoException;
import model.entities.Empleado;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Clase que lee un archivo excel(de una estructura especifica) a partir de una ruta, y guarda la lista de empleados que
 * contiene el archivo en la base de datos.   
 *
 */
public class ReadExcel {
	private FileInputStream archivoEntrada;
	private Workbook libro;
	private Sheet hoja;

	
	public List<Empleado> leerArchivo(String ruta) {
		try {
			this.archivoEntrada = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
			System.out.println("fallo en leer Archivo");
			e.printStackTrace();
		}
		this.obtenerHoja(0);
		try {
			return this.cargarDatos();
		} catch (SecurityException e) {
			System.out.println("fallo en cargar datos");
			e.printStackTrace();
		} catch (FormatoEmpleadoException e) {
			System.out.println("fallo en cargar datos");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("fallo en cargar datos");
			e.printStackTrace();
		}
		return null;
	}

	private Workbook obtenerLibro() {
			try {
				libro = WorkbookFactory.create(archivoEntrada);
			} catch (IOException e) {
				System.out.println("fallo en obtener libro");
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				System.out.println("fallo en obtener libro");
				e.printStackTrace();
			}
		
		return libro;
	}

	private Sheet obtenerHoja(int intIndiceIn) {
		this.libro = obtenerLibro();
		this.hoja = libro.getSheetAt(0);
		return hoja;
	}

	private List<Empleado> cargarDatos() throws FormatoEmpleadoException, SecurityException, NoSuchMethodException{

		Iterator<Row> row =  hoja.rowIterator();
		List<Empleado>retorno = new LinkedList<Empleado>();
		Empleado empleado = null;
		row.next();
		row.next();
		while (row.hasNext()) {
		Row r = row.next();
		Iterator<Cell> celda = r.cellIterator();
		DecimalFormat df = new DecimalFormat("#");
		empleado = new Empleado();
		while (celda.hasNext()) {
			Cell cel = celda.next();
			if (cel.getColumnIndex() == 0) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					//String s = new String(df.format(cel.getNumericCellValue()));
					//empleado.setCUIL("rochi");
					      	}
					    }
			if (cel.getColumnIndex() == 1) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setNom_y_ape(cel.getStringCellValue());//1
					System.out.println(empleado.getNom_y_ape());
				}
					    }
			if (cel.getColumnIndex() == 2) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setRem_net_imp((float) cel.getNumericCellValue());//2
					        	}
					    }
			if (cel.getColumnIndex() == 3) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setEstad_civil((int) cel.getNumericCellValue());//3
					        	}
				    }
			if (cel.getColumnIndex() == 4) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_cas(this.convertMes(cel.getStringCellValue()));//4
					        	}
					    }
	    
			if (cel.getColumnIndex() == 5) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_hij_anual((int) cel.getNumericCellValue());//5
					        	}
					    }
			if (cel.getColumnIndex() == 6) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_nac_hij_1(this.convertMes(cel.getStringCellValue()));//6
					        	}
					    }	
			if (cel.getColumnIndex() == 7) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_hij_nac_1((int) cel.getNumericCellValue());//7
					        	}
					    }
			if (cel.getColumnIndex() == 8) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_baja_hij_1(this.convertMes(cel.getStringCellValue()));//8
					        	}
					    }
			if (cel.getColumnIndex() == 9) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_hij_baja_1((int) cel.getNumericCellValue());//9
					        	}
					    }
			if (cel.getColumnIndex() == 10) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_nac_hij_2(this.convertMes(cel.getStringCellValue()));//10
					        	}
					    }
			if (cel.getColumnIndex() == 11) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_hij_nac_2((int) cel.getNumericCellValue());//11
					        	}
					    }
			if (cel.getColumnIndex() == 12) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_baja_hij_2(this.convertMes(cel.getStringCellValue()));//12
					        	}
					    }
			if (cel.getColumnIndex() == 13) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_hij_baja_2((int) cel.getNumericCellValue());//13
					        	}
					    }
			if (cel.getColumnIndex() == 14) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_pers_a_carg_anual((int) cel.getNumericCellValue());//14
					        	}
					    }				
			if (cel.getColumnIndex() == 15) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_alta_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//15
					        	}
					    }
			if (cel.getColumnIndex() == 16) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_pers_a_carg_1((int) cel.getNumericCellValue());//16
					        	}
					    }
			if (cel.getColumnIndex() == 17) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_baja_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//17
					        	}
					    }
			if (cel.getColumnIndex() == 18) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_pers_a_carg_baja_1((int)cel.getNumericCellValue());//18
					        	}
					    }
			if (cel.getColumnIndex() == 19) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_alta_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//19
					        	}
					    }
			if (cel.getColumnIndex() == 20) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_pers_a_carg_2((int) cel.getNumericCellValue());//20
					        	}
					    }
			if (cel.getColumnIndex() == 21) {
				if (cel.getCellType() == 1) { // 0 = tipo nuemrico 1 = String
					empleado.setMes_baja_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//21
					        	}
					    }
			if (cel.getColumnIndex() == 22) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCant_pers_a_carg_baja_2((int)cel.getNumericCellValue());//22
					        	}
					    }
			if (cel.getColumnIndex() == 23) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setGast_sepe((float) cel.getNumericCellValue());//23
					        	}
					    }
			if (cel.getColumnIndex() == 24) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setSeg_vida((float) cel.getNumericCellValue());//24
					        	}
					    }
			if (cel.getColumnIndex() == 25) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setDonac((float) cel.getNumericCellValue());//25
					        	}
					    }
			if (cel.getColumnIndex() == 26) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setCuot_med_asist((float) cel.getNumericCellValue());//26
					        	}
					    }
			if (cel.getColumnIndex() == 27) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setHonor_med((float) cel.getNumericCellValue());//27
					        	}
					    }
			if (cel.getColumnIndex() == 28) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setInt_cred_hip((float) cel.getNumericCellValue());//28
					        	}
					    }
			if (cel.getColumnIndex() == 29) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setServ_dom((float) cel.getNumericCellValue());//29
					        	}
					    }
			if (cel.getColumnIndex() == 30) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setImp_cheq_cred((float) cel.getNumericCellValue());//30
					        	}
					    }
			if (cel.getColumnIndex() == 31) {
				if (cel.getCellType() == 0) { // 0 = tipo nuemrico 1 = String
					empleado.setDev_compra_exter((float) cel.getNumericCellValue());//31
					        	}
					    }
				}
			//empleado.setTot_pag_ant_temp(); //TODO ws
			//empleado.setRem_net_imp_acum_temp(); //TODO ws
		retorno.add(empleado);
			}
		return retorno;
		}
	
	private int convertMes(String stringCellValue) {
		if(stringCellValue.toLowerCase() == "enero"){
			return 1;
		}
		else if(stringCellValue.toLowerCase() == "febrero"){
			return 2;
		}
		else if(stringCellValue.toLowerCase() == "marzo"){
			return 3;
		}
		else if(stringCellValue.toLowerCase() == "abril"){
			return 4;
		}
		else if(stringCellValue.toLowerCase() == "mayo"){
			return 5;
		}
		else if(stringCellValue.toLowerCase() == "junio"){
			return 6;
		}
		else if(stringCellValue.toLowerCase() == "julio"){
			return 7;
		}
		else if(stringCellValue.toLowerCase() == "agosto"){
			return 8;
		}
		else if(stringCellValue.toLowerCase() == "septiembre"){
			return 9;
		}
		else if(stringCellValue.toLowerCase() == "octubre"){
			return 10;
		}
		else if(stringCellValue.toLowerCase() == "noviembre"){
			return 11;
		}
		else if(stringCellValue.toLowerCase() == "diciembre"){
			return 12;
		}
		else{
			return 0; //quiere decir que no se cargo el valor del mes por lo que no se lo tiene en cuenta
		}
	}
//private void obtenerValorCelda(int colum, int cellType,Cell cel,  String method, Object argSeter, Empleado empleado) throws FormatoEmpleadoException {
//	if (cel.getColumnIndex() == colum) {
//	if (cel.getCellType() == cellType) { // 0 = tipo nuemrico 1 = String
//		try {
//			Method[] methods = Empleado.class.getMethods();
//		    for( int i = 0; i < methods.length; i++ ) {
//		        if( methods[i].getName().equals( method ) ){
//		        	methods[i].invoke(empleado, argSeter);
//		        	}
//		    }
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	} else {
//		throw new FormatoEmpleadoException("La columna " + cel.getColumnIndex() + "tiene un valor incorrecto" );
//	}
//}
//}
	
	//this.obtenerValorCelda(0, 0, cel, "setCUIL", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(1, 1, cel, "setNom_y_ape", cel.getNumericCellValue() , empleado);
//	this.obtenerValorCelda(2, 0, cel, "setRem_net_imp",(float) cel.getNumericCellValue() , empleado);
//	this.obtenerValorCelda(3, 0, cel, "setTot_pag_ant_temp", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(4, 0, cel, "setRem_net_imp_acum_temp", (int) cel.getNumericCellValue() , empleado);
//	this.obtenerValorCelda(5, 0, cel, "setEstad_civil", (int) cel.getNumericCellValue() , empleado);
//	this.obtenerValorCelda(6, 0, cel, "setMes_cas",this.convertMes(cel.getStringCellValue()) , empleado);
//	this.obtenerValorCelda(7, 0, cel, "setCant_hij_anual",(int) cel.getNumericCellValue() , empleado);
//	this.obtenerValorCelda(8, 0, cel, "setMes_nac_hij_1",this.convertMes(cel.getStringCellValue()) , empleado);
//	this.obtenerValorCelda(9, 0, cel, "setCant_hij_nac_1", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(10, 0, cel, "setMes_baja_hij_1", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(11, 0, cel, "setCant_hij_baja_1", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(12, 0, cel, "setMes_nac_hij_2", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(13, 0, cel, "setCant_hij_nac_2", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(14, 0, cel, "setMes_baja_hij_2", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(15, 0, cel, "setCant_hij_baja_2", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(16, 0, cel, "setCant_pers_a_carg_anual", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(17, 0, cel, "setMes_alta_pers_a_carg_1", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(18, 0, cel, "setCant_pers_a_carg_1", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(19, 0, cel, "setMes_baja_pers_a_carg_1", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(20, 0, cel, "setCant_pers_a_carg_baja_1", (int)cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(21, 0, cel, "setMes_alta_pers_a_carg_2", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(22, 0, cel, "setCant_pers_a_carg_2", (int) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(23, 0, cel, "setMes_baja_pers_a_carg_2", this.convertMes(cel.getStringCellValue()), empleado);
//	this.obtenerValorCelda(24, 0, cel, "setCant_pers_a_carg_baja_2", (int)cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(25, 0, cel, "setGast_sepe", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(26, 0, cel, "setSeg_vida", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(27, 0, cel, "setDonac", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(28, 0, cel, "setCuot_med_asist", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(29, 0, cel, "setHonor_med", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(30, 0, cel, "setInt_cred_hip", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(31, 0, cel, "setServ_dom", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(32, 0, cel, "setImp_cheq_cred", (float) cel.getNumericCellValue(), empleado);
//	this.obtenerValorCelda(33, 0, cel, "setDev_compra_exter", (float) cel.getNumericCellValue(), empleado);
}
