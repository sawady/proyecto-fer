/**
 * ServiciosOperixPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.operix.www;

public interface ServiciosOperixPortType extends java.rmi.Remote {
    public ar.com.operix.www.ProyectoServicio[] listarProyectos(int recursoId) throws java.rmi.RemoteException;
    public int grabarDatoProyecto(int proyecto, java.lang.String comentario, java.util.Calendar fecha, int horas) throws java.rmi.RemoteException;
    public ar.com.operix.www.HoraProyectoServicio[] getHistorialProyecto(int proyecto) throws java.rmi.RemoteException;
    public int borrarDatoProyecto(int proyecto, java.util.Calendar fecha) throws java.rmi.RemoteException;
    public int grabarMovimientoRecurso(int recursoId, int fechaHora, java.lang.String movimiento, java.lang.String tipo) throws java.rmi.RemoteException;
    public ar.com.operix.www.HorarioIE[] movimientosRecurso(int recursoId, int limit) throws java.rmi.RemoteException;
    public int imputoUltimaVez(int recursoId) throws java.rmi.RemoteException;
    public int horasTrabajadas(int recursoId, java.lang.String salida) throws java.rmi.RemoteException;
    public ar.com.operix.www.EmpleadoServicio[] getGananciaEmpleados() throws java.rmi.RemoteException;
    public int setGananciaEmpleados(ar.com.operix.www.EmpleadoServicio[] empleadoServicio) throws java.rmi.RemoteException;
}
