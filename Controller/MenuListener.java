package Controller;
import Model.Config;
import Model.Painter;
import View.PopUpMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    private PopUpMenu pm;
    private Config config;
    private Painter painter;

    public MenuListener() {

        pm = new PopUpMenu();
        config  = new Config();
        painter = new Painter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Size")) {
            pm.popup_size_show(true);
        }
        if (e.getActionCommand().equals("Clear")) {
            pm.popup_clear_show(true);
        }
        if (e.getActionCommand().equals("Color")) {

            Color color = JColorChooser.showDialog(null,"Pick brush color", config.getColor());
            config.setColor(color);

        }
    }
}
