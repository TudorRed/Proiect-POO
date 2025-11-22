package proiect;

class Dulceata extends Alimentare {
    protected String fruct;
    protected double procent_zahar;
    protected boolean fara_conservanti;
    protected String tip_ambalaj;

    Dulceata(){
        super();
        this.fruct = "";
        this.procent_zahar = 0;
        this.fara_conservanti = false;
        this.tip_ambalaj = "";
    }

    Dulceata(String nume, String producator, double pret, double cantitate,
             String dataExp, boolean bio, String taraOrigine,
             String fruct, double procent_zahar, boolean fara_conservanti, String tip_ambalaj){
        super(nume, producator, pret, cantitate, dataExp, bio, taraOrigine);
        this.fruct = fruct;
        this.procent_zahar = procent_zahar;
        this.fara_conservanti = fara_conservanti;
        this.tip_ambalaj = tip_ambalaj;
    }

    Dulceata(Dulceata d){
        super(d);
        this.fruct = d.fruct;
        this.procent_zahar = d.procent_zahar;
        this.fara_conservanti = d.fara_conservanti;
        this.tip_ambalaj = d.tip_ambalaj;
    }

    @Override
    public double calculeazaPretFinal(){
        double pret_baza = super.calculeazaPretFinal();
        if(fara_conservanti) pret_baza *= 1.08;
        if(procent_zahar < 40) pret_baza *= 1.05;
        return pret_baza;
    }


    void actualizareStoc(Rezultat r){
        System.out.println("S-au vandut " + r.cantitateVanduta + "g dulceata " + nume);
        stocTotal -= r.cantitateVanduta;
        cantitate = r.cantitateRamasa;
    }

    void costTransport(Rezultat r){
        double cost = 3.0 * (r.cantitateVanduta / 1000);
        System.out.println("Transport dulceata (" + tip_ambalaj + "): " + cost + " lei");
    }

    // Metoda de procesare
    Rezultat procesare(double cerinta){
        if (cerinta > cantitate) { System.out.println("Stoc insuficient " + nume); return null; }
        double pretT = pret * cerinta / 100;
        Rezultat r = new Rezultat(cerinta, pretT, cantitate - cerinta, 3.0, pretT * 0.2);
        actualizareStoc(r);
        costTransport(r);
        return r;
    }

    @Override
    public String toString(){
        return super.toString() +
                " | Fruct: " + fruct +
                " | Zahar: " + procent_zahar + "%" +
                " | Fara conservanti: " + (fara_conservanti ? "Da" : "Nu") +
                " | Ambalaj: " + tip_ambalaj;
    }
}