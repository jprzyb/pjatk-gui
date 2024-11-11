package grafic_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private JFrame frame;
    private JPanel upperPanel, centerPanel;
    private JButton dzialPracownikowMenu, pracownikMenu, uzytkownikMenu, brygadzistaMenu, brygadaMenu, pracaMenu, zlecenieMenu, wylogujMenu;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel inicjalLabel;
    public String inicjalZalogowanego;


    public MainFrame() {
        inicjalize();
    }

    private void inicjalize() {
//Frame
        frame = new JFrame();
        frame.setTitle("Main menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
//inicjal
        inicjalLabel = new JLabel(inicjalZalogowanego);
        inicjalLabel.setForeground(Color.yellow);
        inicjalZalogowanego = "XYZ";
//upperPanel
        upperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        upperPanel.setBackground(Color.darkGray);
//JButton's making
        dzialPracownikowMenu = new JButton("Dzialy Pracownikow");
        dzialPracownikowMenu.setMnemonic(KeyEvent.VK_1);
        dzialPracownikowMenu.setToolTipText("alt + 1");
        pracownikMenu = new JButton("Pracownicy");
        pracownikMenu.setMnemonic(KeyEvent.VK_2);
        pracownikMenu.setToolTipText("alt + 2");
        uzytkownikMenu = new JButton("Uzytkownicy");
        uzytkownikMenu.setMnemonic(KeyEvent.VK_3);
        uzytkownikMenu.setToolTipText("alt + 3");
        brygadzistaMenu = new JButton("Brygadzisci");
        brygadzistaMenu.setMnemonic(KeyEvent.VK_4);
        brygadzistaMenu.setToolTipText("alt + 4");
        brygadaMenu = new JButton("Brygady");
        brygadaMenu.setMnemonic(KeyEvent.VK_5);
        brygadaMenu.setToolTipText("alt + 5");
        pracaMenu = new JButton("Prace");
        pracaMenu.setMnemonic(KeyEvent.VK_6);
        pracaMenu.setToolTipText("alt + 6");
        zlecenieMenu = new JButton("Zlecenia");
        zlecenieMenu.setMnemonic(KeyEvent.VK_7);
        zlecenieMenu.setToolTipText("alt + 7");
        wylogujMenu = new JButton("Wyloguj");
        wylogujMenu.setMnemonic(KeyEvent.VK_0);
        wylogujMenu.setToolTipText("alt + 0");
        setButtonsAcctionListeners();
// adding buttons to upperPanel
        upperPanel.add(dzialPracownikowMenu);
        upperPanel.add(pracownikMenu);
        upperPanel.add(uzytkownikMenu);
        upperPanel.add(brygadzistaMenu);
        upperPanel.add(brygadaMenu);
        upperPanel.add(pracaMenu);
        upperPanel.add(zlecenieMenu);
        upperPanel.add(inicjalLabel);
        upperPanel.add(wylogujMenu);
//centerPanel and picture
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centerPanel.setBackground(Color.white);
        image = new ImageIcon("welcome2.jpg");
        imageLabel = new JLabel(image);
        centerPanel.add(imageLabel);
        setAll();
    }

    public void show() {
        frame.setVisible(!frame.isVisible());
    }

    private void setButtonsAcctionListeners() {
        wylogujMenu.addActionListener(e -> MainMethod.changeFrames());
        dzialPracownikowMenu.addActionListener(e -> showActionFrameForDzialPracownikow());
        pracownikMenu.addActionListener(e -> showActionFrameForPracownik());
        uzytkownikMenu.addActionListener(e -> showActionFrameForUzytkownik());
        brygadzistaMenu.addActionListener(e -> showActionFrameForBrygadzista());
        brygadaMenu.addActionListener(e -> showActionFrameForBrygada());
        zlecenieMenu.addActionListener(e -> showActionFrameForZlecenie());
        pracaMenu.addActionListener(e -> showActionFrameForPraca());
    }

    public void setAll() {
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(frame);
        System.out.println("DOne");
    }

    private void showActionFrameForDzialPracownikow() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        DzialPracownikowPane dzialPracownikowPane = new DzialPracownikowPane();

        JFrame jFrame = new JFrame("Dzial Pracownikow");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private void showActionFrameForPracownik() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        PracownikPane dzialPracownikowPane = new PracownikPane();

        JFrame jFrame = new JFrame("Pracownik");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private void showActionFrameForUzytkownik() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        UzytkownikPane dzialPracownikowPane = new UzytkownikPane();

        JFrame jFrame = new JFrame("Uzytkownik");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private void showActionFrameForBrygadzista() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        BrygadzistaPane dzialPracownikowPane = new BrygadzistaPane();

        JFrame jFrame = new JFrame("Brygadzista");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private void showActionFrameForBrygada() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        BrygadaPane dzialPracownikowPane = new BrygadaPane();

        JFrame jFrame = new JFrame("Brygada");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private void showActionFrameForZlecenie() {
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        ZleceniePane dzialPracownikowPane = new ZleceniePane();

        JFrame jFrame = new JFrame("Zlecenia");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }
    private void showActionFrameForPraca(){
        JPanel leftPanel = new JPanel();
        centerPanel.removeAll();
        leftPanel.removeAll();
        frame.remove(centerPanel);

        PracaPane dzialPracownikowPane = new PracaPane();

        JFrame jFrame = new JFrame("Zlecenia");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(new Dimension(500, 400));
        jFrame.add(leftPanel, BorderLayout.NORTH);


        leftPanel.add(dzialPracownikowPane.getAddButton());
        leftPanel.add(dzialPracownikowPane.getEditButton());
        leftPanel.add(dzialPracownikowPane.getRemoveButton());
        jFrame.add(dzialPracownikowPane.getSplitPane(), BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    public void setInicjalZalogowanego(String a){
        a = a.toUpperCase();
        inicjalZalogowanego = a;
        inicjalLabel.setText("Witaj, " + inicjalZalogowanego +"!");
        SwingUtilities.updateComponentTreeUI(inicjalLabel);
    }
}


