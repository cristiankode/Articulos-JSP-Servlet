package com.ecodeup.articulos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author: cristian Hurtado
 * @email: cristianjavaprogrammer@gmail.com
 */

public class Conexion {
	
	private Connection jdbcConnection;
	private String jdbcURL;
	private String jdbcUserName;
	private String jdbcPassword;
	
	public Conexion(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void Conectar()throws SQLException{
		if(jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
		}
	}
	
	public void desconectar() throws SQLException{
		if(jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public Connection getJdbcConnection() {
		return jdbcConnection;
	}

}
