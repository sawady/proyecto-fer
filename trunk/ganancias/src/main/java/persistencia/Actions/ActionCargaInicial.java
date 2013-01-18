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
		
		homeDecA.agregar(new DeduccionA(new Float(12960), 62208, 14400, 7200, 5400));
		homeDecB.agregar(new DeduccionB(new Float(996.23),new Float(996.23),12960,20000));
		homeDecC.agregar(new DeduccionC(5,5,5,35));
		homeAnual.agregar(new CamposParaCalculoAnual(0,10000,0,9,0));
		homeAnual.agregar(new CamposParaCalculoAnual(10000,20000,800,14,10000));
		homeAnual.agregar(new CamposParaCalculoAnual(20000,30000,2300,19,20000));
		homeAnual.agregar(new CamposParaCalculoAnual(30000,60000,4200,23,30000));
		homeAnual.agregar(new CamposParaCalculoAnual(60000,90000,11100,27,60000));
		homeAnual.agregar(new CamposParaCalculoAnual(90000,120000,19200,31,90000));
		homeAnual.agregar(new CamposParaCalculoAnual(120000,999998,26900,39,120000));
	}
}
