<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>blog de salud</h1>
        
        <p><a href="Inicio?action=add">Nuevo</a></p>
        
        
            <c:forEach var="item" items="${posts}">
                <tr>
                    <br><br>
                    <td>${item.fecha}</td>
                    <br><br>
                    <td>${item.titulo}</td>
                    <br><br>
                    <td>${item.contenido}</td>
                    <br><br>
                    
                    <td><a href="Inicio?action=edit&id=${item.id}" >Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        
    </body>
</html>
