package logic_package;

import java.io.Serializable;

public class Pracownik implements Serializable {

    private String imie, nazwisko, dataUrodzenia;
    private DzialPracownikow dzialPracownikow;

    public Pracownik(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow) {
        System.out.println("wywolany dobry konstruktor");
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzialPracownikow = dzialPracownikow;
        if (!Listy.dzialPracownikowList.contains(this.dzialPracownikow))
            Listy.dzialPracownikowList.add(this.dzialPracownikow);
    }

    public Pracownik() {
        this.imie = "jan";
        this.nazwisko = "nieznany";
        this.dataUrodzenia = "19.10.2002";
        this.dzialPracownikow = new DzialPracownikow();
        if (!Listy.dzialPracownikowList.contains(this.dzialPracownikow))
            Listy.dzialPracownikowList.add(this.dzialPracownikow);
    }

    //settery
    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public void setDzialPracownikow(DzialPracownikow dzialPracownikow) {
        this.dzialPracownikow = dzialPracownikow;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    //gettery
    public DzialPracownikow getDzialPracownikow() {
        return dzialPracownikow;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    //toString
    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dzialPracownikow=" + dzialPracownikow +
                '}';
    }
}
