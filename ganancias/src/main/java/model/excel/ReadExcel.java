package model.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import model.FormatoEmpleadoException;
import model.entities.Empleado;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import persistencia.HibernateApplication;
/**
 * Clase que lee un archivo excel(de una estructura especifica) a partir de una ruta, y guarda la lista de empleados que
 * contiene el archivo en la base de datos.   
 * @author ramaya
 *
 */
public class ReadExcel {
	private FileInputStream archivoEntrada;
	private POIFSFileSystem poiArchivo;
	private HSSFWorkbook libro;
	private HSSFSheet hoja;


	
	public void leerArchivo(String ruta) throws IOException {
		String strRutaArchivo = ruta;
		this.archivoEntrada = new FileInputStream(strRutaArchivo);
		this.poiArchivo = new POIFSFileSystem(archivoEntrada);
		this.obtenerHoja(0);
	}
	public void leerArchivo(FileInputStream file) throws IOException {
		this.archivoEntrada = file;
		this.poiArchivo = new POIFSFileSystem(archivoEntrada);
		this.obtenerHoja(0);
	}

	public HSSFWorkbook obtenerLibro() throws IOException {
		if (poiArchivo != null) {
			libro = new HSSFWorkbook(poiArchivo);
		}
		return libro;
	}

	public HSSFSheet obtenerHoja(int intIndiceIn) throws IOException {
		this.libro = obtenerLibro();
		this.hoja = libro.getSheetAt(intIndiceIn);
		return hoja;
	}

	public void cargarDatos() throws FormatoEmpleadoException, SecurityException, NoSuchMethodException{

		Iterator<Row> row =  hoja.rowIterator();
		Empleado empleado = null;
		row.next();
		row.next();//es para que arranque a recorrer desde la fila 3.(Verificar)
		while (row.hasNext()) {
			Row r = row.next();
			Iterator<Cell> celda = r.cellIterator();
			empleado = new Empleado();
			while (celda.hasNext()) {
				Cell cel = celda.next();
				this.obtenerValorCelda(0, 0, cel, "setCUIL", (int) cel.getNumericCellValue(), empleado);
				this.obtenerValorCelda(1, 1, cel, "setNom_y_ape", cel.getStringCellValue() , empleado);
				this.obtenerValorCelda(2, 0, cel, "setRem_net_imp",(float) cel.getNumericCellValue() , empleado);
				this.obtenerValorCelda(3, 0, cel, "setTot_pag_ant_temp", (int) cel.getNumericCellValue(), empleado);
				this.obtenerValorCelda(4, 0, cel, "setRem_net_imp_acum_temp", (int) cel.getNumericCellValue() , empleado);
				this.obtenerValorCelda(5, 0, cel, "setEstad_civil", (int) cel.getNumericCellValue() , empleado);
//				this.obtenerValorCelda(6, , cel, "", , empleado);
//				this.obtenerValorCelda(7, , cel, "", , empleado);
//				this.obtenerValorCelda(8, , cel, "", , empleado);
//				this.obtenerValorCelda(9, , cel, "", , empleado);
//				this.obtenerValorCelda(10, , cel, "", , empleado);
//				this.obtenerValorCelda(11, , cel, "", , empleado);
//				this.obtenerValorCelda(12, , cel, "", , empleado);
//				this.obtenerValorCelda(13, , cel, "", , empleado);
//				this.obtenerValorCelda(14, , cel, "", , empleado);
//				this.obtenerValorCelda(15, , cel, "", , empleado);
//				this.obtenerValorCelda(16, , cel, "", , empleado);
//				this.obtenerValorCelda(17, , cel, "", , empleado);
//				this.obtenerValorCelda(18, , cel, "", , empleado);
//				this.obtenerValorCelda(19, , cel, "", , empleado);
//				this.obtenerValorCelda(20, , cel, "", , empleado);
//				this.obtenerValorCelda(21, , cel, "", , empleado);
//				this.obtenerValorCelda(22, , cel, "", , empleado);
//				this.obtenerValorCelda(23, , cel, "", , empleado);
//				this.obtenerValorCelda(24, , cel, "", , empleado);
//				this.obtenerValorCelda(25, , cel, "", , empleado);
//				this.obtenerValorCelda(26, , cel, "", , empleado);
//				this.obtenerValorCelda(27, , cel, "", , empleado);
//				this.obtenerValorCelda(28, , cel, "", , empleado);
//				this.obtenerValorCelda(29, , cel, "", , empleado);
//				this.obtenerValorCelda(30, , cel, "", , empleado);
//				this.obtenerValorCelda(31, , cel, "", , empleado);
//				this.obtenerValorCelda(32, , cel, "", , empleado);
//				this.obtenerValorCelda(33, , cel, "", , empleado);


				
//						empleado.setCUIL((int) cel.getNumericCellValue());//0
//						empleado.setNom_y_ape(cel.getStringCellValue());//1
//						empleado.setRem_net_imp((float) cel.getNumericCellValue());//2
//						empleado.setTot_pag_ant_temp((int) cel.getNumericCellValue());//3
						//empleado.setRem_net_imp_acum_temp((int) cel.getNumericCellValue());//4
//						empleado.setEstad_civil((int) cel.getNumericCellValue());//5
//						empleado.setMes_cas(this.convertMes(cel.getStringCellValue()));//6
//						empleado.setCant_hij_anual((int) cel.getNumericCellValue());//7
//						empleado.setMes_nac_hij_1(this.convertMes(cel.getStringCellValue()));//8
//						empleado.setCant_hij_nac_1((int) cel.getNumericCellValue());//9
//						empleado.setMes_baja_hij_1(this.convertMes(cel.getStringCellValue()));//10
//						empleado.setCant_hij_baja_1((int) cel.getNumericCellValue());//11
//						empleado.setMes_nac_hij_2(this.convertMes(cel.getStringCellValue()));//12
//						empleado.setCant_hij_nac_2((int) cel.getNumericCellValue());//13
//						empleado.setMes_baja_hij_2(this.convertMes(cel.getStringCellValue()));//14
//						empleado.setCant_hij_baja_2((int) cel.getNumericCellValue());//15
//						empleado.setCant_pers_a_carg_anual((int) cel.getNumericCellValue());//16
//						empleado.setMes_alta_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//17
//						empleado.setCant_pers_a_carg_1((int) cel.getNumericCellValue());//18
//						empleado.setMes_baja_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//19
//						empleado.setCant_pers_a_carg_baja_1((int)cel.getNumericCellValue());//20
//						empleado.setMes_alta_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//21
//						empleado.setCant_pers_a_carg_2((int) cel.getNumericCellValue());//22
//						empleado.setMes_baja_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//23
//						empleado.setCant_pers_a_carg_baja_2((int)cel.getNumericCellValue());//24
//						empleado.setGast_sepe((float) cel.getNumericCellValue());//25
//						empleado.setSeg_vida((float) cel.getNumericCellValue());//26
//						empleado.setDonac((float) cel.getNumericCellValue());//27
//						empleado.setCuot_med_asist((float) cel.getNumericCellValue());//28
//						empleado.setHonor_med((float) cel.getNumericCellValue());//29
//						empleado.setInt_cred_hip((float) cel.getNumericCellValue());//30
//						empleado.setServ_dom((float) cel.getNumericCellValue());//31
//						empleado.setImp_cheq_cred((float) cel.getNumericCellValue());//32
//						empleado.setDev_compra_exter((float) cel.getNumericCellValue());//33
						
					
				}
			}
			HibernateApplication.getInstance().getHome(Empleado.class).agregar(empleado);
		}
	

	private void obtenerValorCelda(int colum, int cellType,Cell cel,  String method, Object argSeter, Empleado empleado) throws FormatoEmpleadoException {
		if (cel.getColumnIndex() == colum) {
			if (cel.getCellType() == cellType) { // 0 = tipo nuemrico 1 = String
				try {
					Empleado.class.getMethod(method).invoke(empleado, argSeter);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			} else {
				throw new FormatoEmpleadoException("La columna " + cel.getColumnIndex() + "tiene un valor incorrecto" );
			}
		}
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

}
