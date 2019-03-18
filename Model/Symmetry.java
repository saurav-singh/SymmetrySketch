package Model;

import java.awt.*;

public class Symmetry {

    private Painter painter;
    private Config config;
    //Height width
    private int w;
    private int h;
    //Required to add points
    private Color c;
    private int s;
    private int b;
    private int n;

    public Symmetry() {

        painter = new Painter();
        config = new Config();
    }

    private void loadData() {

        w = painter.getCanvas().getWidth();
        h = painter.getCanvas().getHeight();
        c = this.config.getColor();
        s = this.config.getSize();
        b = this.config.getBrushType();
        n = this.config.getSymCross();
    }

    public void addHrSymmetry(Point point) {

        this.loadData();

        //Calculate Vertical Distance
        int y_dist = (h / 2) - point.y;

        //Calculate symmetric horizontal position
        Point p = new Point();
        p.x = point.x;
        p.y = (h / 2) + y_dist;

        //Add symmetric points to config
        this.config.addStrokePoint(p, c, s, b);
    }

    public void addVrSymmetry(Point point) {

        this.loadData();

        //Get Horizontal Distance
        int x_dist = (w / 2) - point.x;

        //Calculate symmetric vertical position
        Point p = new Point();
        p.y = point.y;
        p.x = (w / 2) + x_dist;

        //Add symmetric points to config
        this.config.addStrokePoint(p, c, s, b);

        if (this.config.getSymHorizontal()) {
            this.addHrSymmetry(p);
        }
    }

    public void addCrSymmetry(Point point) {

        this.loadData();

        //Required Variables
        int N_symmetries = n;
        int degreeIncrement = 360/N_symmetries;
        double radius, deg;
        int newX, newY;
        //Center of canvas:
        int cx = w / 2;
        int cy = h / 2;

        //Calculate radius - distance formula
        radius = Math.sqrt(Math.pow((point.x - cx), 2) + Math.pow((point.y - cy), 2));

        //Calculate relative degree
        deg = Math.toDegrees(Math.atan2((point.y - cy), (point.x - cx)));

        for (int i=0;i<N_symmetries;i++) {

            deg += degreeIncrement;
            newX = (int) (cx + radius * Math.cos(Math.toRadians(deg)));
            newY = (int) (cy + radius * Math.sin(Math.toRadians(deg)));

            this.config.addStrokePoint(new Point(newX,newY),c,s,b);

        }
    }
}
