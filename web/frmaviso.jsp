<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${posts.id == 0}">Nuevo</c:if>
            <c:if test="${posts.id != 0}">Editar</c:if>
            posts
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${posts.id}"/>
            
                <br><br>
                <tr>
                    <td>Fecha:</td>
                    <td><input type="text" name="titulo" value="${posts.fecha}"/></td>
                </tr>
                <br><br>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${posts.titulo}"/></td>
                </tr>
                <br><br>
                <tr>
                    <td>Contenido:</td>
                    <td><textarea name="contenido" rows="4" cols="20">
                            ${posts.contenido}
                        </textarea></td>
                </tr>
                <br><br>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ENVIAR"/></td>
                </tr>
            
        </form>
    </body>
</html>
