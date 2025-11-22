package proiect;


interface ProdusAlimentar {
    void afisareDetalii();
    double calculeazaPretFinal();
}

abstract class Alimentare implements ProdusAlimentar {
    static double stocTotal = 10000;

    protected String nume;
    protected String producator;
    protected double pret;
    protected double cantitate;
    protected String dataExp;
    protected boolean bio;
    protected String taraOrigine;

    // Constructor fara argumente
    Alimentare(){
        this.nume = "";
        this.producator = "";
        this.pret = 0;
        this.cantitate = 0;
        this.dataExp = "";
        this.bio = false;
        this.taraOrigine = "";
    }

    // Constructor complet
    Alimentare(String nume, String producator, double pret, double cantitate,
               String dataExp, boolean bio, String taraOrigine){
        this.nume = nume;
        this.producator = producator;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExp = dataExp;
        this.bio = bio;
        this.taraOrigine = taraOrigine;
    }

    // Constructor de copiere
    Alimentare(Alimentare a){
        this.nume = a.nume;
        this.producator = a.producator;
        this.pret = a.pret;
        this.cantitate = a.cantitate;
        this.dataExp = a.dataExp;
        this.bio = a.bio;
        this.taraOrigine = a.taraOrigine;
    }


    abstract void actualizareStoc(Rezultat r);
    abstract void costTransport(Rezultat r);



    @Override
    public void afisareDetalii(){
        System.out.println(this.toString());
    }

    @Override
    public double calculeazaPretFinal(){

        if(bio) return pret * 1.10;
        return pret;
    }

    @Override
    public String toString(){
        return "Produs: " + nume + " | Producator: " + producator +
                " | Pret: " + pret + " lei | Cantitate: " + cantitate + " g/ml" +
                " | Expira: " + dataExp +
                " | Bio: " + (bio ? "Da" : "Nu") +
                " | Tara: " + taraOrigine;
    }
}