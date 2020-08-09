<%@page import="modelo.TablaPacientesAtendidos"%>
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

    <title>Hospitalizar</title>

  </head>

  <body>

    <div class="container">

        <h2> Hospitalizar </h2>

        <div class="form">

            <form:form action="hospitalizar" method="post" modelAttribute="hospitalizarF">
                <label for="nombre"><b>Nombre del paciente</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el nombre del paciente" name="nombre" path="nombre"/>
                <label for="identificacion"><b>Identificacion</b></label>
                <form:input class="input" type="text" placeholder="Ingrese la identificación del paciente" name="identificacion" path="identificacion"/>    
                <label for="centro"><b>Centro donde será internado</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el centro" name="centro" path="centro"/> 
                <label for="especialidad"><b>Especialidad</b></label>
                <form:input class="input" type="text" placeholder="Ingrese la especialidad en la que será internado" name="especialidad" path="especialidad"/>
                <label for="diagnostico"><b>Diagnostico</b></label>
                <form:input class="input" type="text" placeholder="Ingrese la especialidad en la que será internado" name="diagnostico" path="diagnostico"/>
                <label for="fecha"><b>Fecha</b></label>
                <form:input class="input" type="text" placeholder="Ingrese la fecha de finalizacion de la hospitalizacion" name="fecha" path="fecha"/> 
                <form:button type="submit">Hospitalizar</form:button> 
            </form:form>

        </div>
          
        <table>

        <tr>

            <%               
                Tabla<TablaPacientesAtendidos> pacientes = (Tabla<TablaPacientesAtendidos>) request.getAttribute("resultados");
                if(pacientes != null) {
                    for(String columna: pacientes.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(pacientes != null) {
                for(int i = 0; i < pacientes.obtenerLargo(); i++) {
                    ArrayList<Object> campos = pacientes.obtenerCampos(i);               
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