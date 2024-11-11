package grafic_package;

import logic_package.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class BrygadaPane {

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Brygada> list = new JList<>();
    DefaultListModel<Brygada> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JTextField text = new JTextField();
    JList<Brygadzista> listaBrygadzistow = getBrygadzistaList();

    // C O N S T R U C T O R ################################################################
    public BrygadaPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Brygada brygada : Listy.brygadaList) {
            model.addElement(brygada);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (dzial pracownikow)");
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
            System.out.println("add button clicked (brygada)");
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

        panel.add(new JLabel("Enter new name -> "));
        text.setPreferredSize(new Dimension(100, 25));
        panel.add(text);
        panel.add(new JLabel("Wybierz brygadziste"));
        panel.add(listaBrygadzistow);
        panel.add(getSaveButtonToAdd());
        panel.add(confirmLabel);

        panel.updateUI();
        splitPane.updateUI();
        MainMethod.refreshMainFrame();
        System.out.println("ustawiono panel do dodawania (dzial pracownikow)");
    }
    private void setPanelToEdit() {
        panel.removeAll();
        panel.updateUI();
        panel.setBackground(Color.gray);

        text.setText(list.getSelectedValue().getNazwa());
        panel.add(new JLabel("Enter name -> "));
        text.setPreferredSize(new Dimension(100, 25));
        panel.add(text);
        panel.add(new JLabel("Wybierz brygadziste -> "));
        panel.add(listaBrygadzistow);
        panel.add(getSaveButtonToEdit());
        panel.add(confirmLabel);

        panel.updateUI();
        MainMethod.refreshMainFrame();
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
            Listy.brygadaList.add(new Brygada(text.getText() , listaBrygadzistow.getSelectedValue() ));
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
            for(Brygada brygada : Listy.brygadaList){
                if(brygada.equals(list.getSelectedValue())){
                    brygada.setNazwa(text.getText());
                    brygada.setBrygadzista(listaBrygadzistow.getSelectedValue());
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
            splitPane.updateUI();
        });
        return save;
    }
    private JButton getSaveButtonToRemove() {
        JButton save = new JButton("USUN");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alt + enter");
        save.addActionListener(e -> {
            for (Brygada brygada : Listy.brygadaList) {
                if (brygada.equals(list.getSelectedValue())) {
                    Listy.brygadaList.remove(brygada);
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
            }
            splitPane.updateUI();
        });
        return save;
    }
    public JSplitPane getSplitPane() {
        return splitPane;
    }
    private JList<Brygadzista> getBrygadzistaList(){
        JList<Brygadzista> l = new JList<>();
        DefaultListModel<Brygadzista> m = new DefaultListModel<>();
        l.setModel(m);

        for(Brygadzista brygadzista : Listy.brygadzistaList){
            m.addElement(brygadzista);
        }

        return l;
    }
}
