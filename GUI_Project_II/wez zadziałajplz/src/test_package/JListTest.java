package test_package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JListTest {

    JFrame frame;
    JPanel panel;
    JList jList;
    List<Klasa> listaKlas = new ArrayList<>();

    public JListTest() {
        inicjalize();
    }

    private void inicjalize() {
        frame = new JFrame("JList Test");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.setBackground(Color.white);
        panel.setBounds(5, 5, 5, 5);


        zrobKlasy();
        jList = new JList((Vector) listaKlas);

        panel.add(jList, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void zrobKlasy() {
        for (int i = 0; i < 10; i++) {
            Klasa klasa = new Klasa("obiekt " + i, i);
            listaKlas.add(klasa);
        }
    }

}
