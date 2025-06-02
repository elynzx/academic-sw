/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Utilidad {



    //<<<<<<<<<< Fecha en interfaz >>>>>>>>>>>
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

    //<<<<<<<<<< Seleccion Menu >>>>>>>>>>>
    Color gris = new Color(51, 51, 51);
    Color azul = new Color(0, 102, 204);

    public void cambiarBgColor(JComponent componente) {
        componente.setBackground(azul);
    }

    public void rehacerBgColor(JComponent[] componentes) {
        for (JComponent componente : componentes) {
            componente.setBackground(gris);
        }
    }

    public void configureMouseEvents(JComponent componente, JComponent[] componentesMenu) {
        componente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                cambiarBgColor(componente);
                rehacerBgColor(componentesMenu);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                rehacerBgColor(new JComponent[]{componente});
            }
        });
    }

}
