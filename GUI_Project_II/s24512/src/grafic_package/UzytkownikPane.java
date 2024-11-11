package grafic_package;

import logic_package.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class UzytkownikPane{

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Uzytkownik> list = new JList<>();
    DefaultListModel<Uzytkownik> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JTextField imieText = new JTextField();
    JTextField nazwiskoText  = new JTextField();
    JTextField dataText = new JTextField();
    JTextField dzialTekst = new JTextField();
    JTextField loginTekst = new JTextField();
    JTextField hasloTekst = new JTextField();

    // C O N S T R U C T O R ################################################################
    public UzytkownikPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Uzytkownik uzytkownik : Listy.uzytkownikList) {
            model.addElement(uzytkownik);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (uzytkownik)");
    }

    public JButton getAddButton() {
        //tworzenie
        JButton add = new JButton("ADD");
        add.setMnemonic(KeyEvent.VK_A);
        add.setToolTipText("alt + a");
        confirmLabel.setVisible(false);
        //ustawianie listenera
        add.addActionListener(e -> {
            setPanelToAdd();
            splitPane.updateUI();
            MainMethod.refreshMainFrame();
            System.out.println("add button clicked (uzytkownik)");
        });
        return add;
    }

    public JButton getEditButton() {
        JButton edit = new JButton("EDIT");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.setToolTipText("alt + e");
        confirmLabel.setVisible(false);
        edit.addActionListener(e -> {
            setPanelToEdit();
            splitPane.updateUI();
        });

        return edit;
    }

    public JButton getRemoveButton() {
        JButton remove = new JButton("REMOVE");
        remove.setToolTipText("alt + r");
        remove.setMnemonic(KeyEvent.VK_R);
        remove.addActionListener(e -> {
            setPanelToRemove();
            splitPane.updateUI();
        });
        return remove;
    }

    private void setPanelToAdd() {
        panel.removeAll();
        panel.updateUI();
        panel.setBackground(Color.gray);

        //imie
        panel.add(new JLabel("Enter name -> "));
        imieText.setPreferredSize(new Dimension(100, 25));
        panel.add(imieText);
        //nazwisko
        panel.add(new JLabel("Enter surename -> "));
        nazwiskoText.setPreferredSize(new Dimension(100, 25));
        panel.add(nazwiskoText);
        //data
        panel.add(new JLabel("Enter birth date -> "));
        dataText.setPreferredSize(new Dimension(100, 25));
        panel.add(dataText);
        //dzial
        panel.add(new JLabel("Enter dzial -> "));
        dzialTekst.setPreferredSize(new Dimension(100, 25));
        panel.add(dzialTekst);
        //login
        panel.add(new JLabel("Enter login -> "));
        loginTekst.setPreferredSize(new Dimension(100,25));
        panel.add(loginTekst);
        //haslo
        panel.add(new JLabel("Enter password -> "));
        hasloTekst.setPreferredSize(new Dimension(100,25));
        panel.add(hasloTekst);
        //other
        panel.add(getSaveButtonToAdd());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (uzytkownik)");
    }

    private void setPanelToEdit() {
        panel.removeAll();
        panel.updateUI();
        panel.setBackground(Color.gray);

        //imie
        panel.add(new JLabel("Enter name -> "));
        imieText.setPreferredSize(new Dimension(100, 25));
        imieText.setText(list.getSelectedValue().getImie());
        panel.add(imieText);
        //nazwisko
        panel.add(new JLabel("Enter surename -> "));
        nazwiskoText.setPreferredSize(new Dimension(100, 25));
        nazwiskoText.setText(list.getSelectedValue().getNazwisko());
        panel.add(nazwiskoText);
        //data
        panel.add(new JLabel("Enter birth date -> "));
        dataText.setPreferredSize(new Dimension(100, 25));
        dataText.setText(list.getSelectedValue().getDataUrodzenia());
        panel.add(dataText);
        //dzial
        panel.add(new JLabel("Enter dzial -> "));
        dzialTekst.setPreferredSize(new Dimension(100, 25));
        dzialTekst.setText(list.getSelectedValue().getDzialPracownikow().getNazwa());
        panel.add(dzialTekst);
        //login
        panel.add(new JLabel("Enter login -> "));
        loginTekst.setPreferredSize(new Dimension(100,25));
        loginTekst.setText(list.getSelectedValue().getLogin());
        panel.add(loginTekst);
        //haslo
        panel.add(new JLabel("Enter password -> "));
        hasloTekst.setPreferredSize(new Dimension(100,25));
        hasloTekst.setText(list.getSelectedValue().getHaslo());
        panel.add(hasloTekst);

        panel.add(getSaveButtonToEdit());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (uzytkownik)");
    }

    private void setPanelToRemove() {
        panel.removeAll();
        panel.updateUI();
        panel.add(getSaveButtonToRemove());
        panel.add(confirmLabel);
        panel.updateUI();
        MainMethod.refreshMainFrame();
    }

    private JButton getSaveButtonToAdd() {
        JButton save = new JButton("SAVE");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alt + enter");
        save.addActionListener(e -> {
            Listy.uzytkownikList.add(new Uzytkownik( imieText.getText() , nazwiskoText.getText() , dataText.getText() , new DzialPracownikow(dzialTekst.getText()) , loginTekst.getText() , hasloTekst.getText()));
            confirmLabel.setVisible(true);
            try {
                FileIO.save();
                System.out.println("saving");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                FileIO.read();
                System.out.println("reading");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            splitPane.updateUI();
        });
        return save;
    }

    private JButton getSaveButtonToEdit() {
        JButton save = new JButton("SAVE");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alr + enter");
        save.addActionListener(e -> {

            for(Uzytkownik uzytkownik : Listy.uzytkownikList){
                if(uzytkownik.equals(list.getSelectedValue())){
                    uzytkownik.setDzialPracownikow(new DzialPracownikow(dzialTekst.getText()));
                    uzytkownik.setNazwisko(nazwiskoText.getText());
                    uzytkownik.setImie(imieText.getText());
                    uzytkownik.setDataUrodzenia(dataText.getText());
                    uzytkownik.setLogin(loginTekst.getText());
                    uzytkownik.setHaslo(hasloTekst.getText());
                }
            }

            try {
                FileIO.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                FileIO.read();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            System.out.println("ZAPISANO");

        });
        return save;
    }

    private JButton getSaveButtonToRemove() {
        JButton save = new JButton("USUN");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alt + enter");
        save.addActionListener(e -> {

            Listy.uzytkownikList.remove(list.getSelectedValue());
            try {
                FileIO.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                FileIO.read();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            splitPane.updateUI();
        });
        return save;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    private void updateAll(){
        panel.updateUI();
        splitPane.updateUI();
        MainMethod.refreshMainFrame();
    }

}
