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
        display: flex;
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
        color: black;
        width: 20%;
      }

      button:hover {
        opacity: 0.8;
      }

    </style>

    <title>Menu Principal</title>

  </head>

  <body>

    <div class="container">
        <h2> Solicitar Cita </h2>

        <form action="solicitarCita" method="post" commandName="pacientForm">
            
          <div class="content info">
            <label for="especialidad"><b>Especialidad</b></label>
            <input type="text" placeholder="Ingrese la especialidad deseada" name="especialidad" path="especialidad" required>
            <label for="fecha"><b>Fecha de la cita</b></label>
            <input type="datetime-local" placeholder="Ingrese el día y hora deseados para la cita" name="fecha" path="fecha" required>
          </div>

          <div class="content info2">
              <label for="observacion"><b>Observación</b></label>
              <input type="text" placeholder="Ingrese alguna observacion" name="observacion" path="observacion">
              <button type="submit">Solicitar Cita</button>
          </div>
            
        </form>
    </div>

  </body>

</html>
