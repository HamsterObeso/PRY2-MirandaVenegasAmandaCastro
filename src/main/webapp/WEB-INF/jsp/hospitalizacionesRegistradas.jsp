<%-- 
    Document   : hospitalizacionesRegistradas
    Created on : 28/07/2020, 03:59:30 PM
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

    <title>Menu Principal</title>

  </head>

  <body>

    <div class="container">

        <h2> Solicitar Cita </h2>

        <div class="form">

          <form action="solicitarCita" method="post" commandName="patientForm">

            <label for="fechaIni1"><b>Fecha inicial 1</b></label>
            <input type="text" placeholder="Fecha inicial 1:" name="fechaIni1" path="fechaIni1">
            <label for="fechaIni2"><b>Fecha incial 2</b></label>
            <input type="text" placeholder="Fecha inicial 2: " name="fechaIni2" path="fechaIni2">
            <label for="fechaFinal1"><b>Fecha final 1</b></label>
            <input type="text" placeholder="Fecha final 1: " name="fechaFinal1" path="fechaFinal1">
            <label for="fechaFinal2"><b>Fecha final 2</b></label>
            <input type="text" placeholder="Fecha Final 2: " name="fechaFin2" path="fechaFin2">
            <label for="estado"><b>Estado </b></label>
            <input type="text" placeholder="Estado" name="estado" path="estado">
            <label for="especialidad"><b>Especialidad</b></label>
            <input type="text" placeholder="Especialidad " name="especialidad" path="especialdad">
            <label for="nombrePaciente"><b>Nombre paciente</b></label>
            <input type="text" placeholder="Nombre paciente " name="nombrePaciente" path="nombrePaciente">
            <button type="submit">Filtrar</button>

          </form>

        </div>

  </body>

</html>