
<%@page import="org.solent.com504.project.model.dto.Person"%>
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
String errorMessage = "";
String actionString = request.getParameter("action");
String stringid = request.getParameter("CarerId");
String stringAppId = request.getParameter("personId");
long personId = 0;
ServiceFacade serviceFacade = (ServiceFacade) WebClientObjectFactory.getServiceFacade();

if (stringid != null && actionString != "login") {
       personId = Long.parseLong(stringid);
} else if ("arrived".equals(actionString)){
       long id = Long.parseLong(stringAppId);
       //serviceFacade.updateDescription(id, "arrived");  DOESN'T WORK
}
    /** TO-DO   
      arrived set description to arrived
      get time working 
      arrived set description to arrived
      extend time
     getTime()
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
        <div style="color:red;"><%=errorMessage%></div>
        
        <p> <a href="../projectfacadeweb">Home page</a>
        <h2>Your details</h2>
        <form method="post">
            <input type="number" name="CarerId">
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
            <% for (Appointment appointment : serviceFacade.getAppointmentByCarerId(personId)) {
                Person personA = appointment.getPersonA();
                String personAFN = personA.getFirstName();
                String personASN = personA.getSecondName();
                String personAName = personAFN + " " + personASN;

                Person personB = appointment.getPersonB();
                String personBFN = personB.getFirstName();
                String personBSN = personB.getSecondName();
                String personBName = personBFN + " " + personBSN;
                
                String appDate = appointment.getHr() + " " + appointment.getMth() + " " + appointment.getYr();    
// if careworker = careworker input%>
           <tr>
                <td><%=appointment.getId()%></td>
                <td><%=personAName%></td>
                <td><%=personBName%></td>
                <td><%=appointment.getDescripton()%></td>
                <td><%=appDate%></td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%=appointment.getId()%>">
                        <button type="submit" name="action" value="arrived">Arrived</button>
                    </form> 
                </td>
                <td><%%></td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%=appointment.getId()%>">
                        <button type="submit" name="action" value="extend">Extend</button>
                    </form> 
                </td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%=appointment.getId()%>">
                        <button type="submit" name="action" value="delete">Finished</button>
                    </form> 
                </td>
            </tr>
            <%
            }  
            %>
        </table>
        <h2>Simple Farm Client Example</h2>
        <!-- http://localhost:8084/projectfacadeweb-client/testClientHeartbeat.jsp -->
        <p> click on <a href="../projectfacadeweb-client/testClientHeartbeat.jsp">testClientHeartbeat.jsp</a> to open client application
        </p>

    </body>
</html>
