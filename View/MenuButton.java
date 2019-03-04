package View;

import Controller.MenuListener;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String label, String icon){
        this.setText(label);
        this.setPreferredSize(new Dimension(40, 100));
        //this.setBorder(new View.RoundedBorder(10));
        //this.setBorder(new RoundedBorder(10));
        this.addActionListener(new MenuListener());
    }

}

/*
class RoundedBorder implements Border {

    private int radius;


    public RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY);
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}*/