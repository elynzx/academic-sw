/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import java.util.List;
import java.util.stream.Collectors;
import model.dao.DocenteDao;
import model.funcionalidad.catalogo.Antecedente;
import model.funcionalidad.catalogo.Diagnostico;
import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.IRegistroIncidente;
import model.dao.RegistroIncidenteDao;
import model.entidades.Estudiante;
import utillities.Utilidad;

/**
 *
 * @author rpasc
 */
public class IncidentesView extends javax.swing.JPanel {

    private IRegistroIncidente registroIncidenteDao = new RegistroIncidenteDao();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private int idDocente;
    private Utilidad utilidad = new Utilidad();

    public IncidentesView(int idDocente) {
        this.idDocente = idDocente;
        initComponents();
        utilidad.mostrarDia(lbFechaHoy);
        cargarEstudiantes(idDocente);
        cargarTipoConductas();
        cargarFuncionComportamiento();
        cargarAntecedentes();

    }

    private void cargarTipoConductas() {
        cbTipoConducta.removeAllItems();
        try {
            List<TipoConducta> listaTipoConductas = registroIncidenteDao.obtenerTipoConductas();
            if (listaTipoConductas != null && !listaTipoConductas.isEmpty()) {
                for (TipoConducta tipoConducta : listaTipoConductas) {
                    cbTipoConducta.addItem(tipoConducta);
                }
            } else {
                System.out.println("No hay categorías disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los tipos de conducta: " + e.getMessage());
        }
    }

    private void cargarFuncionComportamiento() {
        cbFuncionComportamiento.removeAllItems();
        try {
            List<FuncionComportamiento> listaFuncionComportamientos = registroIncidenteDao.obtenerFuncionComportamientos();
            if (listaFuncionComportamientos != null && !listaFuncionComportamientos.isEmpty()) {
                for (FuncionComportamiento funcionComportamiento : listaFuncionComportamientos) {
                    cbFuncionComportamiento.addItem(funcionComportamiento);
                }
            } else {
                System.out.println("No hay categorías disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de categorías: " + e.getMessage());
        }
    }

    private void cargarAntecedentes() {
        cbAntecedente.removeAllItems();
        try {
            List<Antecedente> listaAntecedentes = registroIncidenteDao.obtenerAntecedentes();

            if (listaAntecedentes != null && !listaAntecedentes.isEmpty()) {
                for (Antecedente antecedente : listaAntecedentes) {
                    cbAntecedente.addItem(antecedente);
                }
            } else {
                System.out.println("No hay categorías disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de categorías: " + e.getMessage());
        }
    }

    private void cargarEstudiantes(int idDocente) {
        cbListaEstudiantes.removeAllItems();
        List<Estudiante> listaEstudiantes = docenteDao.obtenerListaEstudiantes(idDocente);
        for (Estudiante estudiante : listaEstudiantes) {
            cbListaEstudiantes.addItem(estudiante);
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupConducta = new javax.swing.ButtonGroup();
        btnGroupFicha = new javax.swing.ButtonGroup();
        jpDashboardDocente = new javax.swing.JPanel();
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
        txtConductaDsc = new javax.swing.JTextArea();
        lbNivel2 = new javax.swing.JLabel();
        lbNivel4 = new javax.swing.JLabel();
        cbTipoConducta = new javax.swing.JComboBox<>();
        btnCrearConductaProblematica = new javax.swing.JButton();
        lbNivel8 = new javax.swing.JLabel();
        cbFuncionComportamiento = new javax.swing.JComboBox<>();
        lbNivel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        txtEstudianteFiltro = new javax.swing.JTextField();
        btnBuscarEstudiante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtIdEstudiante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbNivel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoEstudiante = new javax.swing.JTextField();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbNivel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbIncidentesEstudiante = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lbNivel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rbF6 = new javax.swing.JRadioButton();
        rbF7 = new javax.swing.JRadioButton();
        rbF8 = new javax.swing.JRadioButton();
        rbF9 = new javax.swing.JRadioButton();
        rbF10 = new javax.swing.JRadioButton();
        rbF11 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComportamiento = new javax.swing.JTextArea();
        lbNivel9 = new javax.swing.JLabel();
        lbNivel10 = new javax.swing.JLabel();
        cbAntecedente = new javax.swing.JComboBox<>();
        btnCrearFicha = new javax.swing.JButton();
        lbNivel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtConsecuencia = new javax.swing.JTextArea();
        lbNivel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbListaEstudiantes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        jpDashboardDocente.setBackground(new java.awt.Color(255, 255, 255));
        jpDashboardDocente.setMinimumSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setPreferredSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(134, 134, 134));

        lbNivel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel1.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel1.setText("Gravedad:");
        lbNivel1.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel5.setBackground(new java.awt.Color(134, 134, 134));

        rbF0.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF0);
        rbF0.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF0.setForeground(new java.awt.Color(255, 255, 255));
        rbF0.setText("0");
        rbF0.setToolTipText("No se observa / Muy positivo");
        rbF0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF0.setFocusPainted(false);
        rbF0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF0.setIconTextGap(10);
        rbF0.setOpaque(true);

        rbF1.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF1);
        rbF1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF1.setForeground(new java.awt.Color(255, 255, 255));
        rbF1.setText("1");
        rbF1.setToolTipText("Leve, sin impacto negativo");
        rbF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF1.setFocusPainted(false);
        rbF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF1.setIconTextGap(10);
        rbF1.setOpaque(true);

        rbF2.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF2);
        rbF2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF2.setForeground(new java.awt.Color(255, 255, 255));
        rbF2.setText("2");
        rbF2.setToolTipText("Moderada");
        rbF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF2.setFocusPainted(false);
        rbF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF2.setIconTextGap(10);
        rbF2.setOpaque(true);

        rbF3.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF3);
        rbF3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF3.setForeground(new java.awt.Color(255, 255, 255));
        rbF3.setText("3");
        rbF3.setToolTipText("Frecuente / Interfiere");
        rbF3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF3.setFocusPainted(false);
        rbF3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF3.setIconTextGap(10);
        rbF3.setOpaque(true);

        rbF4.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF4);
        rbF4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF4.setForeground(new java.awt.Color(255, 255, 255));
        rbF4.setText("4");
        rbF4.setToolTipText("Grave");
        rbF4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF4.setFocusPainted(false);
        rbF4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF4.setIconTextGap(10);
        rbF4.setOpaque(true);

        rbF5.setBackground(new java.awt.Color(134, 134, 134));
        btnGroupConducta.add(rbF5);
        rbF5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF5.setForeground(new java.awt.Color(255, 255, 255));
        rbF5.setText("5");
        rbF5.setToolTipText("Muy grave / Riesgo alto");
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
                .addGap(0, 0, Short.MAX_VALUE)
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
                .addGap(10, 10, 10))
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

        txtConductaDsc.setColumns(20);
        txtConductaDsc.setForeground(new java.awt.Color(51, 51, 51));
        txtConductaDsc.setRows(5);
        txtConductaDsc.setBorder(null);
        jScrollPane1.setViewportView(txtConductaDsc);

        lbNivel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel2.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel2.setText("Descripción:");
        lbNivel2.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Tipo de Conducta:");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));

        cbTipoConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbTipoConducta.setForeground(new java.awt.Color(51, 51, 51));
        cbTipoConducta.setToolTipText("Categoría general observable");
        cbTipoConducta.setBorder(null);

        btnCrearConductaProblematica.setBackground(new java.awt.Color(221, 168, 83));
        btnCrearConductaProblematica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearConductaProblematica.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearConductaProblematica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_fill-2.png"))); // NOI18N
        btnCrearConductaProblematica.setText("GUARDAR");
        btnCrearConductaProblematica.setBorder(null);
        btnCrearConductaProblematica.setBorderPainted(false);
        btnCrearConductaProblematica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearConductaProblematica.setFocusPainted(false);
        btnCrearConductaProblematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearConductaProblematicaActionPerformed(evt);
            }
        });

        lbNivel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbNivel8.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel8.setText("1. Conducta Problemática");
        lbNivel8.setPreferredSize(new java.awt.Dimension(70, 25));

        cbFuncionComportamiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbFuncionComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        cbFuncionComportamiento.setToolTipText("¿Por qué ocurre el comportamiento?");
        cbFuncionComportamiento.setBorder(null);

        lbNivel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel11.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel11.setText("Función del comportamiento:");
        lbNivel11.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbNivel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbFuncionComportamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTipoConducta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCrearConductaProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoConducta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFuncionComportamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearConductaProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jpDashboardDocente.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 390, 520));

        jPanel1.setBackground(new java.awt.Color(221, 227, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 243));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 84, 138));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Registro de Incidentes");

        lbFechaHoy.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(39, 84, 138));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Date_fill-1_1.png"))); // NOI18N
        lbFechaHoy.setText("Fecha de hoy");

        txtEstudianteFiltro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEstudianteFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 94, 152)));

        btnBuscarEstudiante.setBackground(new java.awt.Color(45, 94, 152));
        btnBuscarEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_alt-2.png"))); // NOI18N
        btnBuscarEstudiante.setBorder(null);
        btnBuscarEstudiante.setBorderPainted(false);
        btnBuscarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtEstudianteFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(lbFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstudianteFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))))
        );

        jpDashboardDocente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtIdEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtIdEstudiante.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID:");

        lbNivel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sertificate-2.png"))); // NOI18N
        lbNivel6.setText("Datos del Estudiante");
        lbNivel6.setToolTipText("");
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombres:");

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtNombreEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreEstudiante.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Apellidos:");

        txtApellidoEstudiante.setEditable(false);
        txtApellidoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtApellidoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidoEstudiante.setBorder(null);

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtDiagnosticoEstudiante.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Diagnóstico:");

        lbNivel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Line_up-2.png"))); // NOI18N
        lbNivel5.setText("Historial de incidentes");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));

        tbIncidentesEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbIncidentesEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        tbIncidentesEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Tipo", "Fecha", "Gravedad"
            }
        ));
        tbIncidentesEstudiante.setGridColor(new java.awt.Color(214, 214, 214));
        tbIncidentesEstudiante.setRowHeight(25);
        tbIncidentesEstudiante.setSelectionBackground(new java.awt.Color(252, 249, 239));
        tbIncidentesEstudiante.setShowGrid(false);
        tbIncidentesEstudiante.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(tbIncidentesEstudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(38, 38, 38)
                        .addComponent(txtNombreEstudiante))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(37, 37, 37)
                        .addComponent(txtApellidoEstudiante))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(txtDiagnosticoEstudiante))
                    .addComponent(lbNivel5, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiagnosticoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lbNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jpDashboardDocente.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 310, 470));

        jPanel6.setBackground(new java.awt.Color(110, 146, 203));

        lbNivel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Gravedad:");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel7.setBackground(new java.awt.Color(110, 146, 203));

        rbF6.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF6);
        rbF6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF6.setForeground(new java.awt.Color(255, 255, 255));
        rbF6.setText("0");
        rbF6.setToolTipText("No se observa / Muy positivo");
        rbF6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF6.setFocusPainted(false);
        rbF6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF6.setIconTextGap(10);
        rbF6.setOpaque(true);

        rbF7.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF7);
        rbF7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF7.setForeground(new java.awt.Color(255, 255, 255));
        rbF7.setText("1");
        rbF7.setToolTipText("Leve, sin impacto negativo");
        rbF7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF7.setFocusPainted(false);
        rbF7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF7.setIconTextGap(10);
        rbF7.setOpaque(true);

        rbF8.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF8);
        rbF8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF8.setForeground(new java.awt.Color(255, 255, 255));
        rbF8.setText("2");
        rbF8.setToolTipText("Moderada");
        rbF8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF8.setFocusPainted(false);
        rbF8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF8.setIconTextGap(10);
        rbF8.setOpaque(true);

        rbF9.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF9);
        rbF9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF9.setForeground(new java.awt.Color(255, 255, 255));
        rbF9.setText("3");
        rbF9.setToolTipText("Frecuente / Interfiere");
        rbF9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF9.setFocusPainted(false);
        rbF9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF9.setIconTextGap(10);
        rbF9.setOpaque(true);

        rbF10.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF10);
        rbF10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF10.setForeground(new java.awt.Color(255, 255, 255));
        rbF10.setText("4");
        rbF10.setToolTipText("Grave");
        rbF10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF10.setFocusPainted(false);
        rbF10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF10.setIconTextGap(10);
        rbF10.setOpaque(true);

        rbF11.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupFicha.add(rbF11);
        rbF11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbF11.setForeground(new java.awt.Color(255, 255, 255));
        rbF11.setText("5");
        rbF11.setToolTipText("Muy grave / Riesgo alto");
        rbF11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF11.setFocusPainted(false);
        rbF11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF11.setIconTextGap(10);
        rbF11.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbF6)
                .addGap(23, 23, 23)
                .addComponent(rbF7)
                .addGap(23, 23, 23)
                .addComponent(rbF8)
                .addGap(23, 23, 23)
                .addComponent(rbF9)
                .addGap(23, 23, 23)
                .addComponent(rbF10)
                .addGap(23, 23, 23)
                .addComponent(rbF11)
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbF6)
                    .addComponent(rbF7)
                    .addComponent(rbF8)
                    .addComponent(rbF9)
                    .addComponent(rbF10)
                    .addComponent(rbF11)))
        );

        txtComportamiento.setColumns(20);
        txtComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        txtComportamiento.setRows(5);
        txtComportamiento.setBorder(null);
        jScrollPane3.setViewportView(txtComportamiento);

        lbNivel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel9.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel9.setText("Descripción:");
        lbNivel9.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel10.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel10.setText("Antecedente:");
        lbNivel10.setPreferredSize(new java.awt.Dimension(70, 25));

        cbAntecedente.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbAntecedente.setForeground(new java.awt.Color(51, 51, 51));
        cbAntecedente.setBorder(null);

        btnCrearFicha.setBackground(new java.awt.Color(221, 168, 83));
        btnCrearFicha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearFicha.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_fill-2.png"))); // NOI18N
        btnCrearFicha.setText("GUARDAR");
        btnCrearFicha.setBorder(null);
        btnCrearFicha.setBorderPainted(false);
        btnCrearFicha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearFicha.setFocusPainted(false);
        btnCrearFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFichaActionPerformed(evt);
            }
        });

        lbNivel12.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbNivel12.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel12.setText("2. Ficha ABC");
        lbNivel12.setPreferredSize(new java.awt.Dimension(70, 25));

        txtConsecuencia.setColumns(20);
        txtConsecuencia.setForeground(new java.awt.Color(51, 51, 51));
        txtConsecuencia.setRows(5);
        txtConsecuencia.setBorder(null);
        jScrollPane4.setViewportView(txtConsecuencia);

        lbNivel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel13.setText("Consecuencia:");
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel12, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(cbAntecedente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(btnCrearFicha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNivel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAntecedente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jpDashboardDocente.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 390, 520));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Buscar por Nombre y Apellidos:");
        jpDashboardDocente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 180, -1));

        cbListaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbListaEstudiantes.setOpaque(true);
        cbListaEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaEstudiantesActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(cbListaEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 310, 30));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Selecciona el Estudiante:");
        jpDashboardDocente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

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

    private void btnCrearConductaProblematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearConductaProblematicaActionPerformed


    }//GEN-LAST:event_btnCrearConductaProblematicaActionPerformed

    private void btnCrearFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFichaActionPerformed


    }//GEN-LAST:event_btnCrearFichaActionPerformed

    private void cbListaEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaEstudiantesActionPerformed


       Estudiante estudiante = (Estudiante) cbListaEstudiantes.getSelectedItem();
        if (estudiante != null) {
            mostrarDatosEstudiante(estudiante.getIdEstudiante());

        }

       
    }//GEN-LAST:event_cbListaEstudiantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEstudiante;
    private javax.swing.JButton btnCrearConductaProblematica;
    private javax.swing.JButton btnCrearFicha;
    private javax.swing.ButtonGroup btnGroupConducta;
    private javax.swing.ButtonGroup btnGroupFicha;
    private javax.swing.JComboBox<Antecedente> cbAntecedente;
    private javax.swing.JComboBox<FuncionComportamiento> cbFuncionComportamiento;
    private javax.swing.JComboBox<Estudiante> cbListaEstudiantes;
    private javax.swing.JComboBox<TipoConducta> cbTipoConducta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpDashboardDocente;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel1;
    private javax.swing.JLabel lbNivel10;
    private javax.swing.JLabel lbNivel11;
    private javax.swing.JLabel lbNivel12;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel2;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel8;
    private javax.swing.JLabel lbNivel9;
    private javax.swing.JRadioButton rbF0;
    private javax.swing.JRadioButton rbF1;
    private javax.swing.JRadioButton rbF10;
    private javax.swing.JRadioButton rbF11;
    private javax.swing.JRadioButton rbF2;
    private javax.swing.JRadioButton rbF3;
    private javax.swing.JRadioButton rbF4;
    private javax.swing.JRadioButton rbF5;
    private javax.swing.JRadioButton rbF6;
    private javax.swing.JRadioButton rbF7;
    private javax.swing.JRadioButton rbF8;
    private javax.swing.JRadioButton rbF9;
    private javax.swing.JTable tbIncidentesEstudiante;
    private javax.swing.JTextField txtApellidoEstudiante;
    private javax.swing.JTextArea txtComportamiento;
    private javax.swing.JTextArea txtConductaDsc;
    private javax.swing.JTextArea txtConsecuencia;
    private javax.swing.JTextField txtDiagnosticoEstudiante;
    private javax.swing.JTextField txtEstudianteFiltro;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    // End of variables declaration//GEN-END:variables
}
