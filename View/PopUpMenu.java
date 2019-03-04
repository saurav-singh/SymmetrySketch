package View;

import Controller.PopupButtonListener;
import Controller.PopupSliderListener;
import Model.Config;

import javax.swing.*;
import java.awt.*;

public class PopUpMenu {

    private JPopupMenu popup_file, popup_brush, popup_eraser;
    private JPopupMenu popup_color, popup_size, popup_clear;
    private JPopupMenu popup_symmetry;

    public PopUpMenu() {

        //Initialize popup menus
        popup_file = new JPopupMenu();
        popup_brush = new JPopupMenu();
        popup_eraser = new JPopupMenu();
        popup_size = new JPopupMenu();
        popup_clear = new JPopupMenu();
        popup_symmetry = new JPopupMenu();

        //Setup for File

        //Setup for brush

        //Setup for eraser

        //Setup for size
        JSlider slider_size = new JSlider(JSlider.HORIZONTAL, 1, 20, 5);
        JLabel label_size = new JLabel("Size : 5");
        JButton btn_size = new JButton("Done");
        popup_size.add(slider_size);
        popup_size.add(label_size);
        popup_size.add(btn_size);

        //Setup for Clear
        popup_clear.setBackground(Color.WHITE);
        JLabel label_clear = new JLabel("Are you sure you want to clear the screen?");
        JButton btn_clearYes = new JButton("Yes");
        JButton btn_clearNo = new JButton("No");
        popup_clear.add(label_clear);
        popup_clear.add(btn_clearYes);
        popup_clear.add(btn_clearNo);


        //Set size for popups
        int width = 250;
        int height = 200;
        popup_size.setPopupSize(width, height);
        popup_clear.setPopupSize(width, height);

        //Initialize popup location
        Config config = new Config();
        int x = config.getPosition().x + 450;
        int y = config.getPosition().y + 300;
        //Set location for popups
        popup_size.setLocation(x, y);
        popup_clear.setLocation(x, y);

        //Add action listeners for buttons
        btn_clearYes.addActionListener(new PopupButtonListener(this));
        btn_clearNo.addActionListener(new PopupButtonListener(this));
        btn_size.addActionListener(new PopupButtonListener(this));

        //Add action listeners for sliders and colors
        slider_size.addChangeListener(new PopupSliderListener(slider_size, label_size));
    }

    //Popup appear functions

    public void popup_size_show(boolean b) {
        popup_size.setVisible(b);
    }

    public void popup_clear_show(boolean b) {
        popup_clear.setVisible(b);
    }


}
