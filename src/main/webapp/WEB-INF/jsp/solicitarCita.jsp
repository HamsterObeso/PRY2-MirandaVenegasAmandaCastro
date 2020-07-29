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

            <label for="especialidad"><b>Especialidad</b></label>
            <input type="text" placeholder="Ingrese la especialidad deseada" name="especialidad" path="especialidad" required>
            <label for="fecha"><b>Fecha de la cita</b></label>
            <input type="text" placeholder="Ingrese el día deseado para la cita" name="fecha" path="fecha" required>
            <label for="hora"><b>Hora de la cita</b></label>
            <input type="text" placeholder="Ingrese el hora deseado para la cita" name="hora" path="hora" required>
            <label for="observacion"><b>Observación</b></label>
            <input type="text" placeholder="Ingrese alguna observacion" name="observacion" path="observacion">
            <button type="submit">Solicitar Cita</button>

          </form>

        </div>

  </body>

</html>