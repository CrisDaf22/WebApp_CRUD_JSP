<%-- 
    Document   : leer_producto
    Created on : 13/10/2023, 12:58:57 PM
    Author     : Cristian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leer producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    <center><h1 class="h1">Leer producto</h1></center>
    <div class="container" style="width: 30%;text-align: center">
        <c:choose>
            <c:when test="${producto != null}">
                <table class="table table-bordered border-primary">
                    <tbody>
                        <tr>
                            <th scope="row">ID</th>
                            <td>${producto.id}</td>
                        </tr>
                        <tr>
                            <th scope="row">Nombre</th>
                            <td>${producto.nombre}</td>
                        </tr>
                        <tr>
                            <th scope="row">Descripción</th>
                            <td>${producto.descripcion}</td>
                        </tr>
                        <tr>
                            <th scope="row">Cantidad</th>
                            <td>${producto.cantidad}</td>
                        </tr>
                        <tr>
                            <th scope="row">Imágen</th>
                            <td>
                                <img src="data:image/jpeg;base64,${imgProducto}" width="125" height="125"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:when>

            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    No se pudo encontrar el registro.
                </div>
            </c:otherwise>
        </c:choose>

        <br>
        <center><a href="ControladorProductos?accion=listarProductos" class="btn btn-outline-danger">Regresar</a></center>
    </div>
</body>
</html>
