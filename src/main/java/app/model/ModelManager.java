package app.model;

import app.JDBC.SQLConnection;
import app.shared.Meeting;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class ModelManager implements Model
{
  private ClientListener clientListener;
  public ModelManager(ClientListener clientListener){
    this.clientListener = clientListener;
  }

  @Override public void addMeeting(String title, String description, java.sql.Date date, Time startTime, Time endTime, String email) {
   try{
     clientListener.addMeeting(new Meeting(title, description, date, startTime, endTime, email));
   }catch (Exception e){
     e.printStackTrace();
   }
  }

  @Override public void removeMeeting(Meeting meeting)
  {

  }

  @Override public ArrayList<Meeting> getMeetings() {
    try{
      return clientListener.getMeetings();
    }catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  @Override public void editMeeting(Date oldStartDate, Date oldEndDate,
      Date startDate, Date endDate, String description,
      ArrayList<User> employees)
  {

  }
}
