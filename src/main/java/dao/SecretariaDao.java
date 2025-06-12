package dao;
import configuration.Conexion;
import controller.SecretariaCtrl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.catalogo.Diagnostico;
import model.catalogo.NivelFuncional;
import model.entidades.Apoderado;
import model.entidades.Aula;
import model.entidades.Docente;
import model.entidades.Estudiante;
import model.entidades.Persona;
import model.entidades.Secretaria;
import model.entidades.Usuario;
import model.funcionalidad.ListaAulas;
public class SecretariaDao implements ISecretariaDao{
    private Connection conn;
    private int idUsuario;
    private String username;
    private String password;
    private String rol;
    private String estado;
    private Persona persona;
    private int idSecretaria;
    private int vdt=0;
    private int ad=0;
    private int adt=0;
    public SecretariaDao() {
        conn = Conexion.estableceConexion();
    }
    Usuario usuario = new Usuario(idUsuario, username, password, rol, estado, persona);
    
    
    
    @Override
    public int obtenerIdSecretariaporPersona(int idPersona) {
        String consulta="SELECT id_persona FROM usuario WHERE username = ? AND password = ?;";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setString(1, usuario.getUsername());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idSecretaria=rs.getInt("id_persona");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id Secretaria" + e.getMessage());
        }
            return idSecretaria ;
    }

    @Override
        public ArrayList<ListaAulas> obtenerListaAulas() {
        ArrayList<ListaAulas> lista = new ArrayList<>();
        
        String consulta = "SELECT a.id_aula, a.nombre, n.nombre AS nivel_funcional, d.nombre AS diagnostico, " +
                     "a.vacantes_totales, a.vacantes_disponibles, pr.dni " +
                     "FROM aula a " +
                     "JOIN nivel_funcional n ON a.id_nivel_funcional = n.id_nivel " +
                     "JOIN diagnostico d ON a.id_diagnostico_referente = d.id_diagnostico " +
                     "JOIN persona pr ON a.id_docente = pr.id_persona";

        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ListaAulas aula = new ListaAulas(
                        rs.getInt("id_aula"),
                        rs.getString("nombre"),
                        rs.getString("nivel_funcional"),
                        rs.getString("diagnostico"),
                        rs.getInt("vacantes_totales"),
                        rs.getInt("vacantes_disponibles"),
                        rs.getString("dni")
                );
                adt=adt+1;
                vdt=vdt+rs.getInt("vacantes_disponibles");
                if(rs.getInt("vacantes_disponibles")>0){
                    ad=ad+1;
                }

                lista.add(aula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void obtenerDatosSecretaria(){
        String consulta="SELECT p.nombres, p.apellidos, p.dni, p.celular, p.correo, p.direccion, p.fecha_nacimiento, p.genero FROM persona p JOIN usuario u ON p.id_persona = u.id_persona WHERE u.username = ? AND u.password = ?;";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setString(1, usuario.getUsername());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nombres =rs.getString("nombres");
                persona.setNombres(nombres);
                String apellidos =rs.getString("apellidos");
                persona.setApellidos(apellidos);
                String dni =rs.getString("dni");
                persona.setDni(dni);
                String celular =rs.getString("celular");
                persona.setCelular(celular);
                String correo =rs.getString("correo");
                persona.setCorreo(correo);
                String direccion =rs.getString("direccion");
                persona.setDireccion(direccion);
                Date fecha_nacimiento =rs.getDate("fecha_nacimiento");
                persona.setFechaNacimiento(fecha_nacimiento);
                String genero =rs.getString("genero");
                persona.setGenero(genero);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos de la secretaria" + e.getMessage());
        }
        
    }
    
    public int numeroEstudiantes(){
        String consulta="SELECT * FROM estudiante";
        int i=0;
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos" + e.getMessage());
        }
        return i;
    }
    
    public int numeroMatriculas(){
        String consulta="SELECT * FROM matricula WHERE DATE(fecha_matricula) = CURRENT_DATE();";
        int i=0;
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos" + e.getMessage());
        }
        return i;
    }
    
    public int obtenerAulasDisponibles() {
        String consulta = "SELECT a.id_aula, a.nombre, n.nombre AS nivel_funcional, d.nombre AS diagnostico, " +
                     "a.vacantes_totales, a.vacantes_disponibles, pr.dni " +
                     "FROM aula a " +
                     "JOIN nivel_funcional n ON a.id_nivel_funcional = n.id_nivel " +
                     "JOIN diagnostico d ON a.id_diagnostico_referente = d.id_diagnostico " +
                     "JOIN persona pr ON a.id_docente = pr.id_persona";

        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                rs.getInt("vacantes_totales");

                if(rs.getInt("vacantes_disponibles")>0){
                    ad=ad+1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ad;
    }
    
    public int obtenerAulasDisponiblesTotales() {
        String consulta = "SELECT a.id_aula, a.nombre, n.nombre AS nivel_funcional, d.nombre AS diagnostico, " +
                     "a.vacantes_totales, a.vacantes_disponibles, pr.dni " +
                     "FROM aula a " +
                     "JOIN nivel_funcional n ON a.id_nivel_funcional = n.id_nivel " +
                     "JOIN diagnostico d ON a.id_diagnostico_referente = d.id_diagnostico " +
                     "JOIN persona pr ON a.id_docente = pr.id_persona";

        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                rs.getInt("vacantes_totales");
                adt=adt+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adt;
    }
    
    public int obtenerVacantesDisponibles() {
        String consulta = "SELECT a.id_aula, a.nombre, n.nombre AS nivel_funcional, d.nombre AS diagnostico, " +
                     "a.vacantes_totales, a.vacantes_disponibles, pr.dni " +
                     "FROM aula a " +
                     "JOIN nivel_funcional n ON a.id_nivel_funcional = n.id_nivel " +
                     "JOIN diagnostico d ON a.id_diagnostico_referente = d.id_diagnostico " +
                     "JOIN persona pr ON a.id_docente = pr.id_persona";

        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                vdt=vdt+rs.getInt("vacantes_disponibles");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vdt;
    }
    
    
    public void registrarPersonaApoderado(Apoderado apoderado){
        String consulta="INSERT INTO persona (nombres,apellidos,dni,celular,correo,direccion,fecha_nacimiento,genero) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setString(1, apoderado.getNombres());
            pst.setString(2, apoderado.getApellidos());
            pst.setString(3, apoderado.getDni());
            pst.setString(4, apoderado.getCelular());
            pst.setString(5, apoderado.getCorreo());
            pst.setString(6, apoderado.getDireccion());
            pst.setDate(7, apoderado.getFechaNacimiento());
            pst.setString(8, apoderado.getGenero());
            pst.executeUpdate();
            System.out.println("Persona Apoderado registrado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar persona Apoderado");
            e.printStackTrace();
        }
    }
    
    public void registrarPersonaEstudiante(Estudiante estudiante){
        String consulta="INSERT INTO persona (nombres,apellidos,dni,celular,correo,direccion,fecha_nacimiento,genero) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setString(1, estudiante.getNombres());
            pst.setString(2, estudiante.getApellidos());
            pst.setString(3, estudiante.getDni());
            pst.setString(4, estudiante.getCelular());
            pst.setString(5, estudiante.getCorreo());
            pst.setString(6, estudiante.getDireccion());
            pst.setDate(7, estudiante.getFechaNacimiento());
            pst.setString(8, estudiante.getGenero());
            pst.executeUpdate();
            System.out.println("Persona Estudiante registrado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar persona Estudiante");
            e.printStackTrace();
        }
    }
    
    
    
    public int obtenerPersonaEstudiante(Estudiante estudiante){
        int idPersonaEstudiante=0;
        String consulta="SELECT id_persona FROM persona WHERE dni='"+estudiante.getDni()+"'";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                idPersonaEstudiante=rs.getInt("id_persona");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPersonaEstudiante;
    }
    
    public int obtenerPersonaApoderado(Apoderado apoderado){
        int idPersonaApoderado=0;
        String consulta="SELECT id_persona FROM persona WHERE dni='"+apoderado.getDni()+"'";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                idPersonaApoderado=rs.getInt("id_persona");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPersonaApoderado;
    }
    
    public void registrarApoderado(Apoderado apoderado, String parentesco){
        String consulta="INSERT INTO apoderado (id_persona,parentesco) VALUES (?,?);";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setInt(1, apoderado.getId());
            pst.setString(2, parentesco);
            pst.executeUpdate();
            System.out.println("Apoderado registrado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar apoderado");
            e.printStackTrace();
        }
    }
    
    public int obtenerApoderado(Apoderado apoderado){
        int idApoderado=0;
        String consulta="SELECT id_apoderado FROM apoderado WHERE id_persona ="+apoderado.getId()+"";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                idApoderado=rs.getInt("id_apoderado");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id del apoderado");
            e.printStackTrace();
        }
        return idApoderado;
    }
    
    public void registrarEstudiante(Estudiante estudiante){
        String consulta="INSERT INTO estudiante (id_persona,alergias,tipo_alergia,toma_medicamentos,medicamentos,id_nivel_funcional,id_apoderado,observaciones) VALUES (?,?,?,?,?,?,?,?);";
        int confirmacionAlergia=0;
        int confirmacionMedicamentos=0;
        
        if(estudiante.isAlergias()==true){
            confirmacionAlergia=1;
        }
        
        if(estudiante.isTomaMedicamentos()==true){
            confirmacionMedicamentos=1;
        }
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setInt(1, estudiante.getId());
            pst.setInt(2, confirmacionAlergia);
            pst.setString(3, estudiante.getTipoAlergia());
            pst.setInt(4, confirmacionMedicamentos);
            pst.setString(5, estudiante.getMedicamentos());
            pst.setInt(6, estudiante.getNivelFuncional().getId());
            pst.setInt(7, estudiante.getApoderado().getIdApoderado());
            pst.setString(8, estudiante.getObservaciones());
            pst.executeUpdate();
            System.out.println("Estudiante registrado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar estudiante");
            e.printStackTrace();
        }
    }
    
    public int obtenerEstudiante(Estudiante estudiante){
        int idEstudiante=0;
        String consulta="SELECT id_estudiante FROM estudiante WHERE id_persona ="+estudiante.getId()+"";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                idEstudiante=rs.getInt("id_estudiante");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id del estudiante");
            e.printStackTrace();
        }
        return idEstudiante;
    }
    
    public String [] obtenerAula(Diagnostico diag,NivelFuncional nivel){
        ArrayList<String> aulas = new ArrayList<>();
        String consulta="SELECT nombre FROM aula WHERE id_diagnostico_referente = "+diag.getId()+" AND id_nivel_funcional = "+nivel.getId()+"";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                aulas.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener aulas");
            e.printStackTrace();
        }
        return aulas.toArray(String[]::new);
    }
    
    public String [] obtenerprofesores(Diagnostico diag,NivelFuncional nivel,String aulaAsignada){
        ArrayList<String> profesores = new ArrayList<>();
        String consulta="SELECT p.nombres, p.apellidos FROM persona p JOIN docente d ON d.id_persona = p.id_persona JOIN aula a ON a.id_docente = d.id_docente JOIN nivel_funcional n ON a.id_nivel_funcional=n.id_nivel JOIN diagnostico di ON a.id_diagnostico_referente = di.id_diagnostico WHERE n.id_nivel="+nivel.getId()+" AND di.id_diagnostico="+diag.getId()+" AND a.nombre='"+aulaAsignada+"'";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                profesores.add((rs.getString("nombres"))+" "+(rs.getString("apellidos")));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener profesores");
            e.printStackTrace();
        }
        return profesores.toArray(String[]::new);
    }
    
    public Aula obtenerAula(Aula aula,Docente docente,String aulaAsignada){
        String consulta="SELECT a.id_aula, a.nombre,a.id_nivel_funcional, a.id_diagnostico_referente,a.vacantes_totales,a.vacantes_disponibles,\n" +
        "a.id_docente,d.id_persona,d.id_docente,d.id_usuario, p.nombres,p.apellidos,p.dni,p.celular,p.correo,p.direccion,p.fecha_nacimiento,p.genero \n" +
        "FROM aula a \n" +
        "JOIN docente d ON a.id_docente = d.id_docente \n" +
        "JOIN persona p ON p.id_persona = d.id_persona \n" +
        "WHERE nombre = '"+aulaAsignada+"'";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                aula.setId(rs.getInt("id_aula"));
                aula.setVacantesTotales(rs.getInt("vacantes_totales"));
                aula.setVacantesDisponibles(rs.getInt("vacantes_disponibles"));
                aula.setNombre(rs.getString("nombre"));
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setId(rs.getInt("id_persona"));
                docente.setNombres(rs.getString("nombres"));
                docente.setApellidos(rs.getString("apellidos"));
                docente.setDni(rs.getString("dni"));
                aula.setDocente(docente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener aula");
            e.printStackTrace();
        }
        return aula;
    }
    
    public void registrarMatricula(Aula aula,Estudiante estudiante,String estado,double pension){
        String consulta = "INSERT INTO matricula (id_estudiante, id_aula, fecha_matricula, estado, pension) VALUES (?, ?, CURDATE(), ?, ?);";
        try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            pst.setInt(1, estudiante.getIdEstudiante());
            pst.setInt(2, aula.getId());
            pst.setString(3, estado);
            pst.setDouble(4, pension);
            
            pst.executeUpdate();
            System.out.println("Matricula registrada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar Matricula");
            e.printStackTrace();
        }
        
        String consulta2 = "UPDATE aula SET vacantes_disponibles = vacantes_disponibles - 1 WHERE id_aula = ?;";
        try (PreparedStatement pst = conn.prepareStatement(consulta2)) {
            pst.setInt(1, aula.getId());
            pst.executeUpdate();
            System.out.println("Matricula registrada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar Matricula");
            e.printStackTrace();
        }
        
    }
    
    public int obtenerMatricula(model.funcionalidad.Matricula matriculaObjeto, Estudiante estudiante, Aula aula){
        int IdMatricula=0;
        String consulta="SELECT id_matricula FROM matricula WHERE id_estudiante ="+estudiante.getIdEstudiante()+" AND id_aula="+aula.getId()+" AND fecha_matricula='"+matriculaObjeto.getFechaMatricula()+"'";
            try (PreparedStatement pst = conn.prepareStatement(consulta)) {
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                IdMatricula=rs.getInt("id_matricula");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id matricula");
            e.printStackTrace();
        }
        
        return IdMatricula;
    }
    
    
    
    public List<String[]> listarEstudiantesMatriculados() {
    List<String[]> lista = new ArrayList<>();
    String consulta = "SELECT " +
            "e.id_estudiante, p.apellidos, p.nombres, d.nombre AS diagnostico, " +
            "n.nombre AS nivel_funcional, a.nombre AS aula, " +
            "pd.nombres AS docente_nombres, pd.apellidos AS docente_apellidos, " +
            "p.celular, m.fecha_matricula " +
            "FROM estudiante e " +
            "JOIN persona p ON p.id_persona = e.id_persona " +
            "JOIN matricula m ON m.id_estudiante = e.id_estudiante " +
            "JOIN aula a ON m.id_aula = a.id_aula " +
            "JOIN docente dc ON dc.id_docente = a.id_docente " +
            "JOIN persona pd ON pd.id_persona = dc.id_persona " +
            "JOIN nivel_funcional n ON n.id_nivel = a.id_nivel_funcional " +
            "JOIN diagnostico d ON d.id_diagnostico = a.id_diagnostico_referente";

    try (PreparedStatement pst = conn.prepareStatement(consulta)) {
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String[] fila = new String[10];
            fila[0] = rs.getString("id_estudiante");
            fila[1] = rs.getString("apellidos");
            fila[2] = rs.getString("nombres");
            fila[3] = rs.getString("diagnostico");
            fila[4] = rs.getString("nivel_funcional");
            fila[5] = rs.getString("aula");
            fila[6] = rs.getString("docente_nombres") + " " + rs.getString("docente_apellidos");
            fila[7] = rs.getString("celular");
            fila[8] = rs.getString("fecha_matricula");
            lista.add(fila);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar estudiantes: " + e.getMessage());
    }

    return lista;
}

    

    
    
}
