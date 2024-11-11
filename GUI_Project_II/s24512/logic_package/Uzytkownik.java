package logic_package;

import java.io.Serializable;

public class Uzytkownik extends Pracownik implements Serializable {

    private String login, haslo, inicial;

    public Uzytkownik() {
        super();
        nadajLogin("uzytkownik");
        this.haslo = "haslo";
        setInicial();
    }

    public Uzytkownik(String login, String haslo) {
        super();
        setLogin(login);
        this.haslo = haslo;
        setInicial();
    }

    public Uzytkownik(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        System.out.println("konstruktor uzytkownik + przekazano do pracownik");
        nadajLogin(login);
        System.out.println("nadano login");
        this.haslo = haslo;
        System.out.println("zmieniono haslo");
        setInicial();
        System.out.println("zresetowany inicjal");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(!Listy.loginy.contains(login)){
            this.login=login;
        }else nadajLogin(login);
        Listy.loginy.add(this.login);
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getInicial() {
        return inicial;
    }

    private void setInicial() {
        this.inicial = getImie().substring(0, 1) + getNazwisko().substring(0, 1);
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "imie='" + super.getImie() + '\'' +
                ", nazwisko='" + super.getNazwisko() + '\'' +
                ", dataUrodzenia=" + super.getDataUrodzenia() +
                ", dzialPracownikow=" + super.getDzialPracownikow() +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", inicial='" + inicial + '\'' +
                '}';
    }

    private void nadajLogin(String login){
        String finalLogin = null;
        boolean war=true;
        for(int i = 0 ; war ; i++){
            String temp = login+1;
            if( !Listy.loginy.contains(temp)){
                finalLogin = login+i;
                war = false;
            }
            temp = login;
        }
        setLogin(finalLogin);
    }
}
