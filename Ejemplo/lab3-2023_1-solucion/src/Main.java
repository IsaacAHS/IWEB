import beans.Equipo;
import beans.Tecnico;
import controller.AppController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppController appController = new AppController();
        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        boolean estado = true;
        while(estado){
            switch (Main.menuPrincipal()){
                case "1":
                    System.out.println("\n Registrar Nuevo Equipo");
                    System.out.println("-------------------------------");
                    appController.registrarNuevoEquipo(equipos);
                    break;
                case "2":
                    System.out.println("\n Registrar Nuevo Tecnico");
                    System.out.println("-------------------------------");
                    appController.registrarNuevoTecnico(tecnicos);
                    break;
                case"3":
                    System.out.println("\n Listar Equipos");
                    System.out.println("-------------------------------");
                    appController.listarEquipos(equipos);
                    break;
                case"4":
                    System.out.println("\n Lista Tecnicos X Salario");
                    System.out.println("-------------------------------");
                    appController.listarTecnicosXSalario(tecnicos);
                    break;
                case "9":
                    estado = false;
                    System.out.println(" --- Cerrando Programa ---");
                    break;
                default:
                    System.out.println("\n Ingrese una opcion valida");
                    break;
            }
        }
    }

    public static String menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|              Menu                       |");
        System.out.println("| 1 <- Registrar Nuevo Equipo             |");
        System.out.println("| 2 <- Registrar Nuevo Tecnico            |");
        System.out.println("| 3 <- Listar Equipos                     |");
        System.out.println("| 4 <- Listar Tecnicos x Salario          |");
        System.out.println("| 9 <- Salir                              |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("Ingrese opcion: ");
        return scanner.nextLine();
    }
}