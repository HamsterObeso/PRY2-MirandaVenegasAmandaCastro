<%@page import="modelo.TablaCitasDE"%>
<%@page import="generico.Tabla"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
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

      table {
        margin: 16px;
        width: 100%;
      }

      table th {
        text-align:left;
      }
      
    </style>

    <title>Citas en sistema</title>

  </head>

  <body>

    <div class="container">

        <h2> Información de Citas en el Sistema || Realizar filtrados </h2>

        <div class="form">

          <form action="citasSistemaDocEnf" method="post" commandName="citasSistemaDocEnfForm">

            <label for="fecha"><b>Rango de fechas</b></label>
            <input type="text" placeholder="Indique el primer rango de fecha." name="fecha1" path="fecha1">
            <input type="text" placeholder="Indique el segundo rango de fecha." name="fecha2" path="fecha2">
            <label for="estado"><b>Estado</b></label>
            <input type="text" placeholder="Indique el estado de la cita." name="estado" path="estado">
            <label for="fecha"><b>Especialidad</b></label>
            <input type="text" placeholder="Indique la especialidad de la cita." name="especialidad" path="especialidad">
            <label for="fecha"><b>Nombre Paciente</b></label>
            <input type="text" placeholder="Indique el nombre del paciente." name="nombrePaciente" path="nombrePaciente">
            <button type="submit">Realizar filtrado</button>

          </form>

        </div>
    
    </div>
        
    <table>

        <tr>

            <%               
                Tabla<TablaCitasDE> diagnosticos = (Tabla<TablaCitasDE>) request.getAttribute("resultados");
                if(diagnosticos != null) {
                    for(String columna: diagnosticos.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(diagnosticos != null) {
                for(int i = 0; i < diagnosticos.obtenerLargo(); i++) {
                    ArrayList<Object> campos = diagnosticos.obtenerCampos(i);               
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

</html>

