/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.conx.ConnX;
import com.mycompany.modelo.ResultadosTo;

/**
 *
 * @author romer
 */
public class ResultadosDao implements ResultadosDaoI{
    ConnX intance=ConnX.getInstance();
    Connection conexion=intance.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listarResultados() {
        List<ResultadosTo> lista=new ArrayList();
        String sql="select * from resultado";
        try {
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
               ResultadosTo to=new ResultadosTo();
               to.setIdResultado(rs.getInt("id_resultado"));
               to.setNombrePartida(rs.getString("nombre_partida"));
               to.setNombreJugador1(rs.getString("nombre_jugador1"));
               to.setNombreJugador2(rs.getString("nombre_jugador2"));
               to.setGanador(rs.getString("ganador"));
               to.setPunto(rs.getInt("punto"));
               to.setEstado(rs.getInt("estado"));
               lista.add(to);
            }
            
        } catch (Exception e) {
        }
        return lista;
    }
    
    @Override
    public int crearResultado(ResultadosTo re) {
        int exec=0;
        int i=0;
        String sql="insert into resultados(nombre_partida, nombre_jugador1, nombre_jugador2, ganador, punto, estado)"
                + " values(?,?,?,?,?,?)";
        try {
            ps=conexion.prepareStatement(sql);
            ps.setString(++i, re.getNombrePartida());
            ps.setString(++i, re.getNombreJugador1());
            ps.setString(++i, re.getNombreJugador2());
            ps.setString(++i, re.getGanador());
            ps.setInt(++i, re.getPunto());
            ps.setInt(++i, re.getEstado());
            exec=ps.executeUpdate();
        } catch (Exception e) {
        }
        return exec;
    }
}
