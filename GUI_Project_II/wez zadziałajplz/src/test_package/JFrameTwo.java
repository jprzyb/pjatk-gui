package test_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class JFrameTwo {

    private JFrame frame;
    private JPanel panelOne , panelTwo;
    private JButton buttonOne , buttonTwo , buttonThree;
    private Label label;

    public JFrameTwo () {
        inicjalize();
    }

    private void inicjalize(){

        frame = new JFrame();
        frame.setTitle("Siemandero");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);

        panelOne = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 ,5));
        panelOne.setBounds(10 , 10 ,10 , 10);
        panelOne.setBackground(Color.black);
        frame.add(panelOne , BorderLayout.NORTH);

        label = new Label("this is label");
        panelOne.add(label , BorderLayout.CENTER);

        label.setForeground(losujKolor());
        label.setFont(new Font("Sans-relief" , Font.BOLD , 36));

        panelTwo = new JPanel();
        panelTwo.setBounds(10 , 10 ,10 , 10);
       // panelTwo.setBackground();
        frame.add(panelTwo , BorderLayout.CENTER);

        buttonOne = new JButton("Click me to set color of upper panel");
        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(label.getText().equals("LOL"))  label.setText("DUPA");
                else label.setText("LOL");
            }
        });
        panelTwo.add(buttonOne);

        buttonTwo = new JButton("Im setting this background color");
        buttonTwo.setBackground(Color.black);
        buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTwo.setBackground(losujKolor());
            }
        });
        panelTwo.add(buttonTwo);

        buttonThree = new JButton("click me to set label font color");
        buttonThree.setBackground(Color.black);
        buttonThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(losujKolor());
            }
        });
        panelTwo.add(buttonThree);
    }

    public void show(){
        frame.setVisible(true);
    }

    private Color losujKolor(){
        Color color = new Color((int)(Math.random()* 256) , (int)(Math.random()* 256) , (int)(Math.random()* 256));
        return color;
    }
}