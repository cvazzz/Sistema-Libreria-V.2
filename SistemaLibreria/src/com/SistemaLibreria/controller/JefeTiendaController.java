package com.SistemaLibreria.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.SistemaLibreria.dao.jefeTiendaDAO;
import com.SistemaLibreria.model.JefeTienda;



/**
 * Servlet implementation class JefeTiendaController
 */
@WebServlet("/JefeController")
public class JefeTiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private jefeTiendaDAO objJefeTiendaDAO = new jefeTiendaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JefeTiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("opcionGet");
		switch (accion) {
			case "mostrarJefeTienda": {
				mostrarJefeTienda(request,response);
				break;
			}
				case "buscarJefeTienda" : {
					buscarJefeTienda(request,response);
					break;
				}
				case "editarJefeTienda" : {
					editarJefeTienda(request,response);
					break;
				}
				case "eliminarJefeTienda":{
					eliminarJefeTienda(request,response);
					break;
				}
		}
	}
	public void eliminarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		objJefeTiendaDAO.eliminarJefeTienda_SP(codigo);
		String paginaDestino = "/gestionJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarJefeTienda(HttpServletRequest request,HttpServletResponse response) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		JefeTienda objJefeTienda = objJefeTiendaDAO.buscarJefeTiendaxCodigo(codigo);
		request.setAttribute("objJefeTienda", objJefeTienda);
		String paginaDestino = "/editarJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void buscarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
		List<JefeTienda> listaJefeTienda = null;
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		
	    if(apellidoPaterno.equals("")) {
			listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda_SPPaterno(apellidoPaterno);
		}else if(apellidoMaterno.equals("")) {
			listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda_SPMaterno(apellidoMaterno);
		}else if (apellidoPaterno.isEmpty() && apellidoMaterno.isEmpty()) {
	        // Si ambos campos están vacíos, ejecuta buscarJefeTienda sin condiciones.
	        listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda();
		}
		request.setAttribute("listaJefeTienda",listaJefeTienda);
		String paginaDestino = "/gestionJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}*/
	
	
	//=====================================
	public void buscarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
	    List<JefeTienda> listaJefeTienda = null;
	    String apellidoPaterno = request.getParameter("apellidoPaterno");
	    String apellidoMaterno = request.getParameter("apellidoMaterno");

	    if (apellidoPaterno.isEmpty() && apellidoMaterno.isEmpty()) {
	   
	        listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda();
	    } else if(!apellidoPaterno.equals("") && apellidoMaterno.isEmpty()) 
	    {
	
	    	listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda_SPPaterno(apellidoPaterno);
	    } else if (apellidoPaterno.isEmpty() && !apellidoMaterno.equals("")) {
	      
	    	listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda_SPMaterno(apellidoMaterno);
	        
	    }else if (!apellidoPaterno.isEmpty() && !apellidoMaterno.isEmpty()) {
	        // Aquí puedes agregar la lógica para el caso en que ambos apellidos no estén vacíos.
	        // Puedes llamar a un método específico o realizar la búsqueda que necesites.
	    	listaJefeTienda = objJefeTiendaDAO.buscarJefeTienda_SPApellidos(apellidoPaterno, apellidoMaterno);
	    }

	    request.setAttribute("listaJefeTienda", listaJefeTienda);
	    String paginaDestino = "/gestionJefeTienda.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
	    try {
	        dispatcher.forward(request, response);
	    } catch (ServletException | IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void mostrarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
		String paginaDestino = "/gestionJefeTienda.jsp";
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
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "actualizarJefeTienda" : {
				actualizarJefeTienda(request,response);
				break;
			}
			case "mostrarNuevoJefe":{
				mostrarNuevoJefe(request,response);
			}
			case "grabarJefeTienda":{
				grabarJefeTienda(request,response);
			}
	}
	}
	public void grabarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String dni = request.getParameter("dni");
		objJefeTiendaDAO.registrarJefeTienda_SP(nombre, apellidoPaterno, apellidoMaterno, dni);
		String paginaDestino = "/gestionJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mostrarNuevoJefe(HttpServletRequest request, HttpServletResponse response) {
		String paginaDestino = "/nuevoJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		public void actualizarJefeTienda(HttpServletRequest request, HttpServletResponse response) {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String apellidoPaterno = request.getParameter("apellidoPaterno");
			String apellidoMaterno = request.getParameter("apellidoMaterno");
			String dni = request.getParameter("dni");
		
			objJefeTiendaDAO.actualizarJefeTienda_SP(codigo, nombre, apellidoPaterno, apellidoMaterno, dni);
			String paginaDestino = "/gestionJefeTienda.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

