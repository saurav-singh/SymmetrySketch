package Model;

import View.ArtCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Config {

    private static int size;
    private static int brushType;
    private static Color color;
    private static Point position;
    private static ArrayList<Point> sketchPoints;
    private static ArrayList<Color> colorPoints;
    private static ArrayList<Integer> sizePoints;

    public Config(JFrame frame) {

        this.size = 5;
        this.brushType = 1;
        this.color = Color.BLACK;
        this.position = frame.getLocation();
        this.sketchPoints = new ArrayList<>();
        this.colorPoints = new ArrayList<>();
        this.sizePoints = new ArrayList<>();

    }

    //To use static
    public Config() {
    }

    //Getters

    public ArrayList<Point> getSketchPoints() {
        return this.sketchPoints;
    }

    public ArrayList<Color> getColorPoints() {
        return this.colorPoints;
    }

    public ArrayList<Integer> getSizePoints() {
        return this.sizePoints;
    }

    public int getSize() {
        return this.size;
    }

    public Point getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }
    //Setters

    public void addStrokePoint(Point p, Color c, int s) {
        this.sketchPoints.add(p);
        this.colorPoints.add(c);
        this.sizePoints.add(s);
    }

    public void setSize(int s) {
        this.size = s;
    }

    public void setColor(Color c){
        this.color = c;
    }

    public void clearSketch() {

        this.getSketchPoints().clear();
        this.getColorPoints().clear();
        this.getSizePoints().clear();

    }


}
