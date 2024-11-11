package logic_package;

import java.io.Serializable;

public class Praca implements Serializable {

    private static int numeryPrac = 0;
    private int numerPracy;
    private RodzajPracy rodzajPracy;
    private int czasPracy;
    private boolean czZrealizowane;
    private String opis;

    public Praca(RodzajPracy rodzajPracy, int czasPracy, boolean czZrealizowane, String opis) {
        this.rodzajPracy = rodzajPracy;
        this.czasPracy = czasPracy;
        this.czZrealizowane = czZrealizowane;
        this.opis = opis;
        this.numerPracy = numeryPrac+1;
        numeryPrac++;
    }

    public Praca() {
        this.rodzajPracy = RodzajPracy.OGOLNA;
        this.czasPracy = (int) (Math.random() * 500) + 30;
        this.czZrealizowane = false;
        this.opis = null;
        this.numerPracy = numeryPrac+1;
        numeryPrac++;
    }

    public int getNumerPracy() {
        return numerPracy;
    }

    public RodzajPracy getRodzajPracy() {
        return rodzajPracy;
    }

    public int getCzasPracy() {
        return czasPracy;
    }

    public boolean isCzZrealizowane() {
        return czZrealizowane;
    }

    public String getOpis() {
        return opis;
    }

    public void setRodzajPracy(RodzajPracy rodzajPracy) {
        this.rodzajPracy = rodzajPracy;
    }

    public void setCzasPracy(int czasPracy) {
        this.czasPracy = czasPracy;
    }

    public void setCzZrealizowane(boolean czZrealizowane) {
        this.czZrealizowane = czZrealizowane;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Praca{" +
                "numerPracy=" + numerPracy +
                ", rodzajPracy=" + rodzajPracy +
                ", czasPracy=" + czasPracy +
                ", czZrealizowane=" + czZrealizowane +
                ", opis='" + opis + '\'' +
                '}';
    }
}
