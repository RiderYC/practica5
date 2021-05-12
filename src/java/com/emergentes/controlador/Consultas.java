package com.emergentes.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas extends Conexion {
    public boolean autenticacion(String usuario,String password){
        PreparedStatement pst = null;
        ResultSet rs  = null;
        
        try{
            String consultas = "select * from usuario = ? and password = ?";
            pst = getConexion().prepareStatement(consultas);
            pst.setString(1,usuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)){
            return true;
        }
        }catch (Exception e){
            System.out.println("Error" + e);
        }finally {
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null)rs.close();
            }catch (Exception e){
               System.out.println("Error" + e);
            }
        }
        return false;
    }
    public boolean registrar(String usuario, String password){
        PreparedStatement pst = null;
        try{
            String consultas = "insert into usuarios(uaurio, password) values (?, ?)";
            pst = getConexion().prepareCall(consultas);
            pst.setString(1,usuario);
            pst.setString(2, password);
            
            if (pst.executeUpdate() == 1){
                return true;
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }finally {
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }catch (Exception e){
            System.out.println("Error:" + e);
            }
        }
        return false;
    } 
}
