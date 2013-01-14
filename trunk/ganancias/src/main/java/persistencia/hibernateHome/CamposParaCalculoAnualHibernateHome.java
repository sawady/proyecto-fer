package persistencia.hibernateHome;

import model.entities.CamposParaCalculoAnual;

import org.hibernate.Session;

public class CamposParaCalculoAnualHibernateHome extends
		HibernateHome<CamposParaCalculoAnual> {

	public CamposParaCalculoAnualHibernateHome(ThreadLocal<Session> tl) {
		super(tl, CamposParaCalculoAnual.class);
	}

	public CamposParaCalculoAnual getByInRango(float gananciaNetaC) {
		CamposParaCalculoAnual  retorno = new CamposParaCalculoAnual();
		for (CamposParaCalculoAnual  a :this.getAllEntities()){
			if(a.getDesde()<= gananciaNetaC && a.getHasta()>=gananciaNetaC){
				retorno =a;
				break;
			}
		} //Se espera que siempre el valor del paramentro entre en alguno d los limites dados
		return retorno;
	}
	
}