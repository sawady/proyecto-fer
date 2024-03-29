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

import wsClient.ClienteOperix;

/**
 * Clase que lee un archivo excel(de una estructura especifica) a partir de una
 * ruta, y guarda la lista de empleados que contiene el archivo en la base de
 * datos.
 * 
 */
public class ReadExcel {
	private FileInputStream archivoEntrada;
	private Workbook libro;
	private Sheet hoja;
	private List<String> cuilSinProcesar = new LinkedList<String>();

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

	private List<Empleado> cargarDatos() throws FormatoEmpleadoException, SecurityException, NoSuchMethodException {

		Iterator<Row> row = hoja.rowIterator();
		List<Empleado> retorno = new LinkedList<Empleado>();
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
						String s = new String(df.format(cel.getNumericCellValue()));
						empleado.setCUIL(s);
					}
				}
				if (cel.getColumnIndex() == 1) {
					if (cel.getCellType() == 1) { 
						empleado.setNom_y_ape(cel.getStringCellValue());
					}
				}
				if (cel.getColumnIndex() == 2) {
					if (cel.getCellType() == 0) { 
						empleado.setRem_net_imp((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 3) {
					if (cel.getCellType() == 0) { 
						empleado.setEstad_civil((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 4) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_cas(this.convertMes(cel.getStringCellValue()));
					}
				}

				if (cel.getColumnIndex() == 5) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_hij_anual((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 6) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_nac_hij_1(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 7) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_hij_nac_1((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 8) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_baja_hij_1(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 9) {
					if (cel.getCellType() == 0) {
						empleado.setCant_hij_baja_1((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 10) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_nac_hij_2(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 11) {
					if (cel.getCellType() == 0) {
						empleado.setCant_hij_nac_2((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 12) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_baja_hij_2(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 13) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_hij_baja_2((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 14) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_pers_a_carg_anual((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 15) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_alta_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 16) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_pers_a_carg_1((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 17) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_baja_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 18) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_pers_a_carg_baja_1((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 19) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_alta_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 20) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_pers_a_carg_2((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 21) {
					if (cel.getCellType() == 1) { 
						empleado.setMes_baja_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));
					}
				}
				if (cel.getColumnIndex() == 22) {
					if (cel.getCellType() == 0) { 
						empleado.setCant_pers_a_carg_baja_2((int) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 23) {
					if (cel.getCellType() == 0) { 
						empleado.setGast_sepe((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 24) {
					if (cel.getCellType() == 0) { 
						empleado.setSeg_vida((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 25) {
					if (cel.getCellType() == 0) { 
						empleado.setDonac((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 26) {
					if (cel.getCellType() == 0) { 
						empleado.setCuot_med_asist((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 27) {
					if (cel.getCellType() == 0) { 
						empleado.setHonor_med((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 28) {
					if (cel.getCellType() == 0) { 
						empleado.setInt_cred_hip((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 29) {
					if (cel.getCellType() == 0) { 
						empleado.setServ_dom((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 30) {
					if (cel.getCellType() == 0) { 
						empleado.setImp_cheq_cred((float) cel.getNumericCellValue());
					}
				}
				if (cel.getColumnIndex() == 31) {
					if (cel.getCellType() == 0) { 
						empleado.setDev_compra_exter((float) cel.getNumericCellValue());
					}
				}
			}
			try {
				empleado.setTot_pag_ant_temp(ClienteOperix.ExtraerPagosAnteriores(empleado.getCUIL()));
				empleado.setRem_net_imp_acum_temp(ClienteOperix.ExtraerRnia(empleado.getCUIL()));
				retorno.add(empleado);
			} catch (NoSeEncuentraCuilException e) {
				if (empleado.getCUIL() != null) {
					this.cuilSinProcesar.add(empleado.getCUIL());
				}
			}
		}
		return retorno;
	}

	private int convertMes(String stringCellValue) {
		if (stringCellValue.toLowerCase() == "enero") {
			return 1;
		} else if (stringCellValue.toLowerCase() == "febrero") {
			return 2;
		} else if (stringCellValue.toLowerCase() == "marzo") {
			return 3;
		} else if (stringCellValue.toLowerCase() == "abril") {
			return 4;
		} else if (stringCellValue.toLowerCase() == "mayo") {
			return 5;
		} else if (stringCellValue.toLowerCase() == "junio") {
			return 6;
		} else if (stringCellValue.toLowerCase() == "julio") {
			return 7;
		} else if (stringCellValue.toLowerCase() == "agosto") {
			return 8;
		} else if (stringCellValue.toLowerCase() == "septiembre") {
			return 9;
		} else if (stringCellValue.toLowerCase() == "octubre") {
			return 10;
		} else if (stringCellValue.toLowerCase() == "noviembre") {
			return 11;
		} else if (stringCellValue.toLowerCase() == "diciembre") {
			return 12;
		} else {
			return 0; // quiere decir que no se cargo el valor del mes por lo
						// que no se lo tiene en cuenta
		}
	}

	public List<String> getCuilSinProcesar() {
		return cuilSinProcesar;
	}

	public void setCuilSinProcesar(List<String> cuilSinProcesar) {
		this.cuilSinProcesar = cuilSinProcesar;
	}

}
