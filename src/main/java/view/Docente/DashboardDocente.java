/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Docente;

import utillities.Utilidad;
import controller.DocenteCtrl;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import model.catalogo.Diagnostico;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.entidades.Aula;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class DashboardDocente extends javax.swing.JFrame {

    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private Utilidad utilidad;
    private int idDocente;
    private DocenteCtrl docenteCtrl;

    public DashboardDocente(int idDocente) {
        this.idDocente = idDocente;
        docenteCtrl = new DocenteCtrl(docenteDao);
        utilidad = new Utilidad();
        initComponents();
        
        mostrarDatosAula(idDocente);
        utilidad.mostrarFechaCompleta(lbFechaCompleta);
        cargarEstudiantesTabla(idDocente);
        seleccionTbAlumnos();
        seleccionMenu();
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

    private void seleccionMenu() {

        utilidad.configureMouseEvents(mSeguimiento, new JPanel[]{mIncidentes, mPlanIndividual, mReportes, mSalir});
        utilidad.configureMouseEvents(mIncidentes, new JPanel[]{mSeguimiento, mPlanIndividual, mReportes, mSalir});
        utilidad.configureMouseEvents(mPlanIndividual, new JPanel[]{mSeguimiento, mIncidentes, mReportes, mSalir});
        utilidad.configureMouseEvents(mReportes, new JPanel[]{mSeguimiento, mIncidentes, mPlanIndividual, mSalir});
        utilidad.configureMouseEvents(mSalir, new JPanel[]{mSeguimiento, mIncidentes, mPlanIndividual, mReportes});
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbNivel12 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtDiagnostico = new javax.swing.JTextField();
        txtAlergias = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMedicinas = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtObserv = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantesDashboard = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlHistorialRegistros = new javax.swing.JList<>();
        lbNivel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlTopIncidentes = new javax.swing.JList<>();
        lbNivel6 = new javax.swing.JLabel();
        lbNivel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbEstudiante = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lbAsistentes = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lbAula = new javax.swing.JLabel();
        btnAsistencia = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbNivel = new javax.swing.JLabel();
        lbFechaCompleta = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mInicio = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mSeguimiento = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mIncidentes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        mSalir = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        mPlanIndividual = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        mReportes = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        jScrollPane3.setViewportView(jTextPane1);

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        lbNivel12.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel12.setForeground(new java.awt.Color(71, 159, 159));
        lbNivel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel12.setText("Métricas");
        lbNivel12.setToolTipText("");
        lbNivel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel12.setPreferredSize(new java.awt.Dimension(70, 25));

        txtEdad.setEditable(false);
        txtEdad.setBackground(new java.awt.Color(244, 244, 244));
        txtEdad.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(102, 102, 102));
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
        txtEdad.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtDiagnostico.setEditable(false);
        txtDiagnostico.setBackground(new java.awt.Color(244, 244, 244));
        txtDiagnostico.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDiagnostico.setForeground(new java.awt.Color(102, 102, 102));
        txtDiagnostico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
        txtDiagnostico.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtAlergias.setEditable(false);
        txtAlergias.setBackground(new java.awt.Color(244, 244, 244));
        txtAlergias.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtAlergias.setForeground(new java.awt.Color(102, 102, 102));
        txtAlergias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
        txtAlergias.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Edad:");

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Diagnóstico:");

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Alergias:");

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Medicinas:");

        txtMedicinas.setEditable(false);
        txtMedicinas.setBackground(new java.awt.Color(244, 244, 244));
        txtMedicinas.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtMedicinas.setForeground(new java.awt.Color(102, 102, 102));
        txtMedicinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
        txtMedicinas.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Observación:");

        txtObserv.setEditable(false);
        txtObserv.setBackground(new java.awt.Color(244, 244, 244));
        txtObserv.setColumns(20);
        txtObserv.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtObserv.setForeground(new java.awt.Color(102, 102, 102));
        txtObserv.setRows(5);
        txtObserv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
        txtObserv.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane5.setViewportView(txtObserv);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNivel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMedicinas)
                                .addComponent(txtAlergias)
                                .addComponent(txtDiagnostico)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbNivel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedicinas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 550, 390));

        tbEstudiantesDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbEstudiantesDashboard.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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
        tbEstudiantesDashboard.setSelectionBackground(new java.awt.Color(71, 159, 159));
        tbEstudiantesDashboard.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbEstudiantesDashboard.setShowGrid(false);
        tbEstudiantesDashboard.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tbEstudiantesDashboard);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 240, 500));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        jlHistorialRegistros.setBorder(null);
        jlHistorialRegistros.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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

        lbNivel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel5.setText("Últimos registros del docente:");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));

        jlTopIncidentes.setBorder(null);
        jlTopIncidentes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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

        lbNivel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setText("Estudiantes con más Incidentes:");
        lbNivel6.setToolTipText("");
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(0, 153, 153));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel13.setText("Actividad reciente");
        lbNivel13.setToolTipText("");
        lbNivel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbNivel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(lbNivel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNivel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 290, 390));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Dashboard de Docente");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 430, 40));

        jPanel8.setBackground(new java.awt.Color(213, 243, 239));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vect (2).png"))); // NOI18N
        jLabel9.setText("Total Estudiantes");

        lbEstudiante.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        lbEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        lbEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEstudiante.setText("15");
        lbEstudiante.setToolTipText("Total de estudiantes matriculados");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 200, 90));

        jPanel9.setBackground(new java.awt.Color(213, 243, 239));

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vect (1).png"))); // NOI18N
        jLabel26.setText("Asistentes");

        lbAsistentes.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        lbAsistentes.setForeground(new java.awt.Color(51, 51, 51));
        lbAsistentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAsistentes.setText("10/15");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAsistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 200, 90));

        jPanel10.setBackground(new java.awt.Color(213, 243, 239));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 153));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vect (3).png"))); // NOI18N
        jLabel28.setText("Nombre de Aula");

        lbAula.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        lbAula.setForeground(new java.awt.Color(51, 51, 51));
        lbAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAula.setText("Aula Sol");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAula, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 200, 90));

        btnAsistencia.setBackground(new java.awt.Color(0, 153, 153));
        btnAsistencia.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        btnAsistencia.setText("ASISTENCIA");
        btnAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsistencia.setFocusPainted(false);
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 200, 50));

        jPanel3.setBackground(new java.awt.Color(213, 243, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(160, 90));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vect (4).png"))); // NOI18N
        jLabel3.setText("Nivel Funcional");

        lbNivel.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        lbNivel.setForeground(new java.awt.Color(51, 51, 51));
        lbNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNivel.setText("Moderado");
        lbNivel.setToolTipText("");
        lbNivel.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 200, 90));

        lbFechaCompleta.setFont(new java.awt.Font("Trebuchet MS", 2, 18)); // NOI18N
        lbFechaCompleta.setForeground(new java.awt.Color(51, 51, 51));
        lbFechaCompleta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaCompleta.setText("Fecha de hoy");
        jPanel1.add(lbFechaCompleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 300, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 650));

        jPanel5.setBackground(new java.awt.Color(239, 239, 239));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1 1_2.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 0, 74, 90));

        mInicio.setBackground(new java.awt.Color(255, 255, 255));
        mInicio.setForeground(new java.awt.Color(255, 255, 255));
        mInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home-1.png"))); // NOI18N
        jLabel11.setToolTipText("");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(58, 163, 163));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("INICIO");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mInicioLayout = new javax.swing.GroupLayout(mInicio);
        mInicio.setLayout(mInicioLayout);
        mInicioLayout.setHorizontalGroup(
            mInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mInicioLayout.setVerticalGroup(
            mInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mInicioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12)
                .addGap(24, 24, 24))
        );

        jPanel5.add(mInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 120, 90));

        mSeguimiento.setBackground(new java.awt.Color(239, 239, 239));
        mSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mSeguimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mSeguimientoMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Star_2.png"))); // NOI18N
        jLabel13.setToolTipText("");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(200, 80, 145));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SEGUIMIENTO");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mSeguimientoLayout = new javax.swing.GroupLayout(mSeguimiento);
        mSeguimiento.setLayout(mSeguimientoLayout);
        mSeguimientoLayout.setHorizontalGroup(
            mSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        mSeguimientoLayout.setVerticalGroup(
            mSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSeguimientoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mSeguimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 120, 90));

        mIncidentes.setBackground(new java.awt.Color(239, 239, 239));
        mIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Checlk Alt Square.png"))); // NOI18N
        jLabel15.setToolTipText("");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(66, 128, 191));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("INCIDENTES");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mIncidentesLayout = new javax.swing.GroupLayout(mIncidentes);
        mIncidentes.setLayout(mIncidentesLayout);
        mIncidentesLayout.setHorizontalGroup(
            mIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        mIncidentesLayout.setVerticalGroup(
            mIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mIncidentesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 120, 90));

        mSalir.setBackground(new java.awt.Color(239, 239, 239));
        mSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Log Out_2.png"))); // NOI18N
        jLabel23.setToolTipText("");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("SALIR");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mSalirLayout = new javax.swing.GroupLayout(mSalir);
        mSalir.setLayout(mSalirLayout);
        mSalirLayout.setHorizontalGroup(
            mSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mSalirLayout.setVerticalGroup(
            mSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSalirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel24)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.add(mSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 70, 90));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Hola,");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 40, -1));

        lbNomUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Alt3.png"))); // NOI18N
        lbNomUsuario.setText("Evelyn Pascual");
        lbNomUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        mPlanIndividual.setBackground(new java.awt.Color(239, 239, 239));
        mPlanIndividual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Devices_1.png"))); // NOI18N
        jLabel17.setToolTipText("");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(126, 3, 126));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PLAN INDIVIDUAL");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mPlanIndividualLayout = new javax.swing.GroupLayout(mPlanIndividual);
        mPlanIndividual.setLayout(mPlanIndividualLayout);
        mPlanIndividualLayout.setHorizontalGroup(
            mPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        mPlanIndividualLayout.setVerticalGroup(
            mPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mPlanIndividualLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mPlanIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 130, 90));

        mReportes.setBackground(new java.awt.Color(239, 239, 239));
        mReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mReportes.setPreferredSize(new java.awt.Dimension(120, 90));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clip_1.png"))); // NOI18N
        jLabel21.setToolTipText("");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(214, 64, 64));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("REPORTES");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mReportesLayout = new javax.swing.GroupLayout(mReportes);
        mReportes.setLayout(mReportesLayout);
        mReportesLayout.setHorizontalGroup(
            mReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        mReportesLayout.setVerticalGroup(
            mReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mReportesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 120, 90));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed

        Asistencia vAsistencia = new Asistencia();
        vAsistencia.setVisible(true);
        vAsistencia.setLocationRelativeTo(null);


    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void mSeguimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mSeguimientoMouseClicked
        Seguimiento vSeguimiento = new Seguimiento(idDocente);
        vSeguimiento.setVisible(true);
        vSeguimiento.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_mSeguimientoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JList<String> jlHistorialRegistros;
    private javax.swing.JList<String> jlTopIncidentes;
    private javax.swing.JLabel lbAsistentes;
    private javax.swing.JLabel lbAula;
    private javax.swing.JLabel lbEstudiante;
    private javax.swing.JLabel lbFechaCompleta;
    private javax.swing.JLabel lbNivel;
    private javax.swing.JLabel lbNivel12;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JPanel mIncidentes;
    private javax.swing.JPanel mInicio;
    private javax.swing.JPanel mPlanIndividual;
    private javax.swing.JPanel mReportes;
    private javax.swing.JPanel mSalir;
    private javax.swing.JPanel mSeguimiento;
    private javax.swing.JTable tbEstudiantesDashboard;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtMedicinas;
    private javax.swing.JTextArea txtObserv;
    // End of variables declaration//GEN-END:variables
}
