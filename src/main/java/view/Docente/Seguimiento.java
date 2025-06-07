/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import model.catalogo.CategoriaConducta;
import model.catalogo.Diagnostico;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.ISeguimiento;
import model.dao.SeguimientoDao;
import model.entidades.Estudiante;
import utillities.Utilidad;

public class Seguimiento extends javax.swing.JFrame {

    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private ISeguimiento seguimientoDao = new SeguimientoDao();
    private int idDocente;
    private int idEstudiante;
    private DocenteCtrl docenteCtrl;
    private Utilidad utilidad = new Utilidad();

    public Seguimiento(int idDocente) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFrecuencia = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtNombreEstudiante = new javax.swing.JTextField();
        lbNivel3 = new javax.swing.JLabel();
        txtApellidoEstudiante = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCategoriasEstudiante = new javax.swing.JTable();
        lbNivel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbNivel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbF01 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObsConducta = new javax.swing.JTextArea();
        lbNivel2 = new javax.swing.JLabel();
        lbNivel4 = new javax.swing.JLabel();
        cbCategoriaSeguimiento = new javax.swing.JComboBox<>();
        lbNivel7 = new javax.swing.JLabel();
        txtDscConducta = new javax.swing.JTextField();
        btnGuardarSeguimiento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbListaEstudiantes = new javax.swing.JTable();
        lbNivel6 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Seguimiento Conductual Diario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 520, -1));

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtIdEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtIdEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtIdEstudiante.setBorder(null);
        jPanel1.add(txtIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 80, 30));

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtNombreEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNombreEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreEstudiante.setBorder(null);
        jPanel1.add(txtNombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 230, 30));

        lbNivel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(200, 80, 145));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Lista de Estudiantes");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel1.add(lbNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 30));

        txtApellidoEstudiante.setEditable(false);
        txtApellidoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtApellidoEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtApellidoEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoEstudiante.setBorder(null);
        jPanel1.add(txtApellidoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 230, 30));

        tbCategoriasEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbCategoriasEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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
        tbCategoriasEstudiante.setRowHeight(34);
        tbCategoriasEstudiante.setSelectionBackground(new java.awt.Color(255, 243, 250));
        tbCategoriasEstudiante.setShowGrid(false);
        tbCategoriasEstudiante.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(tbCategoriasEstudiante);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 320, 230));

        lbNivel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(200, 80, 145));
        lbNivel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel5.setText("Progreso");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel1.add(lbNivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 320, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 178, 206)));

        lbNivel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel1.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel1.setText("Frencuencia de conducta");
        lbNivel1.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        rbF01.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(rbF01);
        rbF01.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbF01.setForeground(new java.awt.Color(51, 51, 51));
        rbF01.setText("0");
        rbF01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF01.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbF01.setFocusPainted(false);
        rbF01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF01.setIconTextGap(10);
        rbF01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbF01MouseEntered(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setText("1");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton2.setFocusPainted(false);
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton2.setIconTextGap(10);
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseEntered(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton3.setText("2");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton3.setIconTextGap(10);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton4.setText("3");
        jRadioButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton4.setFocusPainted(false);
        jRadioButton4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton4.setIconTextGap(10);
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseEntered(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton5.setText("4");
        jRadioButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton5.setFocusPainted(false);
        jRadioButton5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton5.setIconTextGap(10);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFrecuencia.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton6.setText("5");
        jRadioButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton6.setFocusPainted(false);
        jRadioButton6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton6.setIconTextGap(10);
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton6MouseEntered(evt);
            }
        });
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(rbF01)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton2)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton3)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton4)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton5)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton6)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbF01)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap())
        );

        rbF01.getAccessibleContext().setAccessibleName("");
        rbF01.getAccessibleContext().setAccessibleDescription("");
        jRadioButton2.getAccessibleContext().setAccessibleName("");
        jRadioButton2.getAccessibleContext().setAccessibleDescription("");
        jRadioButton3.getAccessibleContext().setAccessibleName("");
        jRadioButton3.getAccessibleContext().setAccessibleDescription("");
        jRadioButton4.getAccessibleContext().setAccessibleName("");
        jRadioButton4.getAccessibleContext().setAccessibleDescription("");
        jRadioButton5.getAccessibleContext().setAccessibleName("");
        jRadioButton5.getAccessibleContext().setAccessibleDescription("");
        jRadioButton6.getAccessibleContext().setAccessibleName("");
        jRadioButton6.getAccessibleContext().setAccessibleDescription("");

        txtObsConducta.setColumns(20);
        txtObsConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtObsConducta.setForeground(new java.awt.Color(102, 102, 102));
        txtObsConducta.setRows(5);
        txtObsConducta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        jScrollPane1.setViewportView(txtObsConducta);

        lbNivel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel2.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel2.setText("Observaciones");
        lbNivel2.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Categoria");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));

        cbCategoriaSeguimiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbCategoriaSeguimiento.setForeground(new java.awt.Color(102, 102, 102));
        cbCategoriaSeguimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbNivel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel7.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel7.setText("Descripción de conducta");
        lbNivel7.setPreferredSize(new java.awt.Dimension(70, 25));

        txtDscConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDscConducta.setForeground(new java.awt.Color(102, 102, 102));
        txtDscConducta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        btnGuardarSeguimiento.setBackground(new java.awt.Color(200, 80, 145));
        btnGuardarSeguimiento.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnGuardarSeguimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarSeguimiento.setText("GUARDAR");
        btnGuardarSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarSeguimiento.setFocusPainted(false);
        btnGuardarSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSeguimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDscConducta)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoriaSeguimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNivel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(btnGuardarSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoriaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDscConducta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addComponent(btnGuardarSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 430, 520));

        tbListaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbListaEstudiantes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 280, 450));

        lbNivel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(200, 80, 145));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setText("Datos del Estudiante");
        lbNivel6.setToolTipText("");
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel1.add(lbNivel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 190, 30));

        lbFechaHoy.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(51, 51, 51));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setText("Fecha de hoy");
        jPanel1.add(lbFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 420, 40));

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtDiagnosticoEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtDiagnosticoEstudiante.setBorder(null);
        jPanel1.add(txtDiagnosticoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 230, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Diagnóstico:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, 30));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 20, 30));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Apellidos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, 30));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nombres:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 650));

        jPanel5.setBackground(new java.awt.Color(237, 237, 237));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1 1_2.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 0, 74, 90));

        mInicio.setBackground(new java.awt.Color(237, 237, 237));
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
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        mInicioLayout.setVerticalGroup(
            mInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mInicioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 120, 90));

        mSeguimiento.setBackground(new java.awt.Color(255, 255, 255));
        mSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        mIncidentes.setBackground(new java.awt.Color(237, 237, 237));
        mIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mIncidentesMouseClicked(evt);
            }
        });

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

        mSalir.setBackground(new java.awt.Color(237, 237, 237));
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

        jPanel5.add(mSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 70, 90));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Hola,");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 40, -1));

        lbNomUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Alt3.png"))); // NOI18N
        lbNomUsuario.setText("Evelyn Pascual");
        lbNomUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        mPlanIndividual.setBackground(new java.awt.Color(237, 237, 237));
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

        mReportes.setBackground(new java.awt.Color(237, 237, 237));
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

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void rbF01MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbF01MouseEntered

        rbF01.setToolTipText("No se observa.");

    }//GEN-LAST:event_rbF01MouseEntered

    private void jRadioButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseEntered

        jRadioButton2.setToolTipText("Muy baja.");

    }//GEN-LAST:event_jRadioButton2MouseEntered

    private void jRadioButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MouseEntered

        jRadioButton6.setToolTipText("Alta y positiva.");

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6MouseEntered

    private void jRadioButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseEntered

        jRadioButton4.setToolTipText("Moderada.");
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4MouseEntered

    private void mIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mIncidentesMouseClicked

        Incidentes vIncedente = new Incidentes(idDocente);
        vIncedente.setVisible(true);
        vIncedente.setLocationRelativeTo(null);
        this.dispose();


    }//GEN-LAST:event_mIncidentesMouseClicked

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel1;
    private javax.swing.JLabel lbNivel2;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel7;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JPanel mIncidentes;
    private javax.swing.JPanel mInicio;
    private javax.swing.JPanel mPlanIndividual;
    private javax.swing.JPanel mReportes;
    private javax.swing.JPanel mSalir;
    private javax.swing.JPanel mSeguimiento;
    private javax.swing.JRadioButton rbF01;
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
