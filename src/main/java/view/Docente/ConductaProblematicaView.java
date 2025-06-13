/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.IRegistroIncidente;
import model.dao.RegistroIncidenteDao;
import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;

/**
 *
 * @author rpasc
 */
public class ConductaProblematicaView extends javax.swing.JPanel {

    private IRegistroIncidente registroIncidenteDao = new RegistroIncidenteDao();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();

    private int idEstudiante;

    public ConductaProblematicaView(int idEstudiante) {
        this.idEstudiante = idEstudiante;
        initComponents();
        cargarTipoConductas();
        cargarFuncionComportamiento();
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

    
        private int obtenerGravedadSeleccionada() {
        for (Enumeration<AbstractButton> botones = btnGroupGravConducta.getElements(); botones.hasMoreElements();) {
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

        btnGroupGravConducta = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConductaDsc = new javax.swing.JTextArea();
        lbNivel2 = new javax.swing.JLabel();
        lbNivel4 = new javax.swing.JLabel();
        cbTipoConducta = new javax.swing.JComboBox<>();
        lbNivel8 = new javax.swing.JLabel();
        cbFuncionComportamiento = new javax.swing.JComboBox<>();
        lbNivel11 = new javax.swing.JLabel();
        btnCrearConductaProblematica = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rbF7 = new javax.swing.JRadioButton();
        rbF8 = new javax.swing.JRadioButton();
        rbF9 = new javax.swing.JRadioButton();
        rbF10 = new javax.swing.JRadioButton();
        rbF11 = new javax.swing.JRadioButton();
        lbNivel3 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(110, 146, 203));
        jPanel4.setMinimumSize(new java.awt.Dimension(450, 490));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 490));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtConductaDsc.setColumns(20);
        txtConductaDsc.setForeground(new java.awt.Color(51, 51, 51));
        txtConductaDsc.setRows(5);
        txtConductaDsc.setBorder(null);
        jScrollPane1.setViewportView(txtConductaDsc);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 225, 376, 90));

        lbNivel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel2.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel2.setText("Descripción:");
        lbNivel2.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel4.add(lbNivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 201, 376, 18));

        lbNivel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Tipo de Conducta:");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel4.add(lbNivel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 69, 175, 18));

        cbTipoConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbTipoConducta.setForeground(new java.awt.Color(51, 51, 51));
        cbTipoConducta.setToolTipText("Categoría general observable");
        cbTipoConducta.setBorder(null);
        jPanel4.add(cbTipoConducta, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 93, 376, 30));

        lbNivel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbNivel8.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel8.setText("Conducta Problemática");
        lbNivel8.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel4.add(lbNivel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 26, 284, -1));

        cbFuncionComportamiento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbFuncionComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        cbFuncionComportamiento.setToolTipText("¿Por qué ocurre el comportamiento?");
        cbFuncionComportamiento.setBorder(null);
        jPanel4.add(cbFuncionComportamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 159, 376, 30));

        lbNivel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel11.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel11.setText("Función del comportamiento:");
        lbNivel11.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel4.add(lbNivel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 135, 175, 18));

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
        jPanel4.add(btnCrearConductaProblematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 170, 48));

        jPanel7.setBackground(new java.awt.Color(110, 146, 203));

        rbF7.setBackground(new java.awt.Color(110, 146, 203));
        rbF7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbF7.setForeground(new java.awt.Color(255, 255, 255));
        rbF7.setText("1");
        rbF7.setToolTipText("Leve, sin impacto negativo");
        rbF7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF7.setFocusPainted(false);
        rbF7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF7.setOpaque(true);

        rbF8.setBackground(new java.awt.Color(110, 146, 203));
        rbF8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbF8.setForeground(new java.awt.Color(255, 255, 255));
        rbF8.setText("2");
        rbF8.setToolTipText("Moderada");
        rbF8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF8.setFocusPainted(false);
        rbF8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF8.setOpaque(true);

        rbF9.setBackground(new java.awt.Color(110, 146, 203));
        rbF9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbF9.setForeground(new java.awt.Color(255, 255, 255));
        rbF9.setText("3");
        rbF9.setToolTipText("Frecuente / Interfiere");
        rbF9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF9.setFocusPainted(false);
        rbF9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF9.setOpaque(true);

        rbF10.setBackground(new java.awt.Color(110, 146, 203));
        rbF10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbF10.setForeground(new java.awt.Color(255, 255, 255));
        rbF10.setText("4");
        rbF10.setToolTipText("Grave");
        rbF10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF10.setFocusPainted(false);
        rbF10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF10.setOpaque(true);

        rbF11.setBackground(new java.awt.Color(110, 146, 203));
        rbF11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbF11.setForeground(new java.awt.Color(255, 255, 255));
        rbF11.setText("5");
        rbF11.setToolTipText("Muy grave / Riesgo alto");
        rbF11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        rbF11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbF11.setFocusPainted(false);
        rbF11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbF11.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(rbF7)
                .addGap(37, 37, 37)
                .addComponent(rbF8)
                .addGap(37, 37, 37)
                .addComponent(rbF9)
                .addGap(37, 37, 37)
                .addComponent(rbF10)
                .addGap(37, 37, 37)
                .addComponent(rbF11)
                .addGap(36, 36, 36))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbF7)
                    .addComponent(rbF8)
                    .addComponent(rbF9)
                    .addComponent(rbF10)
                    .addComponent(rbF11)))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 355, -1, -1));

        lbNivel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Gravedad:");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel4.add(lbNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 331, 190, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearConductaProblematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearConductaProblematicaActionPerformed

                TipoConducta tipoConducta = (TipoConducta) cbTipoConducta.getSelectedItem();
                FuncionComportamiento funcionComportamiento = (FuncionComportamiento) cbFuncionComportamiento.getSelectedItem(); 
        String descripcion = txtConductaDsc.getText();
        int gravedad = obtenerGravedadSeleccionada();

        if (gravedad == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una frecuencia.");
            return;
        }

        boolean guardado = registroIncidenteDao.guardarConductaProblematica(idEstudiante, tipoConducta.getId(), funcionComportamiento.getId(), gravedad, descripcion);

        if (guardado) {
            JOptionPane.showMessageDialog(this, "Seguimiento guardado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar seguimiento.");
        }
    }//GEN-LAST:event_btnCrearConductaProblematicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearConductaProblematica;
    private javax.swing.ButtonGroup btnGroupGravConducta;
    private javax.swing.JComboBox<FuncionComportamiento> cbFuncionComportamiento;
    private javax.swing.JComboBox<TipoConducta> cbTipoConducta;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNivel11;
    private javax.swing.JLabel lbNivel2;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel8;
    private javax.swing.JRadioButton rbF10;
    private javax.swing.JRadioButton rbF11;
    private javax.swing.JRadioButton rbF7;
    private javax.swing.JRadioButton rbF8;
    private javax.swing.JRadioButton rbF9;
    private javax.swing.JTextArea txtConductaDsc;
    // End of variables declaration//GEN-END:variables
}
