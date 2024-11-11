package s24512;

public class Uzytkownik extends Pracownik {

    String login,haslo,inicial;

    public Uzytkownik(String login, String haslo, String imie, String nazwisko, String dataUrodzenia, String dzial) {

        super(imie , nazwisko , dataUrodzenia , dzial);

        this.login = login;
        this.haslo = haslo;
        setInicjal();
    }

    public Uzytkownik(String login, String haslo){
        this.login = login;
        this.haslo = haslo;
        setInicjal();
    }

    public Uzytkownik(){
        super();
        this.login = "loginDomyslny";
        this.haslo = "HasloMaslo";
        setInicjal();
    }

    private void setInicjal(){
         this.inicial = imie.charAt(0) + nazwisko.substring(0,1);
    }

    public void setImie(String imie){
        super.imie = imie;
        setInicjal();
    }

    public void setNazwisko(String nazwisko){
        super.nazwisko = nazwisko;
        setInicjal();
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", dzial='" + dzial + '\'' +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", inicial='" + inicial + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pracownik o) {
        return super.compareTo(o);
    }
}
