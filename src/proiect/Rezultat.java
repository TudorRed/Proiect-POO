package proiect;


public class Rezultat {
    protected double cantitateVanduta;
    protected double pretTotal;
    protected double cantitateRamasa;
    protected double costLivrare;
    protected double profit;

    Rezultat(double cantitateVanduta, double pretTotal, double cantitateRamasa,
             double costLivrare, double profit){
        this.cantitateVanduta = cantitateVanduta;
        this.pretTotal = pretTotal;
        this.cantitateRamasa = cantitateRamasa;
        this.costLivrare = costLivrare;
        this.profit = profit;
    }
}