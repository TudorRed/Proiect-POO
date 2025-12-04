package proiect;
import java.util.ArrayList;

public class FiltruPret {

    // Constructor gol (optional, dar e bine sa fie explicit)
    public FiltruPret() {}

    public void afisareSubPret(ArrayList<Object> lista, double pretMaxim) {
        System.out.println("--- Produse sub " + pretMaxim + " lei ---");
        boolean gasit = false;

        for (Object obj : lista) {
            if (obj instanceof Alimentare) {
                Alimentare produs = (Alimentare) obj;
                if (produs.pret <= pretMaxim) {
                    System.out.println(produs.toString());
                    gasit = true;
                }
            }
        }
        
        if (!gasit) {
            System.out.println("Niciun produs gasit in acest interval de pret.");
        }
    }
}