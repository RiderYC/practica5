package com.emergentes.utiles;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private String url = "jdbc:mysql://localhost:3306/bd_blog1";
    private String usuario = "root";
    private String password = "";

    protected Connection conn = null;

    public ConexionDB(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK: " + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("CERRANDO LA BD: " + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}

