package model.entities;

import persistencia.Entity;

public class DeduccionB extends Entity {

	private float gast_sepe_anu;
	private float seg_vida_anu;
	private float serv_dom_anu;
	private float int_cred_hip_anu;
	
	
	
	public DeduccionB() {
		super();
	}


	public DeduccionB(float gast_sepe_anu, float seg_vida_anu,
			float serv_dom_anu, float int_cred_hip_anu) {
		super();
		this.gast_sepe_anu = gast_sepe_anu;
		this.seg_vida_anu = seg_vida_anu;
		this.serv_dom_anu = serv_dom_anu;
		this.int_cred_hip_anu = int_cred_hip_anu;
	}
	public float getGast_sepe_anu() {
		return gast_sepe_anu;
	}
	public void setGast_sepe_anu(float gast_sepe_anu) {
		this.gast_sepe_anu = gast_sepe_anu;
	}
	public float getSeg_vida_anu() {
		return seg_vida_anu;
	}
	public void setSeg_vida_anu(float seg_vida_anu) {
		this.seg_vida_anu = seg_vida_anu;
	}
	public float getServ_dom_anu() {
		return serv_dom_anu;
	}
	public void setServ_dom_anu(float serv_dom_anu) {
		this.serv_dom_anu = serv_dom_anu;
	}
	public float getInt_cred_hip_anu() {
		return int_cred_hip_anu;
	}
	public void setInt_cred_hip_anu(float int_cred_hip_anu) {
		this.int_cred_hip_anu = int_cred_hip_anu;
	}
	
	
}
