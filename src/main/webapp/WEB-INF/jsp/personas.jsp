<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Nombres</th>
			<th>Apellidos</th>
		</tr>
		<c:forEach items="${personas}" var="persona">
			<tr>
				<td>${persona.nombre}</td>
				<td>${persona.apellido}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
		</tr>
	</table>
	<br/>
	<form:form method="POST" modelAttribute="personaAdd">
		<table border="1">
			<tr>
				<td>Nombres</td>
				<td><form:input type="text" id="nombre" path="nombre"/></td>
			</tr>
			<tr>	
				<td>Apellidos</td>
				<td><form:input type="text" id="apellido" path="apellido"/></td>
			</tr>
			<tr>
				<td><button type="submit" value="submit">Guardar</button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>