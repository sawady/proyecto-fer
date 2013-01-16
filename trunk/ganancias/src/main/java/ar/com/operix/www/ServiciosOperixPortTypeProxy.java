package ar.com.operix.www;

public class ServiciosOperixPortTypeProxy implements ar.com.operix.www.ServiciosOperixPortType {
  private String _endpoint = null;
  private ar.com.operix.www.ServiciosOperixPortType serviciosOperixPortType = null;
  
  public ServiciosOperixPortTypeProxy() {
    _initServiciosOperixPortTypeProxy();
  }
  
  public ServiciosOperixPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiciosOperixPortTypeProxy();
  }
  
  private void _initServiciosOperixPortTypeProxy() {
    try {
      serviciosOperixPortType = (new ar.com.operix.www.ServiciosOperixServiceLocator()).getServiciosOperixPort();
      if (serviciosOperixPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviciosOperixPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviciosOperixPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviciosOperixPortType != null)
      ((javax.xml.rpc.Stub)serviciosOperixPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ar.com.operix.www.ServiciosOperixPortType getServiciosOperixPortType() {
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType;
  }
  
  public ar.com.operix.www.ProyectoServicio[] listarProyectos(int recursoId) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.listarProyectos(recursoId);
  }
  
  public int grabarDatoProyecto(int proyecto, java.lang.String comentario, java.util.Calendar fecha, int horas) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.grabarDatoProyecto(proyecto, comentario, fecha, horas);
  }
  
  public ar.com.operix.www.HoraProyectoServicio[] getHistorialProyecto(int proyecto) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.getHistorialProyecto(proyecto);
  }
  
  public int borrarDatoProyecto(int proyecto, java.util.Calendar fecha) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.borrarDatoProyecto(proyecto, fecha);
  }
  
  public int grabarMovimientoRecurso(int recursoId, int fechaHora, java.lang.String movimiento, java.lang.String tipo) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.grabarMovimientoRecurso(recursoId, fechaHora, movimiento, tipo);
  }
  
  public ar.com.operix.www.HorarioIE[] movimientosRecurso(int recursoId, int limit) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.movimientosRecurso(recursoId, limit);
  }
  
  public int imputoUltimaVez(int recursoId) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.imputoUltimaVez(recursoId);
  }
  
  public int horasTrabajadas(int recursoId, java.lang.String salida) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.horasTrabajadas(recursoId, salida);
  }
  
  public ar.com.operix.www.EmpleadoServicio[] getGananciaEmpleados() throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.getGananciaEmpleados();
  }
  
  public int setGananciaEmpleados(ar.com.operix.www.EmpleadoServicio[] empleadoServicio) throws java.rmi.RemoteException{
    if (serviciosOperixPortType == null)
      _initServiciosOperixPortTypeProxy();
    return serviciosOperixPortType.setGananciaEmpleados(empleadoServicio);
  }
  
  
}