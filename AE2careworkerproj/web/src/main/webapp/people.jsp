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
String errorMessage = "";
response.setIntHeader("Refresh", 20);
String firstname = request.getParameter("FirstName");
String secondname = request.getParameter("SecondName");
String address = request.getParameter("Address");
String role = request.getParameter("role");
String actionString = request.getParameter("action");

ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade(); //serviceFacade is undefined

if (firstname != null && secondname != null && address != null && actionString != "arrived") {
            serviceFacade.newPerson(firstname, secondname, role, address);
} else if (actionString != "modify"){       //need to implement modify
            
} else if(actionString != "delete") {
            //serviceFacade.deletePerson(); //get id input working
} else {
    errorMessage = "ERROR: page called for unknown action";
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
        <div style="color:red;"><%=errorMessage%></div>
        <h2>Add person</h2>
        <form>
            <p>First Name <input type="text" name="FirstName"></p>
            <p>Second Name <input type="text" name="SecondName"></p>
            <p>Role: Carer <input type="radio" name="Role" value="Carer"> Patient <input type="radio" name="Role" value="Patient"></p>
            
            <p>Address <input type="text" name="Address"> </p>
            <button type="submit" name="action" value="create">New Person</button>
            <button type="submit" name="action" value="modify">Modify Person</button>
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
                        <button type="submit" name="action" value="delete">Delete</button>
                    </form> 
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
