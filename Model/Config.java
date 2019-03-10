package Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Config {

    //---------------------------- Attributes -----------------------------------

    private static int size;
    private static int brushType;
    private static Color color;
    private static Point position;
    private static Point cursor;
    private static ArrayList<Point> sketchPoints;
    private static ArrayList<Color> colorPoints;
    private static ArrayList<Integer> sizePoints;
    private static ArrayList<Integer> brushPattern;

    //---------------------------- Constructor -----------------------------------

    public Config(JFrame frame) {

        this.size = 5;
        this.brushType = 1;
        this.color = Color.BLACK;
        this.position = frame.getLocation();
        this.sketchPoints = new ArrayList<>();
        this.colorPoints = new ArrayList<>();
        this.sizePoints = new ArrayList<>();
        this.brushPattern = new ArrayList<>();

    }

    //---------------------------- Static Constructor -----------------------------

    public Config() {}

    //---------------------------- Getters -----------------------------------------

    public ArrayList<Point> getSketchPoints() {
        return this.sketchPoints;
    }

    public ArrayList<Color> getColorPoints() {
        return this.colorPoints;
    }

    public ArrayList<Integer> getSizePoints() {
        return this.sizePoints;
    }

    public ArrayList<Integer> getBrushPattern() { return  this.brushPattern; }

    public int getSize() {
        return this.size;
    }

    public Point getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }

    public Point getCursor() { return this.cursor; }

    public int getBrushType() { return this.brushType; }

    //---------------------------- Setters ------------------------------------------

    public void addStrokePoint(Point p, Color c, int s, int b) {
        this.sketchPoints.add(p);
        this.colorPoints.add(c);
        this.sizePoints.add(s);
        this.brushPattern.add(b);
    }

    public void setSize(int s) { this.size = s; }

    public void setColor(Color c){ this.color = c; }

    public void setBrushType(int b) { this.brushType  = b;}

    public void clearSketch() {

        this.getSketchPoints().clear();
        this.getColorPoints().clear();
        this.getSizePoints().clear();

    }

    public void setCursor(Point p) { this.cursor = p; }

    //---------------------------- Helper Methods ---------------------------------

    //LoadData method - To load data from ConfigSave after loading from file
    public void loadData(ConfigSave C){

        this.size = C.getSize();
        this.brushType = C.getBrushType();
        this.color = C.getColor();
        this.sketchPoints = new ArrayList<>(C.getSketchPoints());
        this.colorPoints = new ArrayList<>(C.getColorPoints());
        this.sizePoints = new ArrayList<>(C.getSizePoints());
        this.brushPattern = new ArrayList<>(C.getBrushPattern());

    }

}
