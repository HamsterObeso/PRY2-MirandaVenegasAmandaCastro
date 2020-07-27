<%@page import="fabrica.FabricaOpciones"%>
<%@page import="contexto.ContextoUsuario"%>
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
        display: flex;
        border-radius: 10px;
        box-shadow: 0 5px 10px 0 rgba(32,11,11,0.25);
      }

      .content {
        width: 50%;
        height: 100%;
        border-radius: 10px;
      }

      .title {
        text-align: center;
        padding: 120px 0;
        font-size: 30px;
      }

      .option {
        position: relative;
        padding: 30px;
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
        padding: 15px;
        padding-top: 10px;
        padding-bottom: 10px;
        box-shadow: 0 5px 15px 0 rgba(22,50,30,0.3);
        color: white;
        width: 20%;
        margin-top: 20px;
      }

      button:hover {
        opacity: 0.8;
      }

      select {
        width: 40%;
        height: 10%;
      }

      #action {
        background-color: #4CAF50;
      }

      #close {
        background-color: #C11E2D;
        position: absolute;
        right:    2%;
        bottom:   15%;
      }

    </style>
    <title>Menu Principal</title>
  </head>
  <body>
    <div class="container">

      <div class="content title">
        <h1><b>Hospital TEC</b></h1>
        <h1>¡Bienvenido ${tipo} ${usuario}!</h1>
      </div>

      <div class="content option">
        <h3>¿Que desea realizar?</h3>
        
        <form action="inicioSesion" method="post" commandName="opcion">        
            <select name="category">
                <% 
                   String tipo = ContextoUsuario.getTipo();
                   ArrayList<String> opciones = FabricaOpciones.getOpciones(tipo);
                   for(int i = 0; i < opciones.size(); i++) {
                    String opcion = opciones.get(i);                
                %>
                    <option value="<%= opcion %>"><%= opcion %></option>
                <% 
                    } 
                %>              
            </select>
            <button id="action" type="submit" name="button">Realizar operacion</button>       
        </form>
        
       
        <button id="close" type="button" name="button">Cerrar sesion</button>
      </div>

    </div>
  </body>
</html>
