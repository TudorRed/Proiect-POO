package proiect;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){



        Condimente c = new Condimente("Piper Negru", "Kamis", 12.5, 500, "08.2025", true, "India", "piper", "boabe", 9);
        Sirop s = new Sirop("Sirop Artar", "MapleJoe", 45, 250, "2028", true, "Canada", "Artar", false, 65, "sticla");


        c.procesare(100);

        System.out.println("Pret final (cu TVA/Bio) pentru Sirop: " + s.calculeazaPretFinal());



        // --- LISTA CONDIMENTE ---
        ArrayList<Object> listaCondimente = new ArrayList<>();
        listaCondimente.add(new Condimente("Piper", "Kamis", 10, 300, "2025", false, "India", "piper", "macinat", 7));
        listaCondimente.add(new Condimente("Boia", "Cosmin", 8, 250, "2026", false, "Romania", "boia", "dulce", 5));
        listaCondimente.add(new Condimente("Curry", "Kamis", 15, 200, "2025", true, "India", "curry", "pudra", 9));
        listaCondimente.add(new Condimente("Ghimbir", "Kotanyi", 18, 150, "2026", false, "China", "ghimbir", "pudra", 6));
        listaCondimente.add(new Condimente("Chimion", "Cosmin", 9, 180, "2025", false, "Turcia", "chimion", "macinat", 6));
        listaCondimente.add(new Condimente("Busuioc", "Kotanyi", 11, 120, "2026", true, "Italia", "busuioc", "frunze", 4));
        listaCondimente.add(new Condimente("Oregano", "Kotanyi", 13, 140, "2026", true, "Grecia", "oregano", "frunze", 5));
        listaCondimente.add(new Condimente("Chili", "Kamis", 17, 160, "2025", false, "Mexic", "chili", "pudra", 8));
        listaCondimente.add(new Condimente("Scortisoara", "Kotanyi", 20, 200, "2026", true, "Vietnam", "scortisoara", "pudra", 7));
        listaCondimente.add(new Condimente("Coriandru", "Cosmin", 12, 190, "2025", false, "India", "coriandru", "boabe", 6));

        // --- LISTA OTET ---
        ArrayList<Object> listaOtet = new ArrayList<>();
        listaOtet.add(new OtetBalsamic("Balsamic 1", "Ponti", 22, 700, "2027", false, "Italia", 6, "struguri rosii", 5));
        listaOtet.add(new OtetBalsamic("Balsamic 2", "Monari", 30, 500, "2028", true, "Italia", 6.5, "struguri albi", 8));
        listaOtet.add(new OtetBalsamic("Balsamic 3", "Fini", 28, 600, "2027", false, "Italia", 6, "struguri rosii", 6));
        listaOtet.add(new OtetBalsamic("Balsamic 4", "Ponti", 26, 400, "2028", false, "Italia", 5.5, "struguri rosii", 4));
        listaOtet.add(new OtetBalsamic("Balsamic 5", "Monari", 35, 900, "2029", true, "Italia", 7, "struguri albi", 10));
        listaOtet.add(new OtetBalsamic("Balsamic 6", "Ponti", 20, 800, "2027", false, "Italia", 5, "struguri rosii", 3));
        listaOtet.add(new OtetBalsamic("Balsamic 7", "Fini", 40, 750, "2030", true, "Italia", 6.8, "struguri rosii", 12));
        listaOtet.add(new OtetBalsamic("Balsamic 8", "Ponti", 18, 650, "2026", false, "Italia", 5.2, "struguri rosii", 4));
        listaOtet.add(new OtetBalsamic("Balsamic 9", "Monari", 42, 550, "2030", true, "Italia", 7.1, "struguri albi", 15));
        listaOtet.add(new OtetBalsamic("Balsamic 10", "Fini", 24, 600, "2028", false, "Italia", 5.8, "struguri rosii", 7));

        // --- LISTA SIROPURI  ---
        ArrayList<Object> listaSirop = new ArrayList<>();
        listaSirop.add(new Sirop("Sirop Artar", "MapleJoe", 45, 250, "2028", true, "Canada", "Artar", false, 65, "sticla"));
        listaSirop.add(new Sirop("Sirop tuse", "Meltus", 25, 100, "2026", false, "Romania", "Plante", true, 40, "plastic"));
        listaSirop.add(new Sirop("Sirop Zmeura", "Yo", 15, 700, "2025", false, "Austria", "Zmeura", false, 55, "sticla"));
        listaSirop.add(new Sirop("Sirop Agave", "DmBio", 30, 300, "2027", true, "Mexic", "Agave", false, 70, "sticla"));
        listaSirop.add(new Sirop("Sirop Visine", "Laurul", 12, 1000, "2025", false, "Romania", "Visine", false, 60, "plastic"));
        listaSirop.add(new Sirop("Sirop Patlagina", "Fares", 18, 150, "2026", true, "Romania", "Patlagina", true, 35, "sticla"));
        listaSirop.add(new Sirop("Sirop Ciocolata", "Monin", 28, 500, "2026", false, "Franta", "Ciocolata", false, 62, "sticla"));
        listaSirop.add(new Sirop("Sirop Menta", "Yo", 16, 700, "2025", false, "Austria", "Menta", false, 50, "plastic"));
        listaSirop.add(new Sirop("Sirop Soc", "DaciaPlant", 14, 500, "2025", true, "Romania", "Soc", false, 45, "sticla"));
        listaSirop.add(new Sirop("Sirop Caramel", "Monin", 29, 500, "2026", false, "Franta", "Caramel", false, 64, "sticla"));

        // --- LISTA DULCEATA  ---
        ArrayList<Object> listaDulceata = new ArrayList<>();
        listaDulceata.add(new Dulceata("Dulceata Visine", "Raureni", 15, 350, "2027", false, "Romania", "Visine", 45, false, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Capsuni", "Bun de Tot", 22, 300, "2026", true, "Romania", "Capsuni", 70, true, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Afine", "Topoloveni", 25, 350, "2027", true, "Romania", "Afine", 100, true, "borcan"));
        listaDulceata.add(new Dulceata("Marmelada", "Magiun", 18, 400, "2026", false, "Romania", "Prune", 80, false, "cutie"));
        listaDulceata.add(new Dulceata("Dulceata Caise", "Raureni", 14, 350, "2027", false, "Romania", "Caise", 45, false, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Ardei Iute", "Camara", 30, 200, "2026", true, "Romania", "Ardei iute", 60, true, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Smochine", "Olympia", 19, 300, "2028", false, "Grecia", "Smochine", 50, false, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Zmeura", "Raureni", 16, 350, "2027", false, "Romania", "Zmeura", 45, false, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Gutui", "Bunica", 13, 370, "2026", false, "Romania", "Gutui", 40, false, "borcan"));
        listaDulceata.add(new Dulceata("Dulceata Mure", "Topoloveni", 24, 350, "2027", true, "Romania", "Mure", 100, true, "borcan"));

        System.out.println("\n=== CONDIMENTE ===");
        for(Object o : listaCondimente) { System.out.println(o); }

        System.out.println("\n=== OTET BALSAMIC ===");
        for(Object o : listaOtet) { System.out.println(o); }

        System.out.println("\n=== SIROPURI ===");
        for(Object o : listaSirop) { System.out.println(o); }

        System.out.println("\n=== DULCETURI ===");
        for(Object o : listaDulceata) { System.out.println(o); }
    }
}