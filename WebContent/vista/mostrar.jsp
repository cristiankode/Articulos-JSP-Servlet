<jsp:include page="header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
	<div class="container">
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  		Nuevo Articulo
	</button>
	<br/>
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
	
	<!-- Modal -->
	
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <form action="adminArticulo?action=nuevo" method="post">
  	<div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Nuevo Articulo</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<label for="codigo">Codigo</label>
		    <input type="text" class="form-control" name="codigo" placeholder="codigo..."  />
        </div>
        <div class="form-group">
        	<label for="nombre">Nombre</label>
			<input type="text" class="form-control" name="nombre" placeholder="nombre..." />
        </div>
        <div class="form-group">
        	<label for="descripcion">Descripcion</label>
			<input type="text" class="form-control" name="descripcion" placeholder="descripcion..." />
        </div>
        <div class="form-group">
        	<label for="existencia">Existencia</label>
			<input type="text" class="form-control" name="existencia" placeholder="existencia..." />
        </div>
        <div class="form-group">
        	<label for="Precio">Precio</label>
			<input type="text" class="form-control" name="precio" placeholder="precio..." />
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
      </div>
    </div><!-- modal-content -->
  </div><!-- modal-dialog -->
  </form>
</div> <!-- modal -->
<jsp:include page="footer.jsp"></jsp:include>