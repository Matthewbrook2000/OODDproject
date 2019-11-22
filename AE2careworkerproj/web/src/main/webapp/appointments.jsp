<%-- 
    Document   : newappointment
    Created on : 22-Nov-2019, 23:13:53
    Author     : Matt- Laptop
--%>

<%@page import="org.solent.com504.project.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setIntHeader("Refresh", 20);
String carername = request.getParameter("CarerName");
String patientname = request.getParameter("PatientName");

ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade();

//if (name != null && location != null && actionString != "arrived") {
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
<!--            <tr>
                <td><%//=animal.getAnimalType().getType()%></td>
                <td><%//=animal.getName()%></td>
                <td><%//=animal.getAddress()%></td>
                <td><%//=animal.getAnimalType().getSound()%></td>
                <td>
                    <form action="./farm2.jsp" method="post">
                        <input type="hidden" name="animalName" value="<%=animal.getName()%>">
                        <input type="hidden" name="action" value="deleteAnimal">
                        <button type="submit" >Delete</button>
                    </form> 
                </td>
            </tr>-->
        </table>
    </body>
</html>
