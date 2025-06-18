import java.util.Comparator;

public class ComparadorLibros implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.replace("\\s+","").compareToIgnoreCase(o2.replace("\\s+",""));
    }

    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }
}
//st.replaceAll("\\s+","