<%-- 
    Document   : newappointment
    Created on : 22-Nov-2019, 23:13:53
    Author     : Matt- Laptop
--%>

<%@page import="org.solent.com504.project.model.dto.Role"%>
<%@page import="org.solent.com504.project.model.dto.Person"%>
<%@page import="org.solent.com504.project.model.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="org.solent.com504.project.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setIntHeader("Refresh", 20);
String errorMessage = "";
String actionString = request.getParameter("action");
String stringcid = request.getParameter("CarerId");
String stringpid = request.getParameter("PatientId");
String desc = request.getParameter("Desc");
String stringhr = request.getParameter("Hour");
String stringmth = request.getParameter("Month");
String stringyr = request.getParameter("Year");
String stringdur = request.getParameter("Duration");

ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade();

if (stringcid != null && stringpid != null && actionString != "create") {
    if(stringhr != null && stringmth != null && stringyr != null && stringdur != null){
        int hr = Integer.parseInt(stringhr);           
        int mth = Integer.parseInt(stringhr);
        int yr = Integer.parseInt(stringyr);
        int duration = Integer.parseInt(stringdur);
        long carerid = Long.parseLong(stringcid);
        long patientid = Long.parseLong(stringpid);
        Person personA = serviceFacade.getPerson(carerid);
        Person personB = serviceFacade.getPerson(patientid);
        serviceFacade.addAppointment(desc, personA, personB, hr, mth, yr, duration);
    } 
//            serviceFacade.arrived(name, location);
}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>The time is: <%= new Date().toString() %> (note page is auto refreshed every 20 seconds)</p>
        <h1>Appointments</h1>
        <p> <a href="../projectfacadeweb">Home page</a>
        <div style="color:red;"><%=errorMessage%></div>
        <h2>Add appointment</h2>
        <form>
            Careworker
            <select name="CarerId">
                <% for (Person person : serviceFacade.getPersonByRole(Role.CARER)) {%>
                <option value="<%=person.getId()%>"><%=person.getFirstName()%> <%=person.getSecondName()%></option>
                <%
                    }
                %>
            </select>
            
            <p>Patient
            <select name="PatientId">
                <% for (Person person : serviceFacade.getPersonByRole(Role.PATIENT)) {%>
                <option value="<%=person.getId()%>"><%=person.getFirstName()%> <%=person.getSecondName()%></option>
                <%
                    }
                %>
            </select></p>
            <p>Description <input type="text" name="Desc"> </p>
            <p>Hour <input type="number" name="Hour"> </p>
            <p>Month <input type="number" name="Month"> </p>
            <p>Year <input type="number" name="Year"> </p>
            <p>Duration <input type="number" name="Duration"> </p>
            <button type="submit" name="action" value="create">New appointment</button>
        </form>
        <h2>table</h2>
        <table border="1">
            <tr>
                <th>Id </th>
                <th>Careworker </th>
                <th>Patient </th>
                <th>Status </th>
                <th>Extend time </th>
                <th>Delete </th>
            </tr>
            <% for (Appointment appointment : serviceFacade.getAllAppointments()) {%>
           <tr>
                <td><%=appointment.getId()%></td>
                <td><%=appointment.getPersonA()%></td>
                <td><%=appointment.getPersonB()%></td>
                <td><%appointment.getDescripton()%></td>
                <td></td>
                <td>
                    <form action="./farm2.jsp" method="post">
                        <input type="hidden" name="animalName" value="<%//=animal.getName()%>">
                        <input type="hidden" name="action" value="deleteAnimal">
                        <button type="submit" >Delete</button>
                    </form> 
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
