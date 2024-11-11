package grafic_package;

import logic_package.FileIO;

import javax.swing.*;
import java.io.IOException;

public class S24512 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MainMethod.firstStart();

        SwingUtilities.invokeLater(() -> {

            MainMethod.firstShow();
        });
        FileIO.save();
    }

}
