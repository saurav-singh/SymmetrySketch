package Controller;

import Model.Config;
import Model.ConfigSave;
import Model.Painter;
import Model.SaveLoad;
import View.PopUpMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupButtonListener implements ActionListener {

    private Config config;
    private PopUpMenu pm;
    private Painter painter;

    public PopupButtonListener(PopUpMenu PM){

        this.config = new Config();
        this.painter = new Painter();
        this.pm = PM;

    }

    private void closePopups(){

        this.pm.popup_file_show(false);
        this.pm.popup_brush_show(false);
        this.pm.popup_size_show(false);
        this.pm.popup_symmetry_show(false);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Yes")) {
            this.config.clearSketch();
            this.painter.re_paint();
            this.closePopups();
        }

        if (e.getActionCommand().equals("No")) {
            this.closePopups();
        }

        if (e.getActionCommand().equals("Done")) {
            this.closePopups();
        }

        if (e.getActionCommand().equals("1")) {
            this.config.setBrushType(1);
            this.closePopups();
        }

        if (e.getActionCommand().equals("2")) {
            this.config.setBrushType(2);
            this.closePopups();
        }

        if (e.getActionCommand().equals("3")) {
            this.config.setBrushType(3);
            this.closePopups();
        }

        if (e.getActionCommand().equals("4")) {
            this.config.setBrushType(4);
            this.closePopups();
        }

        if (e.getActionCommand().equals("Close")) {
            this.closePopups();
        }

        if (e.getActionCommand().equals("New")) {

            this.closePopups();
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want a new screen?", "New?", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                this.config.setBgColor(Color.WHITE);
                this.config.setSymVertical(false);
                this.config.setSymHorizontal(false);
                this.config.setSymCross(false);
                this.config.clearSketch();
                this.painter.load_data();
                this.painter.re_paint();
            }
        }

        if (e.getActionCommand().equals("Save")) {

            this.closePopups();

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().toString();

                ConfigSave configSave = new ConfigSave(this.config);
                SaveLoad.save(configSave,fileName);

            }
        }

        if (e.getActionCommand().equals("Load")) {

            this.closePopups();

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if   (response == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().toString();

                SaveLoad.load(fileName);
                this.painter.load_data();
                this.painter.re_paint();
            }
        }

        if (e.getActionCommand().equals("Export")) {

            this.closePopups();

            boolean hr,vr,cr;
            hr = this.config.getSymHorizontal();
            vr = this.config.getSymVertical();
            cr = this.config.getSymCross();

            this.config.setSymVertical(false);
            this.config.setSymHorizontal(false);
            this.config.setSymCross(false);
            this.painter.load_data();

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().toString();
                SaveLoad.export(this.painter.getCanvas(),fileName);
            }

            this.config.setSymVertical(vr);
            this.config.setSymHorizontal(hr);
            this.config.setSymCross(cr);
            this.painter.load_data();
        }

        if (e.getActionCommand().equals("Horizontal")) {

            boolean r = this.config.getSymHorizontal();
            this.config.setSymHorizontal(!r);
            this.painter.load_data();
            this.painter.re_paint();

        }

        if (e.getActionCommand().equals("Vertical")) {

            boolean r = this.config.getSymVertical();
            this.config.setSymVertical(!r);
            this.painter.load_data();
            this.painter.re_paint();

        }

        if (e.getActionCommand().equals("Cross")) {

            boolean r = this.config.getSymCross();
            this.config.setSymCross(!r);
            this.painter.load_data();
            this.painter.re_paint();
        }

    }
}
