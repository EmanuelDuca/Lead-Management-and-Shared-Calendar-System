package app.model;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ReloadData
{
  void meetingAddedFromServer()
      throws SQLException, RemoteException;
}
