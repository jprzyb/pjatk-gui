package grafic_package;

import logic_package.DzialPracownikow;
import logic_package.FileIO;
import logic_package.Listy;
import logic_package.Pracownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class PracownikPane {

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Pracownik> list = new JList<>();
    DefaultListModel<Pracownik> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JTextField imieText = new JTextField();
    JTextField nazwiskoText  = new JTextField();
    JTextField dataText = new JTextField();
    JTextField dzialTekst = new JTextField();

    // C O N S T R U C T O R ################################################################
    public PracownikPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Pracownik pracownik : Listy.pracownikList) {
            model.addElement(pracownik);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (pracownik)");
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
            System.out.println("add button clicked (pracownik)");
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

        panel.add(getSaveButtonToAdd());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (pracownik)");
    }

    private void setPanelToEdit() {
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

        panel.add(getSaveButtonToEdit());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (pracownik)");
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
        JButton save = new JButton("ADD");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alt + enter");
        save.addActionListener(e -> {
            Listy.pracownikList.add(new Pracownik( imieText.getText() , nazwiskoText.getText() , dataText.getText() , new DzialPracownikow(dzialTekst.getText())));
            confirmLabel.setVisible(true);
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

    private JButton getSaveButtonToEdit() {
        JButton save = new JButton("SAVE");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alr + enter");
        save.addActionListener(e -> {

            for(Pracownik pracownik : Listy.pracownikList){
                if(pracownik.equals(list.getSelectedValue())){
                    pracownik.setDzialPracownikow(new DzialPracownikow(dzialTekst.getText()));
                    pracownik.setNazwisko(nazwiskoText.getText());
                    pracownik.setImie(imieText.getText());
                    pracownik.setDataUrodzenia(dataText.getText());
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

            Listy.pracownikList.remove(list.getSelectedValue());
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
