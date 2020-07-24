<%-- 
    Document   : inicioSesion
    Created on : 23/07/2020, 04:10:50 PM
    Author     : Masiel Castro Mora
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
    </head>
    <body>
        <hr>
        <h1>Formulario de acceso</h1>
        <hr>
        <form action="inicioSesion.jps" method="POST">
            Usuario:<input type="text" name="txtUsuario"><br>
            Contraseña:<input type="text" name="txtContrasenia"><br>
            <input type="submit" name="btnIngresar" value="Ingresar">
        </form>
        <%
   


            
            %>
            
    </body>
</html>
