import java.sql.SQLData;
import java.util.HashSet;

public class Usuario {
    private String nombre;
    private int codigoPUCP;
    private HashSet<Libro> registroLibros=new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(int codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public HashSet<Libro> getRegistroLibros() {
        return registroLibros;
    }

    public void setRegistroLibros(HashSet<Libro> registroLibros) {
        this.registroLibros = registroLibros;
    }
}
