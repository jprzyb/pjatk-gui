package s24512;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Zlecenie {
//POLA
    public static HashMap<Integer ,Zlecenie> map = new HashMap<>();
    public static int iloscZlecen=0;
    public int numerZlecenia;
    public StanZlecenia stanZlecenia;
    public List<Praca> listaPrac = new ArrayList<>();
    Brygada brygada;
    LocalDateTime dataUtworzenia;
    LocalDateTime dataRealizacji;
    LocalDateTime dataZakonczenia = LocalDateTime.now();
//KONSTRUKTORY
    //#1
    public Zlecenie(boolean czyPlanowany){
        if(czyPlanowany) this.stanZlecenia = StanZlecenia.PLANOWANE;
        else this.stanZlecenia = StanZlecenia.NIEPLANOWANE;
        this.numerZlecenia = iloscZlecen+1; iloscZlecen++;
        //this.brygada = new Brygada("brygadaPierwszaZlecenie", new Brygadzista());
        this.dataUtworzenia = LocalDateTime.now().minusDays(124);
        this.dataRealizacji = LocalDateTime.now().plusDays(17);
        this.dataZakonczenia = LocalDateTime.now().plusDays(30);
    }
    //#2
    public Zlecenie(boolean czyPlanowany , boolean czyRealizowny , boolean czyZakonczony, Brygada brygada){
        if (czyZakonczony) stanZlecenia = StanZlecenia.ZAKONCZONE;
        else if (czyRealizowny) stanZlecenia = StanZlecenia.REALIZOWANE;
        else if (czyPlanowany) stanZlecenia = StanZlecenia.PLANOWANE;
        else stanZlecenia = stanZlecenia.NIEPLANOWANE;
        this.numerZlecenia = iloscZlecen+1; iloscZlecen++;
        this.brygada = brygada;
        this.dataUtworzenia = LocalDateTime.now().minusDays(94);
    }
    //#3
    public Zlecenie(boolean czyPlanowany , boolean czyRealizowny , boolean czyZakonczony, List<Praca> listaPrac){
        if (czyZakonczony) stanZlecenia = StanZlecenia.ZAKONCZONE;
        else if (czyRealizowny) stanZlecenia = StanZlecenia.REALIZOWANE;
        else if (czyPlanowany) stanZlecenia = StanZlecenia.PLANOWANE;
        else stanZlecenia = stanZlecenia.NIEPLANOWANE;
        this.listaPrac = listaPrac;
        this.numerZlecenia = iloscZlecen+1; iloscZlecen++;
        this.brygada = new Brygada("ZlecenieKonstruktor3" , new Brygadzista());
        this.dataUtworzenia = LocalDateTime.now().minusDays(20);

    }
    //#4
    public Zlecenie(boolean czyPlanowany , boolean czyRealizowny , boolean czyZakonczony, List<Praca> listaPrac , Brygada brygada){
        if (czyZakonczony) stanZlecenia = StanZlecenia.ZAKONCZONE;
        else if (czyRealizowny) stanZlecenia = StanZlecenia.REALIZOWANE;
        else if (czyPlanowany) stanZlecenia = StanZlecenia.PLANOWANE;
        else stanZlecenia = StanZlecenia.NIEPLANOWANE;
        this.listaPrac = listaPrac;
        this.numerZlecenia = iloscZlecen+1; iloscZlecen++;
        this.brygada = brygada;
        this.dataUtworzenia = LocalDateTime.now().minusDays(420);
    }

    public void dodajPrace(Praca praca){
        listaPrac.add(praca);
        System.out.println("Dodano prace");
    }

    public boolean dodajBrygade(Brygada brygada){
        if(this.brygada == null){
            this.brygada = brygada;
            return true;
        }
        else return false;
    }

    public void rozpocznijZlecenie(){
        if(brygada != null && listaPrac != null){

            for (Praca praca : listaPrac) {
                System.out.println("Wykonuje prace. Oto jej dane: " + praca.toString());
                dataRealizacji = LocalDateTime.now();
                praca.czyZreazlizowane = true;
            }
        }
        else System.out.println("Zlecenie nie moze byc wykonane!\t(brak przydzielonej brygady lub lista prac jest pusta)");
        dataZakonczenia = LocalDateTime.now();
    }

    public static Zlecenie getZlecenie(){

        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj numer zlecenia, ktore chcesz pozyskac: "); n = scanner.nextInt();

        return map.get(n);
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "numerZlecenia=" + numerZlecenia +
                ", stanZlecenia=" + stanZlecenia +
                ", listaPrac=" + listaPrac +
                ", brygada=" + brygada +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataRealizacji=" + dataRealizacji +
                ", dataZakonczenia=" + dataZakonczenia +
                '}';
    }
}
