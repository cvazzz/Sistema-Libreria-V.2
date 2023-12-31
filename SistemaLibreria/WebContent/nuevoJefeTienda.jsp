<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Nuevo Jefe Tienda</h1>
	<br>
	<br>
	<form action="JefeController" method="POST">
		<input type="hidden" name="opcionPost" value="grabarJefeTienda">
		Nombre: <input type="text" name="nombre"><br><br>
		Apellido Paterno: <input type="text" name="apellidoPaterno"><br><br>
		Apellido Materno: <input type="text" name="apellidoMaterno"><br><br>
		DNI: <input type="text" name="dni"><br><br>
		<button>Grabar</button>
	</form>
</body>
</html>