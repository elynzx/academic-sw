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
import model.funcionalidad.catalogo.Antecedente;

/**
 *
 * @author rpasc
 */
public class FichaAbcView extends javax.swing.JPanel {

    private IRegistroIncidente registroIncidenteDao = new RegistroIncidenteDao();
    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();

    private int idEstudiante;

    public FichaAbcView(int idEstudiante) {
        this.idEstudiante = idEstudiante;
        initComponents();
        cargarAntecedentes();
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

    private int obtenerGravedadSeleccionada() {
        for (Enumeration<AbstractButton> botones = btnGroupGravFicha.getElements(); botones.hasMoreElements();) {
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

        btnGroupGravFicha = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        lbNivel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
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
        lbNivel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConsecuencia = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(450, 530));
        setPreferredSize(new java.awt.Dimension(450, 530));

        jPanel6.setBackground(new java.awt.Color(110, 146, 203));
        jPanel6.setMinimumSize(new java.awt.Dimension(450, 490));
        jPanel6.setPreferredSize(new java.awt.Dimension(450, 490));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNivel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Gravedad:");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel6.add(lbNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 331, 190, 18));

        jPanel7.setBackground(new java.awt.Color(110, 146, 203));

        rbF7.setBackground(new java.awt.Color(110, 146, 203));
        btnGroupGravFicha.add(rbF7);
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
        btnGroupGravFicha.add(rbF8);
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
        btnGroupGravFicha.add(rbF9);
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
        btnGroupGravFicha.add(rbF10);
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
        btnGroupGravFicha.add(rbF11);
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

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 355, -1, -1));

        txtComportamiento.setColumns(20);
        txtComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        txtComportamiento.setRows(5);
        txtComportamiento.setBorder(null);
        txtComportamiento.setMinimumSize(new java.awt.Dimension(220, 64));
        txtComportamiento.setPreferredSize(new java.awt.Dimension(220, 64));
        jScrollPane3.setViewportView(txtComportamiento);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 159, 376, 62));

        lbNivel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel9.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel9.setText("Comportamiento:");
        lbNivel9.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel6.add(lbNivel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 135, 102, 18));

        lbNivel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel10.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel10.setText("Antecedente:");
        lbNivel10.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel6.add(lbNivel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 69, 87, 18));

        cbAntecedente.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbAntecedente.setForeground(new java.awt.Color(51, 51, 51));
        cbAntecedente.setBorder(null);
        jPanel6.add(cbAntecedente, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 93, 376, 30));

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
        jPanel6.add(btnCrearFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 170, 48));

        lbNivel12.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbNivel12.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel12.setText("Ficha ABC");
        lbNivel12.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel6.add(lbNivel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 26, 247, -1));

        lbNivel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel13.setText("Consecuencia:");
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel6.add(lbNivel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 233, 102, 18));

        txtConsecuencia.setColumns(20);
        txtConsecuencia.setForeground(new java.awt.Color(51, 51, 51));
        txtConsecuencia.setRows(5);
        txtConsecuencia.setBorder(null);
        txtConsecuencia.setMinimumSize(new java.awt.Dimension(220, 64));
        txtConsecuencia.setPreferredSize(new java.awt.Dimension(220, 64));
        jScrollPane5.setViewportView(txtConsecuencia);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 257, 376, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFichaActionPerformed

        Antecedente antecedente = (Antecedente) cbAntecedente.getSelectedItem();
        String comportamiento = txtComportamiento.getText();
        int gravedad = obtenerGravedadSeleccionada();
        String consecuencia = txtConsecuencia.getText();

        if (gravedad == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una frecuencia.");
            return;
        }

        boolean guardado = registroIncidenteDao.guardarFichaAbc(idEstudiante, antecedente.getId(), comportamiento, consecuencia, gravedad);

        if (guardado) {
            JOptionPane.showMessageDialog(this, "Seguimiento guardado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar seguimiento.");
        }


    }//GEN-LAST:event_btnCrearFichaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearFicha;
    private javax.swing.ButtonGroup btnGroupGravFicha;
    private javax.swing.JComboBox<Antecedente> cbAntecedente;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbNivel10;
    private javax.swing.JLabel lbNivel12;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel9;
    private javax.swing.JRadioButton rbF10;
    private javax.swing.JRadioButton rbF11;
    private javax.swing.JRadioButton rbF7;
    private javax.swing.JRadioButton rbF8;
    private javax.swing.JRadioButton rbF9;
    private javax.swing.JTextArea txtComportamiento;
    private javax.swing.JTextArea txtConsecuencia;
    // End of variables declaration//GEN-END:variables
}
