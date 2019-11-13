<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%
response.setIntHeader("Refresh", 20);
String actionString = request.getParameter("action");
String carerName = request.getParameter("CarerName");

//ServiceFacade serviceFacade = (serviceFacade) WebObjectFactory.getServiceFacade();
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
        
        <h2>Your details</h2>

        <!-- post avoids url encoded parameters -->
     
        
        <h2>Buttons</h2>
        <form>
            <input type="text" name="CarerName">
            <button type="submit" name="action" value="arrived">Arrived</button>
            <button type="submit" name="action" value="extTime">Extend time</button>
            <button type="submit" name="action" value="leaving">Leaving</button>
        </form>

        <h2>Simple Farm Client Example</h2>
        <!-- http://localhost:8084/projectfacadeweb-client/testClientHeartbeat.jsp -->
        <p> click on <a href="../projectfacadeweb-client/testClientHeartbeat.jsp">testClientHeartbeat.jsp</a> to open client application
        </p>



    </body>
</html>
