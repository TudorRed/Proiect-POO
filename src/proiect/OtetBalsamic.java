package proiect;

class OtetBalsamic extends Alimentare {
    double aciditate;
    String tipStruguri;
    int aniMaturare;

    OtetBalsamic(){
        super();
        this.aciditate = 0;
        this.tipStruguri = "";
        this.aniMaturare = 0;
    }

    OtetBalsamic(String nume, String producator, double pret, double cantitate,
                 String dataExp, boolean bio, String taraOrigine,
                 double aciditate, String tipStruguri, int aniMaturare){
        super(nume, producator, pret, cantitate, dataExp, bio, taraOrigine);
        this.aciditate = aciditate;
        this.tipStruguri = tipStruguri;
        this.aniMaturare = aniMaturare;
    }

    OtetBalsamic(OtetBalsamic o){
        super(o);
        this.aciditate = o.aciditate;
        this.tipStruguri = o.tipStruguri;
        this.aniMaturare = o.aniMaturare;
    }

    void actualizareStoc(Rezultat r){
        System.out.println("S-a vandut " + r.cantitateVanduta + "ml din " + nume);
        stocTotal -= r.cantitateVanduta / 10;
        cantitate = r.cantitateRamasa;
        System.out.println("Stoc ramas " + cantitate + "ml. Total: " + stocTotal);
    }

    void costTransport(Rezultat r){
        double cost = 4.0 * (r.cantitateVanduta / 1000);
        if (aniMaturare > 5) cost += 10;
        System.out.println("Transport otet: " + cost + " lei");
    }

    Rezultat procesare(double cerinta){
        if (cerinta > cantitate){
            System.out.println("Nu e destul " + nume + " pe stoc!");
            return null;
        }
        double pretT = pret * cerinta / 100;
        double ramas = cantitate - cerinta;
        double cost = 4.0 * (cerinta / 1000);
        double prof = pretT * 0.35;
        Rezultat r = new Rezultat(cerinta, pretT, ramas, cost, prof);
        actualizareStoc(r);
        costTransport(r);
        return r;
    }

    public String toString(){
        return super.toString() + " | Aciditate: " + aciditate +
                "% | Struguri: " + tipStruguri + " | Maturare: " + aniMaturare + " ani";
    }
}