<%-- 
    Document   : listado_productos
    Created on : 11/10/2023, 08:24:09 PM
    Author     : Cristian
--%>

<!-- JSTL integra etiquetas utiles para JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <header>
                <h1 class="h1">Listado de productos</h1>
            </header>  

            <a href="ControladorProductos?accion=crearProducto" class="btn btn-outline-primary">Crear producto</a>
            <table class="table">
                <thead class="thead-class">
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Acciones</th>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${productos != null}">
                            <c:forEach var="producto" items="${productos}">
                                <tr>
                                    <td><c:out value="${producto.id}" /></td>
                                    <td><c:out value="${producto.nombre}" /></td>
                                    <td>
                                        <a href="ControladorProductos?accion=leerProducto&idProducto=${producto.id}" class="btn btn-outline-success">Leer</a> &nbsp;
                                        <a href="#" class="btn btn-outline-warning">Modificar</a> &nbsp;
                                        <a href="#" class="btn btn-outline-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="3">
                                    <div class="alert alert-primary" role="alert">
                                        No hay productos registrados aún.
                                    </div>
                                </td> 
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </body>
</html>
