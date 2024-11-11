package test_package;

import java.io.Serializable;

public class Klasa implements Serializable {

    String nazwa;
    int liczba;

    public Klasa(String nazwa, int liczba) {
        this.nazwa = nazwa;
        this.liczba = liczba;
        dodajDoListy();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public void dodajDoListy(Klasa this){
//        MyLists lists = new MyLists();
//        lists.lista.add(this);
    }

    @Override
    public String toString() {
        return "Klasa{" +
                "nazwa='" + nazwa + '\'' +
                ", liczba=" + liczba +
                '}';
    }
}
