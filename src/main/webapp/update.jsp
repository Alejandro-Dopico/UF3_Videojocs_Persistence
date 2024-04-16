<%-- 
    Document   : update
    Created on : 20 de nov. 2023, 16:27:04
    Author     : alumne_2n
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="dwes.uf1.modelo.Game"%>
<%@ page import="dwes.uf1.modelo.GameServicio" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC Sample</title>
    </head>
    <body>
        <%
            if (request.getAttribute("single_product") != null) {
                Game product = (Game) request.getAttribute("single_product");
        %>

        <h1>Modifica el videojuego "<%= product.getName()%>"</h1>
        <form name="updateform" action="GameServlet" method="POST"> <!-- Removed the erroneous closing </form> tag -->
            <table>
                <h3>Cambia los valores</h3>
                <tr><td></td><td><input type="hidden" name="id" value="<%= product.getId()%>"></td></tr>
                <tr><td>Name:</td><td><input type="text" name="name" value="<%= product.getName()%>"></td></tr>
                <tr><td>Developer:</td><td><input type="text" name="developer" value="<%= product.getDeveloper()%>"></td></tr>
                <tr><td>Price:</td><td><input type="text" name="price" value="<%= product.getPrice()%>"></td></tr>
                <tr><td>Year:</td><td><input type="text" name="year" value="<%= product.getYear()%>"></td></tr>
            </table>
            <br>
            <input type="hidden" name="action" value="updateform">
            <input type="submit" name="submit" value="Enviar">
            <br><br>
            <a href="GameServlet">Volver</a> 
        </form>    
        <% }%>
    </body>
    
</html>