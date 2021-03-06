<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            #error {
                color: red;
            }
            
            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;                   
                }
            }
        </style>
    </head>
    <body>
        <h2>Iniciar Sesion</h2>
        <form action="inicioSesion" method="post" commandName="userForm">
            <div class="container">
                <label for="usuario"><b>Usuario</b></label>
                <input type="text" placeholder="Ingrese el usuario" name="usuario" path="usuario" required>
                <label for="password"><b>Contraseņa</b></label>
                <input type="password" placeholder="Ingrese la contraseņa" name="password" path="password" required>
                <button type="submit">Iniciar Sesion</button>
            </div>
        </form>
        <label id="error" style="opacity: ${opacity};"><b>Usuario o contraseņa incorrecta, por favor revise los datos</b></label>
    </body>
</html>
