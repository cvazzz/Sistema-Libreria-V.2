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
	<h1>Editar Jefe Tienda</h1>
	<br>
	<br>
	<form action="JefeController" method="POST">
		<input type="hidden" name="opcionPost" value="actualizarJefeTienda">
		<input type="hidden" name="codigo" value="${objJefeTienda.codigo}">
		Nombre: <input type="text" name="nombre" value="${objJefeTienda.nombre}"><br><br>
		Apellido Paterno: <input type="text" name="apellidoPaterno" value="${objJefeTienda.apellidoPaterno}"><br><br>
		Apellido Materno: <input type="text" name="apellidoMaterno" value="${objJefeTienda.apellidoMaterno}"><br><br>
		DNI:<input type="text" name="dni" value="${objJefeTienda.dni}"><br><br>
		<button>Grabar</button>
	</form>
</body>
</html>