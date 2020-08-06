<%@page import="modelo.TablaCantidadTratamientos"%>
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

    </style>

    <title>Menu Principal</title>

  </head>

  <body>

    <div class="container">

        <h2> Cantidad de Tratamientos || Realizar filtrados </h2>

        <div class="form">

          <form action="cantidadTratamientos" method="post" commandName="cantidadTratamientosForm">

            <label for="fecha"><b>Tipo de tratamiento</b></label>
            <input type="text" placeholder="Indique el tipo de tratamiento." name="tratamiento" path="tratamiento">
            <label for="estado"><b>Especialidad</b></label>
            <input type="text" placeholder="Indique la especialidad de la cita del tratamiento." name="especialidad" path="especialidad">
            <label for="fecha"><b>Identificación del paciente</b></label>
            <input type="text" placeholder="Indique la identificación del paciente." name="identificacion" path="identificacion">
            <button type="submit">Realizar filtrado</button>

          </form>

        </div>
        
        <table>

        <tr>

            <%               
                Tabla<TablaCantidadTratamientos> cantTratamientos = (Tabla<TablaCantidadTratamientos>) request.getAttribute("resultados");
                if(cantTratamientos != null) {
                    for(String columna: cantTratamientos.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(cantTratamientos != null) {
                for(int i = 0; i < cantTratamientos.obtenerLargo(); i++) {
                    ArrayList<Object> campos = cantTratamientos.obtenerCampos(i);               
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

