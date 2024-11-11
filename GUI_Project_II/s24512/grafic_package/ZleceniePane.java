package grafic_package;

import logic_package.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;

import static javax.swing.JSplitPane.VERTICAL_SPLIT;

public class ZleceniePane {

    // F I E L D S ################################################################
    JSplitPane splitPane = new JSplitPane();
    JList<Zlecenie> list = new JList<>();
    DefaultListModel<Zlecenie> model = new DefaultListModel<>();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JLabel confirmLabel = new JLabel("ZAPISANO");
    JButton pracaButton = new JButton("Prace");
    JButton dataButton = new JButton("dataButton");
    JList<Brygada> listaBrygad = new JList<>();
    JList<StanZlecenia> listaStanow = new JList<>();
    JList<Integer> dni = new JList<Integer>();
    JList<Integer> miesiace = new JList<Integer>();
    JList<Integer> lata = new JList<Integer>();
    int year , month , day;

    // C O N S T R U C T O R ################################################################
    public ZleceniePane() {
        panel.setBackground(Color.gray);

        //ustawianie listy
        list.setModel(model);
        for (Zlecenie zlecenie : Listy.zlecenieList) {
            model.addElement(zlecenie);
        }
        confirmLabel.setVisible(false);

        //ustawianie splitPane
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(new JScrollPane(list));
        splitPane.setBottomComponent(panel);

        System.out.println("wywolano konstruktor (zlecenie)");
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

        panel.add(new JLabel("Stan zlecenia -> "));
        setListaStanowZlecenia();
        panel.add(listaStanow);
        panel.add(new JLabel("Wybierz brygade -> "));
        setListaBrygad();
        panel.add(listaBrygad);
        panel.add(new JLabel("Data utworzenia -> "));
        panel.add(new JLabel(String.valueOf(LocalDateTime.now())));
        panel.add(getSaveButtonToAdd());
        panel.add(confirmLabel);

        panel.updateUI();
        splitPane.updateUI();
        MainMethod.refreshMainFrame();
        System.out.println("ustawiono panel do dodawania (zlecenie)");
    }
    private void setPanelToEdit() {
        panel.removeAll();
        panel.updateUI();
        panel.setBackground(Color.gray);

        panel.add(new JLabel("Stan zlecenia ->"));
        setListaStanowZlecenia2();
        panel.add(listaStanow);
        panel.add(new JLabel("Wybierz brygade -> "));
        setListaBrygad();
        panel.add(listaBrygad);
        panel.add(new JLabel("Data Zakonczenia -> "));
        dataButton.addActionListener(e -> setDataButton());
        panel.add(dataButton);
        panel.add(new JLabel("Prace -> "));
        setPracaButton();
        panel.add(pracaButton);

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
            Listy.zlecenieList.add(new Zlecenie(listaBrygad.getSelectedValue() , listaStanow.getSelectedValue() , null));
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
            for(Zlecenie zlecenie : Listy.zlecenieList){
                if(zlecenie.equals(list.getSelectedValue())){
                    zlecenie.setStanZlecenia(listaStanow.getSelectedValue());
                    zlecenie.setBrygada(listaBrygad.getSelectedValue());

                    setParameters();
                    year = lata.getSelectedIndex()+1;
                    month = miesiace.getSelectedIndex()+1;
                    day = dni.getSelectedIndex()+1;
                    zlecenie.setDataZakonczenia(LocalDateTime.of(year, month, day , 0 , 0 ));
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
            for (Zlecenie zlecenie : Listy.zlecenieList) {
                if (zlecenie.equals(list.getSelectedValue())) {
                    Listy.zlecenieList.remove(zlecenie);
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

    private void setListaBrygad(){
        DefaultListModel<Brygada> m = new DefaultListModel<>();
        listaBrygad.setModel(m);
        for(Brygada brygada : Listy.brygadaList){
            m.addElement(brygada);
        }
    }
    private void setListaStanowZlecenia(){
        DefaultListModel<StanZlecenia> m = new DefaultListModel<>();
        listaStanow.setModel(m);
        m.addElement(StanZlecenia.NIEPLANOWANE);
        m.addElement(StanZlecenia.PLANOWANE);
    }

    private void setListaStanowZlecenia2(){
        DefaultListModel<StanZlecenia> m = new DefaultListModel<>();
        listaStanow.setModel(m);
        m.addElement(StanZlecenia.NIEPLANOWANE);
        m.addElement(StanZlecenia.PLANOWANE);
        m.addElement(StanZlecenia.REALIZOWANE);
        m.addElement(StanZlecenia.ZAKONCZONE);
    }

    private void setDataLists(){

        DefaultListModel<Integer> mLata = new DefaultListModel<>();
        lata.setModel(mLata);
        for(int i = 2000 ; i<2031 ; i++){
            mLata.addElement(i);
        }

        DefaultListModel<Integer> mMiesiace = new DefaultListModel<>();
        miesiace.setModel(mMiesiace);
        for(int i = 1 ; i<13 ; i++){
            mMiesiace.addElement(i);
        }

        DefaultListModel<Integer> mDni = new DefaultListModel<>();
        dni.setModel(mDni);
        for(int i = 1 ; i<32 ; i++){
            mDni.addElement(i);
        }
    }
    private void setParameters(){
        boolean przestepny = false;
        if((lata.getSelectedIndex()+1)%4==0) przestepny = true;

        if(przestepny && (miesiace.getSelectedIndex()+1)==2){
            if((dni.getSelectedIndex()+1)>29) day = 29;
        }

        if(przestepny && (miesiace.getSelectedIndex()+1)==2){
            if((dni.getSelectedIndex()+1)>28) day = 28;
        }

    }
    private void setDataButton(){
        JFrame frame = new JFrame("Zmien date");
        frame.setSize(300,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton b = new JButton("zapisz");
        b.addActionListener(e -> {
            confirmLabel.setVisible(true);
            year = lata.getSelectedIndex()+2000;
            month = miesiace.getSelectedIndex()+1;
            day = dni.getSelectedIndex()+1;
            list.getSelectedValue().setDataZakonczenia(LocalDateTime.of(year , month , day , 0 , 0));
            System.out.println("zapisano date");
        });

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER , 5, 5));
        p.add(b);
        frame.add(p , BorderLayout.NORTH);
        JPanel bottom = new JPanel(new GridLayout(0,3 ,5 , 5));
        bottom.setBackground(Color.gray);

        frame.add(bottom , BorderLayout.CENTER);

        setDataLists();
        p.add(confirmLabel);
        bottom.add(lata);
        bottom.add(miesiace);
        bottom.add(dni);
        p.add(confirmLabel);

    }

    private void setPracaButton(){

        pracaButton.addActionListener(e -> {
            JFrame f = new JFrame("Prace");
            f.setVisible(true);
            f.setSize(300,500);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JList<Praca> pracaJList = new JList<>();
            DefaultListModel<Praca> pracaDefaultListModel = new DefaultListModel<>();
            pracaJList.setModel(pracaDefaultListModel);
            JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER , 5 , 5));

            JButton s = new JButton("dodaj wybrane");
            s.addActionListener(e1 -> {
                list.getSelectedValue().addToList(pracaJList.getSelectedValue());

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
            p.add(s);

            JButton r = new JButton("usun wybrane");
            r.addActionListener(e1 -> {
                list.getSelectedValue().removeFromList(pracaJList.getSelectedValue());
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
            p.add(s);
            p.add(r);

            f.add(p , BorderLayout.NORTH);

            for(Praca praca : Listy.pracaList){
                pracaDefaultListModel.addElement(praca);
            }
            f.add(pracaJList , BorderLayout.EAST);
        });

    }


}
