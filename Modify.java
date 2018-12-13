package project;

import project.classes.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modify {
    JPanel panel1;
    JTextArea vehicledesc;
    JButton verButton;
    JButton modificarButton;
    JScrollPane vehiclelistm;


    public Modify() {

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = Gestapp.todo.getSelectedValue();
                Vehiculo ve = Gestapp.sistema.find(str);
                vehicledesc.setText(ve.toString());
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyWindow modifywindow = new ModifyWindow();
                JFrame modify = new JFrame("Modificar");
                modify.setContentPane(new ModifyWindow().agregar);
                modify.setVisible(true);
                modify.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                modify.setLocationRelativeTo(null);
                modify.setMinimumSize(new Dimension(800,600));
                modify.pack();



                Vehiculo ve = Gestapp.sistema.find(Gestapp.todo.getSelectedValue());
                modifywindow.marca.setText(ve.getMarca());
                modifywindow.modelo.setText(ve.getModelo());
                modifywindow.color.setText(ve.getColor());
                modifywindow.añoFabricacion.setText(""+ve.getAñoFabricacion());
                switch (ve.getTipoDeVehiculo()){
                    case "Auto":modifywindow.comboBox2.setSelectedIndex(0);break;
                    case "Moto":modifywindow.comboBox2.setSelectedIndex(1);break;
                    case "Camion":modifywindow.comboBox2.setSelectedIndex(2);break;
                    case "Camioneta":modifywindow.comboBox2.setSelectedIndex(3);
                }
                modifywindow.km.setText(""+ve.getKm());
                modifywindow.precio.setText(""+ve.getPrecio());
                modifywindow.descuento.setText(""+ve.getDescuento());
                switch (ve.getTipoDeCombustible()){
                    case "Nafta": modifywindow.comboBox1.setSelectedIndex(0);break;
                    case "Diesel":modifywindow.comboBox1.setSelectedIndex(1);break;
                    case "GNC": modifywindow.comboBox1.setSelectedIndex(2);break;
                    case "Electrico": modifywindow.comboBox1.setSelectedIndex(3);break;
                }

            }
        });
    }
}
