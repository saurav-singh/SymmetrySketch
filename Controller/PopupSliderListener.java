package Controller;

import Model.Config;
import Model.Painter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PopupSliderListener implements ChangeListener {

    private JLabel label;
    private JSlider slider;
    private Config config;
    private Painter painter;

    public PopupSliderListener(JSlider slider, JLabel label){
        this.label = label;
        this.slider = slider;
        this.painter = new Painter();
        this.config = new Config();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        int size = slider.getValue();
        this.label.setText("Current size : " + size);
        this.config.setSize(size);
        this.painter.load_data();

    }
}
