package proiect;

class Condimente extends Alimentare {
    String tip;
    String forma;
    int intensitate;

    Condimente(){
        super();
        this.tip = "";
        this.forma = "";
        this.intensitate = 0;
    }

    Condimente(String nume, String producator, double pret, double cantitate,
               String dataExp, boolean bio, String taraOrigine,
               String tip, String forma, int intensitate){
        super(nume, producator, pret, cantitate, dataExp, bio, taraOrigine);
        this.tip = tip;
        this.forma = forma;
        this.intensitate = intensitate;
    }

    Condimente(Condimente c){
        super(c);
        this.tip = c.tip;
        this.forma = c.forma;
        this.intensitate = c.intensitate;
    }

    void actualizareStoc(Rezultat r){
        System.out.println("S-au vandut " + r.cantitateVanduta + "g din " + nume);
        stocTotal -= r.cantitateVanduta;
        cantitate = r.cantitateRamasa;
        System.out.println("Stoc ramas " + cantitate + "g. Stoc total: " + stocTotal);
    }

    void costTransport(Rezultat r){
        double cost = 2.5 * (r.cantitateVanduta / 1000);
        System.out.println("Transport condimente: " + cost + " lei");
    }

    Rezultat procesare(double cerinta){
        if (cerinta > cantitate){
            System.out.println("Nu e destul " + nume + " pe stoc!");
            return null;
        }
        double pretT = pret * cerinta / 100;
        double ramas = cantitate - cerinta;
        double cost = 2.5 * (cerinta / 1000);
        double prof = pretT * 0.25;
        Rezultat r = new Rezultat(cerinta, pretT, ramas, cost, prof);
        actualizareStoc(r);
        costTransport(r);
        return r;
    }

    public String toString(){
        return super.toString() + " | Tip: " + tip + " | Forma: " + forma +
                " | Intensitate: " + intensitate;
    }
}