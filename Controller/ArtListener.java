package Controller;

import Model.Config;
import Model.Painter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ArtListener implements MouseMotionListener {

    private Painter painter;
    private Config config;

    public ArtListener() {

        this.painter = new Painter();
        this.config = new Config();

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        this.config.addStrokePoint(e.getPoint(), this.config.getColor(), this.config.getSize(), this.config.getBrushType());
        this.painter.re_paint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        this.config.setCursor(e.getPoint());
        this.painter.re_paint();
    }
}

