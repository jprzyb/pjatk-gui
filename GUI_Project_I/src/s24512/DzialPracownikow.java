package s24512;

import java.util.Arrays;
import java.util.Objects;

public class DzialPracownikow {

    private String []nazwa = new String[1];

    public String creatDzial (String nowaNazwa) throws NotUniqueNameException{
        if(!sprawdzNazwe(nowaNazwa)) throw new NotUniqueNameException("Nazwa nie jest unikalna");//sprawdzenie warunku dla NotUniquenameException
        else{
            String []temp = new String[nazwa.length];//deklaracja tymczasowej tablicy
            System.arraycopy(nazwa, 0, temp, 0, nazwa.length);//przypisanie tablicy nazwa do tablicy tymczasowej
            nazwa = new String[temp.length+1];//wydlozenie tablicy pierwotnej
            System.arraycopy(temp, 0, nazwa, 0, temp.length);//przypisanie tablicy tymczasowej do pierwotnej
            nazwa[nazwa.length-1] = nowaNazwa;//dodanie nowej nazwy
        }
        return nazwa[nazwa.length-1];//zwrocenie nazwy dodanego dzialu
    }

    private boolean sprawdzNazwe(String nowaNazwa){//sprawdzenie czy nazwa jest unikalna
        for (String s : nazwa)
            if (Objects.equals(nowaNazwa, s)) {
                return false;
            }
        return true;
    }

    public String getDzialName(int a){//tablica name jest prywatna wiec pobrac dane z niej mozna za pomoca tej metody
    if(a > nazwa.length-1) {
        System.out.println("nie ma takiego dzialu. Zwracam ostatni mozliwy");
        return nazwa[nazwa.length-1];
    }
    return nazwa[a];
    }

    @Override
    public String toString() {
        return "DzialPracownikow{" +
                "nazwa=" + Arrays.toString(nazwa) +
                '}';
    }
}