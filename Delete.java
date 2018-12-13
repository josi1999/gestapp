package project;

import project.classes.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete {
    JPanel eliminar;
    JTextArea vehicleDescription;
    JButton deleteButton;
    JScrollPane vehicleList;
    JButton seeButton;

    public Delete() {
        seeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleDescription.setText(Gestapp.sistema.find(Gestapp.todo.getSelectedValue()).toString());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Gestapp.todo.getSelectedIndex();
                Vehiculo ve = Gestapp.sistema.find(Gestapp.todo.getSelectedValue());

                Gestapp.sistema.eliminar(ve.getTipoDeVehiculo(),ve);
                vehicleDescription.setText(null);
                Gestapp.model.removeElementAt(index);
            }
        });
    }
}
