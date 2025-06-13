/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Docente;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.DocenteDao;
import model.dao.EstudianteDao;
import model.dao.IDocenteDao;
import model.dao.IEstudianteDao;
import model.dao.IPlanIndividual;
import model.dao.IRegistroIncidente;
import model.dao.PlanIndividualDao;
import model.dao.RegistroIncidenteDao;
import model.funcionalidad.catalogo.EstrategiaIntervencion;
import model.entidades.Estudiante;
import model.funcionalidad.PlanIntervencion;
import model.funcionalidad.ResumenIncidentes;
import model.funcionalidad.catalogo.Diagnostico;
import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;
import utillities.Utilidad;

/**
 *
 * @author rpasc
 */
public class PlanIndividualView extends javax.swing.JPanel {

    private IRegistroIncidente registroIncidenteDao = new RegistroIncidenteDao();
    private IPlanIndividual planIndividualDao = new PlanIndividualDao();

    private IEstudianteDao estudianteDao = EstudianteDao.obtenerInstancia();
    private IDocenteDao docenteDao = DocenteDao.obtenerInstancia();
    private int idDocente;
    private Utilidad utilidad = new Utilidad();
    private int idEstudianteSeleccionado;
    private FuncionComportamiento funcionComportamiento;

    public PlanIndividualView(int idDocente) {
        this.idDocente = idDocente;
        initComponents();
        utilidad.mostrarDia(lbFechaHoy);
        cargarEstudiantes(idDocente);
        cargarEstrategiasIntervencion();
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

    private void cargarResumenIncidentes(int idEstudiante) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Conducta problemática");
        modelo.addColumn("Frecuencia en 14 días");
        modelo.addColumn("Gravedad promedio");
        modelo.addColumn("Funcion de comportamiento");

        List<ResumenIncidentes> listaResumen = planIndividualDao.obtenerResumenIncidentes(idEstudiante);
        modelo.setRowCount(0);

        for (ResumenIncidentes incidente : listaResumen) {
            modelo.addRow(new Object[]{
                incidente.getTipoConducta().getNombre(),
                incidente.getFrecuencia(),
                incidente.getGravedadPromedio(),
                incidente.getUltComportamiento(),});
        }

        tbResumenIncidentes.setModel(modelo);
    }

    private String calcularEstadoPlan(Date fechaInicio) {
        LocalDate inicio = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaEvaluacion = calcularFechaFinal(inicio, 14);

        return fechaEvaluacion.isAfter(LocalDate.now()) ? "En evaluacion: " : fechaEvaluacion.toString();
    }

    private LocalDate calcularFechaFinal(LocalDate fechaInicio, int diasHabiles) {
        LocalDate fechaFinal = fechaInicio;
        int contadorDias = 0;

        while (contadorDias < diasHabiles) {
            fechaFinal = fechaFinal.plusDays(1);
            if (fechaFinal.getDayOfWeek() != DayOfWeek.SATURDAY && fechaFinal.getDayOfWeek() != DayOfWeek.SUNDAY) {
                contadorDias++;
            }
        }

        return fechaFinal;
    }

    private void cargarHistorialIntervenciones(int idEstudiante) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Conducta Problemática intervenida");
        modelo.addColumn("Estrategia aplicada");
        modelo.addColumn("Estado actual");

        List<PlanIntervencion> listaPlanes = planIndividualDao.obtenerHistorialPlanes(idEstudiante);
        modelo.setRowCount(0);

        for (PlanIntervencion plan : listaPlanes) {
            modelo.addRow(new Object[]{
                plan.getFechaInicio(),
                plan.getTipoConducta().getNombre(),
                plan.getEstrategia().getNombre(),
                calcularEstadoPlan(plan.getFechaInicio())
            });
        }

        tbHistorialIntervenciones.setModel(modelo);
    }

    private void cargarConductasEstudiante(int idEstudiante) {
        cbTipoConducta.removeAllItems();
        List<TipoConducta> listaConductas = planIndividualDao.obtenerTipoConductasEstudiante(idEstudiante);
        for (TipoConducta tipo : listaConductas) {
            cbTipoConducta.addItem(tipo);
        }
    }

    private void cargarEstrategiasIntervencion() {
        cbEstrategiaIntervencion.removeAllItems();
        List<EstrategiaIntervencion> listaEstrategias = planIndividualDao.obtenerEstrategiasIntervencion();
        for (EstrategiaIntervencion estrategia : listaEstrategias) {
            cbEstrategiaIntervencion.addItem(estrategia);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDashboardDocente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbListaEstudiantes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbNivel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbResumenIncidentes = new javax.swing.JTable();
        lbNivel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbHistorialIntervenciones = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtDiagnosticoEstudiante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbNivel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbNivel1 = new javax.swing.JLabel();
        lbNivel4 = new javax.swing.JLabel();
        cbEstrategiaIntervencion = new javax.swing.JComboBox<>();
        lbNivel7 = new javax.swing.JLabel();
        txtFuncionComportamiento = new javax.swing.JTextField();
        lbNivel8 = new javax.swing.JLabel();
        lbNivel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObjetivoPlan = new javax.swing.JTextArea();
        lbNivel5 = new javax.swing.JLabel();
        chkImplementacion = new javax.swing.JCheckBox();
        lbNivel13 = new javax.swing.JLabel();
        lbNivel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtObsPlan = new javax.swing.JTextArea();
        cbTipoConducta = new javax.swing.JComboBox<>();
        btnGuardarPlan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbFechaHoy = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        jpDashboardDocente.setBackground(new java.awt.Color(255, 255, 255));
        jpDashboardDocente.setMinimumSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setPreferredSize(new java.awt.Dimension(1250, 734));
        jpDashboardDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbListaEstudiantes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbListaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbListaEstudiantes.setOpaque(true);
        cbListaEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaEstudiantesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Selecciona el Estudiante:");

        lbNivel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbNivel9.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel9.setText("Resumen de Incidentes");
        lbNivel9.setToolTipText("");
        lbNivel9.setPreferredSize(new java.awt.Dimension(70, 25));

        tbResumenIncidentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbResumenIncidentes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbResumenIncidentes.setForeground(new java.awt.Color(51, 51, 51));
        tbResumenIncidentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Conducta", "Frecuencia en 14 días", "Gravedad Promedio", "Función más frecuente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResumenIncidentes.setGridColor(new java.awt.Color(153, 153, 153));
        tbResumenIncidentes.setSelectionBackground(new java.awt.Color(247, 173, 213));
        jScrollPane3.setViewportView(tbResumenIncidentes);

        lbNivel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbNivel10.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel10.setText("Historial de Intervenciones Aplicadas");
        lbNivel10.setToolTipText("");
        lbNivel10.setPreferredSize(new java.awt.Dimension(70, 25));

        tbHistorialIntervenciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbHistorialIntervenciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbHistorialIntervenciones.setForeground(new java.awt.Color(51, 51, 51));
        tbHistorialIntervenciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Conducta Intervenida", "Estrategia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHistorialIntervenciones.setGridColor(new java.awt.Color(153, 153, 153));
        tbHistorialIntervenciones.setSelectionBackground(new java.awt.Color(247, 173, 213));
        jScrollPane4.setViewportView(tbHistorialIntervenciones);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Diagnósticos:");

        txtDiagnosticoEstudiante.setEditable(false);
        txtDiagnosticoEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtDiagnosticoEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiagnosticoEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtDiagnosticoEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID:");

        txtIdEstudiante.setEditable(false);
        txtIdEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtIdEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtIdEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombres y apellidos:");

        txtNombreEstudiante.setEditable(false);
        txtNombreEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreEstudiante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        lbNivel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbNivel6.setForeground(new java.awt.Color(39, 84, 138));
        lbNivel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel6.setText("Datos de estudiante");
        lbNivel6.setToolTipText("");
        lbNivel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNivel6.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 85, Short.MAX_VALUE))
                                    .addComponent(txtIdEstudiante))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtDiagnosticoEstudiante)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbListaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbListaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbNivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiagnosticoEstudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNivel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNivel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jpDashboardDocente.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 740, 580));

        jPanel4.setBackground(new java.awt.Color(45, 94, 152));

        lbNivel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel1.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel1.setText("Objetivo del plan:");
        lbNivel1.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel4.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel4.setText("Selecciona la conducta a intervenir:");
        lbNivel4.setPreferredSize(new java.awt.Dimension(70, 25));

        cbEstrategiaIntervencion.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbEstrategiaIntervencion.setForeground(new java.awt.Color(51, 51, 51));
        cbEstrategiaIntervencion.setBorder(null);
        cbEstrategiaIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstrategiaIntervencionActionPerformed(evt);
            }
        });

        lbNivel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel7.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel7.setText("Función del comportamiento:");
        lbNivel7.setPreferredSize(new java.awt.Dimension(70, 25));

        txtFuncionComportamiento.setForeground(new java.awt.Color(51, 51, 51));
        txtFuncionComportamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        lbNivel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNivel8.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Group_light.png"))); // NOI18N
        lbNivel8.setText("Plan de intervención");
        lbNivel8.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel11.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbNivel11.setForeground(new java.awt.Color(221, 168, 83));
        lbNivel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNivel11.setText("*  Último registro");
        lbNivel11.setPreferredSize(new java.awt.Dimension(70, 25));

        txtObjetivoPlan.setColumns(20);
        txtObjetivoPlan.setForeground(new java.awt.Color(51, 51, 51));
        txtObjetivoPlan.setRows(5);
        txtObjetivoPlan.setBorder(null);
        jScrollPane2.setViewportView(txtObjetivoPlan);

        lbNivel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel5.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel5.setText("Estrategia de Intervención");
        lbNivel5.setPreferredSize(new java.awt.Dimension(70, 25));

        chkImplementacion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        chkImplementacion.setForeground(new java.awt.Color(255, 255, 255));
        chkImplementacion.setText("Sí");
        chkImplementacion.setEnabled(false);
        chkImplementacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNivel13.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbNivel13.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNivel13.setText("¿Ya se ha utilizado?");
        lbNivel13.setPreferredSize(new java.awt.Dimension(70, 25));

        lbNivel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNivel3.setForeground(new java.awt.Color(255, 255, 255));
        lbNivel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNivel3.setText("Observaciones finales:");
        lbNivel3.setPreferredSize(new java.awt.Dimension(70, 25));

        txtObsPlan.setColumns(20);
        txtObsPlan.setForeground(new java.awt.Color(51, 51, 51));
        txtObsPlan.setRows(5);
        txtObsPlan.setBorder(null);
        jScrollPane6.setViewportView(txtObsPlan);

        cbTipoConducta.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cbTipoConducta.setForeground(new java.awt.Color(51, 51, 51));
        cbTipoConducta.setBorder(null);
        cbTipoConducta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoConductaActionPerformed(evt);
            }
        });

        btnGuardarPlan.setBackground(new java.awt.Color(221, 168, 83));
        btnGuardarPlan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarPlan.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_fill-2.png"))); // NOI18N
        btnGuardarPlan.setText("GUARDAR");
        btnGuardarPlan.setBorder(null);
        btnGuardarPlan.setBorderPainted(false);
        btnGuardarPlan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarPlan.setFocusPainted(false);
        btnGuardarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbEstrategiaIntervencion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarPlan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(lbNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chkImplementacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbTipoConducta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFuncionComportamiento, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbNivel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoConducta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFuncionComportamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNivel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkImplementacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstrategiaIntervencion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jpDashboardDocente.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 420, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 84, 138));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Plan Individual Conductual");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 33, 387, 50));

        lbFechaHoy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaHoy.setForeground(new java.awt.Color(39, 84, 138));
        lbFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Date_fill-1_1.png"))); // NOI18N
        lbFechaHoy.setText("Fecha de hoy");
        jPanel1.add(lbFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 36, 456, 40));

        jpDashboardDocente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 90));

        jSeparator2.setForeground(new java.awt.Color(45, 94, 152));
        jpDashboardDocente.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1160, 12));

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

        Estudiante estudiante = (Estudiante) cbListaEstudiantes.getSelectedItem();
        if (estudiante != null) {
            idEstudianteSeleccionado = estudiante.getIdEstudiante();
            mostrarDatosEstudiante(idEstudianteSeleccionado);
            cargarHistorialIntervenciones(idEstudianteSeleccionado);
            cargarResumenIncidentes(idEstudianteSeleccionado);
            cargarConductasEstudiante(idEstudianteSeleccionado);
        }

    }//GEN-LAST:event_cbListaEstudiantesActionPerformed

    private void cbTipoConductaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoConductaActionPerformed

        TipoConducta conductaSeleccionada = (TipoConducta) cbTipoConducta.getSelectedItem();
        if (conductaSeleccionada != null) {
            funcionComportamiento = planIndividualDao.obtenerUltimaFuncionComportamiento(idEstudianteSeleccionado, conductaSeleccionada.getId());
            txtFuncionComportamiento.setText(funcionComportamiento.getNombre());
        }


    }//GEN-LAST:event_cbTipoConductaActionPerformed

    private void cbEstrategiaIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstrategiaIntervencionActionPerformed

        TipoConducta conductaSeleccionada = (TipoConducta) cbTipoConducta.getSelectedItem();
        EstrategiaIntervencion estrategia = (EstrategiaIntervencion) cbEstrategiaIntervencion.getSelectedItem();

        if (conductaSeleccionada != null && estrategia != null) {
            chkImplementacion.setSelected(planIndividualDao.verificarPlanExistente(idEstudianteSeleccionado, conductaSeleccionada.getId(), estrategia.getId()));
        }


    }//GEN-LAST:event_cbEstrategiaIntervencionActionPerformed

    private void btnGuardarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlanActionPerformed

        if (planIndividualDao.registrarPlanIntervencion(
                idEstudianteSeleccionado,
                ((TipoConducta) cbTipoConducta.getSelectedItem()).getId(),
                funcionComportamiento.getId(),
                txtObjetivoPlan.getText(),
                ((EstrategiaIntervencion) cbEstrategiaIntervencion.getSelectedItem()).getId(),
                chkImplementacion.isSelected(),
                txtObsPlan.getText()
        )) {
            JOptionPane.showMessageDialog(this, "Plan de intervención registrado correctamente.");
            cargarHistorialIntervenciones(idEstudianteSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el plan de intervención.");
        }

    }//GEN-LAST:event_btnGuardarPlanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarPlan;
    private javax.swing.JComboBox<EstrategiaIntervencion> cbEstrategiaIntervencion;
    private javax.swing.JComboBox<Estudiante> cbListaEstudiantes;
    private javax.swing.JComboBox<TipoConducta> cbTipoConducta;
    private javax.swing.JCheckBox chkImplementacion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpDashboardDocente;
    private javax.swing.JLabel lbFechaHoy;
    private javax.swing.JLabel lbNivel1;
    private javax.swing.JLabel lbNivel10;
    private javax.swing.JLabel lbNivel11;
    private javax.swing.JLabel lbNivel13;
    private javax.swing.JLabel lbNivel3;
    private javax.swing.JLabel lbNivel4;
    private javax.swing.JLabel lbNivel5;
    private javax.swing.JLabel lbNivel6;
    private javax.swing.JLabel lbNivel7;
    private javax.swing.JLabel lbNivel8;
    private javax.swing.JLabel lbNivel9;
    private javax.swing.JTable tbHistorialIntervenciones;
    private javax.swing.JTable tbResumenIncidentes;
    private javax.swing.JTextField txtDiagnosticoEstudiante;
    private javax.swing.JTextField txtFuncionComportamiento;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextArea txtObjetivoPlan;
    private javax.swing.JTextArea txtObsPlan;
    // End of variables declaration//GEN-END:variables
}
