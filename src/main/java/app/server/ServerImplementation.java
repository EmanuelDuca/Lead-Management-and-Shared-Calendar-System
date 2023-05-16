package app.server;

import app.JDBC.SQLConnection;
import app.shared.*;

import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerImplementation implements Communicator
{
  private final RemotePropertyChangeSupport<Meeting> meetingSupport;
  private final RemotePropertyChangeSupport<Task> taskSupport;
  private final RemotePropertyChangeSupport<User> userSupport;

  private SQLConnection connection;



  public ServerImplementation()
  {
    meetingSupport = new RemotePropertyChangeSupport<>();
    taskSupport = new RemotePropertyChangeSupport<>();
    userSupport = new RemotePropertyChangeSupport<>();
  }


  @Override public void createMeeting(Meeting meeting) throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.createMeeting(meeting);
    meetingSupport.firePropertyChange("reloadMeeting", null, meeting);
  }

  @Override public void createTask(Task task)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.createTask(task);
    taskSupport.firePropertyChange("reloadTask", null, task);
  }

  @Override public void createLead(Lead lead)
      throws SQLException, RemoteException
  {

  }

  @Override public void removeMeeting(Meeting meeting)
      throws SQLException, RemoteException
  {

  }

  @Override public void removeTask(Task task)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    removeAssignedUsers(task);
    connection.removeTask(task);
    taskSupport.firePropertyChange("reloadTask", null, task);
  }

  @Override public void removeLead(Lead lead) throws SQLException
  {

  }

  @Override public void editTask(Task newTask, Task oldTask) throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.editTask(newTask, oldTask);
    taskSupport.firePropertyChange("reloadTask", oldTask, newTask);
  }
  @Override public void editMeeting(Meeting oldMeeting, Meeting newMeeting) throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.editMeeting(oldMeeting,newMeeting);
    meetingSupport.firePropertyChange("reloadMeeting",oldMeeting,newMeeting);
  }

  @Override public void addMeetingListener(
      RemotePropertyChangeListener<Meeting> listener) throws RemoteException
  {
    meetingSupport.addPropertyChangeListener(listener);
  }

  @Override public void addTaskListener(
      RemotePropertyChangeListener<Task> listener) throws RemoteException
  {
    taskSupport.addPropertyChangeListener(listener);
  }

  @Override public void addLeadListener(
      RemotePropertyChangeListener<Lead> listener) throws RemoteException
  {

  }

  @Override public void addUserListener(
      RemotePropertyChangeListener<User> listener) throws RemoteException
  {
    userSupport.addPropertyChangeListener(listener);
  }

  @Override public ArrayList<Meeting> getMeetings() throws SQLException
  {
    connection = SQLConnection.getInstance();
    return connection.getMeetings();
  }

  @Override public ArrayList<Task> getTasks()
      throws RemoteException, SQLException
  {
    connection = SQLConnection.getInstance();
    return connection.getTasks();
  }

  @Override public ArrayList<User> getUsers()
      throws RemoteException, SQLException
  {
    connection = SQLConnection.getInstance();
    return connection.getUsers();
  }

  @Override public void attendsMeeting(String email, Meeting meeting) throws SQLException
  {
    connection = SQLConnection.getInstance();
    connection.setAttendance(email,meeting);
  }

  @Override public ArrayList<String> getAttendance(Meeting meeting)
      throws SQLException
  {
    connection = SQLConnection.getInstance();
    return connection.getAttendance(meeting);
  }


  @Override public ArrayList<Lead> getLeads()
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    return connection.getLeads();
  }

  @Override public void removeAttendance(Meeting oldMeeting)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.removeAttendance(oldMeeting);
  }

  @Override public ArrayList<Business> getBusinesses()
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    return connection.getBusinesses();
  }

  @Override public void assignTask(String email, Task task)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.assignTask(task, email);
  }

  @Override public ArrayList<String> getAssignedUsers(Task task)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    return connection.getAssignedUsers(task);
  }

  @Override public void removeAssignedUsers(Task task)
      throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.removeAssignedUsers(task);
  }

  @Override public void addLead(Lead lead) throws SQLException, RemoteException
  {
    connection = SQLConnection.getInstance();
    connection.createLead(lead);
  }

  //Syncronization of Users


  /*
  @Override public void addTask(Task task) throws RemoteException
  {
    taskList.add(task);
    supportTask.firePropertyChange("task",null,task);
  }

  @Override public void manageTask(Task deletedTask, Task createdTask) throws RemoteException
  {
    taskList.remove(deletedTask);
    taskList.add(createdTask);
    supportTask.firePropertyChange("task",null,createdTask);
  }

  @Override public void removeTask(Task task) throws RemoteException
  {
    taskList.remove(task);
    supportTask.firePropertyChange("task",null,task);
  }

  @Override public ArrayList<Task> getTasks() throws RemoteException
  {
    return taskList;
  }

  @Override public void addLead(Lead lead) throws RemoteException
  {
    leadList.add(lead);
    supportLead.firePropertyChange("lead",null,lead);
  }

  @Override public void manageLead(Lead deletedLead, Lead createdLead) throws RemoteException
  {
    leadList.remove(deletedLead);
    leadList.add(createdLead);
    supportLead.firePropertyChange("lead",null,createdLead);
  }

  @Override public void removeLead(Lead lead) throws RemoteException
  {
    leadList.remove(lead);
    supportLead.firePropertyChange("lead",null,lead);
  }

  @Override public ArrayList<Lead> getLeads() throws RemoteException
  {
    return leadList;
  }

   */
}
