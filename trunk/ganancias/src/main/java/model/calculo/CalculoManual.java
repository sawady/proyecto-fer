package model.calculo;

import model.entities.DeduccionA;
import model.entities.DeduccionC;

public class CalculoManual extends Calculo{
	private float remuneracion_neta_imponible = 0;
	private int estado_civil = 0;
	private int cant_hijos = 0;
	private int cant_personas_a_cargo = 0;
	private float gastos_sepelio = 0;
	private float seguro_de_vida = 0;
	private float donaciones = 0;
	private float cuotas_medico_asistenciales = 0;
	private float honorarios_medicos = 0;
	private float intereses_por_credito_hipotecario = 0;
	private float servicios_domesticos = 0;
	private float impuesto_al_cheque_sobre_creditos = 0;
	private float monto_devolucion_al_exterior = 0;

	
	//constructor
	public CalculoManual() {
		super();
	}
	
	public CalculoManual(float remuneracion_neta_imponible, int estado_civil,
			int cant_hijos, int cant_personas_a_cargo, float gastos_sepelio,
			float seguro_de_vida, float donaciones,
			float cuotas_medico_asistenciales, float honorarios_medicos,
			float intereses_por_credito_hipotecario,
			float servicios_domesticos,
			float impuesto_al_cheque_sobre_creditos,
			float monto_devolucion_al_exterior, DeduccionA deduccionA,
			DeduccionC deduccionC) {
		super();
		this.remuneracion_neta_imponible = remuneracion_neta_imponible;
		this.estado_civil = estado_civil;
		this.cant_hijos = cant_hijos;
		this.cant_personas_a_cargo = cant_personas_a_cargo;
		this.gastos_sepelio = gastos_sepelio;
		this.seguro_de_vida = seguro_de_vida;
		this.donaciones = donaciones;
		this.cuotas_medico_asistenciales = cuotas_medico_asistenciales;
		this.honorarios_medicos = honorarios_medicos;
		this.intereses_por_credito_hipotecario = intereses_por_credito_hipotecario;
		this.servicios_domesticos = servicios_domesticos;
		this.impuesto_al_cheque_sobre_creditos = impuesto_al_cheque_sobre_creditos;
		this.monto_devolucion_al_exterior = monto_devolucion_al_exterior;
	}

	// Ganancia Neta A
	public float gananciaNetaA() {
		return this.calculoRNI() - this.calculoDeduccionesGananciaA();
	}

	private float calculoDeduccionesGananciaA() {
		float retorno = this.getDeduccionA().getMin_no_imp()
				+ this.getDeduccionA().getDedu_espe()
				+ (this.getDeduccionA().getOtros() * this
						.getCant_personas_a_cargo()) + this.getGastos_sepelio()
				+ this.getSeguro_de_vida() + this.getServicios_domesticos()
				+ this.getIntereses_por_credito_hipotecario();
		if (this.getEstado_civil() == 1) {
			retorno += this.getDeduccionA().getConyuge();
		}
		return retorno;
	}

	private float calculoRNI() {
		return this.getRemuneracion_neta_imponible() * 13;
	}

	// Ganancia Neta B
	public float gananciaNetaB() {
		return this.gananciaNetaA() - this.calculoDeduccionesGananciaB();
	}

	private float calculoDeduccionesGananciaB() {
		return (this.auxiliarMedASist() / 100 ) + ( this.auxDonanciones() / 100);
	}
	
	private float auxDonanciones() {
		return this.getDonaciones() * this.getDeduccionC().getDonac_anu();
	}

	private float auxiliarMedASist(){
		return this.getCuotas_medico_asistenciales()* this.getDeduccionC().getCout_med_asist_anu();
	}
	// Ganancia Neta C
	public float gananciaNetaC() {
		 this.resultadoGananciaNetaC = this.gananciaNetaB() - this.calculoDeduccionesGananciaC();
		 return this.resultadoGananciaNetaC;
	}

	private float calculoDeduccionesGananciaC() {
		return this.auxHonorMedic() + this.auxCheq();
	}
	
	
	private float auxCheq() {
		return (this.getHonorarios_medicos() * this.getDeduccionC().getHonor_med_anu())/100;
	}

	private float auxHonorMedic() {
		return 	(((this.impuesto_al_cheque_sobre_creditos * this.getDeduccionC().getImp_cheq_cred_anu())/100) * this.getDeduccionC().getDeb_total_imp_cheq_cred_anu())/100	;
	}

	//impuesto a pagar en el año
	public float impuestoAPagarEnElAnio(){
  	   this.calculo_anual =  this.calculo_anual_home.getByInRango(this.gananciaNetaC());
		return (this.getCalculo_anual().getBase() 
				+ ((this.getCalculo_anual().getPor_extra()
				* (this.resultadoGananciaNetaC - this.getCalculo_anual().getSobre_exced()))/100))-this.getMonto_devolucion_al_exterior(); 	
	}
	
	// impuesto a pagar por mes
	public float impuestoAPagarPorMes(){
		return this.impuestoAPagarEnElAnio()/12;
	}

	// GET & SET
	
	

	public float getDonaciones() {
		return donaciones;
	}
	public void setDonaciones(float donaciones) {
		this.donaciones = donaciones;
	}


	public float getRemuneracion_neta_imponible() {
		return remuneracion_neta_imponible;
	}

	public void setRemuneracion_neta_imponible(float remuneracion_neta_imponible) {
		this.remuneracion_neta_imponible = remuneracion_neta_imponible;
	}

	public int getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(int estado_civil) {
		this.estado_civil = estado_civil;
	}

	public int getCant_hijos() {
		return cant_hijos;
	}

	public void setCant_hijos(int cant_hijos) {
		this.cant_hijos = cant_hijos;
	}

	public int getCant_personas_a_cargo() {
		return cant_personas_a_cargo;
	}

	public void setCant_personas_a_cargo(int cant_personas_a_cargo) {
		this.cant_personas_a_cargo = cant_personas_a_cargo;
	}

	public float getGastos_sepelio() {
		return gastos_sepelio;
	}

	public void setGastos_sepelio(float gastos_sepelio) {
		this.gastos_sepelio = gastos_sepelio;
	}

	public float getSeguro_de_vida() {
		return seguro_de_vida;
	}

	public void setSeguro_de_vida(float seguro_de_vida) {
		this.seguro_de_vida = seguro_de_vida;
	}

	public float getCuotas_medico_asistenciales() {
		return cuotas_medico_asistenciales;
	}

	public void setCuotas_medico_asistenciales(float cuotas_medico_asistenciales) {
		this.cuotas_medico_asistenciales = cuotas_medico_asistenciales;
	}

	public float getHonorarios_medicos() {
		return honorarios_medicos;
	}

	public void setHonorarios_medicos(float honorarios_medicos) {
		this.honorarios_medicos = honorarios_medicos;
	}

	public float getIntereses_por_credito_hipotecario() {
		return intereses_por_credito_hipotecario;
	}

	public void setIntereses_por_credito_hipotecario(
			float intereses_por_credito_hipotecario) {
		this.intereses_por_credito_hipotecario = intereses_por_credito_hipotecario;
	}

	public float getServicios_domesticos() {
		return servicios_domesticos;
	}

	public void setServicios_domesticos(float servicios_domesticos) {
		this.servicios_domesticos = servicios_domesticos;
	}

	public float getImpuesto_al_cheque_sobre_creditos() {
		return impuesto_al_cheque_sobre_creditos;
	}

	public void setImpuesto_al_cheque_sobre_creditos(
			float impuesto_al_cheque_sobre_creditos) {
		this.impuesto_al_cheque_sobre_creditos = impuesto_al_cheque_sobre_creditos;
	}

	public float getMonto_devolucion_al_exterior() {
		return monto_devolucion_al_exterior;
	}

	public void setMonto_devolucion_al_exterior(
			float monto_devolucion_al_exterior) {
		this.monto_devolucion_al_exterior = monto_devolucion_al_exterior;
	}
}
