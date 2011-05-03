package flightLog.web;

import flightLog.interfaces.FlightLogBusinessImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightLog.entities.Pilot;

public class FlightLogBookCtrl extends HttpServlet {
   private static final long serialVersionUID = -5382691079422638029L;

   private static final String JSP_FLIGHT_LOG_CTRL = "/FlightLogCtrl.jsp";
   private static final String JSP_PILOT_DETAIL = "/PilotDetail.jsp";
   private static final String JSP_PILOT_DISPLAY = "/PilotDisplay.jsp";
   private static final String JSP_PILOT_SEARCH = "/PilotSearch.jsp";

   public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String forward = "";
      try {
         forward = handleRequest(request, response);
      } catch (Exception e) {
         request.setAttribute("msg", e.getLocalizedMessage());
      }
      RequestDispatcher view = request.getRequestDispatcher(forward);
      view.forward(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request, response);
   }

   private String handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
      String forward = "";
      Map<String, String[]> reqParmMap = request.getParameterMap();
      if (request.getAttribute("msg") != null) {
         request.removeAttribute("msg");
      }
      if (reqParmMap.containsKey("createPilot")
               || reqParmMap.containsKey("deletePilot")
               || reqParmMap.containsKey("detailPilot")
               || reqParmMap.containsKey("displayPilot")
               || reqParmMap.containsKey("searchPilot")) {
         forward = handlePilotFunctions(request, response, reqParmMap);
      } else if (reqParmMap.containsKey("createFlight")
               || reqParmMap.containsKey("deleteFlight")
               || reqParmMap.containsKey("detailFlight")
               || reqParmMap.containsKey("displayFlight")
               || reqParmMap.containsKey("searchFlight")) {
         forward = handleFlightFunctions(request, response, reqParmMap);
      } else {
         forward = JSP_FLIGHT_LOG_CTRL;
         if (request.getAttribute("msg") != null) {
            request.removeAttribute("msg");
         }
      }
      return forward;
   }

   private String handlePilotFunctions(HttpServletRequest request,
            HttpServletResponse response, Map<String, String[]> reqParmMap)
            throws Exception {
      String forward = "";
      FlightLogBusinessImpl flbI = new FlightLogBusinessImpl();
      if (reqParmMap.containsKey("createPilot")) {
         forward = JSP_PILOT_DETAIL;
      } else if (reqParmMap.containsKey("deletePilot")) {
         forward = JSP_PILOT_DETAIL;
         request.setAttribute("surname", reqParmMap.get("surname")[0]);
         request.setAttribute("forename", reqParmMap.get("forename")[0]);
         Pilot pilotDelete = new Pilot(reqParmMap.get("surname")[0], reqParmMap
                  .get("forename")[0]);
         try {
            pilotDelete = flbI.deletePilot(pilotDelete);
            request.setAttribute("msg", "Gelšscht!");
         } catch (Exception e) {
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("detailPilot")
               || reqParmMap.containsKey("displayPilot")
               || reqParmMap.containsKey("savePilot")) {
         Pilot pilotSearch = new Pilot(reqParmMap.get("surname")[0], reqParmMap
                  .get("forename")[0]);
         try {
            List<Pilot> pilotsFound = flbI.getPilots(pilotSearch);
            if (pilotsFound != null && pilotsFound.size() <= 1) {
               if (pilotsFound.size() == 1) {
                  Pilot pilotFound = pilotsFound.get(0);
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  request.setAttribute("medical", pilotFound.getMedical());
                  request.setAttribute("radioComLicence", pilotFound
                           .getRadioComLicence());
                  if (reqParmMap.containsKey("savePilot")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("msg", "Bereits vorhanden!");
                  } else {
                     if (request.getAttribute("msg") != null) {
                        request.removeAttribute("msg");
                     }
                     if (reqParmMap.containsKey("detailPilot")) {
                        forward = JSP_PILOT_DETAIL;
                     } else if (reqParmMap.containsKey("displayPilot")) {
                        forward = JSP_PILOT_DISPLAY;
                     }
                  }
               } else {
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  if (reqParmMap.containsKey("savePilot")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("medical",
                              reqParmMap.get("medical")[0]);
                     request.setAttribute("radioComLicence", reqParmMap
                              .get("radioComLicence")[0]);
                     Pilot pilot = new Pilot(reqParmMap.get("surname")[0],
                              reqParmMap.get("forename")[0], reqParmMap
                                       .get("medical")[0], reqParmMap
                                       .get("radioComLicence")[0]);
                     try {
                        pilot = flbI.savePilot(pilot);
                        request.setAttribute("msg", "Gespeichert!");
                     } catch (Exception e) {
                        request.setAttribute("msg", "Fehler beim Speichern!");
                     }
                  } else {
                     forward = JSP_PILOT_SEARCH;
                     request.setAttribute("msg", "Nicht gefunden!");
                  }
               }
            } else {
               forward = JSP_PILOT_SEARCH;
               request.setAttribute("msg", "Mehr als ein Pilot gefunden!");
            }
         } catch (Exception e) {
            forward = JSP_PILOT_SEARCH;
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("searchPilot")) {
         forward = JSP_PILOT_SEARCH;
      } else {
         forward = JSP_FLIGHT_LOG_CTRL;
         request.setAttribute("msg", "Unbekannte Funktion!");
      }
      return forward;
   }

   private String handleFlightFunctions(HttpServletRequest request,
            HttpServletResponse response, Map<String, String[]> reqParmMap)
            throws Exception {
      String forward = "";
      FlightLogBusinessImpl flbI = new FlightLogBusinessImpl();
      if (reqParmMap.containsKey("createFlight")) {
         forward = JSP_PILOT_DETAIL;
      } else if (reqParmMap.containsKey("deleteFlight")) {
         forward = JSP_PILOT_DETAIL;
         request.setAttribute("surname", reqParmMap.get("surname")[0]);
         request.setAttribute("forename", reqParmMap.get("forename")[0]);
         Pilot pilotDelete = new Pilot(reqParmMap.get("surname")[0], reqParmMap
                  .get("forename")[0]);
         try {
            pilotDelete = flbI.deletePilot(pilotDelete);
            request.setAttribute("msg", "Gelšscht!");
         } catch (Exception e) {
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("detailFlight")
               || reqParmMap.containsKey("displayFlight")
               || reqParmMap.containsKey("saveFlight")) {
         Pilot pilotSearch = new Pilot(reqParmMap.get("surname")[0], reqParmMap
                  .get("forename")[0]);
         try {
            List<Pilot> pilotsFound = flbI.getPilots(pilotSearch);
            if (pilotsFound != null && pilotsFound.size() <= 1) {
               if (pilotsFound.size() == 1) {
                  Pilot pilotFound = pilotsFound.get(0);
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  request.setAttribute("medical", pilotFound.getMedical());
                  request.setAttribute("radioComLicence", pilotFound
                           .getRadioComLicence());
                  if (reqParmMap.containsKey("saveFlight")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("msg", "Bereits vorhanden!");
                  } else {
                     if (request.getAttribute("msg") != null) {
                        request.removeAttribute("msg");
                     }
                     if (reqParmMap.containsKey("detailFlight")) {
                        forward = JSP_PILOT_DETAIL;
                     } else if (reqParmMap.containsKey("displayFlight")) {
                        forward = JSP_PILOT_DISPLAY;
                     }
                  }
               } else {
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  if (reqParmMap.containsKey("saveFlight")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("medical",
                              reqParmMap.get("medical")[0]);
                     request.setAttribute("radioComLicence", reqParmMap
                              .get("radioComLicence")[0]);
                     Pilot pilot = new Pilot(reqParmMap.get("surname")[0],
                              reqParmMap.get("forename")[0], reqParmMap
                                       .get("medical")[0], reqParmMap
                                       .get("radioComLicence")[0]);
                     try {
                        pilot = flbI.savePilot(pilot);
                        request.setAttribute("msg", "Gespeichert!");
                     } catch (Exception e) {
                        request.setAttribute("msg", "Fehler beim Speichern!");
                     }
                  } else {
                     forward = JSP_PILOT_SEARCH;
                     request.setAttribute("msg", "Nicht gefunden!");
                  }
               }
            } else {
               forward = JSP_PILOT_SEARCH;
               request.setAttribute("msg", "Mehr als ein Pilot gefunden!");
            }
         } catch (Exception e) {
            forward = JSP_PILOT_SEARCH;
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("searchFlight")) {
         forward = JSP_PILOT_SEARCH;
      } else {
         forward = JSP_FLIGHT_LOG_CTRL;
         request.setAttribute("msg", "Unbekannte Funktion!");
      }
      return forward;
   }
}
