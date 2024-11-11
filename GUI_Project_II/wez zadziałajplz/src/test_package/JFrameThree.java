package test_package;

import javax.swing.*;
import java.awt.*;

public class JFrameThree {

    private JFrame frame;
    private JPanel panel1 , panel2;

    public JFrameThree(){
        inicjalize();
    }

    private void inicjalize(){
        frame = new JFrame("JFrameThree");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER , 0 , 0));
        panel1.setBackground(Color.black);
        frame.add(panel1);

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 10));
        panel2.setPreferredSize(new Dimension(frame.getWidth(), 100));
        panel2.setBackground(Color.pink);
        panel1.add(panel2 , BorderLayout.NORTH);
    }

    public void show(){
        frame.setVisible(true);
    }
}