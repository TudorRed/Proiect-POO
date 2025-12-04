package proiect;
import java.util.ArrayList;

public class FiltruTara {

    public FiltruTara() {}

    public void afisareDinTara(ArrayList<Object> lista, String taraCautata) {
        System.out.println("--- Produse din " + taraCautata + " ---");
        boolean gasit = false;

        for (Object obj : lista) {
            if (obj instanceof Alimentare) {
                Alimentare produs = (Alimentare) obj;
                // Folosim equalsIgnoreCase ca sa gaseasca si "romania" si "Romania"
                if (produs.taraOrigine.equalsIgnoreCase(taraCautata)) {
                    System.out.println(produs.toString());
                    gasit = true;
                }
            }
        }

        if (!gasit) {
            System.out.println("Nu s-au gasit produse din " + taraCautata + ".");
        }
    }
}