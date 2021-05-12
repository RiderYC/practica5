package com.emergentes.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/bd_blog1";
    private String usuario = "root";
    private String password = "";
   /* private String host = "localhost";
    private String port = "3306";
    private String database = "bd_blog1";*/
    private String classname = "com.mysql.jdbc.Driver";
    private Connection con;
    
    public Conexion(){
        try{
            Class.forName(classname);
            con = DriverManager.getConnection(url, usuario, password);
            
        }catch (ClassNotFoundException e){
            System.out.println("Error" + e);
        } catch (SQLException e){
            System.out.println("Error" + e);
        }
    }  
    
    public Connection getConexion(){
        return con;
    }
}
