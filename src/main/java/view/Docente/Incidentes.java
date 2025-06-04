/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Docente;

import java.util.List;
import model.catalogo.Antecedente;
import model.catalogo.CategoriaConducta;
import model.catalogo.FuncionComportamiento;
import model.catalogo.TipoConducta;
import model.dao.IRegistroIncidente;
import model.dao.RegistroIncidenteDao;

/**
 *
 * @author rpasc
 */
public class Incidentes extends javax.swing.JFrame {

    private IRegistroIncidente registroIncidenteDao = new RegistroIncidenteDao();

    public Incidentes(int idDocente) {

        initComponents();
        cargarTipoConductas();
        cargarFuncionComportamiento();
        cargarAntecedentes();
    }

    private void cargarTipoConductas() {
        cbTipoConducta.removeAllItems();
        try {
            List<TipoConducta> listaTipoConductas = registroIncidenteDao.ObtenerTipoConductas();
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
            List<FuncionComportamiento> listaFuncionComportamientos = registroIncidenteDao.ObtenerFuncionComportamientos();
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mInicio = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mSeguimiento = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mEvaluaciones = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        mReemplazo = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        mReportes = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        mSalir = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarEstudiante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbIncidentesEstudiante = new javax.swing.JTable();
        lbNivel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbNivel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConductaDsc = new javax.swing.JTextArea();
        lbNivel2 = new javax.swing.JLabel();
        btnCrearConductaProblematica = new javax.swing.JButton();
        lbNivel4 = new javax.swing.JLabel();
        cbTipoConducta = new javax.swing.JComboBox<>();
        lbNivel6 = new javax.swing.JLabel();
        cbFuncionComportamiento = new javax.swing.JComboBox<>();
        lbNivel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        lbNivel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComportamiento = new javax.swing.JTextArea();
        lbNivel7 = new javax.swing.JLabel();
        btnCrearFicha = new javax.swing.JButton();
        lbNivel8 = new javax.swing.JLabel();
        cbAntecedente = new javax.swing.JComboBox<>();
        lbNivel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtConsecuencia = new javax.swing.JTextArea();
        lbNivel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        txtIdEstudiante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        txtApellidoEstudiante = new javax.swing.JTextField();
        lbNivel13 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
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

        mSeguimiento.setBackground(new java.awt.Color(237, 237, 237));
        mSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Star_2.png"))); // NOI18N
        jLabel13.setToolTipText("");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
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

        mEvaluaciones.setBackground(new java.awt.Color(255, 255, 255));
        mEvaluaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Checlk Alt Square.png"))); // NOI18N
        jLabel15.setToolTipText("");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(66, 128, 191));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("INCIDENTES");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mEvaluacionesLayout = new javax.swing.GroupLayout(mEvaluaciones);
        mEvaluaciones.setLayout(mEvaluacionesLayout);
        mEvaluacionesLayout.setHorizontalGroup(
            mEvaluacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        mEvaluacionesLayout.setVerticalGroup(
            mEvaluacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mEvaluacionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mEvaluaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 120, 90));

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

        mReemplazo.setBackground(new java.awt.Color(237, 237, 237));
        mReemplazo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Devices_1.png"))); // NOI18N
        jLabel17.setToolTipText("");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(126, 3, 126));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PLAN INDIVIDUAL");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout mReemplazoLayout = new javax.swing.GroupLayout(mReemplazo);
        mReemplazo.setLayout(mReemplazoLayout);
        mReemplazoLayout.setHorizontalGroup(
            mReemplazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        mReemplazoLayout.setVerticalGroup(
            mReemplazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mReemplazoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(mReemplazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 130, 90));

        mReportes.setBackground(new java.awt.Color(237, 237, 237));
        mReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mReportes.setPreferredSize(new java.awt.Dimension(120, 90));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clip_1.png"))); // NOI18N
        jLabel21.setToolTipText("");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Buscar por Nombre y Apellidos:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtBuscarEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscarEstudiante.setBorder(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Magnifer75.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarEstudiante))
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 290, -1));

        tbIncidentesEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbIncidentesEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbIncidentesEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        tbIncidentesEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Fecha", "Gravedad"
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
        tbIncidentesEstudiante.setGridColor(new java.awt.Color(153, 153, 153));
        tbIncidentesEstudiante.setRowHeight(25);
        tbIncidentesEstudiante.setSelectionBackground(new java.awt.Color(225, 240, 245));
        jScrollPane2.setViewportView(tbIncidentesEstudiante);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 290, 200));

        lbNivel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(66, 128, 191));
        lbNivel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel5.setText("Incidentes Recientes");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel1.add(lbNivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 30));

        jPanel4.setBackground(new java.awt.Color(203, 223, 243));

        lbNivel1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel1.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel1.setText("Función del comportamiento");
        lbNivel1.setPreferredSize(new java.awt.Dimension(70, 25));

        txtConductaDsc.setColumns(20);
        txtConductaDsc.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtConductaDsc.setForeground(new java.awt.Color(51, 51, 51));
        txtConductaDsc.setRows(5);
        txtConductaDsc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(txtConductaDsc);

        lbNivel2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel2.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel2.setText("Descripción");
        lbNivel2.setPreferredSize(new java.awt.Dimension(70, 25));

        btnCrearConductaProblematica.setBackground(new java.awt.Color(66, 128, 191));
        btnCrearConductaProblematica.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnCrearConductaProblematica.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearConductaProblematica.setText("GUARDAR");
        btnCrearConductaProblematica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearConductaProblematica.setFocusPainted(false);

        lbNivel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Tipo de Conducta");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));

        cbTipoConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbTipoConducta.setForeground(new java.awt.Color(51, 51, 51));
        cbTipoConducta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbNivel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(66, 128, 191));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setText("Conducta Problemática");
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        cbFuncionComportamiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbFuncionComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        cbFuncionComportamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbNivel11.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel11.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel11.setText("Gravedad");
        lbNivel11.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel8.setBackground(new java.awt.Color(203, 223, 243));

        jRadioButton13.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton13);
        jRadioButton13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton13.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton13.setText("0");
        jRadioButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton13.setFocusPainted(false);
        jRadioButton13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton13.setIconTextGap(10);

        jRadioButton14.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton14);
        jRadioButton14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton14.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton14.setText("1");
        jRadioButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton14.setFocusPainted(false);
        jRadioButton14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton14.setIconTextGap(10);

        jRadioButton15.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton15);
        jRadioButton15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton15.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton15.setText("2");
        jRadioButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton15.setFocusPainted(false);
        jRadioButton15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton15.setIconTextGap(10);

        jRadioButton16.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton16);
        jRadioButton16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton16.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton16.setText("3");
        jRadioButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton16.setFocusPainted(false);
        jRadioButton16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton16.setIconTextGap(10);

        jRadioButton17.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton17);
        jRadioButton17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton17.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton17.setText("4");
        jRadioButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton17.setFocusPainted(false);
        jRadioButton17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton17.setIconTextGap(10);

        jRadioButton18.setBackground(new java.awt.Color(203, 223, 243));
        buttonGroup1.add(jRadioButton18);
        jRadioButton18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton18.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton18.setText("5");
        jRadioButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton18.setFocusPainted(false);
        jRadioButton18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton18.setIconTextGap(10);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jRadioButton13)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton14)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton15)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton16)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton17)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton18)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140))
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(140, 140, 140))
                        .addComponent(btnCrearConductaProblematica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1)
                        .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbFuncionComportamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTipoConducta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNivel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoConducta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFuncionComportamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearConductaProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 390, 500));

        jPanel6.setBackground(new java.awt.Color(225, 240, 245));

        lbNivel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Gravedad");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));

        txtComportamiento.setColumns(20);
        txtComportamiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        txtComportamiento.setRows(5);
        txtComportamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane3.setViewportView(txtComportamiento);

        lbNivel7.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel7.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel7.setText("Comportamiento");
        lbNivel7.setPreferredSize(new java.awt.Dimension(70, 25));

        btnCrearFicha.setBackground(new java.awt.Color(66, 128, 191));
        btnCrearFicha.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnCrearFicha.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearFicha.setText("GUARDAR");
        btnCrearFicha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearFicha.setFocusPainted(false);

        lbNivel8.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel8.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel8.setText("Antecedente");
        lbNivel8.setPreferredSize(new java.awt.Dimension(70, 25));

        cbAntecedente.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbAntecedente.setForeground(new java.awt.Color(51, 51, 51));
        cbAntecedente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbNivel9.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lbNivel9.setForeground(new java.awt.Color(66, 128, 191));
        lbNivel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel9.setText("Ficha ABC");
        lbNivel9.setPreferredSize(new java.awt.Dimension(70, 25));

        txtConsecuencia.setColumns(20);
        txtConsecuencia.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtConsecuencia.setForeground(new java.awt.Color(51, 51, 51));
        txtConsecuencia.setRows(5);
        txtConsecuencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane4.setViewportView(txtConsecuencia);

        lbNivel10.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lbNivel10.setForeground(new java.awt.Color(102, 102, 102));
        lbNivel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel10.setText("Consecuencia");
        lbNivel10.setPreferredSize(new java.awt.Dimension(70, 25));

        jPanel9.setBackground(new java.awt.Color(225, 240, 245));

        jRadioButton19.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton19);
        jRadioButton19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton19.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton19.setText("0");
        jRadioButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton19.setFocusPainted(false);
        jRadioButton19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton19.setIconTextGap(10);

        jRadioButton20.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton20);
        jRadioButton20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton20.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton20.setText("1");
        jRadioButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton20.setFocusPainted(false);
        jRadioButton20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton20.setIconTextGap(10);

        jRadioButton21.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton21);
        jRadioButton21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton21.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton21.setText("2");
        jRadioButton21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton21.setFocusPainted(false);
        jRadioButton21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton21.setIconTextGap(10);

        jRadioButton22.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton22);
        jRadioButton22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton22.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton22.setText("3");
        jRadioButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton22.setFocusPainted(false);
        jRadioButton22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton22.setIconTextGap(10);

        jRadioButton23.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton23);
        jRadioButton23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton23.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton23.setText("4");
        jRadioButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton23.setFocusPainted(false);
        jRadioButton23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton23.setIconTextGap(10);

        jRadioButton24.setBackground(new java.awt.Color(225, 240, 245));
        buttonGroup2.add(jRadioButton24);
        jRadioButton24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton24.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton24.setText("5");
        jRadioButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jRadioButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton24.setFocusPainted(false);
        jRadioButton24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton24.setIconTextGap(10);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jRadioButton19)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton20)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton21)
                .addGap(25, 25, 25)
                .addComponent(jRadioButton22)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton23)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton24)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20)
                    .addComponent(jRadioButton21)
                    .addComponent(jRadioButton22)
                    .addComponent(jRadioButton23)
                    .addComponent(jRadioButton24))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(140, 140, 140))
                                .addComponent(btnCrearFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbAntecedente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAntecedente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 390, 500));

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtIdEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtIdEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtIdEstudiante.setBorder(null);
        jPanel1.add(txtIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 60, 30));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 20, 30));

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtNombreEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNombreEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreEstudiante.setBorder(null);
        jPanel1.add(txtNombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 200, 30));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nombres:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Apellidos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Diagnóstico:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 30));

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtDiagnosticoEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtDiagnosticoEstudiante.setBorder(null);
        jPanel1.add(txtDiagnosticoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 200, 30));

        txtApellidoEstudiante.setEditable(false);
        txtApellidoEstudiante.setBackground(new java.awt.Color(248, 248, 248));
        txtApellidoEstudiante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtApellidoEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoEstudiante.setBorder(null);
        jPanel1.add(txtApellidoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 200, 30));

        lbNivel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(66, 128, 191));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel13.setText("Datos del Estudiante");
        lbNivel13.setToolTipText("");
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel1.add(lbNivel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 180, 30));

        lbFechaHoy.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(51, 51, 51));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setText("Fecha de hoy");
        jPanel1.add(lbFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 390, 40));

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Registro de Incidentes");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 520, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearConductaProblematica;
    private javax.swing.JButton btnCrearFicha;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<Antecedente> cbAntecedente;
    private javax.swing.JComboBox<FuncionComportamiento> cbFuncionComportamiento;
    private javax.swing.JComboBox<TipoConducta> cbTipoConducta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel1;
    private javax.swing.JLabel lbNivel10;
    private javax.swing.JLabel lbNivel11;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel2;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel7;
    private javax.swing.JLabel lbNivel8;
    private javax.swing.JLabel lbNivel9;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JPanel mEvaluaciones;
    private javax.swing.JPanel mInicio;
    private javax.swing.JPanel mReemplazo;
    private javax.swing.JPanel mReportes;
    private javax.swing.JPanel mSalir;
    private javax.swing.JPanel mSeguimiento;
    private javax.swing.JTable tbIncidentesEstudiante;
    private javax.swing.JTextField txtApellidoEstudiante;
    private javax.swing.JTextField txtBuscarEstudiante;
    private javax.swing.JTextArea txtComportamiento;
    private javax.swing.JTextArea txtConductaDsc;
    private javax.swing.JTextArea txtConsecuencia;
    private javax.swing.JTextField txtDiagnosticoEstudiante;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    // End of variables declaration//GEN-END:variables
}
