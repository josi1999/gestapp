package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Show {
    JPanel ver;
    JLabel motostitulo;
    JLabel camionestitulo;
    JLabel camionetastitulo;
    JScrollPane listaautos;
    JScrollPane listamotos;
    JScrollPane listacamiones;
    JScrollPane listacamionetas;
    JLabel autostitulo;
    JTextArea mototext;
    JTextArea camiontext;
    JTextArea camionetastext;
    JTextArea autotext;
    JButton botonparaver;



    public Show() {
        botonparaver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Gestapp.autos.getValueIsAdjusting() && Gestapp.autos.getSelectedValue() != null )
                    autotext.setText(Gestapp.sistema.findAuto(Gestapp.autos.getSelectedValue()).toString());

                if (!Gestapp.motos.getValueIsAdjusting() && Gestapp.motos.getSelectedValue() != null)
                    mototext.setText(Gestapp.sistema.findMoto(Gestapp.motos.getSelectedValue()).toString());

                if(!Gestapp.camiones.getValueIsAdjusting() && Gestapp.camiones.getSelectedValue() != null)
                    camiontext.setText(Gestapp.sistema.findCamion(Gestapp.camiones.getSelectedValue()).toString());

                if(!Gestapp.camionetas.getValueIsAdjusting() && Gestapp.camionetas.getSelectedValue() != null)
                    camionetastext.setText(Gestapp.sistema.findCamioneta(Gestapp.camionetas.getSelectedValue()).toString());

            }
        });
    }
}

