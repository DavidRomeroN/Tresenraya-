/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import java.util.List;
import com.mycompany.modelo.ResultadosTo;
/**
 *
 * @author romer
 */
public interface ResultadosDaoI {
    
    public List listarResultados();
    public int crearResultado(ResultadosTo re);
    
}
