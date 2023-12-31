package com.SistemaLibreria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.SistemaLibreria.model.JefeTienda;


public class jefeTiendaDAO {
	private String url;  
	private  Connection conexion; 
	public jefeTiendaDAO() {
		
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=miSistemaCom; user=sa;password=sebastian";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion=DriverManager.getConnection(this.url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public List<JefeTienda> buscarJefeTienda(int codigo){
		List<JefeTienda> listaJefeTienda = new ArrayList<JefeTienda>();
		String query = "select * from JefeTienda where codigo=?";
		PreparedStatement pstmt;
		try {
			pstmt = this.conexion.prepareStatement(query);
			pstmt.setInt(1, codigo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//Cada vez que entre a este while se trata de un usuario
				//Voy a crear un objeto Usuario.
				int codigoJefe = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaterno = rs.getString(4);
				String dni = rs.getString(5);
				JefeTienda objJefeTienda = new JefeTienda(codigoJefe,nombre, apellidoPaterno,apellidoMaterno, dni);
				listaJefeTienda.add(objJefeTienda);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaJefeTienda;
	}*/
	
	public List<JefeTienda> buscarJefeTienda(){
		List<JefeTienda> listaJefeTienda=new ArrayList<JefeTienda>();
		Statement stmt; //Este objeto nos permitira hacer los Querys
		try {
			stmt=this.conexion.createStatement();
			String sentenciaSQL = "select * from JefeTienda";
			ResultSet rs=stmt.executeQuery(sentenciaSQL); //Se ejecuta el query y se guarda en un resultset//
			while(rs.next()) {
				int codigo=rs.getInt(1);
				String nombre=rs.getString(2);
				String apellidoPaterno=rs.getString(3);
				String apellidoMaterno=rs.getString(4);
				String dni=rs.getString(5);
				
				JefeTienda objJefeTienda=new JefeTienda(codigo,nombre,apellidoPaterno,apellidoMaterno,dni);
				listaJefeTienda.add(objJefeTienda);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaJefeTienda;
	}
	public JefeTienda buscarJefeTiendaxCodigo(int codigo) {
		JefeTienda objJefeTienda = new JefeTienda();
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL BuscarJefeTiendaPorCodigo(?)}");
			cs.setInt(1, codigo);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				//Cada vez que entre a este while se trata de un usuario
				//Voy a crear un objeto Usuario.
				int codigoJefeTienda = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaterno = rs.getString(4);
				String dni = rs.getString(5);
				objJefeTienda.setCodigo(codigoJefeTienda);
				objJefeTienda.setNombre(nombre);
				objJefeTienda.setApellidoPaterno(apellidoPaterno);
				objJefeTienda.setApellidoMaterno(apellidoMaterno);
				objJefeTienda.setDni(dni);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objJefeTienda;
	}
	
	public List<JefeTienda> buscarJefeTienda_SP(String nombre){
		List<JefeTienda> listaJefeTienda = new ArrayList<JefeTienda>();
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL BuscarJefeTiendaPorNombre(?)}");
			cs.setString(1, nombre);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				
				int codigo = rs.getInt(1);
				String nombreJefeTienda = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaterno = rs.getString(4);
				String dni = rs.getString(5);
				JefeTienda objJefeTienda = new JefeTienda(codigo,nombreJefeTienda, apellidoPaterno,apellidoMaterno, dni);
				listaJefeTienda.add(objJefeTienda);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaJefeTienda;
	}
/*============================================*/
	public List<JefeTienda> buscarJefeTienda_SPPaterno(String apellidoPaterno){
		List<JefeTienda> listaJefeTienda = new ArrayList<JefeTienda>();
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL BuscarJefeTiendaPorApellidoPaterno(?)}");
			if (apellidoPaterno != null && !apellidoPaterno.isEmpty()) {
			    cs.setString(1, apellidoPaterno);
			} else {
			    cs.setString(1, ""); // O asigna un valor predeterminado si el campo está vacío
			}
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
			
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoPaternoJefeTienda = rs.getString(3);
				String apellidoMaterno = rs.getString(4);
				String dni = rs.getString(5);
				JefeTienda objJefeTienda = new JefeTienda(codigo,nombre, apellidoPaternoJefeTienda,apellidoMaterno, dni);
				listaJefeTienda.add(objJefeTienda);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaJefeTienda;
	}
	
	public List<JefeTienda> buscarJefeTienda_SPMaterno(String apellidoMaterno){
		List<JefeTienda> listaJefeTienda = new ArrayList<JefeTienda>();
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL BuscarJefeTiendaPorApellidoMaterno(?)}");
			if (apellidoMaterno != null && !apellidoMaterno.isEmpty()) {
			    cs.setString(1, apellidoMaterno);
			} else {
			    cs.setString(1, ""); // O asigna un valor predeterminado si el campo está vacío
			}
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				//Cada vez que entre a este while se trata de un usuario
				//Voy a crear un objeto Usuario.
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaternoJefeTienda = rs.getString(4);
				String dni = rs.getString(5);
				JefeTienda objJefeTienda = new JefeTienda(codigo,nombre, apellidoPaterno,apellidoMaternoJefeTienda, dni);
				listaJefeTienda.add(objJefeTienda);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaJefeTienda;
	}
	public List<JefeTienda> buscarJefeTienda_SPApellidos(String apellidoPaterno, String apellidoMaterno){
	    List<JefeTienda> listaJefeTienda = new ArrayList<JefeTienda>();
	    CallableStatement cs;
	    try {
	        cs = this.conexion.prepareCall("{CALL BuscarJefeTiendaPorApellidos(?, ?)}");
	        if (apellidoMaterno != null && !apellidoMaterno.isEmpty() && apellidoPaterno != null && !apellidoPaterno.isEmpty()) {
	            cs.setString(1, apellidoPaterno);
	            cs.setString(2, apellidoMaterno);
	        } else {
	            cs.setString(1, ""); 
	            cs.setString(2, ""); 
	        }
	        ResultSet rs = cs.executeQuery();
	        while (rs.next()) {
	            int codigo = rs.getInt(1);
	            String nombre = rs.getString(2);
	            String apellidoPaternoJefeTienda = rs.getString(3);
	            String apellidoMaternoJefeTienda = rs.getString(4);
	            String dni = rs.getString(5);
	            JefeTienda objJefeTienda = new JefeTienda(codigo, nombre, apellidoPaternoJefeTienda, apellidoMaternoJefeTienda, dni);
	            listaJefeTienda.add(objJefeTienda);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaJefeTienda;
	}
	public void registrarJefeTienda_SP(String nombre, String apellidoPaterno, String apellidoMaterno,String dni) {
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL AgregarJefeTienda(?,?,?,?)}");
			cs.setString(1, nombre);
			cs.setString(2, apellidoPaterno);
			cs.setString(3, apellidoMaterno);
			cs.setString(4, dni);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarJefeTienda_SP(int codigo, String nombre, String apellidoPaterno, String apellidoMaterno,String dni) {
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL EditarJefeTienda(?,?,?,?,?)}");
			cs.setInt(1, codigo);
			cs.setString(2, nombre);
			cs.setString(3, apellidoPaterno);
			cs.setString(4, apellidoMaterno);
			cs.setString(5, dni);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarJefeTienda_SP(int codigo) {
		CallableStatement cs;
		try {
			cs = this.conexion.prepareCall("{CALL EliminarJefeTienda(?)}");
			cs.setInt(1, codigo);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}