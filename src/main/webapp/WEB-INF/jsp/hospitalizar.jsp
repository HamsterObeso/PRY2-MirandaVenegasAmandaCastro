<%@page import="modelo.TablaCita"%>
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

    <title>Realizar Diagnostico</title>

  </head>

  <body>

    <div class="container">

        <h2> Hospitalizar </h2>

        <div class="form">

            <form:form action="realizarDiagnostico" method="post" modelAttribute="realizarDiagnosticoF">
                <label for="id"><b>Id del diagnostico:</b></label>
                <form:input class="input" type="number" placeholder="Ingrese el Id de la especialidad" min="0" name="id" path="id"/>
                <label for="nombre"><b>Nombre del diagnostico:</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el diagnostico deseado" name="nombre" path="nombre"/>
                <label for="nivel"><b>Nivel</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el nivel del diagnostico" name="nivel" path="nivel"/>    
                <label for="observaciones"><b>Observaciones</b></label>
                <form:input class="input" type="text" placeholder="Ingrese las observaciones" name="observaciones" path="observaciones"/>    
                <form:input class="boton verde" type="submit" name="Diagnosticar" value="Diagnosticar" path="opcion"/>
                <form:input class="boton verde" type="submit" name="Atender" value="Atender" path="opcion"/>
                <form:input class="boton rojo" type="submit" name="Tratar" value="Tratar" path="opcion"/>
            </form:form>

        </div>
          
        <table>

        <tr>

            <%               
                Tabla<TablaCita> cita = (Tabla<TablaCita>) request.getAttribute("resultados");
                if(cita != null) {
                    for(String columna: cita.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(cita != null) {
                for(int i = 0; i < cita.obtenerLargo(); i++) {
                    ArrayList<Object> campos = cita.obtenerCampos(i);               
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