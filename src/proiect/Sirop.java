package proiect;

class Sirop extends Alimentare {

    protected String aroma;
    protected boolean contine_zahar;
    protected int procent_fruct;
    protected String tip_recipient;

    Sirop(){
        super();
        this.aroma = "";
        this.contine_zahar = false;
        this.procent_fruct = 0;
        this.tip_recipient = "";
    }

    Sirop(String nume, String producator, double pret, double cantitate,
          String dataExp, boolean bio, String taraOrigine,
          String aroma, boolean contine_zahar, int procent_fruct, String tip_recipient){
        super(nume, producator, pret, cantitate, dataExp, bio, taraOrigine);
        this.aroma = aroma;
        this.contine_zahar = contine_zahar;
        this.procent_fruct = procent_fruct;
        this.tip_recipient = tip_recipient;
    }

    Sirop(Sirop s){
        super(s);
        this.aroma = s.aroma;
        this.contine_zahar = s.contine_zahar;
        this.procent_fruct = s.procent_fruct;
        this.tip_recipient = s.tip_recipient;
    }


    @Override
    public double calculeazaPretFinal(){
        double pret_baza = super.calculeazaPretFinal();
        if(!contine_zahar) pret_baza *= 1.05;
        if(procent_fruct > 70) pret_baza *= 1.10;
        return pret_baza;
    }


    void actualizareStoc(Rezultat r){
        System.out.println("S-au vandut " + r.cantitateVanduta + "ml sirop " + nume);
        stocTotal -= r.cantitateVanduta / 10;
        cantitate = r.cantitateRamasa;
    }

    void costTransport(Rezultat r){
        double cost = 5.0 * (r.cantitateVanduta / 1000);
        System.out.println("Transport sirop (" + tip_recipient + "): " + cost + " lei");
    }


    Rezultat procesare(double cerinta){
        if (cerinta > cantitate) { System.out.println("Stoc insuficient " + nume); return null; }
        double pretT = pret * cerinta / 100;
        Rezultat r = new Rezultat(cerinta, pretT, cantitate - cerinta, 5.0, pretT * 0.3);
        actualizareStoc(r);
        costTransport(r);
        return r;
    }

    @Override
    public String toString(){
        return super.toString() +
                " | Aroma: " + aroma +
                " | Cu zahar: " + (contine_zahar ? "Da" : "Nu") +
                " | Fruct: " + procent_fruct + "%" +
                " | Recipient: " + tip_recipient;
    }
}