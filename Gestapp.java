package project;

import com.alee.laf.WebLookAndFeel;
import project.classes.Sistema;
import project.classes.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class Gestapp {
    private JButton alta;
    private JButton ver;
    private JButton modificar;
    private JButton baja;
    private JPanel mainPanel;
    private JTextArea añadeUnVehiculoATextArea;
    private JTextArea modificaUnVehiculoExistenteTextArea;
    private JTextArea daDeBajaUnTextArea;
    private JTextArea permiteVerLosVehiculosTextArea;
    private JButton guardar;
    static Sistema sistema = new Sistema();
    static Show show;
    static Add add;
    static Delete delete;
    static Modify modify;
    Vehiculo vehiculo;
    static JList<String> autos;
    static JList<String> motos;
    static JList<String> camiones;
    static JList<String> camionetas;
    static JList<String> todo;
    static DefaultListModel<String> model;
    static int id = 0000;


    public Gestapp() {



        añadeUnVehiculoATextArea.setText("Añade un vehiculo\na la base de datos\n");
        modificaUnVehiculoExistenteTextArea.setText("Modifica un vehiculo\nque ya existe\nen la base de datos");
        daDeBajaUnTextArea.setText("Elimina de la \nbase de datos un\nvehiculo ya existente");
        permiteVerLosVehiculosTextArea.setText("Permite ver\nun vehiculo ya existente\nen la base de datos");
        try {
            readId();
            sistema.loadAutos();
            sistema.loadMotos();
            sistema.loadCamiones();
            sistema.loadCamionetas();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        alta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add = new Add();
                JFrame agregar = new JFrame("Agregar");
                agregar.setContentPane(add.agregar);
                agregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                agregar.setVisible(true);
                agregar.setMinimumSize(new Dimension(800,600));
                agregar.setLocationRelativeTo(null);
                agregar.pack();



            }
        });

        ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> asd = sistema.getAuto();
                autos = new JList<>(asd.toArray(new String[0]));
                asd = sistema.getMoto();
                motos = new JList<>(asd.toArray(new String[0]));
                asd = sistema.getCamion();
                camiones = new JList<>(asd.toArray(new String[0]));
                asd = sistema.getCamioneta();
                camionetas = new JList<>(asd.toArray(new String[0]));

                JFrame ver = new JFrame("Ver");
                show = new Show();

                show.listaautos.setViewportView(autos);
                show.listamotos.setViewportView(motos);
                show.listacamiones.setViewportView(camiones);
                show.listacamionetas.setViewportView(camionetas);

                ver.setContentPane(show.ver);
                ver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ver.setVisible(true);
                ver.setMinimumSize(new Dimension(800,600));
                ver.setLocationRelativeTo(null);
                ver.pack();

            }
        });

        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete = new Delete();
                model = new DefaultListModel<>();
                JFrame baja = new JFrame("Baja");
                ArrayList<String> asd = new ArrayList<>(sistema.getAuto());
                asd.addAll(sistema.getMoto());
                asd.addAll(sistema.getCamion());
                asd.addAll(sistema.getCamioneta());
                for (String str:asd) {
                    model.addElement(str);
                }
                todo = new JList<>(model);
                delete.vehicleList.setViewportView(todo);
                baja.setContentPane(delete.eliminar);
                baja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                baja.setVisible(true);
                baja.setMinimumSize(new Dimension(800,600));
                baja.setLocationRelativeTo(null);
                baja.pack();
            }
        });
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        modify = new Modify();
                        model = new DefaultListModel<>();
                        JFrame modificar = new JFrame("Modificar");
                        ArrayList<String> asd = new ArrayList<>(sistema.getAuto());
                        asd.addAll(sistema.getMoto());
                        asd.addAll(sistema.getCamion());
                        asd.addAll(sistema.getCamioneta());
                        for (String str:asd) {
                            model.addElement(str);
                        }
                        todo = new JList<>(model);
                        modify.vehiclelistm.setViewportView(todo);
                        modificar.setContentPane(modify.panel1);
                        modificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        modificar.setVisible(true);
                        modificar.setMinimumSize(new Dimension(800,600));
                        modificar.setLocationRelativeTo(null);
                        modificar.pack();
                    }
                });


            }
        });
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sistema.writeAutos();
                    sistema.writeMotos();
                    sistema.writeCamiones();
                    sistema.writeCamionetas();
                    writeId();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    public static void agregar(String[] toAdd){
        Vehiculo vehiculo = new Vehiculo(toAdd[1],toAdd[0],toAdd[2],Integer.parseInt(toAdd[4]),Integer.parseInt(toAdd[3]),Integer.parseInt(toAdd[5]),Double.parseDouble(toAdd[6]),Double.parseDouble(toAdd[7].replace(',','.')),Integer.parseInt(toAdd[8]),id);
        id++;
        sistema.agregar(vehiculo);



    }

    public static void modificar(String[] toAdd){
        Vehiculo vehiculo = new Vehiculo(toAdd[1],toAdd[0],toAdd[2],Integer.parseInt(toAdd[4]),Integer.parseInt(toAdd[3]),Integer.parseInt(toAdd[5]),Double.parseDouble(toAdd[6]),Double.parseDouble(toAdd[7].replace(',','.')),Integer.parseInt(toAdd[8]),Integer.parseInt(toAdd[9]));
        sistema.modificar(vehiculo,todo.getSelectedIndex());



    }
    public void writeId() throws IOException {
        FileOutputStream obj = null;
        File f = new File("id");
        try {
            f.createNewFile();
            obj = new FileOutputStream(f);
            obj.write(this.id);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (obj != null) {
                obj.close();
            }

        }
    }

    public void readId() throws IOException, ClassNotFoundException {
        FileInputStream filein = null;
        ObjectInputStream oip = null;
        int id;
        try{
            filein = new FileInputStream("id");
            id = filein.read();





        }finally {
            if(filein!=null){
                filein.close();
            }
            if(oip!=null){
                oip.close();
            }
        }
        this.id = id;
    }

    public static void main(String[] args) {
        WebLookAndFeel.install();
        JFrame frame = new JFrame("Gestapp");
        frame.setContentPane(new Gestapp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1280,300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }






}
