package persistencia.Actions;

import persistencia.HibernateApplication;
import model.entities.Empleado;

public class ActionAgregarEmpleado implements Action{
	private Empleado empleado;
	
	
	public ActionAgregarEmpleado(Empleado empleado) {
		super();
		this.empleado = empleado;
	}


	@Override
	public void execute() {
		HibernateApplication.getInstance().getHome(Empleado.class).agregar(empleado);
	}

}
