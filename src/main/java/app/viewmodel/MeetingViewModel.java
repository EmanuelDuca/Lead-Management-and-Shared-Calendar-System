package app.viewmodel;

import app.model.Model;
import app.model.User;
import app.shared.Meeting;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class MeetingViewModel
{
  private Model model;

  public MeetingViewModel(Model model){
    this.model = model;
  }

  public void addMeeting(String title,String description,Date date, Time startTime,Time endTime) throws SQLException
  {
    model.addMeeting(title,description,date,startTime,endTime);
  }

  public void removeMeeting(Meeting meeting)
  {
    model.removeMeeting(meeting);
  }

  public ArrayList<Meeting> getMeetings()
  {
    return model.getMeetings();
  }

  public void editMeeting(Date oldStartDate, Date oldEndDate,
      Date startDate, Date endDate, String description,
      ArrayList<User> employees)
  {
    model.editMeeting(oldStartDate, oldEndDate,
        startDate, endDate, description, employees);
  }

}
