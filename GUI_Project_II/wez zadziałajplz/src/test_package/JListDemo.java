package test_package;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class JListDemo {

    JFrame jFrame = new JFrame("JListDemo");
    JList<Product> list = new JList<>();
    DefaultListModel<Product> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT , 5 , 5));
    JSplitPane splitPane = new JSplitPane();

    public JListDemo(){
        inicjalize();
    }

    private void inicjalize(){

        list.setModel(model);

        for(int i=0 ; i <200 ; i++){
            model.addElement(new Product(("test"+i) ,(int)(Math.random()%200) , ("description"+i) ));
        }

        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);
        splitPane.setRightComponent(panel);

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(new Dimension(800,400));
        jFrame.add(splitPane);
    }

    private class Product{
        String name;
        int price;
        String desc;

        public Product(String name, int price, String desc) {
            this.name = name;
            this.price = price;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
