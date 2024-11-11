package grafic_package;

import logic_package.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainMethod {

    public static boolean isLogged = false;
    private static LogIn login = new LogIn();
    private static MainFrame mainFrame = new MainFrame();
    public static String inicjal;

    public static void changeFrames() {
        if (!isLogged) {
            System.out.println(mainFrame.inicjalZalogowanego);
            mainFrame.setInicjalZalogowanego(inicjal);
            mainFrame.show();
            login.show();
        } else {
            System.out.println(mainFrame.inicjalZalogowanego);
            mainFrame.setInicjalZalogowanego(inicjal);
            login.show();
            mainFrame.show();
        }
    }

    public static void firstShow() {
        login.show();
    }

    public static void refreshMainFrame() {
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }

    public static void firstStart() throws IOException, ClassNotFoundException {
        showInformationFrame();
        File f = new File("uzytkownik.bin");
        if (!f.exists()) {
            System.out.println("pliki nie istnieja");
            makeFiles();
        } else {
            System.out.println("pliki istnieja");
            FileIO.read();
        }
    }

    private static void makeFiles() throws IOException, ClassNotFoundException {
        DzialPracownikow dzialPracownikow = new DzialPracownikow();
        Listy.dzialPracownikowList.add(dzialPracownikow);

        Pracownik pracownik = new Pracownik();
        Listy.pracownikList.add(pracownik);

        Uzytkownik uzytkownik = new Uzytkownik("admin", "admin");
        Listy.uzytkownikList.add(uzytkownik);

        Brygadzista brygadzista = new Brygadzista();
        Listy.brygadzistaList.add(brygadzista);

        Brygada brygada = new Brygada();
        Listy.brygadaList.add(brygada);

        Praca praca = new Praca();
        Listy.pracaList.add(praca);

        Zlecenie zlecenie = new Zlecenie();
        Listy.zlecenieList.add(zlecenie);

        FileIO.save();
        FileIO.read();
    }

    private static void showInformationFrame() {
        JFrame frame = new JFrame("Witaj w moim programie");
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridLayout(4, 0, 10, 10));
        panel.setBackground(Color.pink);

        panel.add(new JLabel("Gdybyœ nieznal lub zapomnial hasla") , BorderLayout.CENTER);
        panel.add(new JLabel("zawsze mozesz zalogowaæ siê na"));
        panel.add(new JLabel("login: 'admin' "));
        panel.add(new JLabel("haslo: 'admin' "));

        frame.add(panel , BorderLayout.CENTER);
    }
}
