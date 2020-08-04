<%@page import="modelo.TablaHospitalizacionesPaciente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   <!DOCTYPE html>
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

    <title>Hospitalizaciones del Paciente</title>

  </head>
  
  <h2> Hospitalizaciones del Paciente </h2>
  
  <table>
            
            <tr>
                
                <th>Id Hospitalizacion</th>
                <th>Identificacion</th>
                <th>Nombre Paciente</th>
                <th>Diagnostico</th>
                <th>Fecha Inicio</th>
                <th>Fecha Final</th>
                <th>Especialidad</th>
                
                
            </tr>
            
            <%
                ArrayList<TablaHospitalizacionesPaciente> hospitalizaciones = (ArrayList<TablaHospitalizacionesPaciente>) request.getAttribute("resultados");
                if(hospitalizaciones != null) {
                    for(TablaHospitalizacionesPaciente hospitalizacion: hospitalizaciones) {
                        int id = hospitalizacion.getId();
                        String identificacion = hospitalizacion.getIdentificacion();
                        String nombrePaciente = hospitalizacion.getNombre();
                        String diagnostico = hospitalizacion.getDiagnostico();
                        String fechaIni = hospitalizacion.getFechaIni();
                        String fechaFin = hospitalizacion.getFechaFin();
                        String especialidad = hospitalizacion.getEspecialidad();
            %>
                        <tr>
                            <td><%= id%></td>
                            <td><%= identificacion%></td>
                            <td><%= nombrePaciente%></td>
                            <td><%= diagnostico%></td>
                            <td><%= fechaIni%></td>
                            <td><%= fechaFin%></td>
                            <td><%= especialidad%></td>
                        </tr>
            <%
                    }
                }
            %>
            
        </table>
        
        
        <% if(request.getAttribute("mensaje") != null) { %>
                <script>alert(${mensaje});</script>
        <%  } %>
       
            
</body>
</html>