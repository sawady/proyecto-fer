package wsClient;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import ar.com.operix.www.EmpleadoServicio;
import ar.com.operix.www.ServiciosOperixPortType;
import ar.com.operix.www.ServiciosOperixServiceLocator;

/**
 * Clase web service cliente de operix. 
 * Solo se interesa  a lo referente a los campos necesarios para el calculo de las ganancias d los empleados
 *
 */
public class ClienteOperix {
	private static ServiciosOperixServiceLocator locator = new ServiciosOperixServiceLocator();
	private static ServiciosOperixPortType port;
	
	
	
	public   static Float ExtraerPagosAnteriores(String cuil){
		try {
			port = locator.getServiciosOperixPort();
		
			EmpleadoServicio[] xs= port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil() == cuil){
					return (float) xs[i].getTotPagAnt();
				}
			}
		} catch (ServiceException e1) {
			System.out.println("fallo e1");
		} catch (RemoteException e) {
			System.out.println("fallo e2");
		}
		return null;
	}
	
	public static Float ExtraerRnia(String cuil){
		try {
			port = locator.getServiciosOperixPort();
			EmpleadoServicio[] xs= port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil() == cuil){
					return (float) xs[i].getRemNetImpAcum();
				}
			}
		} catch (ServiceException e1) {
			System.out.println("fallo e1");
		} catch (RemoteException e) {
			System.out.println("fallo e2");
		}
		return null;
	}
}
