package grafic_package;

import logic_package.DzialPracownikow;
import logic_package.FileIO;
import logic_package.Listy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class DzialPracownikowPane {
    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<DzialPracownikow> list = new JList<>();
    DefaultListModel<DzialPracownikow> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JTextField text = new JTextField();

    // C O N S T R U C T O R ################################################################
    public DzialPracownikowPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (DzialPracownikow dzialPracownikow : Listy.dzialPracownikowList) {
            model.addElement(dzialPracownikow);
        }
        confirmLabel.setVisible(false);

        //ustawianie panelu
        //panel.add(new JLabel("Wybierz co chcesz zrobic"));

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
            System.out.println("add button clicked (dzial pracownikow)");
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
            Listy.dzialPracownikowList.add(new DzialPracownikow(text.getText()));
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
            for(DzialPracownikow dzialPracownikow : Listy.dzialPracownikowList){
                if(dzialPracownikow.getNazwa().equals(list.getSelectedValue().getNazwa())){
                    dzialPracownikow.setNazwa(text.getText());
                }
            }
            for(String n : Listy.nazwyDzialow){
                if(list.getSelectedValue().equals(n)){
                    Listy.nazwyDzialow.remove(n);
                }
            }
            try {
                FileIO.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                FileIO.read();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
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
            for (DzialPracownikow dzialPracownikow : Listy.dzialPracownikowList) {
                if (dzialPracownikow.getNazwa().equals(list.getSelectedValue().getNazwa())) {
                    Listy.dzialPracownikowList.remove(dzialPracownikow);
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
    public void abc(){
        SwingUtilities.updateComponentTreeUI(splitPane);
    }

}
