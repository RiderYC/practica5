<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <form action="IniciarS" method="post">
            <label>Usuario</label>
            <input type="text" name="usuario"><br>
            <label>Contraseña</label>
            <input type="password" name="possword"><br>
            <input type="submit" name="Iniciar Sesion">
        </form>
        <br><br>
    <a href="registro.jsp">Registrarse</a>
    </body>
</html>
