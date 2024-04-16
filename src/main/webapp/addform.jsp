<%-- 
    Document   : addform
    Created on : 13 de nov. 2023, 16:30:47
    Author     : alumne_2n
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añade tu juego</title>
    </head>
    <body>
        <h1>Colección de Juegos!</h1>
        <form name="addform" action="GameServlet" method="POST"> <!-- Removed the erroneous closing </form> tag -->
            <table>
                <h3>Introduce tu juego</h3>
                <tr><td>Name</td><td><input type="text" name="name"></td></tr>
                <tr><td>Developer</td><td><input type="text" name="developer"></td></tr>
                <tr><td>Price</td><td><input type="text" name="price"></td></tr>
                <tr><td>Year</td><td><input type="text" name="year"></td></tr>
            </table>
            <br>
            <input type="hidden" name="action" value="add">
            <input type="submit" name="submit" value="Añadir">  
        </form>
        <br>
        <a href="GameServlet">Volver</a> 
    </body>
</html>