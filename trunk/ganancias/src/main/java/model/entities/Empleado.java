package model.entities;

import persistencia.Entity;

public class Empleado extends Entity{
	private String CUIL;
	private String nom_y_ape;
	private float rem_net_imp;
	private int tot_pag_ant_temp;
	private int rem_net_imp_acum_temp;
	private int estad_civil;
	private int mes_cas;
	private int cant_hij_anual;
	private int mes_nac_hij_1;
	private int cant_hij_nac_1;
	private int mes_baja_hij_1;
	private int cant_hij_baja_1;
	private int mes_nac_hij_2;
	private int cant_hij_nac_2;
	private int mes_baja_hij_2;
	private int cant_hij_baja_2;
	private int cant_pers_a_carg_anual;
	private int mes_alta_pers_a_carg_1;
	private int cant_pers_a_carg_1;
	private int mes_baja_pers_a_carg_1;
	private int cant_pers_a_carg_baja_1;
	private int mes_alta_pers_a_carg_2;
	private int cant_pers_a_carg_2;
	private int mes_baja_pers_a_carg_2;
	private int cant_pers_a_carg_baja_2;
	private float gast_sepe;
	private float seg_vida;
	private float donac;
	private float cuot_med_asist;
	private float honor_med;
	private float int_cred_hip;
	private float serv_dom;
	private float imp_cheq_cred;
	private float dev_compra_exter;
	
	
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getNom_y_ape() {
		return nom_y_ape;
	}
	public void setNom_y_ape(String nom_y_ape) {
		this.nom_y_ape = nom_y_ape;
	}
	public float getRem_net_imp() {
		return rem_net_imp;
	}
	public void setRem_net_imp(float rem_net_imp) {
		this.rem_net_imp = rem_net_imp;
	}
	public int getTot_pag_ant_temp() {
		return tot_pag_ant_temp;
	}
	public void setTot_pag_ant_temp(int tot_pag_ant_temp) {
		this.tot_pag_ant_temp = tot_pag_ant_temp;
	}
	public int getRem_net_imp_acum_temp() {
		return rem_net_imp_acum_temp;
	}
	public void setRem_net_imp_acum_temp(int rem_net_imp_acum_temp) {
		this.rem_net_imp_acum_temp = rem_net_imp_acum_temp;
	}
	public int getEstad_civil() {
		return estad_civil;
	}
	public void setEstad_civil(int estad_civil) {
		this.estad_civil = estad_civil;
	}
	public int getMes_cas() {
		return mes_cas;
	}
	public void setMes_cas(int mes_cas) {
		this.mes_cas = mes_cas;
	}
	public int getCant_hij_anual() {
		return cant_hij_anual;
	}
	public void setCant_hij_anual(int cant_hij_anual) {
		this.cant_hij_anual = cant_hij_anual;
	}
	public int getMes_nac_hij_1() {
		return mes_nac_hij_1;
	}
	public void setMes_nac_hij_1(int mes_nac_hij_1) {
		this.mes_nac_hij_1 = mes_nac_hij_1;
	}
	public int getCant_hij_nac_1() {
		return cant_hij_nac_1;
	}
	public void setCant_hij_nac_1(int cant_hij_nac_1) {
		this.cant_hij_nac_1 = cant_hij_nac_1;
	}
	public int getMes_baja_hij_1() {
		return mes_baja_hij_1;
	}
	public void setMes_baja_hij_1(int mes_baja_hij_1) {
		this.mes_baja_hij_1 = mes_baja_hij_1;
	}
	public int getCant_hij_baja_1() {
		return cant_hij_baja_1;
	}
	public void setCant_hij_baja_1(int cant_hij_baja_1) {
		this.cant_hij_baja_1 = cant_hij_baja_1;
	}
	public int getMes_nac_hij_2() {
		return mes_nac_hij_2;
	}
	public void setMes_nac_hij_2(int mes_nac_hij_2) {
		this.mes_nac_hij_2 = mes_nac_hij_2;
	}
	public int getCant_hij_nac_2() {
		return cant_hij_nac_2;
	}
	public void setCant_hij_nac_2(int cant_hij_nac_2) {
		this.cant_hij_nac_2 = cant_hij_nac_2;
	}
	public int getMes_baja_hij_2() {
		return mes_baja_hij_2;
	}
	public void setMes_baja_hij_2(int mes_baja_hij_2) {
		this.mes_baja_hij_2 = mes_baja_hij_2;
	}
	public int getCant_hij_baja_2() {
		return cant_hij_baja_2;
	}
	public void setCant_hij_baja_2(int cant_hij_baja_2) {
		this.cant_hij_baja_2 = cant_hij_baja_2;
	}
	public int getCant_pers_a_carg_anual() {
		return cant_pers_a_carg_anual;
	}
	public void setCant_pers_a_carg_anual(int cant_pers_a_carg_anual) {
		this.cant_pers_a_carg_anual = cant_pers_a_carg_anual;
	}
	public int getMes_alta_pers_a_carg_1() {
		return mes_alta_pers_a_carg_1;
	}
	public void setMes_alta_pers_a_carg_1(int mes_alta_pers_a_carg_1) {
		this.mes_alta_pers_a_carg_1 = mes_alta_pers_a_carg_1;
	}
	public int getCant_pers_a_carg_1() {
		return cant_pers_a_carg_1;
	}
	public void setCant_pers_a_carg_1(int cant_pers_a_carg_1) {
		this.cant_pers_a_carg_1 = cant_pers_a_carg_1;
	}
	public int getMes_baja_pers_a_carg_1() {
		return mes_baja_pers_a_carg_1;
	}
	public void setMes_baja_pers_a_carg_1(int mes_baja_pers_a_carg_1) {
		this.mes_baja_pers_a_carg_1 = mes_baja_pers_a_carg_1;
	}
	public int getCant_pers_a_carg_baja_1() {
		return cant_pers_a_carg_baja_1;
	}
	public void setCant_pers_a_carg_baja_1(int cant_pers_a_carg_baja_1) {
		this.cant_pers_a_carg_baja_1 = cant_pers_a_carg_baja_1;
	}
	public int getMes_alta_pers_a_carg_2() {
		return mes_alta_pers_a_carg_2;
	}
	public void setMes_alta_pers_a_carg_2(int mes_alta_pers_a_carg_2) {
		this.mes_alta_pers_a_carg_2 = mes_alta_pers_a_carg_2;
	}
	public int getCant_pers_a_carg_2() {
		return cant_pers_a_carg_2;
	}
	public void setCant_pers_a_carg_2(int cant_pers_a_carg_2) {
		this.cant_pers_a_carg_2 = cant_pers_a_carg_2;
	}
	public int getMes_baja_pers_a_carg_2() {
		return mes_baja_pers_a_carg_2;
	}
	public void setMes_baja_pers_a_carg_2(int mes_baja_pers_a_carg_2) {
		this.mes_baja_pers_a_carg_2 = mes_baja_pers_a_carg_2;
	}
	public int getCant_pers_a_carg_baja_2() {
		return cant_pers_a_carg_baja_2;
	}
	public void setCant_pers_a_carg_baja_2(int cant_pers_a_carg_baja_2) {
		this.cant_pers_a_carg_baja_2 = cant_pers_a_carg_baja_2;
	}
	public float getGast_sepe() {
		return gast_sepe;
	}
	public void setGast_sepe(float gast_sepe) {
		this.gast_sepe = gast_sepe;
	}
	public float getSeg_vida() {
		return seg_vida;
	}
	public void setSeg_vida(float seg_vida) {
		this.seg_vida = seg_vida;
	}
	public float getDonac() {
		return donac;
	}
	public void setDonac(float donac) {
		this.donac = donac;
	}
	public float getCuot_med_asist() {
		return cuot_med_asist;
	}
	public void setCuot_med_asist(float cuot_med_asist) {
		this.cuot_med_asist = cuot_med_asist;
	}
	public float getHonor_med() {
		return honor_med;
	}
	public void setHonor_med(float honor_med) {
		this.honor_med = honor_med;
	}
	public float getInt_cred_hip() {
		return int_cred_hip;
	}
	public void setInt_cred_hip(float int_cred_hip) {
		this.int_cred_hip = int_cred_hip;
	}
	public float getServ_dom() {
		return serv_dom;
	}
	public void setServ_dom(float serv_dom) {
		this.serv_dom = serv_dom;
	}
	public float getImp_cheq_cred() {
		return imp_cheq_cred;
	}
	public void setImp_cheq_cred(float imp_cheq_cred) {
		this.imp_cheq_cred = imp_cheq_cred;
	}
	public float getDev_compra_exter() {
		return dev_compra_exter;
	}
	public void setDev_compra_exter(float dev_compra_exter) {
		this.dev_compra_exter = dev_compra_exter;
	}
	
	

	
	
	

}
