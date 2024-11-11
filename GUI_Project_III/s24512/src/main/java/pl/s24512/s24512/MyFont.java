package pl.s24512.s24512;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class MyFont {

    public static Font getLabelFont(){
        return Font.font("labelFont", FontWeight.BOLD, FontPosture.ITALIC, 20);
    }

    public static Font getButtonFont(){
        return Font.font("buttonFont", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 17);
    }

    public static Font getButtonFont(int size){
        return Font.font("buttonFont", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, size);
    }

}
