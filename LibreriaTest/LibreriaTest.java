import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

    Libreria libreria = new Libreria("PFI");

    @Test
    public void crearLibroValido() {

        Libro l1 = new Libro("Corazon Delator", 15);
        Libro l2 = new Libro("Duma Key", 12);
        Libro l3 = new Libro("Tormenta de Espadas", 3);
        Assert.assertEquals(Integer.valueOf(3), l3.getCantDisp());
    }

    @Test
    public void libreriaValida() {
        Libreria libreria = new Libreria("PFI");
        Assert.assertEquals("PFI", libreria.getNombre());
    }

    //    1. Agregar un libro nuevo al inventario con su cantidad inicial.
    @Test
    public void agregarLibroValido() {

        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);

        Assert.assertEquals("{Corazon Delator=15, Diario de un Zombie=15, Duma Key=15}", libreria.getLibros());
    }

    @Test
    public void saberSiUnLibroExisteTest() {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);

        Assert.assertEquals(true, libreria.checkLibro("Duma Key"));

    }

    // 2. Actualizar el stock de un libro existente (sumar o restar cantidad).
    @Test
    public void actualizarStockLibroValido() throws Exception {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);
        libreria.actualizarStockLibro("Corazon Delator", 12);

        Assert.assertEquals(Integer.valueOf(3), libreria.getLibro("Corazon Delator"));
    }

    @Test(expected = LibroNoExisteExeption.class)
    public void actualizarStockLibroInValido() throws Exception {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);
        libreria.actualizarStockLibro("Corazon Delator", 12);

        Assert.assertEquals(Integer.valueOf(3), libreria.getLibro("Corzon Delator"));
    }

    @Test(expected = StockInsuficienteExeption.class)
    public void actualizarStockInvalidoLibro() throws Exception {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);

        libreria.actualizarStockLibro("Corazon Delator", 30);

        Assert.assertEquals(Integer.valueOf(3), libreria.getLibro("Corazon Delator"));
    }

    @Test(expected = LibroNoExisteExeption.class)
    public void eliminarUnLibroInvalidoTest() throws LibroNoExisteExeption {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);

        libreria.eliminarLibro(" ");
    }

    @Test
    public void eliminarUnLibroTest() throws LibroNoExisteExeption {
        Libreria libreria = new Libreria("PFI");

        libreria.agregarLibros("Corazon Delator", 15);
        libreria.agregarLibros("Duma Key", 15);
        libreria.agregarLibros("Diario de un Zombie", 15);

        libreria.eliminarLibro("Duma Key");
        Assert.assertEquals("{Corazon Delator=15, Diario de un Zombie=15}", libreria.getLibros());
    }
}
//Se desea construir un sistema simple de gestión de stock para una tienda de libros.
// Cada libro tiene un nombre (String) y un stock (cantidad disponible, Integer).
// El sistema debe permitir:
// 1. Agregar un libro nuevo al inventario con su cantidad inicial.
// 2. Actualizar el stock de un libro existente (sumar o restar cantidad).
// 3. Consultar la cantidad disponible de un libro.
// 4. Eliminar un libro del inventario.
// 5. Verificar si un libro está disponible (stock > 0).
// 6. (Extra) Obtener todos los libros disponibles (stock > 0).