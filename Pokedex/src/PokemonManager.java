import java.util.ArrayList;
import java.util.Scanner;
public class PokemonManager {
    private ArrayList<Pokemon> bolsa =new ArrayList<Pokemon>();
    private Pokemon[] pokedex= new Pokemon[150];
    private int contadorBolsa=0;
    private int contadorPokedex=0;


    public void capturarPokemon(ArrayList<Pokemon> bolsa){
        Scanner scanner = new Scanner(System.in);
        Pokemon pokemon = new Pokemon();

        System.out.print("Ingrese la información del Pokemon\n");
        System.out.print("Número: ");
        pokemon.setNumero(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nombre: ");
        pokemon.setNombre(scanner.nextLine());

        System.out.print("Seleccione Tipo\n");
        System.out.print("1. Agua\n2. Bicho\n3. Dragon\n4. Planta\n5. Fuego\n6. Otro\n");
        System.out.print("Opcion:");
        switch(Integer.parseInt(scanner.nextLine())){
            case 1:
                pokemon.setTipo("Agua");
                break;
            case 2:
                pokemon.setTipo("Bicho");
                break;
            case 3:
                pokemon.setTipo("Dragon");
                break;
            case 4:
                pokemon.setTipo("Planta");
                break;
            case 5:
                pokemon.setTipo("Fuego");
                break;
            case 6:
                System.out.print("Ingrese nuevo tipo: ");
                pokemon.setTipo(scanner.nextLine());
                break;
            default:
                System.out.print("Opcion no valida");
                break;
        }
        System.out.print("Peso: ");
        pokemon.setPeso(Double.parseDouble(scanner.nextLine()));

        System.out.print("Altura: ");
        pokemon.setAltura(Double.parseDouble(scanner.nextLine()));

        System.out.print("PS: ");
        pokemon.setPs(Integer.parseInt(scanner.nextLine()));

        System.out.print("===Se registró un nuevo pokemon===\n");
    }
    public void registrarPokedex(Pokemon pokemon){
        boolean estado= true;
        for (int i=0; i<contadorPokedex; i++){
            if (pokedex[i].getNumero() == pokemon.getNumero()){
                estado=false;
                if (pokedex[i].getPs()< pokemon.getPs()){
                    pokedex[i] = pokemon;
                }
                break;
            }
        }
        if (estado){
            if(contadorPokedex<150){
                pokedex[contadorPokedex++]=pokemon;
            }else{
                System.out.print("La pokedex esta llena");
            }
        }



    }
    public void listarPokemon(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione Lista\n");
        System.out.print("1. Bolsa\n2. Pokedex\n");
        System.out.println("Opcion: ");
        switch(Integer.parseInt(scanner.nextLine())){
            case 1:

            case 2:
        }



    }
    public void buscarPokemon(){

    }
    public void imprimirResumen(){

    }
}
