package flightLog.interfaces;

import java.util.List;

import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogBusinessImpl implements FlightLogBusiness {
   public Flight deleteFlight(Flight flightDelete) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      try {
         flightDelete = fldI.deleteFlight(flightDelete);
      } catch (Exception e) {
         throw e;
      }
      return flightDelete;
   }

   public List<Flight> getFlights(Flight flight) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      List<Flight> flightList = fldI.getFlights(flight);
      return flightList;
   }

   public Flight saveFlight(Flight flightSave) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      try {
         flightSave = fldI.saveFlight(flightSave);
      } catch (Exception e) {
         throw e;
      }
      return flightSave;
   }

   public List<Pilot> getPilots(Pilot pilot) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      List<Pilot> pilotList = fldI.getPilots(pilot);
      return pilotList;
   }

   public Pilot deletePilot(Pilot pilotDelete) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      try {
         pilotDelete = fldI.deletePilot(pilotDelete);
      } catch (Exception e) {
         throw e;
      }
      return pilotDelete;
   }

   public Pilot savePilot(Pilot pilotSave) throws Exception {
      FlightLogDatabaseImpl fldI = new FlightLogDatabaseImpl();
      try {
         pilotSave = fldI.savePilot(pilotSave);
      } catch (Exception e) {
         throw e;
      }
      return pilotSave;
   }
}
