<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<br>
	<div class="container">
		<form class="form-horizontal" action="adminArticulo?action=editar" method="post">
		<div class="col-md-12">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<h4>Editar Articulo</h4>
					<input type="hidden" name="id" value="<c:out value="${ articulo.id }" />"/>
					<label for="codigo">Codigo</label>
					<input type="text" class="form-control" name="codigo" placeholder="codigo..." value="<c:out value="${articulo.codigo}"/>" />
					<label for="nombre">Nombre</label>
					<input type="text" class="form-control" name="nombre" placeholder="nombre..." value="<c:out value="${articulo.nombre}"/>" />
					<label for="descripcion">Descripcion</label>
					<input type="text" class="form-control" name="descripcion" placeholder="descripcion..." value="<c:out value="${articulo.descripcion}"/>" />
					<label for="existencia">Existencia</label>
					<input type="text" class="form-control" name="existencia" placeholder="existencia..." value="<c:out value="${articulo.existencia}"/>" />
					<label for="Precio">Precio</label>
					<input type="text" class="form-control" name="precio" placeholder="precio..." value="<c:out value="${articulo.precion}"/>" />
					<br/>
					<input class="btn btn-primary" type="submit" name="registrar" value="Guardar">
					<a class="btn btn-danger" href="adminArticulo?action=listar" role="button">Cancelar</a>			
			</div>
			<div class="col-md-3"></div>
		</div>
		</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>