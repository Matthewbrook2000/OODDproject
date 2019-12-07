
<%@page import="org.solent.com504.project.model.dto.Appointment"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="org.solent.com504.project.impl.webclient.WebClientObjectFactory"%>

<%
response.setIntHeader("Refresh", 20);
String actionString = request.getParameter("action");
String name = request.getParameter("CarerName");
String location = request.getParameter("CarerLocation");

ServiceFacade serviceFacade = (ServiceFacade) WebClientObjectFactory.getServiceFacade();

if (name != null && location != null && actionString != "login") {
                
//            serviceFacade.arrived(name, location);
    }
    /** TO-DO   
     * 
     * need to get this working on ServiceFacadeInpl, ServiceRestClientImpl and RestService
     
     Get Extend time button to modify appointment
     * done via: ServiceFacade, ServiceFacadeInpl, ServiceRestClientImpl and RestService
     
     Get Leaving to delete appointment
     * done via: ServiceFacade, ServiceFacadeInpl, ServiceRestClientImpl and RestService
      
     Implement AppointmentDAO
     * done via AppointmentDAOJpaImpl
     
     Implement PersonDAO
     * done via PersonDAOJpaImpl 
      
     Move on to call center
     
     **/
%>

<html>
    <head>
        <title>Example JSPs index.html page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
         <p>The time is: <%= new Date().toString() %> (note page is auto refreshed every 20 seconds)</p>
        <h1>Example Client JSP Pages</h1>
        
        <p> <a href="../projectfacadeweb">Home page</a>
        <h2>Your details</h2>
        <form method="post">
            <input type="text" name="CarerName">
            <button type="submit" name="action" value="login">Log in</button>
        </form>
        <table border="1">
            <tr>
                <th>Id </th>
                <th>Careworker </th>
                <th>Patient </th>
                <th>Description </th>
                <th>Date </th>
                <th>Arrived </th>
                <th>Time left </th>
                <th>Extend time </th>
                <th>Job finished</th>
            </tr>
            <% //for (Appointment appointment : serviceFacade.getAllAppointments()) {
// if careworker = careworker input%>
           <tr>
                <td><%//=appointment.getId()%></td>
                <td><%%></td>             
                <td><%%></td>
                <td><%%></td>
                <td><%%></td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%%>">
                        <button type="submit" name="action" value="arrived">Arrived</button>
                    </form> 
                </td>
                <td><%%></td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%%>">
                        <button type="submit" name="action" value="extend">Extend</button>
                    </form> 
                </td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%%>">
                        <button type="submit" name="action" value="delete">Finished</button>
                    </form> 
                </td>
            </tr>
            <%
            //}  
            %>
        </table>
        <h2>Simple Farm Client Example</h2>
        <!-- http://localhost:8084/projectfacadeweb-client/testClientHeartbeat.jsp -->
        <p> click on <a href="../projectfacadeweb-client/testClientHeartbeat.jsp">testClientHeartbeat.jsp</a> to open client application
        </p>

    </body>
</html>
