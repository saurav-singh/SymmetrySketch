package View;

import Controller.ArtListener;
import Model.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArtCanvas extends JPanel {

    //Symmetries
    private boolean hr, vr;
    private int cr;
    //Sketch points
    private ArrayList<Point> sketchPoint;
    //Size history
    private ArrayList<Integer> sizePoint;
    //Color history
    private ArrayList<Color> colorPoint;
    //Brush Type
    private ArrayList<Integer> brushType;


    //Art Class Constructor
    public ArtCanvas(Config config) {

        //Load data from config
        loadData(config);

        //Set Background color
        this.setBackground(config.getBgColor());

        //Add mouse listener for drawing
        this.addMouseMotionListener(new ArtListener());

        //Hide mouse cursor in canvas
        /*
        this.setCursor(this.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));
                */

        //Refresh canvas
        repaint();
    }

    //Loads data from config
    public void loadData(Config config) {
        this.sketchPoint = config.getSketchPoints();
        this.sizePoint = config.getSizePoints();
        this.colorPoint = config.getColorPoints();
        this.brushType = config.getBrushPattern();
        this.setBackground(config.getBgColor());
        this.hr = config.getSymHorizontal();
        this.vr = config.getSymVertical();
        this.cr = config.getSymCross();
    }

    //Overwriting paint class (actual canvas)
    public void paint(Graphics g) {

        //call super class
        super.paintComponent(g);

        //Initialize graphics 2D
        Graphics2D G2 = (Graphics2D) g;

        //Set Anti-alias
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //G2.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //Sketch on canvas if there are any points on 'sketchPoint'
        for (int i = 0; i < this.sketchPoint.size(); i++) {

            //Get position
            int x = this.sketchPoint.get(i).x;
            int y = this.sketchPoint.get(i).y;

            //Set color
            G2.setColor(this.colorPoint.get(i));

            //Size
            int s = this.sizePoint.get(i);

            //Stroke according to brush type
            switch (this.brushType.get(i)) {
                case 1:
                    G2.fillOval(x - s / 2, y - s / 2, s, s);
                    break;
                case 2:
                    G2.drawRect(x - s / 2, y - s / 2, s, s);
                    break;
                case 3:
                    G2.drawArc(x, y - s / 3, s, s, 180, -90);
                    G2.drawArc(x - s, y - s / 3, s, s, 0, 90);
                    break;
                case 4:
                    G2.drawArc(x - s, y - s / 2, s, s, 0, 90);
                    G2.drawArc(x, y - s / 2, s, s, 180, 90);
                    break;
            }

        }

        //Symmetric Guide Lines if active
        G2.setColor(Color.LIGHT_GRAY);

        //Vertical Symmetry guide line
        if (this.vr) {

            int x1 = this.getWidth() / 2;
            int y1 = 0;
            int x2 = x1;
            int y2 = this.getHeight();

            G2.drawLine(x1, y1, x2, y2);

        }

        //Horizontal Symmetry guide line
        if (this.hr) {

            int x1 = 0;
            int y1 = this.getHeight() / 2;
            int x2 = this.getWidth();
            int y2 = y1;

            G2.drawLine(x1, y1, x2, y2);
        }

        //Cross Symmetry guide line
        if (this.cr > 0) {

            //Required Variables
            int N_symmetries = this.cr;
            int degreeIncrement = 360 / N_symmetries;
            double radius, deg;
            int newX, newY;
            //Center of canvas:
            int cx = this.getHeight() / 2;
            int cy = this.getWidth() / 2;
            Point point = new Point(this.getWidth(), cy);

            //Calculate radius - distance formula
            radius = Math.sqrt(Math.pow((point.x - cx), 2) + Math.pow((point.y - cy), 2));

            //Calculate relative degree
            deg = Math.toDegrees(Math.atan2((point.y - cy), (point.x - cx)));

            for (int i = 0; i < N_symmetries ; i++) {

                deg += degreeIncrement;
                newX = (int) (cx + radius * Math.cos(Math.toRadians(deg)));
                newY = (int) (cy + radius * Math.sin(Math.toRadians(deg)));
                G2.drawLine(cy, cx, newY, newX);
                point.x = newX;
                point.y = newY;

            }
        }

    }

}