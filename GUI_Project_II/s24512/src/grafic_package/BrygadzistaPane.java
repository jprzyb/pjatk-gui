package grafic_package;

import logic_package.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class BrygadzistaPane {

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Brygadzista> list = new JList<>();
    DefaultListModel<Brygadzista> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JTextField imieText = new JTextField();
    JTextField nazwiskoText = new JTextField();
    JTextField dataText = new JTextField();
    JTextField dzialTekst = new JTextField();
    JTextField loginTekst = new JTextField();
    JTextField hasloTekst = new JTextField();

    // C O N S T R U C T O R ################################################################
    public BrygadzistaPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Brygadzista brygadzista : Listy.brygadzistaList) {
            model.addElement(brygadzista);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (brygadzista)");
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
            System.out.println("add button clicked (brygadzista)");
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
        loginTekst.setPreferredSize(new Dimension(100, 25));
        panel.add(loginTekst);
        //haslo
        panel.add(new JLabel("Enter password -> "));
        hasloTekst.setPreferredSize(new Dimension(100, 25));
        panel.add(hasloTekst);
        //other
        panel.add(getSaveButtonToAdd());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (brygadzista)");
    }

    private void setPanelToEdit() {
        panel.removeAll();
        panel.updateUI();
        panel.setBackground(Color.gray);
        JButton brygadaButton = new JButton("Edytuj listê brygad");

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
        loginTekst.setPreferredSize(new Dimension(100, 25));
        loginTekst.setText(list.getSelectedValue().getLogin());
        panel.add(loginTekst);
        //haslo
        panel.add(new JLabel("Enter password -> "));
        hasloTekst.setPreferredSize(new Dimension(100, 25));
        hasloTekst.setText(list.getSelectedValue().getHaslo());
        panel.add(hasloTekst);
        //brygada
        brygadaButton.addActionListener(e -> {
            brygadaList();
        });
        panel.add(brygadaButton);

        panel.add(getSaveButtonToEdit());
        panel.add(confirmLabel);
        updateAll();
        System.out.println("ustawiono panel do dodawania (brygadzista)");
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
            Listy.brygadzistaList.add(new Brygadzista(imieText.getText(), nazwiskoText.getText(), dataText.getText(), new DzialPracownikow(dzialTekst.getText()), loginTekst.getText(), hasloTekst.getText()));
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

            for (Brygadzista brygadzista : Listy.brygadzistaList) {
                if (brygadzista.equals(list.getSelectedValue())) {
                    brygadzista.setDzialPracownikow(new DzialPracownikow(dzialTekst.getText()));
                    brygadzista.setNazwisko(nazwiskoText.getText());
                    brygadzista.setImie(imieText.getText());
                    brygadzista.setDataUrodzenia(dataText.getText());
                    brygadzista.setLogin(loginTekst.getText());
                    brygadzista.setHaslo(hasloTekst.getText());
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

            Listy.brygadzistaList.remove(list.getSelectedValue());
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

    private void updateAll() {
        panel.updateUI();
        splitPane.updateUI();
        MainMethod.refreshMainFrame();
    }

    private void brygadaList() {

        JFrame jFrame = new JFrame("Lista brygad");
        jFrame.setSize(new Dimension(300, 500));
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton add = new JButton("DODAJ"), remove = new JButton("USUN");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.gray);
        panel.add(add);
        panel.add(remove);
        jFrame.add(panel, BorderLayout.NORTH);

        JList<Brygada> brygadaJList = new JList<>();
        DefaultListModel<Brygada> brygadaDefaultListModel = new DefaultListModel<>();
        brygadaJList.setModel(brygadaDefaultListModel);


        remove.addActionListener(e -> {
            for (Brygada brygada : list.getSelectedValue().getListaBrygad()) {
                if (brygada.equals(brygadaJList.getSelectedValue()))
                    list.getSelectedValue().removeBrygada(brygadaJList.getSelectedValue());
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
            }
        });
        add.addActionListener(e -> setActionForAddButton());

        for (Brygada brygada : list.getSelectedValue().getListaBrygad()) {
            brygadaDefaultListModel.addElement(brygada);
        }

        jFrame.add(brygadaJList , BorderLayout.CENTER);
        System.out.println("dodano liste brygad");

    }

    private void setActionForAddButton(){
        System.out.println("kliknieto DODAJ");
        JFrame addFrame = new JFrame("ADD Brygada");
        addFrame.setVisible(true);
        addFrame.setSize(200, 200);
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton b = new JButton("Dodaj wybrana brygade");

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p.add(b);
        JList<Brygada> l = new JList();

        b.addActionListener(e1 -> {
            if(list.getSelectedValue().getListaBrygad() == null  || list.getSelectedValue().getListaBrygad().contains(l.getSelectedValue())) list.getSelectedValue().addBrygada(l.getSelectedValue());
            System.out.println("zapisano");
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
        });
        DefaultListModel<Brygada> m = new DefaultListModel<>();
        l.setModel(m);
        for (Brygada brygada : Listy.brygadaList) {
            m.addElement(brygada);
        }
        addFrame.add(p, BorderLayout.NORTH);
        addFrame.add(l, BorderLayout.CENTER);
    }
}
