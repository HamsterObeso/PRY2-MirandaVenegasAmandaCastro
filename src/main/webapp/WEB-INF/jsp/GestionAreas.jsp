<%-- 
    Document   : GestionAreas
    Created on : 28/07/2020, 06:59:43 PM
    Author     : Masiel Castro Mora
--%>

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

    <title>Secretario</title>

  </head>

  <body>

    <div class="container">

        <h2> Citas registradas </h2>

        <div class="form">

          <form action="citasRegistradas" method="post" commandName="patientForm">

            <label for="fechaIni1"><b>Nombre del área/b></label>
            <input type="text" placeholder="Nombre area" name="nombre" path="nombre"> Esto se pone?
            <label for="fechaIni1"><b>Identificación área/b></label>
            <input type="text" placeholder="identificación area" name="idArea" path="idArea">
            <button type="submit">Agregar</button>
            <button type="submit">Eliminar</button>
            <button type="submit">Actualizar</button>
            <button type="submit">Consultar</button>

          </form>

        </div>

  </body>

</html>