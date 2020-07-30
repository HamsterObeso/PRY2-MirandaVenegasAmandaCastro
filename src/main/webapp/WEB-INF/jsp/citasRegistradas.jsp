<%-- 
    Document   : citasRegistradas
    Created on : 28/07/2020, 06:12:00 PM
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

          <form action="citasRegistradas" method="post" commandName="citasRegistradasSecreForm">

            <label for="fecha1"><b>Fecha inicial</b></label>
            <input type="text" placeholder="Fecha inicial:" name="fecha1" path="fecha1">
            <label for="fecha2"><b>Fecha final</b></label>
            <input type="text" placeholder="Fecha final: " name="fecha2" path="fecha2">
            <label for="estado"><b>Estado </b></label>
            <input type="text" placeholder="Estado" name="estado" path="estado">
            <label for="especialidad"><b>Especialidad</b></label>
            <input type="text" placeholder="Especialidad " name="especialidad" path="especialidad">
            <label for="nombrePaciente"><b>Nombre paciente</b></label>
            <input type="text" placeholder="Nombre paciente " name="nombrePaciente" path="nombrePaciente">
            <button type="submit">Filtrar</button>

          </form>

        </div>

  </body>

</html>