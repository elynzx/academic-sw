/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import utillities.Utilidad;
import controller.DocenteCtrl;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import java.util.stream.Collectors;
import model.funcionalidad.catalogo.Diagnostico;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.entidades.Aula;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class DashboardView extends javax.swing.JPanel {

    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private Utilidad utilidad;
    private int idDocente;
    private DocenteCtrl docenteCtrl;

    public DashboardView(int idDocente) {
        this.idDocente = idDocente;
        docenteCtrl = new DocenteCtrl(docenteDao);
        utilidad = new Utilidad();
        initComponents();
        mostrarDatosAula(idDocente);
        utilidad.mostrarDiaHora(lbFechaHoy);
        cargarEstudiantesTabla(idDocente);
        seleccionTbAlumnos();
        jlHistorialRegistros.setListData(docenteDao.obtenerHistorialIncidentes(idDocente).toArray(new String[0]));
        jlTopIncidentes.setListData(docenteDao.obtenerTopEstudiantesIncidentes(idDocente).toArray(new String[0]));
    }

    private void mostrarDatosAula(int idDocente) {
        Aula aula = docenteDao.obtenerDatosAula(idDocente);
        if (aula != null) {
            lbAula.setText(aula.getNombre());
            lbNivel.setText(aula.getNivelFuncional().getNombre());
            lbEstudiante.setText(String.valueOf(aula.getVacantesTotales()));
            lbAsistentes.setText(aula.getVacantesDisponibles() + " / " + aula.getVacantesTotales());
        } else {
            System.out.println("Error: No se encontraron datos del aula.");
        }
    }

    private void cargarEstudiantesTabla(int idDocente) {
        tbEstudiantesDashboard.setModel(docenteCtrl.obtenerModeloTablaEstudiantes(idDocente));
    }

    private void mostrarDatosEstudiante(int idEstudiante) {

        try {
            Estudiante estudiante = estudianteDao.obtenerDatosEstudiante(idEstudiante);
            txtEdad.setText(String.valueOf(estudiante.getEdad()) + " años");
            txtDiagnostico.setText(estudiante.getDiagnosticos().stream().map(Diagnostico::getNombre).collect(Collectors.joining(", ")));
            txtAlergias.setText(estudiante.getTipoAlergia());
            txtMedicinas.setText(estudiante.getMedicamentos());
            txtObserv.setText(estudiante.getObservaciones());

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    private void seleccionTbAlumnos() {
        tbEstudiantesDashboard.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tbEstudiantesDashboard.getSelectedRow();
                if (selectedRow != -1) {
                    int idEstudiante = (int) tbEstudiantesDashboard.getValueAt(selectedRow, 0);
                    mostrarDatosEstudiante(idEstudiante);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDashboardDocente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbEstudiante = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbAsistentes = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbNivel = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbAula = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlHistorialRegistros = new javax.swing.JList<>();
        lbNivel13 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlTopIncidentes = new javax.swing.JList<>();
        lbNivel6 = new javax.swing.JLabel();
        lbNivel12 = new javax.swing.JLabel();
        btnAsistencia = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantesDashboard = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtMedicinas = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtObserv = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(1250, 734));
        setPreferredSize(new java.awt.Dimension(1250, 734));

        jpDashboardDocente.setBackground(new java.awt.Color(255, 255, 255));
        jpDashboardDocente.setMinimumSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setPreferredSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 227, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 243));

        jPanel8.setBackground(new java.awt.Color(23, 50, 78));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setFocusable(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(180, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mortarboard-2.png"))); // NOI18N
        jLabel9.setText("Total Estudiantes");

        lbEstudiante.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lbEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        lbEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEstudiante.setText("-");
        lbEstudiante.setToolTipText("Total de estudiantes matriculados");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEstudiante)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(23, 64, 112));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel13.setFocusable(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(180, 60));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check_ring_round-2.png"))); // NOI18N
        jLabel11.setText("Asistentes");

        lbAsistentes.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lbAsistentes.setForeground(new java.awt.Color(255, 255, 255));
        lbAsistentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAsistentes.setText("-");
        lbAsistentes.setToolTipText("Total de estudiantes matriculados");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAsistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAsistentes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(45, 94, 152));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel14.setFocusable(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(180, 60));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sort_up_alt-2.png"))); // NOI18N
        jLabel12.setText("Nivel Funcional");

        lbNivel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbNivel.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNivel.setText("-");
        lbNivel.setToolTipText("Total de estudiantes matriculados");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNivel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(81, 124, 191));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel15.setFocusable(false);
        jPanel15.setPreferredSize(new java.awt.Dimension(180, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Group_fill-2.png"))); // NOI18N
        jLabel13.setText("Nombre de Aula");

        lbAula.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lbAula.setForeground(new java.awt.Color(255, 255, 255));
        lbAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAula.setText("-");
        lbAula.setToolTipText("Total de estudiantes matriculados");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 84, 138));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Dashboard de Docente");

        jlHistorialRegistros.setBorder(null);
        jlHistorialRegistros.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jlHistorialRegistros.setForeground(new java.awt.Color(102, 102, 102));
        jlHistorialRegistros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlHistorialRegistros.setFocusable(false);
        jlHistorialRegistros.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jlHistorialRegistros.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jlHistorialRegistros);

        lbNivel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit_fill-1_1.png"))); // NOI18N
        lbNivel13.setText("Mi actividad reciente:");
        lbNivel13.setToolTipText("");
        lbNivel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));

        lbFechaHoy.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(39, 84, 138));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFechaHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Date_fill-1_1.png"))); // NOI18N
        lbFechaHoy.setText("Fecha de hoy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        jpDashboardDocente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jlTopIncidentes.setBorder(null);
        jlTopIncidentes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jlTopIncidentes.setForeground(new java.awt.Color(102, 102, 102));
        jlTopIncidentes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlTopIncidentes.setFocusable(false);
        jlTopIncidentes.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jlTopIncidentes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jlTopIncidentes);

        lbNivel6.setBackground(new java.awt.Color(255, 255, 255));
        lbNivel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm_fill-1.png"))); // NOI18N
        lbNivel6.setText("Estudiantes con más Incidentes:");
        lbNivel6.setToolTipText("");
        lbNivel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jpDashboardDocente.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 420));

        lbNivel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbNivel12.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pie_chart_fill-2.png"))); // NOI18N
        lbNivel12.setText("Métricas de estudiante");
        lbNivel12.setToolTipText("");
        lbNivel12.setPreferredSize(new java.awt.Dimension(70, 25));
        jpDashboardDocente.add(lbNivel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 300, 40));

        btnAsistencia.setBackground(new java.awt.Color(221, 168, 83));
        btnAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        btnAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tumer-2.png"))); // NOI18N
        btnAsistencia.setText("ASISTENCIA");
        btnAsistencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAsistencia.setBorderPainted(false);
        btnAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsistencia.setFocusPainted(false);
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 170, 50));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpDashboardDocente.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 310, 340));

        tbEstudiantesDashboard.setForeground(new java.awt.Color(51, 51, 51));
        tbEstudiantesDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEstudiantesDashboard.setToolTipText("Selecciona un alumno para ver sus métricas");
        tbEstudiantesDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbEstudiantesDashboard.setGridColor(new java.awt.Color(214, 214, 214));
        tbEstudiantesDashboard.setRowHeight(25);
        tbEstudiantesDashboard.setSelectionBackground(new java.awt.Color(45, 94, 152));
        tbEstudiantesDashboard.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbEstudiantesDashboard.setShowGrid(false);
        tbEstudiantesDashboard.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tbEstudiantesDashboard);

        jpDashboardDocente.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 240, 340));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Edad:");
        jpDashboardDocente.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 39, -1));

        txtEdad.setForeground(new java.awt.Color(51, 51, 51));
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEdad.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jpDashboardDocente.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 82, 25));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flash-1.png"))); // NOI18N
        jLabel30.setText("Alergias:");
        jpDashboardDocente.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 101, 16));

        txtAlergias.setEditable(false);
        txtAlergias.setBackground(new java.awt.Color(255, 255, 255));
        txtAlergias.setForeground(new java.awt.Color(51, 51, 51));
        txtAlergias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtAlergias.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jpDashboardDocente.add(txtAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 240, 25));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pil-1.png"))); // NOI18N
        jLabel31.setText("Medicinas:");
        jpDashboardDocente.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 114, 16));

        txtMedicinas.setEditable(false);
        txtMedicinas.setBackground(new java.awt.Color(255, 255, 255));
        txtMedicinas.setForeground(new java.awt.Color(51, 51, 51));
        txtMedicinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtMedicinas.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jpDashboardDocente.add(txtMedicinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 240, 25));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Diagnóstico:");
        jpDashboardDocente.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 93, 16));

        txtDiagnostico.setEditable(false);
        txtDiagnostico.setBackground(new java.awt.Color(255, 255, 255));
        txtDiagnostico.setForeground(new java.awt.Color(51, 51, 51));
        txtDiagnostico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDiagnostico.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jpDashboardDocente.add(txtDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 240, 25));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Observación:");
        jpDashboardDocente.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 114, 16));

        txtObserv.setEditable(false);
        txtObserv.setBackground(new java.awt.Color(255, 255, 255));
        txtObserv.setColumns(20);
        txtObserv.setForeground(new java.awt.Color(51, 51, 51));
        txtObserv.setLineWrap(true);
        txtObserv.setRows(5);
        txtObserv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtObserv.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtObserv.setEnabled(false);
        jScrollPane5.setViewportView(txtObserv);

        jpDashboardDocente.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 240, 80));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jpDashboardDocente.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 850, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpDashboardDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDashboardDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed

        Asistencia vAsistencia = new Asistencia();
        vAsistencia.setVisible(true);
        vAsistencia.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnAsistenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> jlHistorialRegistros;
    private javax.swing.JList<String> jlTopIncidentes;
    private javax.swing.JPanel jpDashboardDocente;
    private javax.swing.JLabel lbAsistentes;
    private javax.swing.JLabel lbAula;
    private javax.swing.JLabel lbEstudiante;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel;
    private javax.swing.JLabel lbNivel12;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JTable tbEstudiantesDashboard;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtMedicinas;
    private javax.swing.JTextArea txtObserv;
    // End of variables declaration//GEN-END:variables
}
