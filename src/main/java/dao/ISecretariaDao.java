package dao;
import java.util.ArrayList;
import java.util.List;
import model.entidades.Aula;
import model.funcionalidad.ListaAulas;


public interface ISecretariaDao {
    int obtenerIdSecretariaporPersona (int idPersona);
    ArrayList<ListaAulas> obtenerListaAulas();
    
}
