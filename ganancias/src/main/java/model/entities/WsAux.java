package model.entities;

import persistencia.Entity;

public class WsAux extends Entity{
	private String CUIL;
	private float tot_pag_ant_temp;
	private float rem_net_imp_acum_temp;
	
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public float getTot_pag_ant_temp() {
		return tot_pag_ant_temp;
	}
	public void setTot_pag_ant_temp(float tot_pag_ant_temp) {
		this.tot_pag_ant_temp = tot_pag_ant_temp;
	}
	public float getRem_net_imp_acum_temp() {
		return rem_net_imp_acum_temp;
	}
	public void setRem_net_imp_acum_temp(float rem_net_imp_acum_temp) {
		this.rem_net_imp_acum_temp = rem_net_imp_acum_temp;
	}
	
}
