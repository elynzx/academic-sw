/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import controller.DocenteCtrl;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.funcionalidad.catalogo.CategoriaConducta;
import model.funcionalidad.catalogo.Diagnostico;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.ISeguimiento;
import model.dao.SeguimientoDao;
import model.entidades.Estudiante;
import utillities.Utilidad;

/**
 *
 * @author rpasc
 */
public class SeguimientoView extends javax.swing.JPanel {

    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private ISeguimiento seguimientoDao = new SeguimientoDao();
    private int idDocente;
    private int idEstudiante;
    private DocenteCtrl docenteCtrl;
    private Utilidad utilidad = new Utilidad();

    public SeguimientoView(int idDocente) {
        this.idDocente = idDocente;
        docenteCtrl = new DocenteCtrl(docenteDao);

        initComponents();

        utilidad.mostrarDia(lbFechaHoy);
        cargarEstudiantesTabla(idDocente);
        seleccionTbAlumnos();

        cargarCategorias();
    }

    private void cargarEstudiantesTabla(int idDocente) {
        tbListaEstudiantes.setModel(docenteCtrl.obtenerModeloTablaEstudiantes(idDocente));
    }

    private void mostrarDatosEstudiante(int idEstudiante) {

        try {
            Estudiante estudiante = estudianteDao.obtenerDatosEstudiante(idEstudiante);
            txtIdEstudiante.setText(String.valueOf(estudiante.getIdEstudiante()));
            txtNombreEstudiante.setText(estudiante.getNombres());
            txtApellidoEstudiante.setText(estudiante.getApellidos());
            txtDiagnosticoEstudiante.setText(estudiante.getDiagnosticos().stream().map(Diagnostico::getNombre).collect(Collectors.joining(", ")));

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    private void cargarCategorias() {
        cbCategoriaSeguimiento.removeAllItems();

        try {
            List<CategoriaConducta> listaCategoria = seguimientoDao.ObtenerCategoriaConductas();

            if (listaCategoria != null && !listaCategoria.isEmpty()) {
                for (CategoriaConducta categoria : listaCategoria) {
                    cbCategoriaSeguimiento.addItem(categoria);
                }
            } else {
                System.out.println("No hay categorías disponibles.");
            }

        } catch (Exception e) {
            System.out.println("Error al obtener la lista de categorías: " + e.getMessage());
        }
    }

    private DefaultTableModel cargarPromedioSeguimiento(int idEstudiante) {
        DefaultTableModel modelo = (DefaultTableModel) tbCategoriasEstudiante.getModel();
        modelo.setRowCount(0);

        for (Map<String, Object> registro : seguimientoDao.obtenerPromedioFrecuencia(idEstudiante)) {
            modelo.addRow(new Object[]{registro.get("categoria"), registro.get("promedio")});
        }
        return modelo;

    }

    private void seleccionTbAlumnos() {
        tbListaEstudiantes.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tbListaEstudiantes.getSelectedRow();
                if (selectedRow != -1) {
                    int idEstudiante = (int) tbListaEstudiantes.getValueAt(selectedRow, 0);
                    mostrarDatosEstudiante(idEstudiante);
                    cargarPromedioSeguimiento(idEstudiante);

                }
            }
        });
    }

    private int obtenerFrecuenciaSeleccionada() {
        for (Enumeration<AbstractButton> botones = btnGroupFrecuencia.getElements(); botones.hasMoreElements();) {
            AbstractButton boton = botones.nextElement();
            if (boton.isSelected()) {
                return Integer.parseInt(boton.getText());
            }
        }
        return -1;
    }
    
//    private void limpiarDatosEstudiante() {
//
//            txtIdEstudiante.setText(String.valueOf(estudiante.getIdEstudiante()));
//            txtNombreEstudiante.setText(estudiante.getNombres());
//            txtApellidoEstudiante.setText(estudiante.getApellidos());
//            txtDiagnosticoEstudiante.setText(estudiante.getDiagnosticos().stream().map(Diagnostico::getNombre).collect(Collectors.joining(", ")));
//
//    }
//    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFrecuencia = new javax.swing.ButtonGroup();
        jpDashboardDocente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbNivel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbListaEstudiantes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtIdEstudiante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoEstudiante = new javax.swing.JTextField();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbNivel6 = new javax.swing.JLabel();
        lbNivel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCategoriasEstudiante = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbNivel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rbF0 = new javax.swing.JRadioButton();
        rbF1 = new javax.swing.JRadioButton();
        rbF2 = new javax.swing.JRadioButton();
        rbF3 = new javax.swing.JRadioButton();
        rbF4 = new javax.swing.JRadioButton();
        rbF5 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObsConducta = new javax.swing.JTextArea();
        lbNivel2 = new javax.swing.JLabel();
        lbNivel4 = new javax.swing.JLabel();
        cbCategoriaSeguimiento = new javax.swing.JComboBox<>();
        lbNivel7 = new javax.swing.JLabel();
        txtDscConducta = new javax.swing.JTextField();
        btnGuardarSeguimiento = new javax.swing.JButton();
        lbNivel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jpDashboardDocente.setBackground(new java.awt.Color(255, 255, 255));
        jpDashboardDocente.setMinimumSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setPreferredSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbNivel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Lista de Estudiantes");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));

        tbListaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbListaEstudiantes.setForeground(new java.awt.Color(51, 51, 51));
        tbListaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbListaEstudiantes.setGridColor(new java.awt.Color(214, 214, 214));
        tbListaEstudiantes.setRowHeight(22);
        tbListaEstudiantes.setSelectionBackground(new java.awt.Color(255, 243, 250));
        tbListaEstudiantes.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tbListaEstudiantes);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtIdEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtIdEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombres:");

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Apellidos:");

        txtApellidoEstudiante.setEditable(false);
        txtApellidoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellidoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtDiagnosticoEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtDiagnosticoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Diagnóstico:");

        lbNivel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sertificate-2.png"))); // NOI18N
        lbNivel6.setText("Datos del Estudiante:");
        lbNivel6.setToolTipText("");
        lbNivel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Line_up-2.png"))); // NOI18N
        lbNivel5.setText("Resumen de progreso");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));

        tbCategoriasEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbCategoriasEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        tbCategoriasEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Transición", null},
                {"Juego", null},
                {"Alimentación", null},
                {"Seguridad", null},
                {"Socialización", null},
                {"Trabajo independiente", null}
            },
            new String [] {
                "Categoria", "Frecuencia Promedio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCategoriasEstudiante.setGridColor(new java.awt.Color(214, 214, 214));
        tbCategoriasEstudiante.setRowHeight(28);
        tbCategoriasEstudiante.setSelectionBackground(new java.awt.Color(252, 249, 239));
        tbCategoriasEstudiante.setShowGrid(false);
        tbCategoriasEstudiante.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(tbCategoriasEstudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtApellidoEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbNivel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNivel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                        .addComponent(txtDiagnosticoEstudiante, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lbNivel6, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiagnosticoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lbNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNivel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jpDashboardDocente.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 710, 580));

        jPanel4.setBackground(new java.awt.Color(45, 94, 152));

        lbNivel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel1.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel1.setText("Frencuencia de conducta:");
        lbNivel1.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel5.setBackground(new java.awt.Color(45, 94, 152));

        rbF0.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF0);
        rbF0.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF0.setForeground(new java.awt.Color(255, 255, 255));
        rbF0.setText("0");
        rbF0.setToolTipText("No se observó la conducta en ninguna ocasión.");
        rbF0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF0.setFocusPainted(false);
        rbF0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF0.setIconTextGap(10);
        rbF0.setOpaque(true);

        rbF1.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF1);
        rbF1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF1.setForeground(new java.awt.Color(255, 255, 255));
        rbF1.setText("1");
        rbF1.setToolTipText("Se observó una sola vez de forma muy leve.");
        rbF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF1.setFocusPainted(false);
        rbF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF1.setIconTextGap(10);
        rbF1.setOpaque(true);

        rbF2.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF2);
        rbF2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF2.setForeground(new java.awt.Color(255, 255, 255));
        rbF2.setText("2");
        rbF2.setToolTipText("Se observó de forma ocasional (2 -3 veces)");
        rbF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF2.setFocusPainted(false);
        rbF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF2.setIconTextGap(10);
        rbF2.setOpaque(true);

        rbF3.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF3);
        rbF3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF3.setForeground(new java.awt.Color(255, 255, 255));
        rbF3.setText("3");
        rbF3.setToolTipText("Se observó con frecuencia moderada (4-5 veces)");
        rbF3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF3.setFocusPainted(false);
        rbF3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF3.setIconTextGap(10);
        rbF3.setOpaque(true);

        rbF4.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF4);
        rbF4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF4.setForeground(new java.awt.Color(255, 255, 255));
        rbF4.setText("4");
        rbF4.setToolTipText("Se observó con frecuencia alta (más de 5 veces)");
        rbF4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF4.setFocusPainted(false);
        rbF4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF4.setIconTextGap(10);
        rbF4.setOpaque(true);

        rbF5.setBackground(new java.awt.Color(45, 94, 152));
        btnGroupFrecuencia.add(rbF5);
        rbF5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF5.setForeground(new java.awt.Color(255, 255, 255));
        rbF5.setText("5");
        rbF5.setToolTipText("Se observó de forma constante y positiva.");
        rbF5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF5.setFocusPainted(false);
        rbF5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF5.setIconTextGap(10);
        rbF5.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbF0)
                .addGap(23, 23, 23)
                .addComponent(rbF1)
                .addGap(23, 23, 23)
                .addComponent(rbF2)
                .addGap(23, 23, 23)
                .addComponent(rbF3)
                .addGap(23, 23, 23)
                .addComponent(rbF4)
                .addGap(23, 23, 23)
                .addComponent(rbF5)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbF0)
                    .addComponent(rbF1)
                    .addComponent(rbF2)
                    .addComponent(rbF3)
                    .addComponent(rbF4)
                    .addComponent(rbF5)))
        );

        txtObsConducta.setColumns(20);
        txtObsConducta.setForeground(new java.awt.Color(51, 51, 51));
        txtObsConducta.setRows(5);
        txtObsConducta.setBorder(null);
        jScrollPane1.setViewportView(txtObsConducta);

        lbNivel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel2.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel2.setText("Observaciones:");
        lbNivel2.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Selecciona la categoria:");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));

        cbCategoriaSeguimiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbCategoriaSeguimiento.setForeground(new java.awt.Color(51, 51, 51));
        cbCategoriaSeguimiento.setBorder(null);

        lbNivel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel7.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel7.setText("Descripción:");
        lbNivel7.setPreferredSize(new java.awt.Dimension(70, 25));

        txtDscConducta.setForeground(new java.awt.Color(51, 51, 51));
        txtDscConducta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        btnGuardarSeguimiento.setBackground(new java.awt.Color(221, 168, 83));
        btnGuardarSeguimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarSeguimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_fill-2.png"))); // NOI18N
        btnGuardarSeguimiento.setText("GUARDAR");
        btnGuardarSeguimiento.setBorder(null);
        btnGuardarSeguimiento.setBorderPainted(false);
        btnGuardarSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarSeguimiento.setFocusPainted(false);
        btnGuardarSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSeguimientoActionPerformed(evt);
            }
        });

        lbNivel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNivel8.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Group_light.png"))); // NOI18N
        lbNivel8.setText("Actividad de hoy");
        lbNivel8.setPreferredSize(new java.awt.Dimension(70, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sad_alt-2_1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/happy-5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnGuardarSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(lbNivel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoriaSeguimiento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDscConducta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoriaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDscConducta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jpDashboardDocente.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 450, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 84, 138));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Seguimiento Conductual Diario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 33, 387, 50));

        lbFechaHoy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(39, 84, 138));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Date_fill-1_1.png"))); // NOI18N
        lbFechaHoy.setText("Fecha de hoy");
        jPanel1.add(lbFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 36, 456, 40));

        jpDashboardDocente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 90));

        jSeparator1.setForeground(new java.awt.Color(45, 94, 152));
        jpDashboardDocente.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1160, 12));

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

    private void btnGuardarSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSeguimientoActionPerformed

                
        int idEstudiante = Integer.parseInt(txtIdEstudiante.getText());
        CategoriaConducta categoria = (CategoriaConducta) cbCategoriaSeguimiento.getSelectedItem();
        String descripcion = txtDscConducta.getText();
        int frecuencia = obtenerFrecuenciaSeleccionada();
        String observaciones = txtObsConducta.getText();

        if (frecuencia == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una frecuencia.");
            return;
        }

        boolean guardado = seguimientoDao.guardarSeguimiento(idEstudiante, categoria.getId(), descripcion, frecuencia, observaciones);

        if (guardado) {
            JOptionPane.showMessageDialog(this, "Seguimiento guardado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar seguimiento.");
        }

    }//GEN-LAST:event_btnGuardarSeguimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupFrecuencia;
    private javax.swing.JButton btnGuardarSeguimiento;
    private javax.swing.JComboBox<CategoriaConducta> cbCategoriaSeguimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpDashboardDocente;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel1;
    private javax.swing.JLabel lbNivel2;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel7;
    private javax.swing.JLabel lbNivel8;
    private javax.swing.JRadioButton rbF0;
    private javax.swing.JRadioButton rbF1;
    private javax.swing.JRadioButton rbF2;
    private javax.swing.JRadioButton rbF3;
    private javax.swing.JRadioButton rbF4;
    private javax.swing.JRadioButton rbF5;
    private javax.swing.JTable tbCategoriasEstudiante;
    private javax.swing.JTable tbListaEstudiantes;
    private javax.swing.JTextField txtApellidoEstudiante;
    private javax.swing.JTextField txtDiagnosticoEstudiante;
    private javax.swing.JTextField txtDscConducta;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextArea txtObsConducta;
    // End of variables declaration//GEN-END:variables
}
