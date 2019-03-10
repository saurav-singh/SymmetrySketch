package Model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ConfigSave implements Serializable {

    //---------------------------- Attributes ------------------------------------------

    private int size;
    private int brushType;
    private Color color;
    private ArrayList<Point> sketchPoints;
    private ArrayList<Color> colorPoints;
    private ArrayList<Integer> sizePoints;
    private ArrayList<Integer> brushPattern;

    //---------------------------- Constructor ------------------------------------------

    public ConfigSave (Config C) {
        this.size = C.getSize();
        this.brushType = C.getBrushType();
        this.color = C.getColor();
        this.sketchPoints = new ArrayList<>(C.getSketchPoints());
        this.colorPoints = new ArrayList<>(C.getColorPoints());
        this.sizePoints = new ArrayList<>(C.getSizePoints());
        this.brushPattern = new ArrayList<>(C.getBrushPattern());
    }

    //---------------------------- Getters -----------------------------------------------

    public int getSize() {
        return this.size;
    }

    public int getBrushType() {
        return this.brushType;
    }

    public Color getColor() {
        return this.color;
    }

    public ArrayList<Point> getSketchPoints() {
        return this.sketchPoints;
    }

    public ArrayList<Color> getColorPoints() {
        return this.colorPoints;
    }

    public ArrayList<Integer> getSizePoints() {
        return this.sizePoints;
    }

    public ArrayList<Integer> getBrushPattern() {
        return this.brushPattern;
    }

}
