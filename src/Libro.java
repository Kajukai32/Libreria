public class Libro implements Comparable<Libro> {

    private final String nombre;
    private Integer cantDisp;

    public Libro(String nombre, Integer cantDisp) {
        this.nombre = nombre;
        this.cantDisp = cantDisp;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(Integer cantDisp) {
        this.cantDisp = cantDisp;
    }

    @Override
    public int compareTo(Libro o) {
        return this.getCantDisp().compareTo(o.getCantDisp());
    }
}
