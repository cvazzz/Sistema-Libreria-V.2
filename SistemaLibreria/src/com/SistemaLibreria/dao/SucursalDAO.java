package com.SistemaLibreria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.SistemaLibreria.model.Sucursal;



public class SucursalDAO {
	private String url;  /* Este atributo guarda la ruta donde se encuentra la BBDD*/
	private  Connection conexion;

public SucursalDAO() {
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
public List<Sucursal> buscarTodosSucursal(){
	List<Sucursal> listaSucursales=new ArrayList<Sucursal>();
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "select * from sucursal";
		ResultSet rs=stmt.executeQuery(sentenciaSQL); //Se ejecuta el query y se guarda en un resultset//
		while(rs.next()) {
			int codigo=rs.getInt(1);
			String nombre=rs.getString(2);
			String direccion=rs.getString(3);
			int estado=rs.getInt(4);
			
			Sucursal objSucursal=new Sucursal(codigo,nombre,direccion,estado);
			listaSucursales.add(objSucursal);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listaSucursales;
}
public List<Sucursal> buscarSucursalxNombre(String nombre){
	List<Sucursal> listaSucursales = new ArrayList<Sucursal>();
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "select * from sucursal where nombre like '%" + nombre + "%'";
		ResultSet rs= stmt.executeQuery(sentenciaSQL); //Se ejecuta el query y se guarda en un resultset//
		while(rs.next()) {
			//cadavez que entre a este while se trata de un usuario
			//voy a crear un objeto usuario
			int codigo = rs.getInt(1);
			String nombreSucursal = rs.getString(2);
			String direccion = rs.getString(3);
			int estado = rs.getInt(4);
			Sucursal objSucursal = new Sucursal(codigo,nombreSucursal, direccion, estado);
			listaSucursales.add(objSucursal);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listaSucursales;
}
public int validarSucursalxNombre(String nombre) {
	int existe=0;
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "select * from sucursal where nombre='" + nombre + "' ";
		ResultSet rs=stmt.executeQuery(sentenciaSQL); //Se ejecuta el query y se guarda en un resultset//
		while(rs.next()) {
			existe=1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return existe;
}
public void registrarSucursal(String nombre, String direccion, int estado) {
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "insert into sucursal(nombre,direccion,estado) values ('"+nombre+"','"+direccion+"','" + estado + "')";
		stmt.execute(sentenciaSQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public Sucursal buscarSucursalxCodigo(int codigo) {
	Sucursal objSucursal=new Sucursal();
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "select * from sucursal where codigo like " + codigo;
		ResultSet rs= stmt.executeQuery(sentenciaSQL); //Se ejecuta el query y se guarda en un resultset//
		while(rs.next()) {
		
			int codigoSucursal = rs.getInt(1);
			String nombreSucursal = rs.getString(2);
			String direccion = rs.getString(3);
			int estado = rs.getInt(4);
	
			objSucursal = new Sucursal(codigoSucursal,nombreSucursal,direccion,estado);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return objSucursal;
}
public void eliminarSucursal(int codigo) {
	// TODO Auto-generated method stub
	Statement stmt; //Este objeto nos permitira hacer los Querys
	try {
		stmt=this.conexion.createStatement();
		String sentenciaSQL = "delete from sucursal where codigo="+ codigo;

		stmt.execute(sentenciaSQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
}
}
