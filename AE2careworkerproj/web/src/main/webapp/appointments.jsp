<%-- 
    Document   : newappointment
    Created on : 22-Nov-2019, 23:13:53
    Author     : Matt- Laptop
--%>

<%@page import="org.solent.com504.project.model.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="org.solent.com504.project.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setIntHeader("Refresh", 20);
String carername = request.getParameter("CarerName");
String patientname = request.getParameter("PatientName");
String desc = request.getParameter("Desc");
String stringhr = request.getParameter("Hour");
//int hr = Integer.parseInt(stringhr);            //error
//int hr = Integer.parseInt(request.getParameter("Hour"));
//int mth = Integer.parseInt(request.getParameter("Month"));
//int yr = Integer.parseInt(request.getParameter("Year"));
//int duration = Integer.parseInt(request.getParameter("Duration"));
//long id = Long.parseLong(request.getParameter("id"));

ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade();

//if (carername != null && patientname != null && actionString != "arrived") {
//            serviceFacade.arrived(name, location);

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>The time is: <%= new Date().toString() %> (note page is auto refreshed every 20 seconds)</p>
        <h1>Appointments</h1>
        <h2>Add appointment</h2>
        <form>
            <p>Careworker <input type="text" name="CarerName"></p>
            <p>Patient <input type="text" name="PatientName"></p>
            <p>Description <input type="text" name="Desc"> </p>
            <p>id <input type="number" name="id"> </p>
            <p>Hour <input type="number" name="Hour"> </p>
            <p>Month <input type="number" name="Month"> </p>
            <p>Year <input type="number" name="Year"> </p>
            <p>Duration <input type="number" name="Duration"> </p>
            <button type="submit" name="action" value="create">New appointment</button>
        </form>
        <h2>table</h2>
        <table border="1">
            <tr>
                <th>Careworker </th>
                <th>Patient </th>
                <th>Status </th>
                <th>Extend time </th>
                <th>Delete </th>
            </tr>
            <% //for (Animal animal : farmFacade.getAllAnimals()) {%>
           <tr>
                <td><%//=animal.getAnimalType().getType()%></td>
                <td><%//=animal.getName()%></td>
                <td><%//=animal.getAddress()%></td>
                <td><%//=animal.getAnimalType().getSound()%></td>
                <td>
                    <form action="./farm2.jsp" method="post">
                        <input type="hidden" name="animalName" value="<%//=animal.getName()%>">
                        <input type="hidden" name="action" value="deleteAnimal">
                        <button type="submit" >Delete</button>
                    </form> 
                </td>
            </tr>
        </table>
    </body>
</html>
