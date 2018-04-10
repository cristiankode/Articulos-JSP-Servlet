package com.ecodeup.articulo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.articulos.dao.ArticuloDAO;
import com.ecodeup.articulos.model.Articulo;

@WebServlet("/adminArticulo")
public class AdminArticulo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	ArticuloDAO articuloDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			articuloDAO = new ArticuloDAO(jdbcURL, jdbcUserName, jdbcPassword);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public AdminArticulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		System.out.println("Hola desde el servlet");
		String action = request.getParameter("action");
		
		try {
			switch(action) {
				case "listar":
					mostrar(request,response);
					break;
				case "editar":
					editar(request,response);
					break;
				case "eliminar":
					eliminar(request,response);
					break;
				case "showEdit":
					showEditar(request,response);
					break;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException,IOException {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Articulo> listaArticulos = articuloDAO.listarArticulos();
		for(Articulo lista : listaArticulos) {
			
			System.out.println(lista.getPrecion());
		}
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
		        
	}
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException{
		
		String id = request.getParameter("id");
		System.out.println(id);
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("articulo", articulo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException{
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException{
		
//		String id = request.getParameter("id");
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		articuloDAO.eliminar(articulo);
		mostrar(request,response);
	}
}
