<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%

    
    /**
     * implement:
     * manual add, extend time and leaving
     * 
     */
%>
<html>
    <head>
        <title>Example JSPs index.html page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Call center</h1>
        
        <h2>Add, delete, update</h2> <!--link to new jsp pages-->
        <h2>Workers</h2>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Status</th>
            </tr>
        </table>
        
        <h2>Test Heartbeat</h2>
        <!-- http://localhost:8084/projectfacadeweb/testHeartbeat.jsp -->
        <p> click on <a href="../projectfacadeweb/testHeartbeat.jsp">testHeartbeat.jsp</a> to open application
        </p>
 
        <h1>Rest end points</h1>
        <table>
            <tr><td></td><td><a href="../projectfacadeweb/rest/appointmentService/">http://localhost:8084/projectfacadeweb/rest/appointmentService/</a> </td></tr>
            <tr><td></td><td><a href="../projectfacadeweb/rest/appointmentService/getHeartbeat">http://localhost:8084/projectfacadeweb/rest/appointmentService/getHeartbeat</a> </td></tr>
            <tr><td></td><td><a href="../projectfacadeweb/rest/appointmentService/arrived">http://localhost:8084/projectfacadeweb/rest/appointmentService/arrived</a> </td></tr>
        </table>


    </body>
</html>
