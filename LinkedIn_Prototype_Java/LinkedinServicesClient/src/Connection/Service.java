/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public int getUserId(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String username, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getUserNameById(int userId) throws java.rmi.RemoteException;
    public java.lang.String signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String insertEducation(java.lang.String field, java.lang.String level, java.lang.String univname, int grade, java.lang.String description, int userId) throws java.rmi.RemoteException;
    public java.lang.String insertExperience(java.lang.String companyName, int userId, java.lang.String title, java.lang.String location, java.lang.String description) throws java.rmi.RemoteException;
    public java.lang.String insertSummary(java.lang.String summary, int userId) throws java.rmi.RemoteException;
    public java.lang.String insertSkills(java.lang.String skills, int userId) throws java.rmi.RemoteException;
    public Connection.Education getEducationById(int userId) throws java.rmi.RemoteException;
    public Connection.Users getSummaryById(int userId) throws java.rmi.RemoteException;
    public Connection.Skills getSkillsById(int userId) throws java.rmi.RemoteException;
    public java.lang.String[] getAllUsers(java.lang.String text) throws java.rmi.RemoteException;
    public int getUserIdByName(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String sendInvitations(int fromId, int toId) throws java.rmi.RemoteException;
    public int getConnectionID(int userId) throws java.rmi.RemoteException;
    public java.lang.String getMD5(java.lang.String data) throws java.rmi.RemoteException;
    public Connection.Experience getExperienceById(int userId) throws java.rmi.RemoteException;
    public java.lang.String[] displayInvitation(int userId) throws java.rmi.RemoteException;
    public java.lang.String acceptInvitations(int connectionId) throws java.rmi.RemoteException;
    public java.lang.String rejectInvitations(int connectionId) throws java.rmi.RemoteException;
    public java.lang.String[] displayConnections(int userId) throws java.rmi.RemoteException;
}
