/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Docente;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import utillities.Utilidad;

/**
 *
 * @author rpasc
 */
public class MenuDocenteView extends javax.swing.JFrame {

    private ReporteDocenteView vReporteDocente;
    private DashboardView vDashboardDocente;
    private SeguimientoView vSeguimiento;
    private IncidentesView vIncidente;
    private int idDocente;
    private Utilidad utilidad;
    Color azul = new Color(10, 93, 175);

    public MenuDocenteView(int idDocente) {
        this.idDocente = idDocente;
        utilidad = new Utilidad();
        initComponents();
//        seleccionMenu();
        setDashboardDocente();
    }

    public void setReporteDocente() {
        if (vReporteDocente == null) {
            vReporteDocente = new ReporteDocenteView(idDocente);
        }
        jpMenu.removeAll();
        jpMenu.add(vReporteDocente);
        SwingUtilities.updateComponentTreeUI(jpMenu);

    }

    public void setDashboardDocente() {
        if (vDashboardDocente == null) {
            vDashboardDocente = new DashboardView(idDocente);
        }
        jpMenu.removeAll();
        jpMenu.add(vDashboardDocente);
        SwingUtilities.updateComponentTreeUI(jpMenu);
    }

    public void setSeguimiento() {
        if (vSeguimiento == null) {
            vSeguimiento = new SeguimientoView(idDocente);
        }
        jpMenu.removeAll();
        jpMenu.add(vSeguimiento);
        SwingUtilities.updateComponentTreeUI(jpMenu);
    }

    public void setIncidente() {
        if (vIncidente == null) {
            vIncidente = new IncidentesView(idDocente);
        }
        jpMenu.removeAll();
        jpMenu.add(vIncidente);
        SwingUtilities.updateComponentTreeUI(jpMenu);
    }
//
//    public void setReporteDocente() {
//        if (vReporteDocente == null) {
//            vReporteDocente = new ReporteDocenteView(idDocente);
//        }
//        jpMenu.removeAll();
//        jpMenu.add(vReporteDocente);
//        SwingUtilities.updateComponentTreeUI(jpMenu);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        pInicio = new javax.swing.JPanel();
        mInicio = new javax.swing.JLabel();
        bInicio = new javax.swing.JPanel();
        mSeguimiento = new javax.swing.JPanel();
        pSeguimiento = new javax.swing.JLabel();
        bSeguimiento = new javax.swing.JPanel();
        mIncidentes = new javax.swing.JPanel();
        pIncidentes = new javax.swing.JLabel();
        bIncidentes = new javax.swing.JPanel();
        mPlanIndividual = new javax.swing.JPanel();
        pPlanIndividual = new javax.swing.JLabel();
        bPlanIndividual = new javax.swing.JPanel();
        pReportes = new javax.swing.JPanel();
        mReportes = new javax.swing.JLabel();
        bReportes = new javax.swing.JPanel();
        mSalir = new javax.swing.JPanel();
        pSalir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNomUsuario = new javax.swing.JLabel();
        jpMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 800));
        setPreferredSize(new java.awt.Dimension(1250, 800));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(1250, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(1250, 60));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInicio.setBackground(new java.awt.Color(255, 255, 255));
        pInicio.setForeground(new java.awt.Color(255, 255, 255));
        pInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mInicio.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        mInicio.setForeground(new java.awt.Color(10, 93, 175));
        mInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Widget-2_1.png"))); // NOI18N
        mInicio.setText("DASHBOARD");
        mInicio.setToolTipText("");
        mInicio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        mInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mInicio.setIconTextGap(2);
        mInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mInicioMouseClicked(evt);
            }
        });

        bInicio.setBackground(new java.awt.Color(10, 93, 175));
        bInicio.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout bInicioLayout = new javax.swing.GroupLayout(bInicio);
        bInicio.setLayout(bInicioLayout);
        bInicioLayout.setHorizontalGroup(
            bInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bInicioLayout.setVerticalGroup(
            bInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pInicioLayout = new javax.swing.GroupLayout(pInicio);
        pInicio.setLayout(pInicioLayout);
        pInicioLayout.setHorizontalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        pInicioLayout.setVerticalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(pInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 3, 135, 60));

        mSeguimiento.setBackground(new java.awt.Color(255, 255, 255));
        mSeguimiento.setForeground(new java.awt.Color(255, 255, 255));
        mSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pSeguimiento.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        pSeguimiento.setForeground(new java.awt.Color(10, 93, 175));
        pSeguimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Star_fill-2_1.png"))); // NOI18N
        pSeguimiento.setText("SEGUIMIENTO");
        pSeguimiento.setToolTipText("");
        pSeguimiento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pSeguimiento.setIconTextGap(2);
        pSeguimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pSeguimientoMouseClicked(evt);
            }
        });

        bSeguimiento.setBackground(new java.awt.Color(255, 255, 255));
        bSeguimiento.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout bSeguimientoLayout = new javax.swing.GroupLayout(bSeguimiento);
        bSeguimiento.setLayout(bSeguimientoLayout);
        bSeguimientoLayout.setHorizontalGroup(
            bSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bSeguimientoLayout.setVerticalGroup(
            bSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mSeguimientoLayout = new javax.swing.GroupLayout(mSeguimiento);
        mSeguimiento.setLayout(mSeguimientoLayout);
        mSeguimientoLayout.setHorizontalGroup(
            mSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSeguimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        mSeguimientoLayout.setVerticalGroup(
            mSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSeguimientoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pSeguimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(mSeguimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 3, 135, 60));

        mIncidentes.setBackground(new java.awt.Color(255, 255, 255));
        mIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        mIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pIncidentes.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        pIncidentes.setForeground(new java.awt.Color(10, 93, 175));
        pIncidentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pIncidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flag_fill-2_1.png"))); // NOI18N
        pIncidentes.setText("INCIDENTES");
        pIncidentes.setToolTipText("");
        pIncidentes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pIncidentes.setIconTextGap(2);
        pIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pIncidentesMouseClicked(evt);
            }
        });

        bIncidentes.setBackground(new java.awt.Color(255, 255, 255));
        bIncidentes.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout bIncidentesLayout = new javax.swing.GroupLayout(bIncidentes);
        bIncidentes.setLayout(bIncidentesLayout);
        bIncidentesLayout.setHorizontalGroup(
            bIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bIncidentesLayout.setVerticalGroup(
            bIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mIncidentesLayout = new javax.swing.GroupLayout(mIncidentes);
        mIncidentes.setLayout(mIncidentesLayout);
        mIncidentesLayout.setHorizontalGroup(
            mIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mIncidentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pIncidentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bIncidentes, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        mIncidentesLayout.setVerticalGroup(
            mIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mIncidentesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pIncidentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bIncidentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(mIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 3, 135, 60));

        mPlanIndividual.setBackground(new java.awt.Color(255, 255, 255));
        mPlanIndividual.setForeground(new java.awt.Color(255, 255, 255));
        mPlanIndividual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pPlanIndividual.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        pPlanIndividual.setForeground(new java.awt.Color(10, 93, 175));
        pPlanIndividual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPlanIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/File_dock_add_fill-2.png"))); // NOI18N
        pPlanIndividual.setText("PLAN INDIVIDUAL");
        pPlanIndividual.setToolTipText("");
        pPlanIndividual.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pPlanIndividual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pPlanIndividual.setIconTextGap(2);

        bPlanIndividual.setBackground(new java.awt.Color(255, 255, 255));
        bPlanIndividual.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout bPlanIndividualLayout = new javax.swing.GroupLayout(bPlanIndividual);
        bPlanIndividual.setLayout(bPlanIndividualLayout);
        bPlanIndividualLayout.setHorizontalGroup(
            bPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bPlanIndividualLayout.setVerticalGroup(
            bPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mPlanIndividualLayout = new javax.swing.GroupLayout(mPlanIndividual);
        mPlanIndividual.setLayout(mPlanIndividualLayout);
        mPlanIndividualLayout.setHorizontalGroup(
            mPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mPlanIndividualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pPlanIndividual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPlanIndividual, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        mPlanIndividualLayout.setVerticalGroup(
            mPlanIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mPlanIndividualLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pPlanIndividual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bPlanIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(mPlanIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 3, 135, 60));

        pReportes.setBackground(new java.awt.Color(255, 255, 255));
        pReportes.setForeground(new java.awt.Color(255, 255, 255));
        pReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mReportes.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        mReportes.setForeground(new java.awt.Color(10, 93, 175));
        mReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paper_clip-2_1.png"))); // NOI18N
        mReportes.setText("REPORTES");
        mReportes.setToolTipText("");
        mReportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        mReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mReportes.setIconTextGap(2);
        mReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mReportesMouseClicked(evt);
            }
        });

        bReportes.setBackground(new java.awt.Color(255, 255, 255));
        bReportes.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout bReportesLayout = new javax.swing.GroupLayout(bReportes);
        bReportes.setLayout(bReportesLayout);
        bReportesLayout.setHorizontalGroup(
            bReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bReportesLayout.setVerticalGroup(
            bReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pReportesLayout = new javax.swing.GroupLayout(pReportes);
        pReportes.setLayout(pReportesLayout);
        pReportesLayout.setHorizontalGroup(
            pReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        pReportesLayout.setVerticalGroup(
            pReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(pReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 3, 135, 60));

        mSalir.setBackground(new java.awt.Color(255, 255, 255));
        mSalir.setForeground(new java.awt.Color(255, 255, 255));
        mSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pSalir.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        pSalir.setForeground(new java.awt.Color(10, 93, 175));
        pSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/On_button_fill-2.png"))); // NOI18N
        pSalir.setText("SALIR");
        pSalir.setToolTipText("");
        pSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pSalir.setIconTextGap(2);

        javax.swing.GroupLayout mSalirLayout = new javax.swing.GroupLayout(mSalir);
        mSalir.setLayout(mSalirLayout);
        mSalirLayout.setHorizontalGroup(
            mSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );
        mSalirLayout.setVerticalGroup(
            mSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSalirLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pSalir)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.add(mSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 130, 70));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logox75.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 70));

        lbNomUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNomUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lbNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNomUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_cicrle-2.png"))); // NOI18N
        lbNomUsuario.setText("Evelyn Pascual");
        lbNomUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(lbNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 170, 70));

        jpMenu.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mInicioMouseClicked
        bInicio.setBackground(azul);
        bIncidentes.setBackground(Color.white);
        bPlanIndividual.setBackground(Color.white);
        bReportes.setBackground(Color.white);
        bSeguimiento.setBackground(Color.white);
        setDashboardDocente();

        // TODO add your handling code here:
    }//GEN-LAST:event_mInicioMouseClicked

    private void mReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mReportesMouseClicked

        bReportes.setBackground(azul);
        bInicio.setBackground(Color.white);
        bIncidentes.setBackground(Color.white);
        bPlanIndividual.setBackground(Color.white);
        bSeguimiento.setBackground(Color.white);
        setReporteDocente();

        // TODO add your handling code here:
    }//GEN-LAST:event_mReportesMouseClicked

    private void pSeguimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSeguimientoMouseClicked

        bReportes.setBackground(Color.white);
        bInicio.setBackground(Color.white);
        bIncidentes.setBackground(Color.white);
        bPlanIndividual.setBackground(Color.white);
        bSeguimiento.setBackground(azul);
        setSeguimiento();

// TODO add your handling code here:
    }//GEN-LAST:event_pSeguimientoMouseClicked

    private void pIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pIncidentesMouseClicked

        bReportes.setBackground(Color.white);
        bInicio.setBackground(Color.white);
        bIncidentes.setBackground(azul);
        bPlanIndividual.setBackground(Color.white);
        bSeguimiento.setBackground(Color.white);
        setIncidente();

        // TODO add your handling code here:
    }//GEN-LAST:event_pIncidentesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bIncidentes;
    private javax.swing.JPanel bInicio;
    private javax.swing.JPanel bPlanIndividual;
    private javax.swing.JPanel bReportes;
    private javax.swing.JPanel bSeguimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JLabel lbNomUsuario;
    private javax.swing.JPanel mIncidentes;
    private javax.swing.JLabel mInicio;
    private javax.swing.JPanel mPlanIndividual;
    private javax.swing.JLabel mReportes;
    private javax.swing.JPanel mSalir;
    private javax.swing.JPanel mSeguimiento;
    private javax.swing.JLabel pIncidentes;
    private javax.swing.JPanel pInicio;
    private javax.swing.JLabel pPlanIndividual;
    private javax.swing.JPanel pReportes;
    private javax.swing.JLabel pSalir;
    private javax.swing.JLabel pSeguimiento;
    // End of variables declaration//GEN-END:variables
}
