package s24512;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik>{

    public static List<Pracownik> listaPracownikow = new ArrayList<>();

    String imie,nazwisko,dataUrodzenia,dzial;

    public Pracownik(String imie , String nazwisko , String dataUrodzenia , String dzial){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;


    }

    public Pracownik(){
        this.imie = "Jan";
        this.nazwisko = "Domyslny";
        this.dataUrodzenia = "01.01.1979";
        this.dzial = "kopalnia";
    }

    public void dodajDoListy(Pracownik a){
        listaPracownikow.add(a);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", dzial='" + dzial + '\'' +
                '}';
    }

    public void pokazListePracownikow(){
        System.out.println(listaPracownikow);
    }

    @Override
    public int compareTo(Pracownik o) {
        int result = this.imie.compareTo(o.imie);
        if(result == 0) result = this.nazwisko.compareTo(o.nazwisko);
        if(result == 0) result = this.dataUrodzenia.compareTo(o.dataUrodzenia);
        return result;
    }
}
