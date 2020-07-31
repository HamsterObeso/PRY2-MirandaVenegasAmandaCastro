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
        
        <h2> Agregar Funcionario </h2>

        <div class="form">

          <form action="agregarFuncionario" method="post" commandName="funcionarioForm">

            <label for="identificacion"><b>Identificacion</b></label>
            <input type="text" placeholder="Ingrese su identificacion." name="identificacion" path="identificacion" required>
            <label for="nombre"><b>Nombre completo</b></label>
            <input type="text" placeholder="Ingrese su nombre completo" name="nombre" path="nombre" required>
            <label for="tipo"><b>Hora de la cita</b></label>
            <input type="text" placeholder="Ingrese su fecha de nacimiento" name="fechaNacimiento" path="fechaNacimiento" required>
            <label for="tipoFuncionario"><b>Tipo de Funcionario</b></label>
            <input type="text" placeholder="Ingrese su tipo de sangre" name="tipoFuncionario" path="tipoFuncionario">
            <label for="area"><b>Área de Trabajo</b></label>
            <input type="text" placeholder="Ingrese su área de trabajo" name="area" path="area">
            <button type="submit">Añadir Funcionario</button>

          </form>

        </div>

        <% if(request.getAttribute("funcionario") != null) { %>
            <script>alert("Se agregó el funcionario.");</script>
        <%  } else if (request.getAttribute("error") != null) { %>
            <script>alert("Fallo la vaina");</script>
        <% } %>
  </body>

</html>
