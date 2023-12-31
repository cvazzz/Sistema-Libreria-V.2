<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jefe Tienda</title>
</head>
<body>
	<h1>Gestión Jefe Tienda</h1>
	<br>
	<br>
	<form action="JefeController" method="GET">
		<input type="hidden" name="opcionGet" value="buscarJefeTienda">
		Apellido Paterno: <input type="text" name="apellidoPaterno">
			Apellido Materno: <input type="text" name="apellidoMaterno">
		<button>Buscar</button>
	</form>
	<br><br>
	<table>
		<thead>
			<tr>
				<td>Código</td>
				<td>Nombre</td>
				<td>Apellido Paterno</td>
				<td>Apellido Materno</td>
				<td>DNI</td>
				<td>Acciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="JefeTienda" items="${listaJefeTienda}">
				<tr>
					<td>${JefeTienda.codigo}</td>
					<td>${JefeTienda.nombre}</td>
					<td>${JefeTienda.apellidoPaterno}</td>
					<td>${JefeTienda.apellidoMaterno}</td>
					<td>${JefeTienda.dni}</td>
					<td><a href="JefeController?opcionGet=editarJefeTienda&codigo=${JefeTienda.codigo}">Editar</a>
						<a href="JefeController?opcionGet=eliminarJefeTienda&codigo=${JefeTienda.codigo}">Eliminar</a>
					</td>
				</tr>		
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<form action="JefeController" method="POST">
		<input type="hidden" name="opcionPost" value="mostrarNuevoJefe">
		<button>Nuevo</button>
	</form>
</body>
</html>