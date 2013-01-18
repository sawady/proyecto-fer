package model.entities;

import persistencia.Entity;

public class DeduccionC extends Entity{
	private float cout_med_asist_anu;
	private float honor_med_anu;
	private float donac_anu;
	private float deb_total_imp_cheq_cred_anu;
	
	public DeduccionC(float cout_med_asist_anu, float honor_med_anu,
			float donac_anu, 
			float deb_total_imp_cheq_cred_anu) {
		super();
		this.cout_med_asist_anu = cout_med_asist_anu;
		this.honor_med_anu = honor_med_anu;
		this.donac_anu = donac_anu;
		this.deb_total_imp_cheq_cred_anu = deb_total_imp_cheq_cred_anu;
	}
	public DeduccionC() {
		super();
	}
	
	public float getCout_med_asist_anu() {
		return cout_med_asist_anu;
	}
	public void setCout_med_asist_anu(float cout_med_asist_anu) {
		this.cout_med_asist_anu = cout_med_asist_anu;
	}
	public float getHonor_med_anu() {
		return honor_med_anu;
	}
	public void setHonor_med_anu(float honor_med_anu) {
		this.honor_med_anu = honor_med_anu;
	}
	public float getDonac_anu() {
		return donac_anu;
	}
	public void setDonac_anu(float donac_anu) {
		this.donac_anu = donac_anu;
	}

	public float getDeb_total_imp_cheq_cred_anu() {
		return deb_total_imp_cheq_cred_anu;
	}
	public void setDeb_total_imp_cheq_cred_anu(float deb_total_imp_cheq_cred_anu) {
		this.deb_total_imp_cheq_cred_anu = deb_total_imp_cheq_cred_anu;
	}
	
	

	
}
