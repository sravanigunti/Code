package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public int getUserId(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUserId(username, password);
  }
  
  public java.lang.String signUp(java.lang.String username, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(username, email, password);
  }
  
  public java.lang.String getUserNameById(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUserNameById(userId);
  }
  
  public java.lang.String signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(username, password);
  }
  
  public java.lang.String insertEducation(java.lang.String field, java.lang.String level, java.lang.String univname, int grade, java.lang.String description, int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertEducation(field, level, univname, grade, description, userId);
  }
  
  public java.lang.String insertExperience(java.lang.String companyName, int userId, java.lang.String title, java.lang.String location, java.lang.String description) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertExperience(companyName, userId, title, location, description);
  }
  
  public java.lang.String insertSummary(java.lang.String summary, int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertSummary(summary, userId);
  }
  
  public java.lang.String insertSkills(java.lang.String skills, int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.insertSkills(skills, userId);
  }
  
  public Connection.Education getEducationById(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getEducationById(userId);
  }
  
  public Connection.Users getSummaryById(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getSummaryById(userId);
  }
  
  public Connection.Skills getSkillsById(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getSkillsById(userId);
  }
  
  public java.lang.String[] getAllUsers(java.lang.String text) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getAllUsers(text);
  }
  
  public int getUserIdByName(java.lang.String username) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUserIdByName(username);
  }
  
  public java.lang.String sendInvitations(int fromId, int toId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.sendInvitations(fromId, toId);
  }
  
  public int getConnectionID(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getConnectionID(userId);
  }
  
  public java.lang.String getMD5(java.lang.String data) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getMD5(data);
  }
  
  public Connection.Experience getExperienceById(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getExperienceById(userId);
  }
  
  public java.lang.String[] displayInvitation(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.displayInvitation(userId);
  }
  
  public java.lang.String acceptInvitations(int connectionId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.acceptInvitations(connectionId);
  }
  
  public java.lang.String rejectInvitations(int connectionId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.rejectInvitations(connectionId);
  }
  
  public java.lang.String[] displayConnections(int userId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.displayConnections(userId);
  }
  
  
}