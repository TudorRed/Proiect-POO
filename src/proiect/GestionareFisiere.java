package proiect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestionareFisiere {

    public void scrieInFisier(ArrayList<Object> lista, String numeFisier) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            
            writer.write("=== RAPORT SALVARE DATE ===\n");
            writer.write("Numar produse: " + lista.size() + "\n\n");

            for (Object obj : lista) {
       
                writer.write(obj.toString());
                writer.newLine(); 
                writer.write("--------------------------------------------------"); 
                writer.newLine();
            }

            System.out.println("Succes: Datele au fost salvate in fisierul '" + numeFisier + "'");

        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul " + numeFisier);
            e.printStackTrace();
        }
    }
}