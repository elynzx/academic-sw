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

import model.funcionalidad.ListaAulas;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.entidades.Persona;


public class SecretariaCtrl {
    private DashboardMatricula dashboard;
    private Estudiantes estudiantes;
    private Matricula matricula;
    private ReportesMatricula reportes;
    private SecretariaDao dao;
    private Persona persona;
    int ad,vdt,adt;

    
    
    public SecretariaCtrl(Matricula matricula) {
        this.matricula = matricula;
        
        this.matricula.jbtnregistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registrar(); 
        }
        });
     }
    
    private void registrar() {
        // Aquí va la lógica de registro
        System.out.println("Botón presionado. Aquí irá la lógica del registro.");
        // Puedes acceder a campos con: vista.getNombre(), etc.
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
