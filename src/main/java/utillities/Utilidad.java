/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utillities;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Utilidad {

    public void mostrarFechaCompleta(JLabel lbFecha) {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            String fechaHora = s.format(d);
            lbFecha.setText(fechaHora);
        });
        t.start();
    }

    public void mostrarFechaHora(JLabel lbFecha, JLabel lbHora) {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat h = new SimpleDateFormat("HH:mm:ss");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            lbFecha.setText(f.format(d));
            lbHora.setText(h.format(d));

        });
        t.start();
    }

    public void mostrarFecha(JLabel lbFecha) {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            lbFecha.setText(f.format(d));
        });
        t.start();
    }

    public void mostrarDiaHora(JLabel lbFecha) {
        SimpleDateFormat s = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY HH:mm:ss");
        Timer t = new Timer(1000, e -> {
            Date d = new Date();
            String fechaHora = s.format(d).toUpperCase();
            lbFecha.setText(fechaHora);
        });
        t.start();
    }

    public void mostrarDia(JLabel lbDia) {
        String fecha = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY").format(new Date()).toUpperCase();
        lbDia.setText(fecha);
    }

//<<<<<<<<<< Seleccion Menu >>>>>>>>>>>
    Color gris = new Color(239, 239, 239);
    Color blanco = new Color(255, 255, 255);

    public void cambiarBgColor(JPanel panel) {
        panel.setBackground(blanco);
    }

    public void rehacerBgColor(JPanel[] paneles) {
        for (JPanel panel : paneles) {
            panel.setBackground(gris);
        }
    }

    public void configureMouseEvents(JPanel panel, JPanel[] panelesMenu) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                cambiarBgColor(panel);
                rehacerBgColor(panelesMenu);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                rehacerBgColor(new JPanel[]{panel});
            }
        });
    }

//    
//    public void configurarEventosMenu(JPanel panel, JFrame vista, JPanel[] componentesMenu) {
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent evt) {
//                if (panel != panelActivo) {
//                    cambiarBgColor(panel);
//                    rehacerBgColor(componentesMenu);
//                }
//            }
//
//            @Override
//            public void mouseExited(MouseEvent evt) {
//                if (panel != panelActivo) {
//                    
//                     rehacerBgColor(new JComponent[]{componente});
//                }
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent evt) {
//
//                if (panelActivo != panel) {
//                    rehacerBgColor(componentesMenu);
//                    panel.setBackground(blanco);
//                    setPanelActivo(panel);
//                }
//
//                vista.setVisible(true);
//                vista.setLocationRelativeTo(null);
//            }
//        });
//    }
//
//    public void setPanelActivo(JPanel nuevoPanelActivo) {
//        if (panelActivo != nuevoPanelActivo) {
//            panelActivo = nuevoPanelActivo;
//        }
//    }
}
