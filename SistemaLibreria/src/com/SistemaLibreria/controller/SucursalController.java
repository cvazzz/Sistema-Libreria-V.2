package com.SistemaLibreria.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.SistemaLibreria.dao.SucursalDAO;
import com.SistemaLibreria.model.Sucursal;

/**
 * Servlet implementation class SucursalController
 */
@WebServlet("/sucursal")
public class SucursalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SucursalDAO objSucursalDAO=new SucursalDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SucursalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion= request.getParameter("opcionGet");
		switch(opcion) {
		case "mostrarSucursal": {
			mostrarSucursal( request, response);
			break;
		}
		case "buscarSucursales": {
			buscarSucursales( request, response);
			break;
		}
		case "eliminarSucursal":{
			eliminarSucursal( request, response);
			break;
		}
		}
	}
	public void mostrarSucursal(HttpServletRequest request,HttpServletResponse response) {
		String paginaDestino = "/principal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarSucursales(HttpServletRequest request, HttpServletResponse response) {
		List<Sucursal> listaSucursales;
		String nombre=request.getParameter("nombre");
		if(nombre.equals("")) {
			listaSucursales=objSucursalDAO.buscarTodosSucursal();
		}else {
			listaSucursales=objSucursalDAO.buscarSucursalxNombre(nombre);
		}
		request.setAttribute("listaSucursales", listaSucursales);
		String paginaDestino="/principal.jsp";
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void eliminarSucursal(HttpServletRequest request, HttpServletResponse response) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		objSucursalDAO.eliminarSucursal(codigo);
		String paginaDestino = "/principal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcionPost");
		switch (opcion) { 
		case "mostrarNuevaSucursal":{
			mostrarNuevaSucursal(request,response);
			break;
		}
		case "grabarSucursal":{
			grabarSucursal(request,response);
			break;
		}
	}
}
public void grabarSucursal(HttpServletRequest request, HttpServletResponse response) {
	String nombre = request.getParameter("nombre");
	String direccion = request.getParameter("direccion");
	
	String paginaDestino;
	int existe = objSucursalDAO.validarSucursalxNombre(nombre);
	if(existe ==0) {
		
		objSucursalDAO.registrarSucursal(nombre,direccion,1);
		paginaDestino="/principal.jsp";
	}
	else {
		
		paginaDestino="/nuevaSucursal.jsp";
	}
	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(paginaDestino);
	try {
		dispatcher.forward(request,response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void mostrarNuevaSucursal(HttpServletRequest request, HttpServletResponse response) {
	String paginaDestino="/nuevaSucursal.jsp";
	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(paginaDestino);
	try {
		dispatcher.forward(request,response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}	




