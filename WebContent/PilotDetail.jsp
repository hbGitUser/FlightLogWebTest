<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pilot bearbeiten</title>
</head>
<body>
<form method="post" action='FlightLogBookCtrl' name="detail">
<table>
   <tr>
      <td>Nachname:</td>
      <td>
         <input type="text" name="surname" value=<%=(request.getAttribute("surname") != null) ? request.getAttribute("surname") : "" %>>
      </td>
   </tr>
   <tr>
      <td>Vorname:</td>
      <td>
         <input type="text" name="forename" value=<%=(request.getAttribute("forename") != null) ? request.getAttribute("forename") : "" %>>
      </td>
   </tr>
   <tr>
      <td>Tauglichkeitszeugnis:</td>
      <td>
         <input type="text" name="medical" value=<%=(request.getAttribute("medical") != null) ? request.getAttribute("medical") : "" %>>
      </td>
   </tr>
   <tr>
      <td>Sprechfunklizenz:</td>
      <td>
         <input type="text" name="radioComLicence" value=<%=(request.getAttribute("radioComLicence") != null) ? request.getAttribute("radioComLicence") : "" %>>
      </td>
   </tr>
   <tr>
      <td>
         <input type="submit" value="Speichern" name="savePilot">
         <input type="submit" value="Löschen" name="deletePilot">
         <input type="submit" value="Suchen" name="searchPilot">
         <input type="reset" value="reset">
         <input type="submit" value="Zurück" name="ctrl">
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
