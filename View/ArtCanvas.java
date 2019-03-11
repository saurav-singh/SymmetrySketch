package View;

import Controller.ArtListener;
import Model.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArtCanvas extends JPanel {

    //Symmetries
    private boolean hr, vr, cr;
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

        //Sketch on canvas if there are any points on 'sketchPoint'
        if (this.sketchPoint.size() > 0) {

            for (int i = 0; i < this.sketchPoint.size(); i++) {

                //Get position
                int x = this.sketchPoint.get(i).x;
                int y = this.sketchPoint.get(i).y;

                //Set color
                G2.setColor(this.colorPoint.get(i));

                //Stroke according to brush type
                switch (this.brushType.get(i)) {
                    case 1:
                        G2.fillOval(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                    case 2:
                        G2.drawRect(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                    case 3:
                        //G2.fillArc(x, y, this.sizePoint.get(i), this.sizePoint.get(i),0,180);
                        G2.drawArc(x, y, this.sizePoint.get(i), this.sizePoint.get(i), 0, 50);
                        break;
                    case 4:
                        G2.fillOval(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                }

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
            int y1 = this.getHeight()/2;
            int x2 = this.getWidth();
            int y2 = y1;

            G2.drawLine(x1, y1, x2, y2);
        }

        //Cross Symmetry guide line
        if (this.cr) {

            int x1 = 0;
            int y1 = 0;
            int x2 = this.getWidth();
            int y2 = this.getHeight();

            G2.drawLine(x1, y1, x2, y2);
            G2.drawLine(x1,y2,x2,y1);
        }

    }

}