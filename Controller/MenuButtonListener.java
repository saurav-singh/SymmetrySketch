package Controller;

import Model.Config;
import Model.Painter;
import View.PopUpMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButtonListener extends MouseAdapter {

    private PopUpMenu pm;
    private Config config;
    private Painter painter;
    private JButton btn;

    public MenuButtonListener(JButton button) {

        this.pm = new PopUpMenu();
        this.config = new Config();
        this.painter = new Painter();
        this.btn = button;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        this.btn.setBackground(new Color(250, 127, 67));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        this.btn.setBackground(new Color(73, 76, 74));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        this.btn.setBackground(new Color(108, 0, 1));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if (this.btn.getText().equals("File")) {
            pm.popup_file_show(true);

        }
        if (this.btn.getText().equals("Size")) {
            pm.popup_size_show(true);
        }
        if (this.btn.getText().equals("Clear")) {

            //Custom Popup (not ready)
            //pm.popup_clear_show();

            //Default Popup
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the screen?", "Clear Screen?", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                this.config.clearSketch();
                this.painter.re_paint();
            }
        }
        if (this.btn.getText().equals("Color")) {
            Color color = JColorChooser.showDialog(null, "Pick brush color", config.getColor());
            config.setColor(color);
        }
        if (this.btn.getText().equals("Eraser")) {
            config.setColor(Color.WHITE);
        }
        if (this.btn.getText().equals("Brush")) {
            pm.popup_brush_show(true);
        }
    }
}
