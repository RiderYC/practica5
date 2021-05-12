package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostsDAOimpl extends ConexionDB implements PostsDAO{

    @Override
    public void insert(Posts posts) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into posts (fecha, titulo, contenido) values (?, ?, ?)");
            ps.setDate(1, posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Posts posts) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE posts set fecha = ? , titulo = ?, contenido = ? where id = ?");
            ps.setDate(1, posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.setInt(4, posts.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts pos = new Posts();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pos.setId(rs.getInt("id"));
                pos.setFecha(rs.getDate("fecha"));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return pos;
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Posts>();
            while(rs.next()){
                Posts pos = new Posts();
                pos.setId(rs.getInt("id"));
                pos.setFecha(rs.getDate("fecha"));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
                lista.add(pos);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
}
