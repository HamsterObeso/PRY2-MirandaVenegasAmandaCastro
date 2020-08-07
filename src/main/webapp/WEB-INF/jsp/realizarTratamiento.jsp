<%@page import="modelo.CatalogoTratamiento"%>
<%@page import="generico.Tabla"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!DOCTYPE html>
<html lang="en" dir="ltr">

  <head>

    <meta charset="utf-8">

    <style>

      body {
      	background-color: rgb(242, 242, 242);
      }

      .container {
      	width: 100%;
        height: 500px;
        background-color: #FFFFFF;
        border-radius: 10px;
        display: block;
        box-shadow: 0 5px 10px 0 rgba(32, 11, 11, 0.5)
      }

      .content {
        width: 50%;
        height: 100%;
        border-radius: 10px;
      }

      button {
        display: block;
        background: none;
      	color: inherit;
      	border: none;
      	padding: 0;
      	font: inherit;
      	cursor: pointer;
      	outline: inherit;
        border-radius: 5px;
        text-align: center;
        padding: 14px 20px;
        box-shadow: 0 5px 15px 0 rgba(22,50,30,0.3);
        background-color: #4CAF50;
        color: white;
        width: 20%;
      }

      button:hover {
        opacity: 0.8;
      }

      h2 {
        margin: 10px;
      }

      label {
        display: block;
      }

      form {
        margin: 10px;
      }

      form > label {
        margin-top: 10px;
        margin-left: 10px;
      }

      form > button {
        margin-top: 20px;
        margin-left: 10px;
      }

      form > input {
        margin-left: 10px;
        margin-top: 5px;
        width: 20%
      }

    </style>

    <title>Realizar Tratamiento</title>

  </head>

  <body>

    <div class="container">

        <h2> Realizar Tratamiento </h2>

        <div class="form">

            <form:form action="realizarTratamiento" method="post" modelAttribute="realizarTratamientoF">
                <label for="nombreTratamiento"><b>Nombre del Tratamiento</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el tratamiento deseado" name="nombreTratamiento" path="nombreTratamiento"/>
                <label for="tipo"><b>Nivel</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el tipo de tratamiento" name="tipo" path="tipo"/>    
                <label for="dosis"><b>Observaciones</b></label>
                <form:input class="input" type="text" placeholder="Ingrese la dosis recomendada" name="dosis" path="dosis"/>    
                <form:input class="boton verde" type="submit" name="Tratar" value="Tratar" path="opcion"/>
            </form:form>

        </div>
          
        <table>

        <tr>

            <%               
                Tabla<CatalogoTratamiento> tratamiento = (Tabla<CatalogoTratamiento>) request.getAttribute("resultados");
                if(tratamiento != null) {
                    for(String columna: tratamiento.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(tratamiento != null) {
                for(int i = 0; i < tratamiento.obtenerLargo(); i++) {
                    ArrayList<Object> campos = tratamiento.obtenerCampos(i);               
        %>
                    <tr>            
        <%
                        for(Object campo: campos) {                       
        %>
                            <td><%= campo %></td>
        <%
                        }   
        %>
                    </tr>
        <%
                }
            }
        %>

    </table>

  </body>