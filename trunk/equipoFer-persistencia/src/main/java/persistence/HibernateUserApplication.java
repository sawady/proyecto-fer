package persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import appModel.UserApplication;

public class HibernateUserApplication extends UserApplication {

	private Session session;
	
	public HibernateUserApplication(Session session) {
		super(new HibernateHomeFactory(session));
		this.session = session;
	}
	
	private Transaction startTransaction(){
		return this.session.beginTransaction();
	}
	
	private void commitTransaction(Transaction transc){
		transc.commit();
	}
	
	private void rollbackTransaction(Transaction transc){
		transc.rollback();
	}

}
