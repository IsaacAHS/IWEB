import java.lang.reflect.Array;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Biblioteca {
    Scanner scanner=new Scanner(System.in);
    Libro[][]estanteLibros;
    ArrayList<Usuario>listaUsuarios;

    public Biblioteca(Libro[][] estanteLibros, ArrayList<Usuario> listaUsuarios) {
        this.estanteLibros = estanteLibros;
        this.listaUsuarios = listaUsuarios;
    }

    public void agregarUsuario(Usuario usuario){
        for(Usuario user:listaUsuarios){
            if(user.getCodigoPUCP()==usuario.getCodigoPUCP()){
                System.out.println("El ID de usuario ya está en uso. Intente con otro.");
                return;
            }
        }listaUsuarios.add(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    public void agregarLibroEstante(Libro libro,int fila,int columna){
        if(estanteLibros[fila][columna]==null){
            libro.setDisponibilidad(true);
            estanteLibros[fila][columna]=libro;
            System.out.println("Libro agregado al estante con éxito.");
        }else{
            System.out.println("La posición ingresada está ocupada por un libro.");
        }
    }

    public void prestarLibro(Libro libro,Usuario usuario){
        if(usuario.getRegistroLibros().isEmpty()){
            if(libro.isDisponibilidad()){
                libro.setDisponibilidad(false);
                usuario.getRegistroLibros().add(libro);
            }else {
                System.out.println("El libro ya ha sido prestado, por lo que no se puede prestar a " + usuario.getNombre());
            }
        }else{
            System.out.println("El usuario ya tiene un libro prestado y no puede tomar otro.");
        }
    }

    public void devolverLibro(Libro libro,Usuario usuario){
        if (!libro.isDisponibilidad()){
            if(!usuario.getRegistroLibros().isEmpty()){
                for(Libro book: usuario.getRegistroLibros()){
                    if(libro==book){
                        libro.setDisponibilidad(true);
                        usuario.getRegistroLibros().remove(libro);
                        System.out.println("El libro '"+ libro.getTitulo()+"' ha sido devuelto por "+usuario.getNombre());
                        return;
                    }
                }
                System.out.println("No se puede devolver el libro, ya que no está prestado a este usuario.");
            }
        }else{
            System.out.println("El libro está disponible en el estante.");
        }
    }

    public void mostrarUsuarios(){
        System.out.println("Usuarios y libros prestados:");
        for(Usuario usuario:listaUsuarios){
            System.out.println(usuario.getNombre()+" (ID: "+usuario.getCodigoPUCP()+")");
            if(usuario.getRegistroLibros().isEmpty()){
                System.out.println("- Ningún libro prestado.");
            }else{
                for(Libro libro:usuario.getRegistroLibros()){
                    System.out.println("- "+libro.getTitulo());
                }
            }
        }
    }

    public void librosDisponiblesPrestados(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(estanteLibros[i][j]==null){
                    System.out.print("| Vacío ");
                }else{
                    if(estanteLibros[i][j].isDisponibilidad()){
                        System.out.print("| "+estanteLibros[i][j].getTitulo()+" (Disponible) ");
                    }else{
                        System.out.print("| "+estanteLibros[i][j].getTitulo()+" (No disponible) ");
                    }
                }

            }
            System.out.print("|\n");
        }
    }

    public void mostrarLibros(){
        System.out.println("Libros disponibles: ");
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(!(estanteLibros[i][j]==null)){
                    if(estanteLibros[i][j].isDisponibilidad()){
                        System.out.println("Título: "+estanteLibros[i][j].getTitulo()+" | Autor: "+estanteLibros[i][j].getAutor()+" | ISBN: "+estanteLibros[i][j].getISBN());
                    }
                }
            }
        }
    }
}
