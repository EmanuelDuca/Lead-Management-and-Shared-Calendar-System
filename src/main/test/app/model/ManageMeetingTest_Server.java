package app.model;

import app.JDBC.SQLConnection;
import app.server.ServerImplementation;
import app.shared.Meeting;
import app.viewmodel.MeetingViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManageMeetingTest_Server
{
  private ServerImplementation server;
  private SQLConnection connection;
  private Meeting meeting;

  @BeforeEach void setUp() throws Exception {
    this.connection = Mockito.mock(SQLConnection.class);
    server = new ServerImplementation();

    this.meeting = new Meeting("Meeting3","test3",
        Date.valueOf(LocalDate.of(2023,6,5)),
        Time.valueOf(LocalTime.of(12,30,0)),
        Time.valueOf(LocalTime.of(15,45,0)), "example@gmail.com");

  }

  @Test void edit_a_meeting() throws Exception{
    // Know it's show an error because the method doesn't exist
    //server.editMeeting(meeting, meeting);
    //Mockito.verify(connection,Mockito.times(1)).editMeeting(meeting,meeting);

  }

  @Test void test_if_a_meeting_is_removed() throws Exception{
    server.removeMeeting(meeting);
    //Mockito.verify(connection,Mockito.times(1)).removeMeeting(meeting);
  }
}