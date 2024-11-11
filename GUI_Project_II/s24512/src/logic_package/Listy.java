package logic_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Listy implements Serializable {

    public static List<DzialPracownikow> dzialPracownikowList = new ArrayList<>();
    public static List<String> nazwyDzialow = new ArrayList<>();
    public static List<Pracownik> pracownikList = new ArrayList<>();
    public static List<Uzytkownik> uzytkownikList = new ArrayList<>();
    public static List<String> loginy = new ArrayList<>();
    public static List<Brygadzista> brygadzistaList = new ArrayList<>();
    public static List<Brygada> brygadaList = new ArrayList<>();
    public static List<String> nazwyBrygad = new ArrayList<>();
    public static List<Zlecenie> zlecenieList = new ArrayList<>();
    public static List<Praca> pracaList = new ArrayList<>();

    @Override
    public String toString() {
        return "Listy{" +
                "dzialPracownikowList=" + dzialPracownikowList +
                ", nazwyDzialow=" + nazwyDzialow +
                ", pracownikList=" + pracownikList +
                ", uzytkownikList=" + uzytkownikList +
                ", loginy=" + loginy +
                ", brygadzistaList=" + brygadzistaList +
                ", brygadaList=" + brygadaList +
                ", nazwyBrygad=" + nazwyBrygad +
                ", zlecenieList=" + zlecenieList +
                ", pracaList=" + pracaList +
                '}';
    }
}
