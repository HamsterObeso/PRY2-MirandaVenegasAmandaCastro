<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h2>Bienvenido :)</h2>
        
        <div class="container">         

            <form:form action="inicio" method="post" modelAttribute="inicioF">
                <form:input class="boton verde" type="submit" name="Iniciar Sesion" value="Iniciar Sesion" path="opcion"/>
                <form:input class="boton verde" type="submit" name="Registrar Paciente" value="Registrar Paciente" path="opcion"/>
                <form:input class="boton rojo" type="submit" name="Registrar Funcionario" value="Registrar Funcionario" path="opcion"/>
            </form:form>
                     
        </div>
    </body>
</html>
