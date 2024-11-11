package s24512;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) { //START OF MAIN

// Klasa DzialPracownikow
        oddziel("DzialPracownikow");
        lekkoOddziel("Dodawanie działow");
        DzialPracownikow dzialPracownikow = new DzialPracownikow(); //zadeklarowane dla qrzystkich klas dziedziczacych po klasie Pracownik
        try{
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("kopalnia")); // dodaje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("zarzad")); // dodaje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("obsluga")); // dodaje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("informatyka")); // dodaje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("energetyka")); // dodaje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("kopalnia"));//zatrzymuje
            System.out.println("Dodano dzial: " + dzialPracownikow.creatDzial("ochrona"));//nie wykonuje
        }
        catch (NotUniqueNameException e){
            e.showException();
        }

//Klasa Kopacz
        oddziel("Kopacz");
        lekkoOddziel("Wywolanie konstruktorow");
        Kopacz kopaczFull = new Kopacz("mlotek" , "Kopacz" , "Pelny" , "01.01.1981" , dzialPracownikow.getDzialName(2));//wywolanie konstruktora ze wszystkimi parametrami
        kopaczFull.dodajDoListy(kopaczFull); //dodanie do listy pracownikow
        System.out.println(kopaczFull);
        Kopacz kopaczOkrojony = new Kopacz("kilof"); //wywolanie konstruktora z parametrem narzedzie
        kopaczOkrojony.dodajDoListy(kopaczOkrojony); //dodanie do listy pracownikow
        System.out.println(kopaczOkrojony);
        Kopacz kopaczNull = new Kopacz(); //wywolanie konstuktora bez parametrow
        kopaczNull.dodajDoListy(kopaczNull);  //dodanie do listy pracownikow
        System.out.println(kopaczNull);

        lekkoOddziel("Aktualna lista pracownikow");
        kopaczNull.pokazListePracownikow(); // nie ma roznicy ktorego kopacza uzyje lista zawsze bedzie taka sama (sprawdzalem)

        lekkoOddziel("Porownanie kopaczy (liczba >0 wskazuje na wyzszosc pierwszego pracownika , liczba 0 wskazuje na rownosc pracownikow , liczba <0 wskazuje na mniejszosc pierwszego pracownika):\nFull vs Null ->\t" + kopaczFull.compareTo(kopaczNull) + "\nNull vs Okrojony ->\t" + kopaczNull.compareTo(kopaczOkrojony) + "\nFull vs Okrojony ->\t" + kopaczFull.compareTo(kopaczOkrojony) );

//Klasa Specjalista
        oddziel("Specjalista");
        lekkoOddziel("Wywolanie konstruktorow (+ dodanie do listy)");
        Specjalista specjalistaFull = new Specjalista("row" , "Arkadiusz" , "Specjalny" , "20.04.2420" , dzialPracownikow.getDzialName(2)); //wywolanie konstruktora ze wszystkimi parametrami
        specjalistaFull.dodajDoListy(specjalistaFull); //dodanie do listy pracownikow
        System.out.println(specjalistaFull);
        Specjalista specjalistaOkrojony= new Specjalista("murarz,tynkarz,akrobata");//wywolanie konstruktora z jednym parametrem
        specjalistaOkrojony.dodajDoListy(specjalistaOkrojony); //dodanie do listy pracownikow
        System.out.println(specjalistaOkrojony);
        Specjalista specjalistaNull = new Specjalista();
        specjalistaNull.dodajDoListy(specjalistaNull); //dodanie do listy pracownikow
        System.out.println(specjalistaNull);

        lekkoOddziel("Aktualna lista pracownikow");
        kopaczNull.pokazListePracownikow(); // wywolanie listy (pokazuje takze specjalistow

//klasa Uzytkownik
        oddziel("Uzytkownik");
        lekkoOddziel("Wywolanie konstruktorow (+ dodanie do listy)");
        Uzytkownik uzytkownikFull = new Uzytkownik("SwinkaMorska123" , "MamKawie321" , "Zbyszek" , "Uzytkowy" , "30.02.2022" , dzialPracownikow.getDzialName(10)); //wywolanie konstruktora ze wszytkimi parametrami
        uzytkownikFull.dodajDoListy(uzytkownikFull); //dodanie do listy pracownikow
        System.out.println(uzytkownikFull);
        Uzytkownik uzytkownikOkrojony = new Uzytkownik("BezLoginu99" , "BezHasla12321");//wywolanie konstruktora z samym loginem i haslem
        uzytkownikOkrojony.dodajDoListy(uzytkownikOkrojony); //dodanie do listy pracownikow
        System.out.println(uzytkownikOkrojony);
        Uzytkownik uzytkownikNull = new Uzytkownik();
        uzytkownikNull.dodajDoListy(uzytkownikNull); //dodanie do listy pracownikow
        System.out.println(uzytkownikNull);

        lekkoOddziel("Wowolanie zmiany imienia");
        uzytkownikNull.setImie("Zmienny");
        System.out.println(uzytkownikNull);
        lekkoOddziel("Wowolanie zmiany nazwiska");
        uzytkownikNull.setNazwisko("Zmieniony");
        System.out.println(uzytkownikNull);
        lekkoOddziel("Dowod zmiany");
        specjalistaNull.pokazListePracownikow(); // dowod ze OBIEKT zostal zmieniony, poniewaz zmienil sie on takze na liscie

//Klasa Brygadzista oraz Brygada
        oddziel("Klasa Brygadzista oraz Brygada");
        lekkoOddziel("Wywolanie konstruktorow Brygadzistow");
        Brygadzista brygadzistaFull = new Brygadzista("Jan" , "Pan" , "Jan" , "Pan" , "0.0.0000" , dzialPracownikow.getDzialName(0));
        specjalistaFull.dodajDoListy(brygadzistaFull); // dodanie do listy pracownikow
        System.out.println(brygadzistaFull);
        Brygadzista brygadzistaNull = new Brygadzista();
        specjalistaFull.dodajDoListy(brygadzistaNull); //dodanie do listy pracownikow
        System.out.println(brygadzistaNull);
        brygadzistaFull.dodajDoListy(kopaczFull); //dodanie do listy pracownikow
        System.out.println(brygadzistaFull);

        lekkoOddziel("Wywolanie konstruktorow Brygad");
        Brygada brygada = new Brygada("HARMIDER", brygadzistaFull);
        lekkoOddziel("Dodawanie pracownika do listy");
        brygada.dodajPracownika(kopaczFull); // dodanie pojedynczego pracownika do listy pracownikow w klasie Brygada
        System.out.println(brygada); // w liscie powinien znajdowac sie tylko jeden pracownik
        lekkoOddziel("Dodanie listy do listy pracownikow");
        List<Pracownik> tempList = new ArrayList<>(); // stworzenie tymczasowej listy pracownikow
        tempList.add(specjalistaFull); tempList.add(kopaczFull); tempList.add(uzytkownikOkrojony); // dodanie pracownikow do listy
        brygada.dodajPracownika(tempList); // dodanie listy pracownikow do listy pracownikow w klasie Brygada
        System.out.println(brygada); // w liscie powinno znajdowac sie 4 pracownikow

//Klasa Praca
        oddziel("Klasa Praca");
        RodzajPracy rodzajPracy = RodzajPracy.MONTAZ;
        List <Praca> praca = new ArrayList<>();

        lekkoOddziel("Wywoalnie konstruktora oraz dodanie ich do listy prac");
        Praca temp = new Praca(rodzajPracy , 6 , "Montaz nadwozia"); praca.add(temp);
        temp.map.put(temp.numerPracy , temp);
        rodzajPracy = RodzajPracy.OGOLNA;
        temp = new Praca(rodzajPracy , 10 , "Ogolne praca remontowe"); praca.add(temp);
        temp.map.put(temp.numerPracy , temp);
        rodzajPracy = RodzajPracy.DEMONTAZ;
        temp = new Praca(rodzajPracy , 1 , "Demontaz szyby"); praca.add(temp);
        temp.map.put(temp.numerPracy , temp);

        System.out.println(praca.toString());

//Klasa Zlecenie
        oddziel("Klasa Zlecenie");
        lekkoOddziel("Wywolanie konstruktorow");
        Zlecenie zlecenie1 = new Zlecenie(true); //wywyolanie pierwszego konstruktora
        zlecenie1.map.put(zlecenie1.numerZlecenia , zlecenie1);
        System.out.println("#1 " + zlecenie1.toString());
        Zlecenie zlecenie2 = new Zlecenie(true , false , false , brygada); //wywyolanie drugiego konstruktora
        zlecenie2.map.put(zlecenie2.numerZlecenia , zlecenie2);
        System.out.println("#2 " + zlecenie2.toString());
        Zlecenie zlecenie3 = new Zlecenie(true , true , false , praca); //wywyolanie trzeciego konstruktora
        zlecenie3.map.put(zlecenie3.numerZlecenia , zlecenie3);
        System.out.println("#3 " + zlecenie3.toString());
        Zlecenie zlecenie4= new Zlecenie(true , true, true , praca , brygada); //wywyolanie czwartego konstruktora
        zlecenie4.map.put(zlecenie4.numerZlecenia , zlecenie4);
        System.out.println("#4 " + zlecenie4.toString());

        lekkoOddziel("Dodanie pracy oraz brygady do zlecenia nr1");
        zlecenie1.dodajPrace(new Praca( RodzajPracy.OGOLNA, 1 , "Stukanie mlotkiem o blache zeby brygadzista sie nie zorientowal ze nic nie robie" )); // dodanie pracy
        if(zlecenie1.dodajBrygade(new Brygada("Specjalini.inc" , brygadzistaFull))){ // dodanie brygady do zlecenia bez niej i wykorzystanie wartosci zwracanej przez metode "dodajBrygade"
            System.out.println("Dodano brygade!");
        }
        else System.out.println("Zlecenie ma juz przydzielona brygade!");
        lekkoOddziel("dodanie brygady do zlecenia nr2, ktore juz ja posiada");
        if(zlecenie2.dodajBrygade(new Brygada("Specjalini.inc" , brygadzistaFull))){ // dodanie brygady do zlecenia, ktore juz ja ma i wykorzystanie wartosci zwracanej przez metode "dodajBrygade"
            System.out.println("Dodano brygade!");
        }
        else System.out.println("Zlecenie ma juz przydzielona brygade!");

        lekkoOddziel("zlecenie nr1 (po dodaniu brygady oraz pracy)");
        System.out.println(zlecenie1.toString());

        lekkoOddziel("wykonanie zlecenia nr4 za pomoca metody rozpocznijZlecenie");
        zlecenie4.rozpocznijZlecenie();

        lekkoOddziel("Pozyskanie zlecenia po jego numerze");
        System.out.println(zlecenie1.getZlecenie());

        lekkoOddziel("Pozyskanie pracy po jej numerze");
        System.out.println(temp.getPraca());

    }// END OF MAIN

    public static void oddziel(String xxx){
        System.out.println("\n===================================\n" + xxx + "\n===================================");
    } //funkcja kosmetyczna
    public static void lekkoOddziel(String xxx){
        System.out.println("\n\t# " + xxx);
    } //funkcja kosmetyczna

}