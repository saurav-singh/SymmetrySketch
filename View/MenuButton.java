package View;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String label, String icon){

        //Set button Label
        this.setText(label);
        this.setForeground(Color.gray);
        this.setVerticalTextPosition(BOTTOM);
        this.setHorizontalTextPosition(CENTER);

        //Set button icon
        Image image = new ImageIcon(this.getClass().getResource("/Assets/"+icon)).getImage();
        image = image.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(image));

        //Background and Foreground Color
        this.setBackground(new Color(73, 76, 74));
        this.setForeground(new Color(255,255,255));

        //Border settings
        this.setBorderPainted(false);

    }

}

