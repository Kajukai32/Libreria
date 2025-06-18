import java.util.Map;
import java.util.TreeMap;

public class Libreria {
    private final String nombre;
    private final Map<String, Integer> libros = new TreeMap<>(new ComparadorLibros());

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLibros() {
        return libros.toString();
    }

    public void agregarLibros(String nombreLibro, Integer cantDisponible) {

        libros.put(nombreLibro, cantDisponible);
    }

    public void actualizarStockLibro(String key, Integer cantVendida) throws LibroNoExisteExeption, StockInsuficienteExeption {

        if (checkLibro(key)) {
            Integer stock = libros.get(key);
            if (stock > cantVendida) {
                agregarLibros(key, stock - cantVendida);
            } else throw new StockInsuficienteExeption();
        } else throw new LibroNoExisteExeption();

    }


    public boolean checkLibro(String nombre) {
        return libros.containsKey(nombre);
    }

    public Integer getLibro(String key) throws LibroNoExisteExeption {
        if (checkLibro(key)) {
            return libros.get(key);
        } else throw new LibroNoExisteExeption();
    }

    public void eliminarLibro(String key) throws LibroNoExisteExeption {
        if (checkLibro(key)) {
            libros.remove(key);
        } else throw new LibroNoExisteExeption();
    }
}
