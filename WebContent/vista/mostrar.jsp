<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h4>cargando listado</h4>
	<table class="table table-striped table-hover table-bordered" width="100%">
	<thead>
		<tr>
			<td>Codigo</td>
			<td>Nombre</td>
			<td>Descripcion</td>
			<td>Existencia</td>
			<td>Precio</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="articulo" items="${lista}">
			<tr>
				<td><c:out value="${articulo.codigo}"/></td>
				<td><c:out value="${articulo.nombre }"/></td>
				<td><c:out value="${articulo.descripcion }"/></td>
				<td><c:out value="${articulo.existencia}"/></td>
				<td>$&nbsp<c:out value="${articulo.precion}"/></td>
				
				<td><a class="btn btn-warning" href="adminArticulo?action=showEdit&id=<c:out value="${articulo.id}"/>" role="button">Editar</a></td>
				<td><a class="btn btn-danger" role="button" href="adminArticulo?action=eliminar&id=<c:out value="${articulo.id}"/>">Eliminar</a></td>
			</tr>
		</c:forEach>
	</thead>
	</table>
	</div>
</body>
</html>