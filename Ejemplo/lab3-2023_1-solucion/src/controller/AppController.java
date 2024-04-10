package controller;

import beans.Equipo;
import beans.Tecnico;

import java.util.ArrayList;
import java.util.Scanner;

public class AppController {

    public void registrarNuevoEquipo(ArrayList<Equipo> equipos){
        Scanner scanner = new Scanner(System.in);
        Equipo equipo = new Equipo();

        System.out.print(" Marca: ");
        equipo.setMarca(scanner.nextLine());

        System.out.print(" Tipo: ");
        equipo.setTipo(scanner.nextLine());

        System.out.print(" Cantidad de Puertos: ");
        equipo.setCantidadDePuertos(scanner.nextLine());

        System.out.print(" Costo: ");
        equipo.setCosto(Float.parseFloat(scanner.nextLine()));

        System.out.print( "Numero de serie: ");
        equipo.setNumeroDeSerie(scanner.nextLine());
        boolean condicion = buscarEquipoXSerie(equipos,equipo);
        if(condicion){
            System.out.println("\"Error, ya existe el numero de serie\"");
            return;
        }

        equipos.add(equipo);
    }

    public void registrarNuevoTecnico(ArrayList<Tecnico> tecnicos){
        Scanner scanner = new Scanner(System.in);
        Tecnico tecnico = new Tecnico();

        System.out.print(" Nombre: ");
        tecnico.setNombre(scanner.nextLine());

        System.out.print(" Apellidos: ");
        tecnico.setApellido(scanner.nextLine());

        System.out.print(" DNI: ");
        tecnico.setDni(scanner.nextLine());
        boolean condicion = buscarTecnicoXDni(tecnicos,tecnico);
        if(condicion){
            System.out.println("\"Error,ya existe el dni\"");
            return;
        }

        System.out.print(" Edad: ");
        tecnico.setEdad(scanner.nextLine());

        System.out.print(" Telefono: ");
        tecnico.setTelefono(scanner.nextLine());

        System.out.print(" Salario: ");
        tecnico.setSalario(Float.parseFloat(scanner.nextLine()));

        System.out.print(" Cargo: ");
        tecnico.setCargo(scanner.nextLine());

        tecnicos.add(tecnico);
    }

    public void listarEquipos(ArrayList<Equipo> equipos){
        for(Equipo equipo: equipos){
            System.out.println("Marca: "+equipo.getMarca() +
            "| Tipo: "+equipo.getTipo()+
            "| Cantidad de Puertos: "+equipo.getCantidadDePuertos()+
            "| Numero de serie: "+equipo.getNumeroDeSerie()+
            "| Costo: "+equipo.getCosto());
        }
    }

    public void listarTecnicosXSalario(ArrayList<Tecnico> tecnicos){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salario mayor a: ");
        float salary = Float.parseFloat(scanner.nextLine());
        for(Tecnico tecnico: tecnicos){
            if(tecnico.getSalario() > salary){
                System.out.println(" Nombre: " +tecnico.getNombre()+
                "| Apellido: "+tecnico.getApellido()+
                "| DNI: "+tecnico.getDni()+
                "| Edad: "+tecnico.getEdad()+
                "| Telefono: "+tecnico.getTelefono()+
                "| Salario: "+tecnico.getSalario()+
                "| Cargo: "+ tecnico.getCargo());
            }
        }
    }

    public boolean buscarEquipoXSerie(ArrayList<Equipo> equipos, Equipo equipo){
        boolean condicion = false;
        for(Equipo equipo1: equipos){
            if(equipo1.getNumeroDeSerie().equalsIgnoreCase(equipo.getNumeroDeSerie())){
                condicion = true;
                break;
            }
        }
        return condicion;
    }

    public boolean buscarTecnicoXDni(ArrayList<Tecnico> tecnicos, Tecnico tecnico){
        boolean condicion = false;
        for(Tecnico tecnico1: tecnicos){
            if(tecnico1.getDni().equalsIgnoreCase(tecnico.getDni())){
                condicion = true;
                break;
            }
        }
        return condicion;
    }
}
