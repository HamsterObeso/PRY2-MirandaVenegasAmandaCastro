<%@page import="modelo.TablaHospitalizaciones"%>
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
      }

    </style>

    <title>Menu Principal</title>

  </head>

  <body>

    <div class="container">
        
        <h2> Realizar Seguimiento </h2>

        <div class="form">

          <form action="realizarSeguimiento" method="post" commandName="realizarSeguimientoForm">
              
            <label for="hospitalizacion"><b>ID Hospitalización</b></label>
            <input type="number" placeholder="Ingrese el ID de la hospitalización." name="idHospitalizacion" path="idHospitalizacion" required>
            <label for="observacion"><b>Observación sobre el seguimiento</b></label>
            <input type="text" placeholder="Ingrese la observación :)" name="observacion" path="observacion" required>
            <label for="tratamiento"><b>Nombre del tratamiento</b></label>
            <input type="text" placeholder="Ingrese el nombre del tratamiento asociado" name="tratamientoAsociado" path="tratamientoAsociado" required>
            <button type="submit">Realizar Seguimiento</button>

          </form>

        </div>
<table>

        <tr>

            <%               
                Tabla<TablaHospitalizaciones> hospitalizaciones = (Tabla<TablaHospitalizaciones>) request.getAttribute("resultados");
                if(hospitalizaciones != null) {
                    for(String columna: hospitalizaciones.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(hospitalizaciones != null) {
                for(int i = 0; i < hospitalizaciones.obtenerLargo(); i++) {
                    ArrayList<Object> campos = hospitalizaciones.obtenerCampos(i);               
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