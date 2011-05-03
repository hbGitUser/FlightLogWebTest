<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flugbuch: Piloten/Flüge verwalten</title>
</head>
<body>
<form method="get" action='FlightLogBookCtrl' name="search">
Funktion auswählen
<table>
   <tr>
      <td>Pilot:</td>
      <td>
         <input type="submit" value="Pilot suchen" name="searchPilot">
         <input type="submit" value="Pilot anlegen" name="createPilot">
         <input type="reset" value="reset">
      </td>
   </tr>
   <tr>
      <td>Flug:</td>
      <td>
         <input type="submit" value="Flug suchen" name="searchFlight">
         <input type="submit" value="Flug anlegen" name="createFlight">
         <input type="reset" value="reset">
      </td>
   </tr>
   <tr>
      <td>
         <%=(request.getAttribute("msg") != null) ? request.getAttribute("msg") : "" %>
      </td>
   </tr>
</table>
</form>
</body>
</html>
