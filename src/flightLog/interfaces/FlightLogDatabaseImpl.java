package flightLog.interfaces;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.config.ConfigScope;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.config.encoding.StringEncodings;

import flightLog.entities.Flight;
import flightLog.entities.Pilot;

public class FlightLogDatabaseImpl implements FlightLogDatabase {
   private String dbFileName;
   private EmbeddedConfiguration flightLogDbConf;
   private EmbeddedObjectContainer objCont;

   private EmbeddedConfiguration confFlightLogDb() {
      flightLogDbConf = Db4oEmbedded.newConfiguration();
      flightLogDbConf.common().updateDepth(2);
      flightLogDbConf.common().messageLevel(1);
      flightLogDbConf.common().stringEncoding(StringEncodings.utf8());
      flightLogDbConf.file().generateUUIDs(ConfigScope.GLOBALLY);
      return flightLogDbConf;
   }

   private EmbeddedObjectContainer getObjCont() throws Exception {
      EmbeddedObjectContainer objCont;
      if (dbFileName != null) {
         objCont = Db4oEmbedded.openFile(confFlightLogDb(), dbFileName);
      } else {
         throw new Exception("Missing database filename!");
      }
      return objCont;
   }

   public Boolean closeObjCont() throws Exception {
      Boolean closed = Boolean.FALSE;
      if (objCont != null) {
         objCont.close();
         closed = Boolean.TRUE;
      } else {
         closed = Boolean.TRUE;
      }
      return closed;
   }

   public Flight deleteFlight(Flight flight) throws Exception {
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         objCont.delete(flight);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return flight;
   }

   public List<Flight> getFlights(Flight flight) throws Exception {
      List<Flight> flightList;
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         flightList = objCont.queryByExample(flight);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return flightList;
   }

   public Flight saveFlight(Flight flight) throws Exception {
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         objCont.store(flight);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return flight;
   }

   public Pilot deletePilot(Pilot pilot) throws Exception {
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         objCont.delete(pilot);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return pilot;
   }

   public List<Pilot> getPilots(Pilot pilot) throws Exception {
      List<Pilot> pilotList;
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         pilotList = objCont.queryByExample(pilot);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return pilotList;
   }

   public Pilot savePilot(Pilot pilot) throws Exception {
      if (objCont != null) {
         objCont = getObjCont();
      }
      try {
         objCont.store(pilot);
         objCont.commit();
      } catch (Exception e) {
         throw e;
      }
      return pilot;
   }
}
