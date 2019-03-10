package View;

import Controller.ArtListener;
import Model.Config;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArtCanvas extends JPanel {

    //Sketch points
    private ArrayList<Point> sketchPoint;
    //Size history
    private ArrayList<Integer> sizePoint;
    //Color history
    private ArrayList<Color> colorPoint;
    //Brush Type
    private ArrayList<Integer> brushType;



    public ArtCanvas(Config config) {

        //Load data from config
        loadData(config);

        //Set Background color
        this.setBackground(Color.WHITE);

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
    }

    //Overwriting paint class (actual canvas)
    public void paint(Graphics g) {

        //call super class
        super.paintComponent(g);

        //Initialize graphics 2D
        Graphics2D G2 = (Graphics2D) g;

        //Set Anti-alias
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //Sketch on canvas if there are any points on 'sketchPoint'
        if (this.sketchPoint.size() > 0) {

            for (int i = 0; i < this.sketchPoint.size(); i++) {

                //Get position
                int x = this.sketchPoint.get(i).x;
                int y = this.sketchPoint.get(i).y;

                //Set color
                G2.setColor(this.colorPoint.get(i));

                //Stroke according to brush type
                switch (this.brushType.get(i)){
                    case 1:
                        G2.fillOval(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                    case 2:
                        G2.fillRect(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                    case 3:
                        //G2.fillArc(x, y, this.sizePoint.get(i), this.sizePoint.get(i),0,180);
                        G2.drawArc(x,y,this.sizePoint.get(i),this.sizePoint.get(i),0,50);
                        break;
                    case 4:
                        G2.fillOval(x, y, this.sizePoint.get(i), this.sizePoint.get(i));
                        break;
                }

            }
        }

    }

}