package logic_package;

import java.io.Serializable;
import java.util.List;

public class Brygadzista extends Uzytkownik implements Serializable {

    private List<Brygada> listaBrygad;

    public Brygadzista() {
        super();
    }

    public Brygadzista(String login, String haslo) {
        super(login, haslo);
    }

    public Brygadzista(String imie, String nazwisko, String dataUrodzenia, DzialPracownikow dzialPracownikow, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow, login, haslo);
    }

    @Override
    public String toString() {
        return "Brygadzista{"  + '\'' +
                "imie=" + getImie()  + '\'' +
                "nazwisko=" + getNazwisko()  + '\'' +
                "listaBrygad=" + listaBrygad +
                '}';
    }

    public void addBrygada(Brygada brygada){
        listaBrygad.add(brygada);
    }

    public List<Brygada> getListaBrygad() {
        return listaBrygad;
    }

    public void removeBrygada(Brygada brygada){
        listaBrygad.remove(brygada);
    }
}
