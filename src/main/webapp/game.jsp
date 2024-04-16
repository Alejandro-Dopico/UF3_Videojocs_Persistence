<%-- 
    Document   : producto.jsp
    Created on : 11 nov 2022, 0:21:15
    Author     : manuc
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
        <title>MVC Games</title>
    </head>
    <body>
        <%
            if (request.getAttribute("single_product") != null) {
                Game product = (Game) request.getAttribute("single_product");
        %>

        <h1>Game Details of "<%= product.getName()%>"</h1>
        <div>ID: <%= product.getId()%></div>
        <div>Name: <%= product.getName()%></div>
        <div>Developer: <%= product.getDeveloper()%></div>
        <div>Price: $ <%= new DecimalFormat("#0.00").format(product.getPrice())%></div>
        <div>Year: <%= product.getYear()%></div>
        <br>
        <div><a href="GameServlet">Go Back</a></div>

        <% } else { %>

        <h1>Games List</h1>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Options</b></td>
                <td><b>Buttons</b></td>
            </tr>

            <% for (Game product : (List<Game>) request.getAttribute("game_list")) {%>

            <tr>
                <td><%= product.getName()%></td>
                <td>
                    <a href="GameServlet?id=<%= product.getId()%>">Details...</a> 
                </td>
                 <td>
                    <form action="GameServlet" method="POST">
                        <input type="hidden" name="id" value="<%= product.getId()%>">    
                        <input type="submit" name="action" value="delete"/>
                    </form>
                </td>
                <td>
                    <form action="GameServlet" method="POST">
                        <input type="hidden" name="id" value="<%= product.getId()%>">    
                        <input type="submit" name="action" value="update"/>
                    </form>
                </td>
            </tr>

            <% }%>
            
        </table> 
            <br>
            <a href="GameServlet?action=addform">+Añadir</a>         
           
            <% }%>

    </body>
</html>