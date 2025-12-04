package proiect;
import java.util.ArrayList;

public class FiltruPret {
    // Returneaza o lista, NU afiseaza direct
    public ArrayList<Object> filtreazaDupaPret(ArrayList<Object> lista, double pretMaxim) {
        ArrayList<Object> listaFiltrata = new ArrayList<>();
        for (Object obj : lista) {
            if (obj instanceof Alimentare) {
                Alimentare produs = (Alimentare) obj;
                if (produs.pret <= pretMaxim) {
                    listaFiltrata.add(produs);
                }
            }
        }
        return listaFiltrata;
    }
}