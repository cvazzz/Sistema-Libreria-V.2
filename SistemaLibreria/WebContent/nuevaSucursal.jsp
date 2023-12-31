<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Nueva Sucursal</h1>
<br>
<br>
		<form action="sucursal" method="POST">
		<input type="hidden" name="opcionPost" value="grabarSucursal">
				Nombre <input type="text" name="nombre"><br><br>
				Direccion <input type="text" name="direccion"><br><br>
					Estado <input type="number" name="estado"><br><br>
				
		</select><br><br>
		
		<button>Grabar</button>
		</form>
</body>

</html>