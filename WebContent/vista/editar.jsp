<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<form class="form-horizontal" action="adminArticulo?action=editar" method="post">
		<div class="col-md-12">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<h4>Editar Articulo</h4>
				
					<label for="codigo">Codigo</label>
					<input type="text" class="form-control" placeholder="codigo..." value="<c:out value="${articulo.codigo}"/>" />
					<label for="nombre">Nombre</label>
					<input type="text" class="form-control" placeholder="nombre..." value="<c:out value="${articulo.nombre}"/>" />
					<label for="descripcion">Descripcion</label>
					<input type="text" class="form-control" placeholder="descripcion..." value="<c:out value="${articulo.descripcion}"/>" />
					<label for="existencia">Existencia</label>
					<input type="text" class="form-control" placeholder="existencia..." value="<c:out value="${articulo.existencia}"/>" />
					<label for="Precio">Precio</label>
					<input type="text" class="form-control" placeholder="precio..." value="<c:out value="${articulo.precion}"/>" />
					<br/>
					<input class="btn btn-primary" type="submit" name="registrar" value="Guardar">
					<a class="btn btn-danger" href="adminArticulo?action=listar" role="button">Cancelar</a>			
			</div>
			<div class="col-md-4"></div>
		</div>
		</form>
	</div>
</body>
</html>