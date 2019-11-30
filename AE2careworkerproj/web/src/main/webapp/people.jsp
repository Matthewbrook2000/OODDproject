<%-- 
    Document   : people
    Created on : 30-Nov-2019, 23:32:32
    Author     : Matt- Laptop
--%>

<%@page import="org.solent.com504.project.model.dto.Person"%>
<%@page import="org.solent.com504.project.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setIntHeader("Refresh", 20);
String firstname = request.getParameter("FirstName");
String secondname = request.getParameter("SecondName");
String address = request.getParameter("Address");
String actionString = request.getParameter("action");
// add role and id inputs


ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade();

if (firstname != null && secondname != null && address != null && actionString != "arrived") {
            serviceFacade.newPerson(null, firstname, secondname, null, address);
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>The time is: <%= new Date().toString() %> (note page is auto refreshed every 20 seconds)</p>
        <h1>People</h1>
        <h2>Add person</h2>
        <form>
            <p>First Name <input type="text" name="FirstName"></p>
            <p>Second Name <input type="text" name="SecondName"></p>
            <p>Role <input type="text" name="Role"> </p>
            <p>Address <input type="number" name="Address"> </p>
            <p>Id <input type="number" name="id"> </p>
            <button type="submit" name="action" value="create">New Person</button>
        </form>
        <h2>table</h2>
        <table border="1">
            <tr>
                <th>ID </th>
                <th>First Name </th>
                <th>Second Name </th>
                <th>Role </th>
                <th>Delete </th>
            </tr>
            <% for (Person person : serviceFacade.getAllPersons()){%>
           <tr>
                <td><%=person.getId()%></td>
                <td><%=person.getFirstName()%></td>             <!--error somewhere here-->
                <td><%=person.getSecondName()%></td>
                <td><%=person.getRole()%></td>
                <td>
                    <form action="./people.jsp" method="post">
                        <input type="hidden" name="personId" value="<%=person.getId()%>">
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
