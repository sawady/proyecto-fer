package model.excel;

import java.io.FileOutputStream;
import java.util.List;

import model.entities.ResultadoDeCalculo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import persistencia.HibernateApplication;
import persistencia.hibernateHome.HibernateHome;

public class WriteExcel {
	HSSFWorkbook libro = new HSSFWorkbook();
	HSSFSheet hoja = libro.createSheet();	
	List<ResultadoDeCalculo> resultado;
	public WriteExcel() {
		super();
	}

	public void crear(){
		HibernateHome<ResultadoDeCalculo> resultadoHome = (HibernateHome<ResultadoDeCalculo>) HibernateApplication.getInstance().getHome(ResultadoDeCalculo.class);
		List<ResultadoDeCalculo> resultado = resultadoHome.getAllEntities();
		this.crearFilaTitulo();
		for (int i = 1; i <= resultado.size()+1; i++) {
			HSSFRow fila = hoja.createRow(i);
			ResultadoDeCalculo r = resultado.get(i-1);
			
			new String("" + r.getCUIL() + "");
			//Celdas con los contenidos de resultado
			this.crearCelda(0,new String("" + r.getCUIL() + ""), fila);
			this.crearCelda(1,r.getNom_y_ape(), fila);
			this.crearCelda(2,new String("" + r.getRNIF() + ""), fila);
			this.crearCelda(3,new String("" + r.getGananciaA() + ""), fila);
			this.crearCelda(4,new String("" + r.getGananciaB() + ""), fila);
			this.crearCelda(5,new String("" + r.getGananciaC() + ""), fila);
			this.crearCelda(6,new String("" + r.getImp_ganan_periodo() + ""), fila);
			this.crearCelda(7,new String("" + r.getImp_ganan_a_pagar_mes() + ""), fila);
			this.crearCelda(8,new String("" + r.getDev_IIGG() + ""), fila);

		}
        try {
            FileOutputStream elFichero = new FileOutputStream("~/ImpuestoALasGananciasMontos.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	private void crearFilaTitulo() {
		HSSFCellStyle style = this.crearStyleTitulo();
		HSSFRow fila = hoja.createRow(0);
		
		crearCelda(0,"Cuil", style, fila);
		crearCelda(1,"Nombre y apellido", style, fila);
		crearCelda(2,"Remuneracion Neta Imponible final", style, fila);
		crearCelda(3,"Ganancia Neta(A)", style, fila);
		crearCelda(4,"Ganancia Neta(B)", style, fila);
		crearCelda(5,"Ganancia Neta(C)", style, fila);
		crearCelda(6,"Impuesto de ganancias total del periodo", style, fila);
		crearCelda(7,"Impuesto a pagar en el mes", style, fila);
		crearCelda(8,"Monto de devolucion", style, fila);
	}

	private void crearCelda(int posicion, String elTexto, HSSFRow fila) {
		HSSFCell celda = fila.createCell(posicion);
		HSSFRichTextString texto = new HSSFRichTextString(elTexto);
		celda.setCellValue(texto);		
	}
	private void crearCelda(int posicion, String elTexto, HSSFCellStyle style, HSSFRow fila) {
		HSSFCell celda = fila.createCell(posicion);
		HSSFRichTextString texto = new HSSFRichTextString(elTexto);
		celda.setCellValue(texto);
		celda.setCellStyle(style);
	}
	private HSSFCellStyle crearStyleTitulo() {

    HSSFCellStyle style = libro.createCellStyle();
    style.setBorderTop((short) 6); // double lines border
    style.setBorderBottom((short) 1); // single line border
    style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);

    HSSFFont font = libro.createFont();
    font.setFontName(HSSFFont.FONT_ARIAL);
    font.setFontHeightInPoints((short) 20);
    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    font.setColor(HSSFColor.BLUE.index);
    style.setFont(font);
		return style;
	}
}
