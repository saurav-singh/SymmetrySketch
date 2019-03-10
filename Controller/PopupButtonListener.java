package Controller;

import Model.Config;
import Model.ConfigSave;
import Model.Painter;
import Model.SaveLoad;
import View.PopUpMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupButtonListener implements ActionListener {

    private Config config;
    private PopUpMenu pm;
    private Painter painter;
    private SaveLoad saveLoad;
    private ConfigSave configSave;
    public PopupButtonListener(PopUpMenu PM){

        this.config = new Config();
        this.painter = new Painter();
        this.saveLoad = new SaveLoad();
        this.pm = PM;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Yes")) {
            this.config.clearSketch();
            this.painter.re_paint();
            this.pm.popup_clear_show(false);
        }

        if (e.getActionCommand().equals("No")) {
            this.pm.popup_clear_show(false);
        }

        if (e.getActionCommand().equals("Done")) {
            this.pm.popup_size_show(false);
        }

        if (e.getActionCommand().equals("Brush 1")) {
            this.config.setBrushType(1);
            this.pm.popup_brush_show(false);
        }

        if (e.getActionCommand().equals("Brush 2")) {
            this.config.setBrushType(2);
            this.pm.popup_brush_show(false);
        }

        if (e.getActionCommand().equals("Brush 3")) {
            this.config.setBrushType(3);
            this.pm.popup_brush_show(false);
        }

        if (e.getActionCommand().equals("Brush 4")) {
            this.config.setBrushType(4);
            this.pm.popup_brush_show(false);
        }

        if (e.getActionCommand().equals("Save")) {

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().toString();

                configSave = new ConfigSave(this.config);
                SaveLoad.save(configSave,fileName);

            }
        }

        if (e.getActionCommand().equals("Load")) {

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

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().toString();
                SaveLoad.export(this.painter.getCanvas(),fileName);

            }
        }
    }
}
