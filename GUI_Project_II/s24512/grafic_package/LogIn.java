package grafic_package;

import logic_package.Listy;
import logic_package.Uzytkownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LogIn {

    private JFrame frame;
    private JPanel panel;
    private JTextField login;
    private JPasswordField password;
    private JButton button;
    private JLabel loginLabel;
    private Uzytkownik uzytkownik;

    public LogIn() {
        inicjalize();
    }

    private void inicjalize() {
//frame
        frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
//layout
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        layout.setHgap(0);
        layout.setVgap(0);
        frame.setLayout(layout);
//panel
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(300, 150));
        frame.add(panel, BorderLayout.CENTER);
//login label
        loginLabel = new JLabel("Niepoprawny login lub haslo");
        loginLabel.setForeground(Color.white);
//login
        login = new JTextField(15);
//password
        password = new JPasswordField(15);
//check button
        button = new JButton("login");
        button.setMnemonic(KeyEvent.VK_ENTER);
        button.setFocusable(false);
        button.setToolTipText("alt + ENTER");
        String tempPassword = "admin";
        button.addActionListener(e -> {

            try{
                for (Uzytkownik temp : Listy.uzytkownikList) {
                    if (temp.getLogin().equals(login.getText())) uzytkownik = temp;
                }
//
                if (login.getText().equals("admin") && tempPassword.equals(new String(password.getPassword()))) {
                    frame.setTitle("zalogowane");
                    MainMethod.inicjal = "aa";
                    loginLabel.setForeground(Color.white);
                    MainMethod.isLogged = true;
                    MainMethod.changeFrames();

                } else if ((uzytkownik.getLogin().equals(login.getText()) && uzytkownik.getHaslo().equals(new String(password.getPassword())))) {
                    frame.setTitle("zalogowane");
                    MainMethod.inicjal = uzytkownik.getInicial();
                    loginLabel.setForeground(Color.white);
                    MainMethod.isLogged = true;
                    MainMethod.changeFrames();
                } else {
                    frame.setTitle("Login");
                    loginLabel.setForeground(Color.RED);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }

        });
//adding components
        panel.add(new JLabel("Login:          "), BorderLayout.WEST);
        panel.add(login, BorderLayout.CENTER);
        panel.add(new JLabel("Password: "), BorderLayout.WEST);
        panel.add(password, BorderLayout.WEST);
        panel.add(new JLabel(""), BorderLayout.WEST);
        panel.add(button, BorderLayout.SOUTH);
        panel.add(loginLabel, BorderLayout.CENTER);
    }

    public void show() {
        if (!frame.isVisible()) frame.setVisible(true);
        else frame.setVisible(false);
    }
}
