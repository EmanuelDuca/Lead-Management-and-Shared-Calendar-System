package app.view;

import app.viewmodel.MeetingViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class MeetingController
{
  @FXML private Button Calendar;
  @FXML private Button Tasks;
  @FXML private Button AvailableClients;
  @FXML private Button AllClients;
  @FXML private Button Leads;


  private Region root;
  private ViewHandler viewHandler;
  private MeetingViewModel meetingViewModel;

  public void init(ViewHandler viewHandler, MeetingViewModel meetingViewModel, Region root){
    this.viewHandler = viewHandler;
    this.meetingViewModel = meetingViewModel;
    this.root = root;

    //bs comes below
  }

  public Region getRoot()
  {
    return root;
  }

  public void  reset(){} //why not

  @FXML public void onCalendarView(){
    viewHandler.openView("Calendar");
  }
  @FXML public void onTasksView(){
    viewHandler.openView("Tasks");
  }

  @FXML public void onAvailableClientsView(){
    viewHandler.openView("AvailableClients");
  }

  @FXML public void onAllClientsView(){
    viewHandler.openView("AllClients");
  }

  @FXML public void onLeadsView(){
    viewHandler.openView("Leads");
  }
}
