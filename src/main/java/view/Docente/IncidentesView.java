/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.DocenteDao;
import model.funcionalidad.catalogo.Diagnostico;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.IRegistroIncidente;
import model.dao.RegistroIncidenteDao;
import model.entidades.Estudiante;
import model.funcionalidad.ConductaProblematica;
import model.funcionalidad.FichaAbc;
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
    private int idEstudianteSeleccionado;
    private FichaAbcView vFichaAbc;
    private ConductaProblematicaView vConducta;
    private boolean listaEstudiantesInicializado = false;

    public IncidentesView(int idDocente) {
        this.idDocente = idDocente;
        initComponents();
        utilidad.mostrarDia(lbFechaHoy);
        cargarEstudiantes(idDocente);
        setConductaPanel();

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
            txtNombreEstudiante.setText(estudiante.getNombres() + " " + estudiante.getApellidos());
            txtDiagnosticoEstudiante.setText(estudiante.getDiagnosticos().stream().map(Diagnostico::getNombre).collect(Collectors.joining(", ")));

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    private void cargarConductasEstudiante(int idEstudiante) {

        List<ConductaProblematica> listaConductas = registroIncidenteDao.obtenerConductasPorEstudiante(idEstudiante);

        DefaultTableModel modelo = (DefaultTableModel) tbIncidentesEstudiante.getModel();
        modelo.setRowCount(0);
        for (ConductaProblematica conducta : listaConductas) {
            modelo.addRow(new Object[]{
                conducta.getId(),
                conducta.getTipo().getNombre(),
                conducta.getFecha(),
                conducta.getGravedad(),
                conducta.getDescripcion()
            });
        }

    }

    private void cargarFichasEstudiante(int idEstudiante) {
   
        List<FichaAbc> listaFichas = registroIncidenteDao.obtenerFichasPorEstudiante(idEstudiante);
         DefaultTableModel modelo = (DefaultTableModel) tbHistorialFichasAbc.getModel();
         
        modelo.setRowCount(0);

        for (FichaAbc fichaAbc : listaFichas) {
            modelo.addRow(new Object[]{
                fichaAbc.getFecha(),
                fichaAbc.getAntecedente().getNombre(),
                fichaAbc.getComportamiento(),
                fichaAbc.getGravedad()
            });
        }


    }

    public void setFichaPanel() {
        if (vFichaAbc == null) {
            vFichaAbc = new FichaAbcView(idEstudianteSeleccionado);
        }
        jpIncidente.removeAll();
        jpIncidente.add(vFichaAbc);
        SwingUtilities.updateComponentTreeUI(jpIncidente);

    }

    public void setConductaPanel() {
        if (vConducta == null) {
            vConducta = new ConductaProblematicaView(idEstudianteSeleccionado);
        }
        jpIncidente.removeAll();
        jpIncidente.add(vConducta);
        SwingUtilities.updateComponentTreeUI(jpIncidente);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupConducta = new javax.swing.ButtonGroup();
        btnGroupFicha = new javax.swing.ButtonGroup();
        jpDashboardDocente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbFechaHoy = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbListaEstudiantes = new javax.swing.JComboBox<>();
        jpIncidente = new javax.swing.JPanel();
        btnConductaProb = new javax.swing.JButton();
        btnFichaAbc = new javax.swing.JButton();
        lbNivel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbIncidentesEstudiante = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHistorialFichasAbc = new javax.swing.JTable();
        lbNivel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbNivel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        descargaResumen = new javax.swing.JLabel();
        descargaHistorial = new javax.swing.JLabel();

        jpDashboardDocente.setBackground(new java.awt.Color(255, 255, 255));
        jpDashboardDocente.setMinimumSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setPreferredSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFechaHoy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(39, 84, 138));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Date_fill-1_1.png"))); // NOI18N
        lbFechaHoy.setText("Fecha de hoy");
        jPanel1.add(lbFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 36, 456, 40));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 84, 138));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Registro de Incidentes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 33, 387, 50));

        jpDashboardDocente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 90));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Buscar por Nombre y Apellidos:");
        jpDashboardDocente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 180, -1));

        cbListaEstudiantes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbListaEstudiantes.setForeground(new java.awt.Color(51, 51, 51));
        cbListaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        cbListaEstudiantes.setOpaque(true);
        cbListaEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaEstudiantesActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(cbListaEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 240, 30));

        jpIncidente.setBackground(new java.awt.Color(110, 146, 203));
        jpIncidente.setPreferredSize(new java.awt.Dimension(450, 500));
        jpIncidente.setLayout(new java.awt.BorderLayout());
        jpDashboardDocente.add(jpIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 450, 490));

        btnConductaProb.setBackground(new java.awt.Color(110, 146, 203));
        btnConductaProb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConductaProb.setForeground(new java.awt.Color(255, 255, 255));
        btnConductaProb.setText("1. Conducta problemática");
        btnConductaProb.setBorder(null);
        btnConductaProb.setBorderPainted(false);
        btnConductaProb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConductaProb.setFocusPainted(false);
        btnConductaProb.setMinimumSize(new java.awt.Dimension(120, 30));
        btnConductaProb.setPreferredSize(new java.awt.Dimension(120, 30));
        btnConductaProb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConductaProbActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(btnConductaProb, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 230, 50));

        btnFichaAbc.setBackground(new java.awt.Color(75, 75, 75));
        btnFichaAbc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFichaAbc.setForeground(new java.awt.Color(255, 255, 255));
        btnFichaAbc.setText("2. Ficha ABC");
        btnFichaAbc.setBorder(null);
        btnFichaAbc.setBorderPainted(false);
        btnFichaAbc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFichaAbc.setFocusPainted(false);
        btnFichaAbc.setPreferredSize(new java.awt.Dimension(120, 30));
        btnFichaAbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichaAbcActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(btnFichaAbc, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 220, 50));

        lbNivel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Line_up-2.png"))); // NOI18N
        lbNivel5.setText("Historial de Conductas Problemáticas");
        lbNivel5.setToolTipText("");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));
        jpDashboardDocente.add(lbNivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 400, 30));

        tbIncidentesEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbIncidentesEstudiante.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbIncidentesEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        tbIncidentesEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Conducta problemática", "Fecha", "Gravedad", "Descripción"
            }
        ));
        tbIncidentesEstudiante.setGridColor(new java.awt.Color(214, 214, 214));
        tbIncidentesEstudiante.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbIncidentesEstudiante.setSelectionBackground(new java.awt.Color(252, 249, 239));
        tbIncidentesEstudiante.setShowGrid(false);
        jScrollPane2.setViewportView(tbIncidentesEstudiante);

        jpDashboardDocente.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 630, 130));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jpDashboardDocente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 70, 20));

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtIdEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtIdEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtIdEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEstudianteActionPerformed(evt);
            }
        });
        jpDashboardDocente.add(txtIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombres y apellidos:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jpDashboardDocente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, 20));

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpDashboardDocente.add(txtNombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 240, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Selecciona un estudiante:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jpDashboardDocente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 130, 20));

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtDiagnosticoEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtDiagnosticoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpDashboardDocente.add(txtDiagnosticoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 240, 25));

        tbHistorialFichasAbc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbHistorialFichasAbc.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbHistorialFichasAbc.setForeground(new java.awt.Color(51, 51, 51));
        tbHistorialFichasAbc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Antecedente", "Comportamiendo", "Gravedad"
            }
        ));
        tbHistorialFichasAbc.setGridColor(new java.awt.Color(214, 214, 214));
        tbHistorialFichasAbc.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbHistorialFichasAbc.setSelectionBackground(new java.awt.Color(252, 249, 239));
        tbHistorialFichasAbc.setShowGrid(false);
        jScrollPane3.setViewportView(tbHistorialFichasAbc);

        jpDashboardDocente.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 630, 140));

        lbNivel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNivel7.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Line_up-2.png"))); // NOI18N
        lbNivel7.setText("Historial de Fichas ABC");
        lbNivel7.setToolTipText("");
        lbNivel7.setPreferredSize(new java.awt.Dimension(70, 25));
        jpDashboardDocente.add(lbNivel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 260, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Diagnósticos:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jpDashboardDocente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 20));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jpDashboardDocente.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 630, 10));

        lbNivel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_fill-2.png"))); // NOI18N
        lbNivel6.setText("Datos de estudiante:");
        lbNivel6.setToolTipText("");
        lbNivel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));
        jpDashboardDocente.add(lbNivel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 290, 50));

        jSeparator2.setForeground(new java.awt.Color(45, 94, 152));
        jpDashboardDocente.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1160, 12));

        descargaResumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Import-2.png"))); // NOI18N
        descargaResumen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        descargaResumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descargaResumenMouseClicked(evt);
            }
        });
        jpDashboardDocente.add(descargaResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 40, 25));

        descargaHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Import-2.png"))); // NOI18N
        descargaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        descargaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descargaHistorialMouseClicked(evt);
            }
        });
        jpDashboardDocente.add(descargaHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 40, 25));

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

    private void cbListaEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaEstudiantesActionPerformed

        if (!listaEstudiantesInicializado) {
            listaEstudiantesInicializado = true;
            return;
        }

        Estudiante estudiante = (Estudiante) cbListaEstudiantes.getSelectedItem();
        if (estudiante != null) {
            idEstudianteSeleccionado = estudiante.getIdEstudiante();
            mostrarDatosEstudiante(idEstudianteSeleccionado);
            cargarFichasEstudiante(idEstudianteSeleccionado);
            cargarConductasEstudiante(idEstudianteSeleccionado);
        }


    }//GEN-LAST:event_cbListaEstudiantesActionPerformed

    private void btnConductaProbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConductaProbActionPerformed

        btnConductaProb.setBackground(new Color(110, 146, 203));
        btnFichaAbc.setBackground(new Color(75, 75, 75));
        setConductaPanel();


    }//GEN-LAST:event_btnConductaProbActionPerformed

    private void btnFichaAbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichaAbcActionPerformed

        btnFichaAbc.setBackground(new Color(110, 146, 203));
        btnConductaProb.setBackground(new Color(75, 75, 75));
        setFichaPanel();


    }//GEN-LAST:event_btnFichaAbcActionPerformed

    private void txtIdEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEstudianteActionPerformed

    private void descargaResumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargaResumenMouseClicked
//
//        if (listaResumenIncidentes == null || listaResumenIncidentes.isEmpty()) {
//            JOptionPane.showMessageDialog(PlanIndividualView.this, "No hay datos para exportar.");
//            return;
//        }
//        ExcelResumenIncidentes.exportarResumen(listaResumenIncidentes, estudianteSeleccionado, PlanIndividualView.this);

    }//GEN-LAST:event_descargaResumenMouseClicked

    private void descargaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargaHistorialMouseClicked

//        if (listaPlanes == null || listaPlanes.isEmpty()) {
//            JOptionPane.showMessageDialog(PlanIndividualView.this, "No hay datos para exportar.");
//            return;
//        }
//        ExcelHistorialIntervenciones.exportarHistorial(listaPlanes, estudianteSeleccionado, PlanIndividualView.this);
    }//GEN-LAST:event_descargaHistorialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConductaProb;
    private javax.swing.JButton btnFichaAbc;
    private javax.swing.ButtonGroup btnGroupConducta;
    private javax.swing.ButtonGroup btnGroupFicha;
    private javax.swing.JComboBox<Estudiante> cbListaEstudiantes;
    private javax.swing.JLabel descargaHistorial;
    private javax.swing.JLabel descargaResumen;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpDashboardDocente;
    private javax.swing.JPanel jpIncidente;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel7;
    private javax.swing.JTable tbHistorialFichasAbc;
    private javax.swing.JTable tbIncidentesEstudiante;
    private javax.swing.JTextField txtDiagnosticoEstudiante;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    // End of variables declaration//GEN-END:variables
}
