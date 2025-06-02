
package dao;

import java.util.List;
import model.entidades.Aula;
import model.entidades.Estudiante;


public interface IDocenteDao {
    int obtenerIdDocenteporPersona (int idPersona);
    
    List<Estudiante> obtenerListaEstudiantes(int idDocente);
    
    Aula obtenerDatosAula (int idDocente);
    
}
