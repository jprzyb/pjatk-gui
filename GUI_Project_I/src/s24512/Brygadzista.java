package s24512;

import java.util.ArrayList;
import java.util.List;

public class Brygadzista extends Uzytkownik{

    List<Brygada> listaBrygadBrygadzisty = new ArrayList<>();

    public Brygadzista(String login, String haslo, String imie, String nazwisko, String dataUrodzenia , String dzial){
        super(login,haslo,imie,nazwisko,dataUrodzenia,dzial);
    }

    public Brygadzista(){
        super();
    }

    public void showListaBrygadBrygadzisty(){
        System.out.println("# Lista brygad brygadzisty " + this.imie + ": " + "\n" + listaBrygadBrygadzisty);
    }



    @Override
    public String toString() {
        return "Brygadzista{" +
                "listaBrygadBrygadzisty=" + listaBrygadBrygadzisty +
                ",\nimie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", dzial='" + dzial + '\'' +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", inicial='" + inicial + '\'' +
                '}';
    }


}
