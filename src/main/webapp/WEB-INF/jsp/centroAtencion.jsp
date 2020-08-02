<%@page import="modelo.TablaCentrosAtencion"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=text], input[type=IdCita] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            .boton {
                background: none;
                color: inherit;
                border: none;
                padding: 0;
                font: inherit;
                cursor: pointer;
                outline: inherit;
                border-radius: 5px;
                text-align: center;
                padding: 15px;
                padding-top: 10px;
                padding-bottom: 10px;
                box-shadow: 0 5px 15px 0 rgba(22,50,30,0.3);
                color: white;
                width: 20%;
                margin-top: 20px;
                margin-bottom: 10px;
                margin-left: 10px;
            }

            .boton:hover {
                opacity: 0.8;
            }   

            label {
                display: block;
                margin-top: 16px;
                margin-left: 10px;
            }
            
            .container {
                width: 100%;
                height: 100%;
                background-color: #FFFFFF;
                border-radius: 10px;
                box-shadow: 0 5px 10px 0 rgba(32,11,11,0.25);
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }
            
            .verde {
                background-color: #4CAF50;
            }

             .rojo {
               background-color: #C11E2D;
             }
             
             .input {
                 margin-left: 10px;
             }
             
             table {
                 margin: 16px;
                 width: 100%;
             }
             
             table th {
                text-align:left;
             }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelarbtn {
                    width: 100%;
                }
            }
        </style>
    <title>Agregar Centros</title>
    </head>
    <body>
        
        <h2> Agregar Centros </h2>

        <div class="form">

          <form action="agregarCentro" method="post" commandName="agregarCentroForm">

            <label for="nombre"><b>Nombre</b></label>
            <input type="text" placeholder="Ingrese el nombre del centro" name="nombre" path="nombre" required>
            <label for="lugar"><b>Lugar</b></label>
            <input type="text" placeholder="Ingrese el lugar del centro" name="lugar" path="lugar" required>
            <label for="capacidad"><b>Capacidad</b></label>
            <input type="number" placeholder="Ingrese la capacidad del centro" min=0 name="capacidad" path="capacidad" required>
            <label for="tipo"><b>Tipo Centro</b></label>
            <input type="text" placeholder="Ingrese el tipo de Centro" name="tipo" path="tipo">
            <button type="submit">Agregar Centro</button>

          </form>
                     
        </div>
          
        <table>
            
            <tr>
                
                <th>Id</th>
                <th>Nombre</th>
                <th>Lugar</th>
                <th>Capacidad</th>
                <th>Tipo de Centro</th>
                
            </tr>
            
            <%
                ArrayList<TablaCentrosAtencion> centros = (ArrayList<TablaCentrosAtencion>) request.getAttribute("resultados");
                if(centros != null) {
                    for(TablaCentrosAtencion centro: centros) {
                        int id = centro.getId();
                        String nombre = centro.getNombre();
                        String lugar = centro.getLugar();
                        int capacidad = centro.getCapacidad();
                        String tipoCentro = centro.getTipoCentro();
            %>
                        <tr>
                            <td><%= id%></td>
                            <td><%= nombre%></td>
                            <td><%= lugar%></td>
                            <td><%= capacidad%></td>
                            <td><%= tipoCentro%></td>
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