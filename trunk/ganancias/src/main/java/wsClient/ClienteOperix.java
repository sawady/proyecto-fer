package wsClient;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import model.excel.NoSeEncuentraCuilException;

import ar.com.operix.www.EmpleadoServicio;
import ar.com.operix.www.ServiciosOperixPortType;
import ar.com.operix.www.ServiciosOperixServiceLocator;

/**
 * Clase web service cliente de operix. Solo se interesa a lo referente a los
 * campos necesarios para el calculo de las ganancias d los empleados
 * 
 */
public class ClienteOperix {
	private static ServiciosOperixServiceLocator locator = new ServiciosOperixServiceLocator();
	private static ServiciosOperixPortType port;
	private static EmpleadoServicio[] xs;

	public static void extraerTodos() {
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				System.out.println(xs[i].getCuil() + " rnif " +xs[i].getRemNetImpAcum() + " pagant "+ xs[i].getTotPagAnt());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrar() {
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				xs[i].setRemNetImpAcum(0);
				xs[i].setTotPagAnt(0);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static Float ExtraerPagosAnteriores(String cuil) {
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil() == cuil) {
					return (float) xs[i].getTotPagAnt();
				}
			}
		} catch (ServiceException e1) {
			System.out.println("fallo e1");
		} catch (RemoteException e) {
			System.out.println("fallo e2");
		}
		return (float) 0;
	}

	public static void actualizarPagosAnteriores(String cuil, float value) {
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil().equalsIgnoreCase(cuil)) {
					xs[i].setTotPagAnt((int) value);
					System.out.println("pagos anteriores set " + value + "guardo" + xs[i].getTotPagAnt());
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
	public static void actualizarRemNetAcum(String cuil, float value) {
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil().equalsIgnoreCase(cuil)) {
					xs[i].setRemNetImpAcum((int) value);
					System.out.println(xs[i].getCuil() + " rnif set " + value + " guardo en rnif " + xs[i].getRemNetImpAcum());
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	public static Float ExtraerRnia(String cuil)
			throws NoSeEncuentraCuilException {
		Float retorno = null;
		try {
			port = locator.getServiciosOperixPort();
			xs = port.getGananciaEmpleados();
			for (int i = 0; i < xs.length; i++) {
				if (xs[i].getCuil().equalsIgnoreCase(cuil)) {
					return (float) xs[i].getRemNetImpAcum();
				}
			}
		} catch (ServiceException e1) {
			System.out.println("fallo e1");
		} catch (RemoteException e) {
			System.out.println("fallo e2");
		}
		if (retorno == null) {
			throw new NoSeEncuentraCuilException(cuil);
		}
		return retorno;
	}
}
