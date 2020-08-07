<%@page import="generico.Tabla"%>
<%@page import="modelo.CatalogoDiagnostico"%>
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
        <title>Gestion de diagnosticos</title>
    </head>
    <body>
        
        <h2>Gestión diagnosticos</h2>
        
        <div class="container">         

            <form:form action="gestionDiagnostico" method="post" modelAttribute="diagnostico">
                <label for="id"><b>Id del diagnostico:</b></label>
                <form:input class="input" type="number" placeholder="Ingrese el Id de la especialidad" min="0" name="id" path="id"/>
                <label for="nombre"><b>Nombre del diagnostico:</b></label>
                <form:input class="input" type="text" placeholder="Ingrese el diagnostico deseado" name="nombre" path="nombre"/>              
                <form:input class="boton verde" type="submit" name="Crear" value="Crear" path="opcion"/>
                <form:input class="boton verde" type="submit" name="Actualizar" value="Actualizar" path="opcion"/>
                <form:input class="boton rojo" type="submit" name="Borrar" value="Borrar" path="opcion"/>
            </form:form>
                     
        </div>
          
        <table>
            
            <tr>
                
                <%               
                    Tabla<CatalogoDiagnostico> diagnosticos = (Tabla<CatalogoDiagnostico>) request.getAttribute("resultados");
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
        
        <% if(request.getAttribute("mensaje") != null) { %>
                <script>alert(${mensaje});</script>
        <%  } %>
       
            
</body>
</html>
