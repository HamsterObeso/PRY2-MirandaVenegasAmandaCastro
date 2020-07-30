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

        <h2> Secretario </h2>

        <div class="form">

          <form action="hospitalizacionesRegistradasS" method="post" commandName="hospitalizacionesRegistradasSForm">

            <label for="fechaIni1"><b>Primer rango de fechas</b></label>
            <input type="text" placeholder="Fecha inicial" name="fechaIni1" path="fechaIni1">
            <input type="text" placeholder="Fecha final" name="fechaFin1" path="fechaFin1">
            <label for="fechaIni2"><b>Segundo rango de fechas</b></label>
            <input type="text" placeholder="Fecha inicial" name="fechaIni2" path="fechaIni2">
            <input type="text" placeholder="Fecha Final" name="fechaFin2" path="fechaFin2">
            <label for="estado"><b>Estado </b></label>
            <input type="text" placeholder="Indique el estado" name="estado" path="estado">
            <label for="especialidad"><b>Especialidad</b></label>
            <input type="text" placeholder="Nombre de la especialidad " name="especialidad" path="especialidad">
            <label for="nombrePaciente"><b>Nombre paciente</b></label>
            <input type="text" placeholder="Nombre paciente " name="nombrePaciente" path="nombrePaciente">
            <button type="submit">Filtrar</button>

          </form>

        </div>

  </body>

</html>