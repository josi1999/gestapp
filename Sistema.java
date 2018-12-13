package project.classes;

import java.io.*;
import java.util.ArrayList;

public class Sistema implements Serializable {

    public ArrayList<Vehiculo> auto = new ArrayList<>();
    private ArrayList<Vehiculo> moto = new ArrayList<>();
    private ArrayList<Vehiculo> camion = new ArrayList<>();
    private ArrayList<Vehiculo> camioneta = new ArrayList<>();

    public void loadCamionetas() throws IOException, ClassNotFoundException{
        FileInputStream filein = null;
        ObjectInputStream oip = null;
        boolean cont = true;
        ArrayList<Vehiculo> camionetas = new ArrayList<>();
        try{
            filein = new FileInputStream("Camionetas");
            oip = new ObjectInputStream( filein );
            while(cont){
                if(filein.available() != 0) {
                    Vehiculo ve = (Vehiculo) oip.readObject();
                    camionetas.add(ve);
                } else {
                    cont = false;
                }
            }


        }finally {
            if(filein!=null){
                filein.close();
            }
            if(oip!=null){
                oip.close();
            }
        }
        this.camioneta = camionetas;
    }

    public void writeCamionetas() throws IOException {
        ObjectOutputStream obj = null;
        File f = new File("Camionetas");
        try {
            f.createNewFile();
            obj = new ObjectOutputStream(new FileOutputStream(f));
            for (Vehiculo ve :camioneta) {
                obj.writeObject(ve);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (obj != null) {
                obj.close();
            }

        }



    }
    public void loadCamiones() throws IOException, ClassNotFoundException{
        FileInputStream filein = null;
        ObjectInputStream oip = null;
        boolean cont = true;
        ArrayList<Vehiculo> camiones = new ArrayList<>();
        try{
            filein = new FileInputStream("Camiones");
            oip = new ObjectInputStream( filein );
            while(cont){
                if(filein.available() != 0) {
                    Vehiculo ve = (Vehiculo) oip.readObject();
                    camiones.add(ve);
                } else {
                    cont = false;
                }
            }


        }finally {
            if(filein!=null){
                filein.close();
            }
            if(oip!=null){
                oip.close();
            }
        }
        this.camion = camiones;
    }

    public void writeCamiones() throws IOException {
        ObjectOutputStream obj = null;
        File f = new File("Camiones");
        try {
            f.createNewFile();
            obj = new ObjectOutputStream(new FileOutputStream(f));
            for (Vehiculo ve :camion) {
                obj.writeObject(ve);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (obj != null) {
                obj.close();
            }

        }

    }
    public void loadMotos() throws IOException, ClassNotFoundException{
        FileInputStream filein = null;
        ObjectInputStream oip = null;
        boolean cont = true;
        ArrayList<Vehiculo> motos = new ArrayList<>();
        try{
            filein = new FileInputStream("Motos");
            oip = new ObjectInputStream( filein );
            while(cont){
                if(filein.available() != 0) {
                    Vehiculo ve = (Vehiculo) oip.readObject();
                    motos.add(ve);
                } else {
                    cont = false;
                }
            }


        }finally {
            if(filein!=null){
                filein.close();
            }
            if(oip!=null){
                oip.close();
            }
        }
        this.moto = motos;
    }

    public void writeMotos() throws IOException {
        ObjectOutputStream obj = null;
        File f = new File("Motos");
        try {
            f.createNewFile();
            obj = new ObjectOutputStream(new FileOutputStream(f));
            for (Vehiculo ve :moto) {
                obj.writeObject(ve);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (obj != null) {
                obj.close();
            }

        }



    }
    public void loadAutos() throws IOException, ClassNotFoundException{
        FileInputStream filein = null;
        ObjectInputStream oip = null;
        boolean cont = true;
        ArrayList<Vehiculo> autos = new ArrayList<>();
        try{
            filein = new FileInputStream("Autos");
            oip = new ObjectInputStream( filein );
            while(cont){
                if(filein.available() != 0) {
                    Vehiculo ve = (Vehiculo) oip.readObject();
                    autos.add(ve);
                    } else {
                        cont = false;
                    }
                }


        }finally {
            if(filein!=null){
                filein.close();
            }
            if(oip!=null){
                oip.close();
            }
        }
        this.auto = autos;
    }

    public void writeAutos() throws IOException {
        ObjectOutputStream obj = null;
        File f = new File("Autos");
        try {
            f.createNewFile();
            obj = new ObjectOutputStream(new FileOutputStream(f));
            for (Vehiculo ve :auto) {
                obj.writeObject(ve);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (obj != null) {
                obj.close();
            }

        }



    }



    public Vehiculo findAuto(String specific){
        for (Vehiculo ve: auto) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        Vehiculo error = new Vehiculo("0","0","0",0,0,0,0,0,1,0);
        return error;
    }
    public Vehiculo findMoto(String specific){
        for (Vehiculo ve: moto) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        Vehiculo error = new Vehiculo("0","0","0",0,0,0,0,0,1,0);
        return error;
    }
    public Vehiculo findCamion(String specific){
        for (Vehiculo ve: camion) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        Vehiculo error = new Vehiculo("0","0","0",0,0,0,0,0,1,0);
        return error;
    }
    public Vehiculo findCamioneta(String specific){
        for (Vehiculo ve: camioneta) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        Vehiculo error = new Vehiculo("0","0","0",0,0,0,0,0,1,0);
        return error;
    }

    public Vehiculo find(String specific){
        for (Vehiculo ve: auto) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        for (Vehiculo ve: moto) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        for (Vehiculo ve: camion) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        for (Vehiculo ve: camioneta) {
            if(ve.specificToString().equals(specific)){
                return ve;
            }
        }
        Vehiculo error = new Vehiculo("0","0","0",0,0,0,0,0,1,0);
        return error;

    }

     public ArrayList<String> getAuto() {
        ArrayList<String> toreturn = new ArrayList<>();
        for (Vehiculo ve:auto) {
            toreturn.add(ve.specificToString());
        }
        return toreturn;
    }




    public ArrayList<String> getMoto() {
        ArrayList<String> toreturn = new ArrayList<>();
        for (Vehiculo ve:
             moto) {
            toreturn.add(ve.specificToString());
        }

        return toreturn;
    }



    public ArrayList<String> getCamion() {
        ArrayList<String> toreturn = new ArrayList<>();
        for (Vehiculo ve: camion) {
            toreturn.add(ve.specificToString());

        }

        return toreturn;
    }



    public ArrayList<String> getCamioneta() {
        ArrayList<String> toreturn = new ArrayList<>();
        for (Vehiculo ve:camioneta) {
            toreturn.add(ve.specificToString());
        }

        return toreturn;
    }



    public Sistema(ArrayList<Vehiculo> vehiculos){
        for (Vehiculo ve: vehiculos) {

            if(ve.getTipoDeVehiculo().equals("Auto")){
                auto.add(ve);
            }

            if (ve.getTipoDeVehiculo().equals("Moto")){
                moto.add(ve);
            }

            if(ve.getTipoDeVehiculo().equals("Camion")){
                camion.add(ve);
            }

            if(ve.getTipoDeVehiculo().equals("Camioneta")){
                camioneta.add(ve);
            }

        }
    }

    public Sistema(){

    }


    public void agregar(ArrayList<Vehiculo> vehiculos){
        for (Vehiculo ve: vehiculos) {

            if(ve.getTipoDeVehiculo().equals("Auto")){
                auto.add(ve);
            }

            if (ve.getTipoDeVehiculo().equals("Moto")){
                moto.add(ve);
            }

            if(ve.getTipoDeVehiculo().equals("Camion")){
                camion.add(ve);
            }

            if(ve.getTipoDeVehiculo().equals("Camioneta")){
                camioneta.add(ve);
            }

        }

    }

    public void agregar(Vehiculo vehiculo){


            if(vehiculo.getTipoDeVehiculo().equals("Auto")){
                auto.add(vehiculo);
            }

            if (vehiculo.getTipoDeVehiculo().equals("Moto")){
                moto.add(vehiculo);
            }

            if(vehiculo.getTipoDeVehiculo().equals("Camion")){
                camion.add(vehiculo);
            }

            if(vehiculo.getTipoDeVehiculo().equals("Camioneta")){
                camioneta.add(vehiculo);
            }


    }
    public void modificar(Vehiculo vehiculo, int indice){

        switch(vehiculo.getTipoDeVehiculo()) {
            case "Auto": auto.set(indice,vehiculo);break;
            case "Moto": moto.set(indice,vehiculo);break;
            case "Camion":camion.set(indice,vehiculo);break;
            case "Camioneta":camioneta.set(indice,vehiculo);break;
        }

    }

    public int getIndice(int id, String tipoVehiculo){
        int indice = -1;
        int cont = 0;
        switch(tipoVehiculo) {
            case "Auto":
                for (Vehiculo ve:auto) {
                    if(ve.getId() == id){
                        indice = cont;
                    }
                    cont++;
                } break;
            case "Moto":
                for (Vehiculo ve:moto) {
                    if(ve.getId() == id){
                        indice = cont;
                    }
                    cont++;
                } break;
            case "Camion":for (Vehiculo ve:camion) {
                if(ve.getId() == id){
                    indice = cont;
                }
                cont++;
            } break;
            case "Camioneta":for (Vehiculo ve:camioneta) {
                if(ve.getId() == id){
                    indice = cont;
                }
                cont++;
            } break;
        }
        return indice;
    }

    public void eliminar(String tipoVehiculo, Vehiculo vehiculo){

        switch(tipoVehiculo) {
            case "Auto": if(auto.contains(vehiculo)) {
                            auto.remove(vehiculo);
                        }else System.out.println("El elemento no existe");break;
            case "Moto": if(moto.contains(vehiculo)) {
                            moto.remove(vehiculo);
                        }else System.out.println("El elemento no existe");break;
            case "Camion":if(camion.contains(vehiculo)) {
                            camion.remove(vehiculo);
                        }else System.out.println("El elemento no existe");break;
            case "Camioneta":if(camioneta.contains(vehiculo)) {
                                camioneta.remove(vehiculo);
                            }else System.out.println("El elemento no existe");break;


        }

    }

    public void mostrarAutos(){
        if(auto.isEmpty()){
            System.out.println("No hay autos");
            return;
        }
        for (Vehiculo ve:auto) {
            System.out.println(ve);
        }
    }


    public void mostrarMotos(){
        if(moto.isEmpty()){
            System.out.println("No hay motos");
            return;
        }
        for (Vehiculo ve:moto) {
            System.out.println(ve);
        }
    }


    public void mostrarCamiones(){
        if(camion.isEmpty()){
            System.out.println("No hay camiones");
            return;
        }
        for (Vehiculo ve:camion) {
            System.out.println(ve);
        }
    }


    public void mostrarCamionetas(){
        if(camioneta.isEmpty()){
            System.out.println("No hay camionetas");
            return;
        }
        for (Vehiculo ve:camioneta) {
            System.out.println(ve);
        }
    }








}
