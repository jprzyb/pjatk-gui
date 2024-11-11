package logic_package;

import java.io.*;
import java.util.List;

public class FileIO {

    private static String dzialPath = "dzialPracownikow.bin" , pracownikPath = "pracownik.bin" , uzytkownikPath = "uzytkownik.bin",
            brygadzistaPath = "brygadzista.bin" , brygadaPath = "brygada.bin" , zleceniePath = "zlecenie.bin" , pracaPath = "praca.bin",
            nazwyDzialowPath = "nazwyDzialow.bin" , nazwyBrygadPath = "nazwyBrygad.bin" , loginyPath = "loginy.bin";

    public static void save() throws IOException {

        savingDzial(Listy.dzialPracownikowList , dzialPath);
        savingPracownik(Listy.pracownikList , pracownikPath);
        savingUzytkownik(Listy.uzytkownikList , uzytkownikPath);
        savingBrygadzista(Listy.brygadzistaList , brygadzistaPath);
        savingBrygada(Listy.brygadaList , brygadaPath);
        savingZlecenie(Listy.zlecenieList , zleceniePath);
        savingPraca(Listy.pracaList , pracaPath);
        savingString(Listy.nazwyDzialow , nazwyDzialowPath);
        savingString(Listy.nazwyBrygad , nazwyBrygadPath);
        savingString(Listy.loginy , loginyPath);

    }
    public static void savingDzial(List<DzialPracownikow> list, String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingPracownik(List<Pracownik> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingUzytkownik(List<Uzytkownik> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingBrygadzista(List<Brygadzista> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingBrygada(List<Brygada> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingPraca(List<Praca> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void savingZlecenie(List<Zlecenie> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }
    public static void  savingString(List<String> list , String path) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        try{
            output.writeObject(list);
            output.flush();
        }finally {
            if(output!=null) output.close();
        }
    }

    public static void read() throws IOException, ClassNotFoundException {
        readDzial(dzialPath);
        readPracownik(pracownikPath);
        readUzytkownik(uzytkownikPath);
        readBrygadzista(brygadzistaPath);
        readBrygada(brygadaPath);
        readZlecenie(zleceniePath);
        readPraca(pracaPath);
        readDzialName(nazwyDzialowPath);
        readNazwyBrygad(nazwyBrygadPath);
        readloginy(loginyPath);
    }
    private static void readDzial(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.dzialPracownikowList = (List<DzialPracownikow>) (in.readObject());
    }
    private static void readPracownik(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.pracownikList = (List<Pracownik>) (in.readObject());
    }
    private static void readUzytkownik(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.uzytkownikList = (List<Uzytkownik>) (in.readObject());
    }
    private static void readBrygadzista(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.brygadzistaList = (List<Brygadzista>) (in.readObject());
    }
    private static void readBrygada(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.brygadaList = (List<Brygada>) (in.readObject());
    }
    private static void readZlecenie(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.zlecenieList = (List<Zlecenie>) (in.readObject());
    }
    private static void readPraca(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.pracaList = (List<Praca>) (in.readObject());
    }
    private static void readDzialName(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.nazwyDzialow = (List<String>) (in.readObject());
    }
    private static void readloginy(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.loginy = (List<String>) (in.readObject());
    }
    private static void readNazwyBrygad(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Listy.nazwyBrygad = (List<String>) (in.readObject());
    }
}
