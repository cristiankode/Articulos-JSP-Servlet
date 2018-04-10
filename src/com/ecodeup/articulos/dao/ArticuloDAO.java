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
 * @email cristianjavaprogrammer@gmail.com
 */

public class ArticuloDAO {

	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
	}

	// insertar un Articulo
	public boolean insertar(Articulo articulo) throws SQLException {
		String sql = "INSERT INTO articulos (id,codigo,nombre,descripcion,existencia,precio) VALUES(?,?,?,?,?,?)";
		System.out.println(sql);
		con.Conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(0, null);
		statement.setString(1, articulo.getNombre());
		statement.setString(2, articulo.getDescripcion());
		statement.setDouble(3, articulo.getExistencia());
		statement.setDouble(4, articulo.getPrecion());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	//Listar todos los artculos
	public List<Articulo> listarArticulos() throws SQLException{
		
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

}
