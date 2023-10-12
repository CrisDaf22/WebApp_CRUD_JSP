<%-- 
    Document   : index
    Created on : 11/10/2023, 08:23:07 PM
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        
        <style>
            * {
                text-align: center;
            }
            
            #main-content {
                border: 5px solid;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container" id="main-content">
            <header>
                <h1 class="display-1">Sistema CRUD</h1>
            </header>
            <p class="lead">
                Bienvenido al sistema, aquí podrás trabajar 
                con las consultas básicas a una base de datos.
            </p>
            <a class="btn btn-outline-primary" href="ControladorProductos?accion=listarProductos">Mostrar productos</a>
        </div>
    </body>
</html>
