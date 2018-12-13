package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add {
    JPanel agregar;
    JTextField precio;
    JTextField descuento;
    JTextField km;
    JTextField marca;
    JTextField añoFabricacion;
    JTextField modelo;
    JTextField color;
    JButton confirm;
    JComboBox comboBox1;
    JLabel marc;
    JLabel model;
    JLabel col;
    JLabel año;
    JLabel tipocomb;
    JLabel kilometraje;
    JLabel price;
    JLabel discount;
    JComboBox comboBox2;
    JLabel tipoVehiculo;
    String[] data = new String[9];

    public Add() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data[0] = marca.getText();
                data[1] = modelo.getText();
                data[2] = color.getText();
                data[3] = añoFabricacion.getText();
                data[4] = ""+comboBox1.getSelectedIndex();
                data[5] = km.getText();
                data[6] = precio.getText();
                data[7] = descuento.getText();
                data[8] = ""+comboBox2.getSelectedIndex();
                Gestapp.agregar(data);
                JOptionPane.showMessageDialog(null,"Alta realizada con exito");
                marca.setText("");
                precio.setText("");
                descuento.setText("");
                km.setText("");
                añoFabricacion.setText("");
                modelo.setText("");
                color.setText("");


            }
        };

        confirm.addActionListener(listener);
    }
}
