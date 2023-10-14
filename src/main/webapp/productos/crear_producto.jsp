<%-- 
    Document   : crear_producto
    Created on : 12/10/2023, 09:03:08 PM
    Author     : Cristian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container" style="width: 30%">
            <header>
                <center><h1>Crear producto</h1></center>
            </header>

            <form action="ControladorProductos?accion=almacenarProducto" method="POST" enctype="multipart/form-data">
                <!-- Segíun se asigne ID o no, entonces será un proceso de creación o modificación -->
                <c:choose>
                    <c:when test="${producto.id == null}">
                        <!-- disabled elimina del form el dato, por eso se usa hidden -->
                        <div class="mb-3">
                            <label for="txt_idProducto" class="form-label">ID del producto</label>
                            <input type="number" class="form-control" id="txt_idProducto" value="0" disabled name="txt_idProducto">
                        </div>
                        <input type="hidden" name="txt_idProducto" value="0">
                    </c:when>

                    <c:otherwise>
                        <div class="mb-3">
                            <label for="txt_idProducto" class="form-label">ID del producto</label>
                            <input type="number" class="form-control" id="txt_idProducto" value="${producto.id}" disabled name="txt_idProducto">
                        </div>
                        <input type="hidden" name="txt_idProducto" value="${producto.id}">
                    </c:otherwise>
                </c:choose>

                <div class="mb-3">
                    <label for="txt_nombreProducto" class="form-label">Nombre del producto</label>
                    <input type="text" class="form-control" id="txt_nombreProducto" value="${producto.nombre}" name="txt_nombreProducto">
                </div>

                <div class="mb-3">
                    <label for="txt_descripcionProducto" class="form-label">Descripción del producto</label>
                    <input type="text" class="form-control" id="txt_descripcionProducto" value="${producto.descripcion}" name="txt_descripcionProducto">
                </div>

                <div class="mb-3">
                    <label for="txt_cantidadProducto" class="form-label">Cantidad</label>
                    <input type="number" class="form-control" id="txt_cantidadProducto" value="${producto.cantidad}" name="txt_cantidadProducto">
                </div>

                <div class="mb-3">
                    <label for="txt_imagenProducto" class="form-label">Nueva imágen</label>
                    <input type="file" class="form-control" id="txt_imagenProducto" accept='image/png, image/jpg, image/jpeg' name="txt_imagenProducto">
                </div>

                <c:if test="${imgProducto != null}">
                    <div class="mb-3">
                        <label for="txt_imgProducto" class="form-label">Imágen actual</label>
                        <img src="data:image/jpeg;base64,${imgProducto}" id="txt_imgProducto" width="125" height="125"/>
                    </div>
                </c:if>
                
                <center><input type="submit" class="btn btn-primary" text="Crear" /></center>
            </form>
            <br>
            <center><a href="ControladorProductos?accion=listarProductos" class="btn btn-outline-danger">Regresar</a></center>
        </div>
    </body>
</html>
