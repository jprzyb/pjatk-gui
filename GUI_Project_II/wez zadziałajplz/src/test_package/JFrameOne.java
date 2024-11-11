package test_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameOne {

    private JFrame jframe;
    private JPanel panel;
    private JButton button;

    public JFrameOne () {
        inicjalize();
    }

    private void inicjalize(){

        jframe = new JFrame();
        jframe.setLayout(new GridLayout());
        jframe.setSize(800,500);
        jframe.setTitle("Siemandero");
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setLocationRelativeTo(null);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 ,10));
        panel.setBackground(new Color((int)(Math.random()* 256) , (int)(Math.random()* 256) , (int)(Math.random()* 256)));

        button = new JButton("ZMIEN KOLOR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color((int)(Math.random()* 256) , (int)(Math.random()* 256) , (int)(Math.random()* 256)));
            }
        });
        button.setSize(30,10);


        jframe.add(panel , BorderLayout.NORTH);
        panel.add(button , BorderLayout.CENTER);

    }

    public void show(){
        jframe.setVisible(true);
    }

}
