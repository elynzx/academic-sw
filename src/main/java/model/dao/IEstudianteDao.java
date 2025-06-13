/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public interface IEstudianteDao {

        
    Estudiante obtenerDatosEstudiante(int idEstudiante);
    
}
