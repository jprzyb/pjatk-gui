module pl.s24512.s24512 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens pl.s24512.s24512 to javafx.fxml;
    exports pl.s24512.s24512;
}