package proiect;
import java.util.ArrayList;

public class FiltruTara {
    public ArrayList<Object> filtreazaDupaTara(ArrayList<Object> lista, String taraCautata) {
        ArrayList<Object> listaFiltrata = new ArrayList<>();
        for (Object obj : lista) {
            if (obj instanceof Alimentare) {
                Alimentare produs = (Alimentare) obj;
                if (produs.taraOrigine.equalsIgnoreCase(taraCautata)) {
                    listaFiltrata.add(produs);
                }
            }
        }
        return listaFiltrata;
    }
}