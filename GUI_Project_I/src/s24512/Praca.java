package s24512;

import java.util.HashMap;
import java.util.Scanner;

public class Praca extends Thread implements Runnable{

    private static int iloscPrac = 0;
    public static HashMap<Integer , Praca> map = new HashMap<>();
    int numerPracy;
    RodzajPracy rodzajPracy;
    int czasPracy;
    boolean czyZreazlizowane;
    String opis;

    public Praca (RodzajPracy rodzajPracy , int czasPracy , String opis){
        this.rodzajPracy =rodzajPracy;
        this.czasPracy = czasPracy;
        this.opis = opis;
        this.numerPracy = iloscPrac+1; iloscPrac++;
        this.czyZreazlizowane = false;
    }

    public static Praca getPraca(){
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Podaj numer pracy, ktora chcesz pozyskac: "); n = scanner.nextInt();

        return map.get(n);
    }

    @Override
    public String toString() {
        return "Praca{" +
                "numerPracy=" + numerPracy +
                ", rodzajPracy=" + rodzajPracy +
                ", czasPracy=" + czasPracy +
                ", czyZreazlizowane=" + czyZreazlizowane +
                ", opis='" + opis + '\'' +
                '}';
    }
}
