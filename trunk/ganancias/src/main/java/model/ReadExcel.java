package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

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

	public void cargarDatos()
			throws FileNotFoundException, IOException, FormatoEmpleadoException {

		Iterator<Row> row =  hoja.rowIterator();
		Empleado empleado = null;

		while (row.hasNext()) {
			Row r = row.next();
			Iterator<Cell> celda = r.cellIterator();
			empleado = new Empleado();
			while (celda.hasNext()) {
				Cell cel = celda.next();
				if (cel.getColumnIndex() == 0) {
					if (cel.getCellType() == 0) { // 0 = tipo nuemrico
						empleado.setCUIL((int) cel.getNumericCellValue());
					} else {
						throw new FormatoEmpleadoException("La columna " + cel.getColumnIndex() + "tiene un valor incorrecto" );
					}
				}
				if (cel.getColumnIndex() == 1) { 
					if (cel.getCellType() == 1) { // 1 = tipo string
						empleado.setNom_y_ape(cel.toString());
						empleado.setRem_net_imp((float) cel.getNumericCellValue());//2
						empleado.setTot_pag_ant_temp((int) cel.getNumericCellValue());//3
						empleado.setRem_net_imp_acum_temp((int) cel.getNumericCellValue());//4
						empleado.setEstad_civil((int) cel.getNumericCellValue());//5
						empleado.setMes_cas(this.convertMes(cel.getStringCellValue()));//6
						empleado.setCant_hij_anual((int) cel.getNumericCellValue());//7
						empleado.setMes_nac_hij_1(this.convertMes(cel.getStringCellValue()));//8
						empleado.setCant_hij_nac_1((int) cel.getNumericCellValue());//9
						empleado.setMes_baja_hij_1(this.convertMes(cel.getStringCellValue()));//10
						empleado.setCant_hij_baja_1((int) cel.getNumericCellValue());//11
						empleado.setMes_nac_hij_2(this.convertMes(cel.getStringCellValue()));//12
						empleado.setCant_hij_nac_2((int) cel.getNumericCellValue());//13
						empleado.setMes_baja_hij_2(this.convertMes(cel.getStringCellValue()));//14
						empleado.setCant_hij_baja_2((int) cel.getNumericCellValue());//15
						empleado.setCant_pers_a_carg_anual((int) cel.getNumericCellValue());//16
						empleado.setMes_alta_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//17
						empleado.setCant_pers_a_carg_1((int) cel.getNumericCellValue());//18
						empleado.setMes_baja_pers_a_carg_1(this.convertMes(cel.getStringCellValue()));//19
						empleado.setCant_pers_a_carg_baja_1((int)cel.getNumericCellValue());//20
						empleado.setMes_alta_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//21
						empleado.setCant_pers_a_carg_2((int) cel.getNumericCellValue());//22
						empleado.setMes_baja_pers_a_carg_2(this.convertMes(cel.getStringCellValue()));//23
						empleado.setCant_pers_a_carg_baja_2((int)cel.getNumericCellValue());//24
						empleado.setGast_sepe((float) cel.getNumericCellValue());//25
						empleado.setSeg_vida((float) cel.getNumericCellValue());//26
						empleado.setDonac((float) cel.getNumericCellValue());//27
						empleado.setCuot_med_asist((float) cel.getNumericCellValue());//28
						empleado.setHonor_med((float) cel.getNumericCellValue());//29
						empleado.setInt_cred_hip((float) cel.getNumericCellValue());//30
						empleado.setServ_dom((float) cel.getNumericCellValue());//31
						empleado.setImp_cheq_cred((float) cel.getNumericCellValue());//32
						empleado.setDev_compra_exter((float) cel.getNumericCellValue());//33
					} else {
						throw new FormatoEmpleadoException("La columna " + cel.getColumnIndex() + "tiene un valor incorrecto" );
					}
				}
			}
			HibernateApplication.getInstance().getHome(Empleado.class).agregar(empleado);
		}
	}

	private int convertMes(String stringCellValue) {
		return 0;
	}

}
