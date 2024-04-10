import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PokemonManager pokemonManager = new PokemonManager();
        ArrayList<Pokemon> pokemones = new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        boolean estado= true;
        while(estado){
            System.out.println("-----------------------------------------------");
            System.out.println("Bienvenido al sistema de registro Pokemon");
            System.out.println("Indique la acción que desea realizar:");
            System.out.println("1.Capturar Pokemon");
            System.out.println("2.Listar Pokemon");
            System.out.println("3.Buscar Pokemon");
            System.out.println("4.Imprimir Resumen");
            System.out.println("5.Salir");
            System.out.print("Seleccione una opcion: ");
            switch(Integer.parseInt(scanner.nextLine())){
                case 1:
                    System.out.println("\n Capturar Pokemon");
                    System.out.println("-------------------------------");
                    pokemonManager.capturarPokemon(pokemones);
                    break;
                case 2:
                    System.out.println("\n Listar Pokemon");
                    System.out.println("-------------------------------");
                    pokemonManager.listarPokemon();
                    break;
                case 3:
                    System.out.println("\n Buscar Pokemon");
                    System.out.println("-------------------------------");
                    pokemonManager.buscarPokemon();
                    break;
                case 4:
                    System.out.println("\n Imprimir Resumen");
                    System.out.println("-------------------------------");
                    pokemonManager.imprimirResumen();
                    break;
                case 5:
                    estado=false;
                    System.out.println(" --- Cerrando Programa ---");
                    break;
                default:
                    System.out.println("Ingrese una opción correcta.");
                    break;
            }

        }
    }
}