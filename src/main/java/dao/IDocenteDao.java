
package dao;

import java.util.List;
import model.entidades.Aula;


public interface IDocenteDao {
    int obtenerIdDocenteporPersona (int idPersona);
    
    List<String[]> obtenerListaEstudiantes(int idDocente);
    
    Aula obtenerDatosAula (int idDocente);
    
}
