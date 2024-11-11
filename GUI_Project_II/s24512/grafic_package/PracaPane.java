package grafic_package;

import logic_package.FileIO;
import logic_package.Listy;
import logic_package.Praca;
import logic_package.RodzajPracy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class PracaPane {

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Praca> list = new JList<>();
    DefaultListModel<Praca> model = new DefaultListModel<>();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JList<RodzajPracy> rodzajPracyJList = new JList<>();
    JTextField czasPracyText = new JTextField();
    JList<Boolean> czZreazlizowanoList = new JList<>();
    JTextField opisText = new JTextField();
    int czas;

    // C O N S T R U C T O R ################################################################
    public PracaPane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Praca praca : Listy.pracaList) {
            model.addElement(praca);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (praca)");
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
            System.out.println("add button clicked (praca)");
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

        setRodzajPracyJList();
        setCzZreazlizowanoList();

        panel.add(new JLabel("Rodzaj pracy -> "));
        panel.add(rodzajPracyJList);
        panel.add(new JLabel("Czas pracy -> "));
        czasPracyText.setPreferredSize(new Dimension(100, 25));
        panel.add(czasPracyText);
        panel.add(new JLabel("czy zrealizowano"));
        panel.add(new JLabel(Boolean.FALSE.toString()));
        panel.add(new JLabel("Opis -> "));
        opisText.setPreferredSize(new Dimension(100, 25));
        panel.add(opisText);

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

        setRodzajPracyJList();
        setCzZreazlizowanoList();

        panel.add(new JLabel("Rodzaj pracy -> "));
        panel.add(rodzajPracyJList);
        panel.add(new JLabel("Czas pracy -> "));
        czasPracyText.setText(Integer.toString(list.getSelectedValue().getCzasPracy()));
        panel.add(czasPracyText);
        panel.add(new JLabel("czy zrealizowano -> "));
        panel.add(czZreazlizowanoList);
        panel.add(new JLabel("Opis -> "));
        opisText.setText(list.getSelectedValue().getOpis());
        panel.add(opisText);

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
            checkTime(czasPracyText.getText());
            Listy.pracaList.add(new Praca(rodzajPracyJList.getSelectedValue() , czas , false , opisText.getText() ));
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
            for(Praca praca : Listy.pracaList){
                checkTime(czasPracyText.getText());
                if(praca.equals(list.getSelectedValue())){
                    checkTime(czasPracyText.getText());
                    praca.setCzasPracy(czas);
                    praca.setCzZrealizowane(czZreazlizowanoList.getSelectedValue().booleanValue());
                    praca.setOpis(opisText.getText());
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
    private JButton getSaveButtonToRemove()  {
        JButton save = new JButton("USUN");
        save.setMnemonic(KeyEvent.VK_ENTER);
        save.setToolTipText("alt + enter");
        save.addActionListener(e -> {
            for (Praca praca : Listy.pracaList) {
                if (praca.equals(list.getSelectedValue())) {
                    Listy.pracaList.remove(praca);
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

    private void setRodzajPracyJList(){
        DefaultListModel<RodzajPracy> m = new DefaultListModel<>();
        rodzajPracyJList.setModel(m);

        m.addElement(RodzajPracy.OGOLNA);
        m.addElement(RodzajPracy.DEMONTAZ);
        m.addElement(RodzajPracy.MONTAZ);
        m.addElement(RodzajPracy.WYMIANA);
    }
    private void setCzZreazlizowanoList(){
        DefaultListModel<Boolean> m = new DefaultListModel<>();
        czZreazlizowanoList.setModel(m);
        m.addElement(Boolean.TRUE);
        m.addElement(Boolean.FALSE  );
    }
    private void checkTime(String text){
        char a;
        for(int i = 0 ; i<text.length();i++){
            a = text.charAt(i);
            if(!Character.isDigit(a)){
                randomNumber();
                System.out.println("losowanie");
            }
            else{
                czas = Integer.parseInt(String.valueOf(czasPracyText.getText()));
            }
        }
    }
    public void randomNumber(){
        czas = (int)(Math.random()*500)+30;
    }
}
