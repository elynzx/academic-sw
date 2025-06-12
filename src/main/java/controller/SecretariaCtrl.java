package controller;
import configuration.SesionUsuario;
import dao.SecretariaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Secretaria.DashboardMatricula;
import view.Secretaria.Estudiantes;
import view.Secretaria.Matricula;
import view.Secretaria.ReportesMatricula;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import model.funcionalidad.ListaAulas;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.catalogo.Diagnostico;
import model.catalogo.NivelFuncional;
import model.entidades.Apoderado;
import model.entidades.Aula;
import model.entidades.Docente;
import model.entidades.Estudiante;
import model.entidades.Persona;


public class SecretariaCtrl {
    private DashboardMatricula dashboard;
    private Estudiantes estudiantes;
    private Matricula matricula;
    private ReportesMatricula reportes;
    private SecretariaDao dao = new SecretariaDao();
    private Persona persona;
    int ad,vdt,adt;
    
    
    private void registrar() {
        String nombreAlumno=matricula.getNombresAlumno();
        String apellidoAlumno=matricula.getApellidosAlumno();
        String dniAlumno=matricula.getDniAlumno();
        String generoAlumno=matricula.getGeneroAlumno();
        
        java.util.Date utilFechaEstudiante = matricula.getJDatenacimientoAlumno();
        java.sql.Date sqlFechaEstudiante= new java.sql.Date(utilFechaEstudiante.getTime());
        
        String tipoAlergia=matricula.getJtxtalergia();
        boolean confirmacionAlergia;
        if(tipoAlergia == null || tipoAlergia.isEmpty()){
            confirmacionAlergia = false;
        }else{
            confirmacionAlergia = true;
        }
        String tipoMedicamento=matricula.getjtxtmedicinas();
        boolean confirmacionMedicamentos;
        if(tipoMedicamento == null || tipoMedicamento.isEmpty()){
            confirmacionMedicamentos = false;
        }else{
            confirmacionMedicamentos = true;
        }
        String nombreApoderado=matricula.getJtxtnombreApoderado();
        String apellidoApoderado=matricula.getJtxtapellidoApoderado();
        String dniApoderado=matricula.getJtxtdniApoderado();
        String parentesco=matricula.getJcmbparentesco();
        String celular=matricula.getJtxtcelular();
        String correo=matricula.getJtxtcorreo();
        String direccion=matricula.getJTextAreadireccion();
        String generoApoderado=matricula.getJcmbgeneroApoderado();
        
        java.util.Date utilFechaApoderado = matricula.getjDatenacimientoApoderado();
        java.sql.Date sqlFechaApoderado = new java.sql.Date(utilFechaApoderado.getTime());
                
        
        String estado=matricula.getJcmbestado();
        String fecha=matricula.getJtxtfecha();
        String diagnostico=matricula.getJListdiagnostico().getSelectedValue();
        String nivelFuncional=matricula.getJcmbnivelFuncional();
        String aulaAsignada=matricula.getJcmbaulaAsignada();
        String docenteCargo=matricula.getJcmbdocenteCargo();
        String observaciones=matricula.getJTextAreaobservaciones();
        double pension = 750;
        
        Apoderado apoderado = new Apoderado (
            0, //id apoderado
            parentesco,
            0, //id persona
            nombreApoderado,
            apellidoApoderado,
            dniApoderado,
            celular,
            correo,
            direccion,
            sqlFechaApoderado,
            generoApoderado
        );
        

        int id_nivel=0;
        String nivel_funcional = null;
        switch(nivelFuncional){
            case "Bajo: Requiere ayuda constante":id_nivel=1; nivel_funcional="Bajo";break;
            case "Medio: Requiere apoyo ocasional":id_nivel=2; nivel_funcional="Medio";break;
            case "Alto: Mayor autonomía": id_nivel=3; nivel_funcional="Alto";break;
        }
        
        NivelFuncional nivel = new NivelFuncional(
                id_nivel,
                nivel_funcional
        );
        
        int id_persona_estudiante=0;
        int id_persona_apoderado=0;
        int id_estudiante=0;
        int id_apoderado=0;
        
        dao.registrarPersonaApoderado(apoderado);
        
        
        id_persona_apoderado=dao.obtenerPersonaApoderado(apoderado);
        apoderado.setId(id_persona_apoderado);
        
        dao.registrarApoderado(apoderado, parentesco);
        id_apoderado=dao.obtenerApoderado(apoderado);
        apoderado.setIdApoderado(id_apoderado);
        
        Estudiante estudiante = new Estudiante(
            0, // idEstudiante (temporal)
            confirmacionAlergia, // alergias (temporal)
            tipoAlergia, // tipoAlergia
            confirmacionMedicamentos, // tomaMedicamentos
            tipoMedicamento, // medicamentos
            nivel, // nivelFuncional (falta implementar)
            apoderado, // apoderado (falta implementar)
            observaciones, // observaciones
            0, // id (persona)
            nombreAlumno,
            apellidoAlumno,
            dniAlumno,
            celular,
            correo,
            direccion,
            sqlFechaApoderado,
            generoAlumno
        );
        
        dao.registrarPersonaEstudiante(estudiante);
        id_persona_estudiante=dao.obtenerPersonaEstudiante(estudiante);
        estudiante.setId(id_persona_estudiante);
        
        dao.registrarEstudiante(estudiante);
        id_estudiante=dao.obtenerEstudiante(estudiante);
        estudiante.setIdEstudiante(id_estudiante);
        
        int id_diagnostico=0;
        String diagnostico_final = null;
        switch(diagnostico){
            case "Trastorno del Espectro Autista (TEA)":diagnostico_final="Autismo";id_diagnostico=1;break;
            case "Síndrome de Asperger":diagnostico_final="Asperger";id_diagnostico=2;break;
            case "Síndrome de Down":diagnostico_final="Síndrome de Down";id_diagnostico=3;break;
            case "Retraso mental leve":diagnostico_final="Retraso mental leve";id_diagnostico=4;break;
            case "Retraso mental moderado": diagnostico_final="Retraso mental moderado";id_diagnostico=5;
        }
        
        
        Diagnostico diag = new Diagnostico(
        id_diagnostico,
           diagnostico_final
        );
        
        Docente docente = new Docente(
                0,
                null,
                0,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        
        Aula aula = new Aula(
                0,
                aulaAsignada,
                nivel,
                diag,
                0,
                0,
                docente
        );
        
        aula=dao.obtenerAula(aula, docente, aulaAsignada);
        dao.registrarMatricula(aula, estudiante, estado, pension);
        
        
        
        
         
    }
    
    private void cargarCombos(){
        
        String diagnostico=matricula.getJListdiagnostico().getSelectedValue();
        String nivelFuncional=matricula.getJcmbnivelFuncional();
        int id_diagnostico = 0;
        int id_nivel=0;
        String nivel_funcional = null;
        switch(nivelFuncional){
            case "Bajo: Requiere ayuda constante":id_nivel=1; nivel_funcional="Bajo";break;
            case "Medio: Requiere apoyo ocasional":id_nivel=2; nivel_funcional="Medio";break;
            case "Alto: Mayor autonomía": id_nivel=3; nivel_funcional="Alto";break;
        }
        
        NivelFuncional nivel = new NivelFuncional(
                id_nivel,
                nivel_funcional
        );
        
        String diagnostico_final = null;
        switch(diagnostico){
            case "Trastorno del Espectro Autista (TEA)":diagnostico_final="Autismo";id_diagnostico=1;break;
            case "Síndrome de Asperger":diagnostico_final="Asperger";id_diagnostico=2;break;
            case "Síndrome de Down":diagnostico_final="Síndrome de Down";id_diagnostico=3;break;
            case "Retraso mental leve":diagnostico_final="Retraso mental leve";id_diagnostico=4;break;
            case "Retraso mental moderado": diagnostico_final="Retraso mental moderado";id_diagnostico=5;
        }
        
        
        Diagnostico diag = new Diagnostico(
        id_diagnostico,
           diagnostico_final
        );
        
        System.out.println("diagnostico: "+diag.getId()+" "+diag.getNombre());
        System.out.println("nivel funcional: "+nivel.getId()+" "+nivel.getNombre());
        
        
        
        matricula.jcmbaulaAsignada.removeAllItems(); // Limpiar antes de cargar
        matricula.jcmbdocenteAsignado.removeAllItems(); // Limpiar antes de cargar
        
        String aulas[] = dao.obtenerAula(diag, nivel);
        for (int i = 0; i < aulas.length; i++) {
            matricula.jcmbaulaAsignada.addItem(aulas[i]);
        }
        
        
        




    }
    
    public void cargarProfesores(){
        
        String diagnostico=matricula.getJListdiagnostico().getSelectedValue();
        String nivelFuncional=matricula.getJcmbnivelFuncional();
        int id_diagnostico = 0;
        int id_nivel=0;
        String nivel_funcional = null;
        switch(nivelFuncional){
            case "Bajo: Requiere ayuda constante":id_nivel=1; nivel_funcional="Bajo";break;
            case "Medio: Requiere apoyo ocasional":id_nivel=2; nivel_funcional="Medio";break;
            case "Alto: Mayor autonomía": id_nivel=3; nivel_funcional="Alto";break;
        }
        
        NivelFuncional nivel = new NivelFuncional(
                id_nivel,
                nivel_funcional
        );
        
        String diagnostico_final = null;
        switch(diagnostico){
            case "Trastorno del Espectro Autista (TEA)":diagnostico_final="Autismo";id_diagnostico=1;break;
            case "Síndrome de Asperger":diagnostico_final="Asperger";id_diagnostico=2;break;
            case "Síndrome de Down":diagnostico_final="Síndrome de Down";id_diagnostico=3;break;
            case "Retraso mental leve":diagnostico_final="Retraso mental leve";id_diagnostico=4;break;
            case "Retraso mental moderado": diagnostico_final="Retraso mental moderado";id_diagnostico=5;
        }
        
        
        Diagnostico diag = new Diagnostico(
        id_diagnostico,
           diagnostico_final
        );
        
        System.out.println("diagnostico: "+diag.getId()+" "+diag.getNombre());
        System.out.println("nivel funcional: "+nivel.getId()+" "+nivel.getNombre());
        
        matricula.jcmbdocenteAsignado.removeAllItems();
        
        String aulaAsignada = matricula.getJcmbaulaAsignada();
        String profesores[] = dao.obtenerprofesores(diag, nivel,aulaAsignada);
        for (int i = 0; i < profesores.length; i++) {
            matricula.jcmbdocenteAsignado.addItem(profesores[i]);
        }
    }
    
    public SecretariaCtrl(DashboardMatricula dashboard) {
        this.dashboard = dashboard;
        this.dao = new SecretariaDao();
        cargarTablaAulas();

        dashboard.getJlblmatricula().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Matricula().setVisible(true);
                dashboard.dispose();
            }
        });

        dashboard.getJlblestudiantes().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Estudiantes().setVisible(true);
                dashboard.dispose();
            }
        });

        dashboard.getJlblreportes().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ReportesMatricula().setVisible(true);
                dashboard.dispose();
            }
        });
    }
    
    public SecretariaCtrl(Estudiantes estudiantes){
        this.estudiantes = estudiantes;
        
        estudiantes.getJlblmatricula().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Matricula().setVisible(true);
                estudiantes.dispose();
            }
        });
        
        estudiantes.getJlblinicio().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new DashboardMatricula().setVisible(true);
                estudiantes.dispose();
            }
        });
        
        estudiantes.getJlblreportes().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ReportesMatricula().setVisible(true);
                estudiantes.dispose();
            }
        });
    }
    
    public SecretariaCtrl(Matricula matricula){
            this.matricula=matricula;
            
        this.matricula.jcmbnivelFuncional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarCombos();
            }
        });
        
        this.matricula.jcmbaulaAsignada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProfesores();
            }
        });
            
        this.matricula.addListSelectionListenerDiagnostico(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                
            }
        });


        this.matricula.jbtnregistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar(); 
            }
            });


            matricula.getJlblreportes().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new ReportesMatricula().setVisible(true);
                    matricula.dispose();
                }
            });

            matricula.getJlblestudiantes().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new Estudiantes().setVisible(true);
                    matricula.dispose();
                }
            });

            matricula.getJlblinicio().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new DashboardMatricula().setVisible(true);
                    matricula.dispose();
                }
            });
        }
    public SecretariaCtrl(ReportesMatricula reportes){
        this.reportes = reportes;
        
                
        reportes.getJlblinicio().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new DashboardMatricula().setVisible(true);
                reportes.dispose();
            }
        });
        
        reportes.getJlblestudiantes().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Estudiantes().setVisible(true);
                reportes.dispose();
            }
        });
        
        reportes.getJlblmatricula().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Matricula().setVisible(true);
                reportes.dispose();
            }
        });
    }
    
    private void cargarTablaAulas() {
        DefaultTableModel modelo = (DefaultTableModel) dashboard.getTbAlumnosDashboard().getModel();
        modelo.setRowCount(0);
        dashboard.getJlblnombre().setText(SesionUsuario.getUsuarioActual().getNombres());
        String num = Integer.toString(dao.numeroEstudiantes());
        dashboard.getJlbltotal().setText(num);
        num = Integer.toString(dao.numeroMatriculas());
        dashboard.getJlblmatriculas().setText(num);
        num = Integer.toString(dao.obtenerVacantesDisponibles());
        dashboard.getJlblvacantes().setText(num);
        ad=dao.obtenerAulasDisponibles();
        adt=dao.obtenerAulasDisponiblesTotales();
        dashboard.getJlblasistentes().setText(ad+"/"+adt);
        
        List<ListaAulas> aulas = dao.obtenerListaAulas();
        for (ListaAulas a : aulas) {
            modelo.addRow(new Object[]{
                a.getNombre(),
                a.getNivelFuncional(),
                a.getDiagnostico(),
                a.getDniDocente(),
                a.getVacantesTotales(),
                a.getVacantesDisponibles()
            });
        }
    }
    
}
