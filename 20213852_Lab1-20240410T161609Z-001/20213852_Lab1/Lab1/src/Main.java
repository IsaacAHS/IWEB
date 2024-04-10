import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libro[][]estanteLibros=new Libro[7][7];
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        Biblioteca biblioteca=new Biblioteca(estanteLibros,listaUsuarios);
        main:while(true){
            System.out.print("--- Menú de la Biblioteca ---\n1. Agregar usuario\n2. Agregar libro\n3. Prestar libro\n4. Devolver libro\n5. Mostrar libros disponibles\n6. Mostrar usuarios y libros prestados\n7. Estante\nSeleccione una opción: ");
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    Usuario newUser=new Usuario();
                    System.out.print("Nombre del usuario: ");
                    newUser.setNombre(scanner.nextLine());
                    System.out.print("Código PUCP: ");
                    newUser.setCodigoPUCP(Integer.parseInt(scanner.nextLine()));
                    biblioteca.agregarUsuario(newUser);
                    break;
                case 2:
                    Libro newBook=new Libro();
                    System.out.print("Título del libro: ");
                    newBook.setTitulo(scanner.nextLine());
                    System.out.print("Autor del libro: ");
                    newBook.setAutor(scanner.nextLine());
                    System.out.print("ISBN del libro: ");
                    newBook.setISBN(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Fila en el estante (0-7): ");
                    int fila=Integer.parseInt(scanner.nextLine());
                    System.out.print("Columna en el estante (0-7): ");
                    int columna=Integer.parseInt(scanner.nextLine());
                    biblioteca.agregarLibroEstante(newBook,fila,columna);
                    break;
                case 3:
                    System.out.print("ID del usuario: ");
                    int ID=Integer.parseInt(scanner.nextLine());
                    Usuario userFound=new Usuario();
                    userFound.setNombre("");
                    for(Usuario usuario: biblioteca.listaUsuarios){
                        if(usuario.getCodigoPUCP()==ID){
                            userFound.setNombre(usuario.getNombre());
                            userFound.setCodigoPUCP(usuario.getCodigoPUCP());
                            userFound.setRegistroLibros(usuario.getRegistroLibros());
                            break;
                        }
                    }
                    if(userFound.getNombre().equals("")){
                        System.out.println("El usuario indicado no está registrado.");
                    }else{
                        System.out.println("ISBN del libro a prestar: ");
                        int ISBN=Integer.parseInt(scanner.nextLine());
                        aux:for(int i=0;i<7;i++){
                            for(int j=0;j<7;j++){
                                if(biblioteca.estanteLibros[i][j]!=null){
                                    if(biblioteca.estanteLibros[i][j].getISBN()==ISBN) {
                                        biblioteca.prestarLibro(biblioteca.estanteLibros[i][j], userFound);
                                        break aux;
                                    }
                                }
                            }
                        }
                    }break;
                case 4:
                    System.out.print("ID del usuario: ");
                    int ID2=Integer.parseInt(scanner.nextLine());
                    Usuario userFound2=new Usuario();
                    userFound2.setNombre("");
                    for(Usuario usuario: biblioteca.listaUsuarios){
                        if(usuario.getCodigoPUCP()==ID2){
                            userFound2.setNombre(usuario.getNombre());
                            userFound2.setCodigoPUCP(usuario.getCodigoPUCP());
                            userFound2.setRegistroLibros(usuario.getRegistroLibros());
                            break;
                        }
                    }
                    if(userFound2.getNombre()==""){
                        System.out.println("El usuario indicado no está registrado.");
                    }else{
                        System.out.println("ISBN del libro a prestar: ");
                        int ISBN2=Integer.parseInt(scanner.nextLine());
                        for(int i=0;i<7;i++){
                            for(int j=0;j<7;j++){
                                if(biblioteca.estanteLibros[i][j]!=null){
                                    if(biblioteca.estanteLibros[i][j].getISBN()==ISBN2){
                                        biblioteca.devolverLibro(biblioteca.estanteLibros[i][j],userFound2);
                                        continue main;
                                    }
                                }
                            }
                        }
                        System.out.println("El ISBN no corresponde a ningún libro registrado.");
                    }break;
                case 5:
                    biblioteca.mostrarLibros();
                    break;
                case 6:
                    biblioteca.mostrarUsuarios();
                    break;
                case 7:
                    biblioteca.librosDisponiblesPrestados();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta.");
                    break;
            }
        }

    }
}