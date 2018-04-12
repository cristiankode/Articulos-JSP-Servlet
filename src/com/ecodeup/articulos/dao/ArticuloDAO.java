package com.ecodeup.articulos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.articulos.model.Articulo;
import com.ecodeup.articulos.model.Conexion;

/**
 * 
 * @author cristian Hurtado
 * @email <cristianjavaprogrammer@gmail.com>
 */

public class ArticuloDAO {

	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		System.out.println(jdbcUserName);
		System.out.println(jdbcPassword);
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
	}

	// insertar un Articulo
	public int insertar(Articulo articulo) throws SQLException {
		int rows = 0;
		String sql = "INSERT INTO articulos (codigo,nombre,descripcion,existencia,precio) VALUES(?,?,?,?,?)";
		System.out.println(sql);
		con.Conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.setString(0, null);
		statement.setString(1, articulo.getCodigo());
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getDescripcion());
		statement.setDouble(4, articulo.getExistencia());
		statement.setDouble(5, articulo.getPrecion());
		rows = statement.executeUpdate();
		System.out.println("registros afectados" + rows);
		statement.close();
		con.desconectar();
		return rows;
	}
	
	//Listar todos los artculos
	public List<Articulo> listarArticulos() throws SQLException{
		System.out.println("creando listado");
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
		con.Conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String codigo = rs.getString("codigo");
			String nombre = rs.getString("nombre");
			String descripcion = rs.getString("descripcion");
			Double existencia = rs.getDouble("existencia");
			Double precio = rs.getDouble("precio");
			Articulo articulo = new Articulo(id,codigo,nombre,descripcion,existencia,precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	public Articulo obtenerPorId(int id) throws SQLException{
		
		Articulo articulo = null;
		
		String sql = "SELECT * FROM articulos WHERE id= ?";
		con.Conectar();
		connection = con.getJdbcConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			articulo = new Articulo(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
									rs.getString("descripcion"), rs.getDouble("existencia"), rs.getDouble("precio"));
		}
		rs.close();
		con.desconectar();
		
		return articulo;
	}
	
	//Actualizar
	public boolean actualizar(Articulo articulo) throws SQLException{
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=?,precio=? WHERE id=?";
		con.Conectar();
		connection = con.getJdbcConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, articulo.getCodigo());
		ps.setString(2, articulo.getNombre());
		ps.setString(3, articulo.getDescripcion());
		ps.setDouble(4, articulo.getExistencia());
		ps.setDouble(5, articulo.getPrecion());
		ps.setInt(6, articulo.getId());
		
		rowActualizar = ps.executeUpdate() > 0;
		ps.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//Eliminar
	public boolean eliminar(Articulo articulo) throws SQLException{
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE id=?";
		con.Conectar();
		connection = con.getJdbcConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, articulo.getId());
		
		rowEliminar = ps.executeUpdate() > 0;
		ps.close();
		con.desconectar();
		return rowEliminar;
	}

}
