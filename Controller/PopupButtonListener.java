package Controller;

import Model.Config;
import Model.Painter;
import View.PopUpMenu;
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
    }
}
