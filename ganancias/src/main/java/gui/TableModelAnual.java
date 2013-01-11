package gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.entities.CamposParaCalculoAnual;

public class TableModelAnual extends DefaultTableModel {

	// Variables *********************************************************** //
	private static final long serialVersionUID = 1L;

	// Metodos *********************************************************** //

	/**
	 * Agrega un proyecto a la tablaModel
	 */
	public void add(CamposParaCalculoAnual a) {
		this.dataVector.add(a);
	}

	/**
	 * Retorna el proyecto que corresponde a la fila seleccionada
	 * 
	 * @param row
	 * @return
	 */
	public CamposParaCalculoAnual getSelected(int row) {
		return (CamposParaCalculoAnual) this.dataVector.get(row);
	}

	/**
	 * Recrea la tabla.
	 * 
	 * @param model
	 */
	public void actualizarme(List<CamposParaCalculoAnual> model) {

		Object[] datos = new Object[1];
		for (CamposParaCalculoAnual anual : model) {
			datos[0] = anual.getDesde();
			datos[1] = anual.getHasta();
			datos[2] = anual.getBase();
			datos[3] = anual.getPor_extra();
			datos[4] = anual.getSobre_exced();
			this.addRow(datos);
		}
	}

}
