<%@page import="modelo.TablaCita"%>
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

        <h2> Asignar Cita </h2>

        <div class="form">

          <form action="asignarCita" method="post" commandName="patientForm">

            <label for="idCita"><b>Identificación cita</b></label>
            <input type="text" placeholder="Ingrese la identificación de la cita" name="idCita" path="idCita" required>
            <label for="idFuncionario"><b>Tipo funcionario</b></label>
            <input type="text" placeholder="Indique el tipo de funcionario" name="idUsuario" path="idUsuario">
            <button type="submit">Asignar Cita</button>

          </form>

        </div>
        
        <table>

        <tr>

            <%               
                Tabla<TablaCita> citas = (Tabla<TablaCita>) request.getAttribute("resultados");
                if(citas != null) {
                    for(String columna: citas.obtenerColumnas()) {    
            %> 
                        <th><%= columna %></th>       
            <%
                    }
                }
            %>

        </tr>

        <%          
            if(citas != null) {
                for(int i = 0; i < citas.obtenerLargo(); i++) {
                    ArrayList<Object> campos = citas.obtenerCampos(i);               
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

