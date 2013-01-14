package persistencia.Actions;

import model.entities.CamposParaCalculoAnual;
import model.entities.DeduccionA;
import model.entities.DeduccionB;
import model.entities.DeduccionC;
import persistencia.HibernateApplication;
import persistencia.hibernateHome.CamposParaCalculoAnualHibernateHome;
import persistencia.hibernateHome.HibernateHome;

public class ActionCargaInicial implements Action {
	private HibernateHome<DeduccionA> homeDecA;
	private HibernateHome<DeduccionB> homeDecB;
	private HibernateHome<DeduccionC> homeDecC;
	private CamposParaCalculoAnualHibernateHome homeAnual;

	@Override
	public void execute() {
		homeDecA = (HibernateHome<DeduccionA>) HibernateApplication
				.getInstance().getHome(DeduccionA.class);
		homeDecB =  (HibernateHome<DeduccionB>) HibernateApplication
				.getInstance().getHome(DeduccionB.class);
		homeDecC =  (HibernateHome<DeduccionC>) HibernateApplication
				.getInstance().getHome(DeduccionC.class);
		
		homeAnual = (CamposParaCalculoAnualHibernateHome) HibernateApplication
				.getInstance().getHome(CamposParaCalculoAnual.class);

		homeAnual.deleteAllEntities();
		homeDecA.deleteAllEntities();
		homeDecB.deleteAllEntities();
		homeDecC.deleteAllEntities();
		
		homeDecA.agregar(new DeduccionA(1, 2, 3, 5, 7));
		homeDecB.agregar(new DeduccionB(1,2,3,4));
		homeDecC.agregar(new DeduccionC(2,3,4,5,6));
		CamposParaCalculoAnual datoAnual = new CamposParaCalculoAnual();
		datoAnual.setBase(0);
		datoAnual.setDesde(0);
		datoAnual.setHasta(0);
		datoAnual.setPor_extra(0);
		datoAnual.setSobre_exced(0);
		datoAnual.setId(0);
		homeAnual.agregar(datoAnual);
	
//		homeAnual.agregar(new CamposParaCalculoAnual(1,2,3,4,6));
//		homeAnual.agregar(new CamposParaCalculoAnual(9,8,7,6,5));
//		homeAnual.agregar(new CamposParaCalculoAnual(8,7,6,5,4));
//		homeAnual.agregar(new CamposParaCalculoAnual(7,6,5,4,3));
	}
}
