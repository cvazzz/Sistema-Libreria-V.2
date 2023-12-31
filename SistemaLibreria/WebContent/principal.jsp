<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Gestión Sucursal</h1>
    <br>
    <br>
    <form action="sucursal" method="GET">
    <input type = "hidden" name = "opcionGet" value= "buscarSucursales">
        Nombre Sucursal : <input type = "text" name = "nombre">
        <button>Buscar</button>
    </form>
    <br><br>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Direccion</td>
                <td>Estado</td>
             
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sucursal" items="${listaSucursales}">
                <tr>
                    <td>${sucursal.codigo}</td>
                    <td>${sucursal.nombre}</td>
                    <td>${sucursal.direccion}</td>
                    <td>${sucursal.estado}</td>
                    <td> 
                    	 	<a href="sucursal?opcionGet=editarSucursal&codigo=${sucursal.codigo}">Editar </a>
                              <a href="sucursal?opcionGet=eliminarSucursal&codigo=${sucursal.codigo}"> Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    <br><br>
    <form action="sucursal" method="POST">
    <input type="hidden" name="opcionPost" value="mostrarNuevaSucursal">
    <button>Nuevo</button>
    </form>
</body>
</html>