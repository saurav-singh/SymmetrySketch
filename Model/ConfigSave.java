package Model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ConfigSave implements Serializable {

    //---------------------------- Attributes ------------------------------------------

    private int size;
    private int brushType;
    private Color color;
    private Color bgColor;
    private boolean sym_horizontal;
    private boolean sym_vertical;
    private int sym_N;
    private ArrayList<Point> sketchPoints;
    private ArrayList<Color> colorPoints;
    private ArrayList<Integer> sizePoints;
    private ArrayList<Integer> brushPattern;

    //---------------------------- Constructor ------------------------------------------

    public ConfigSave (Config C) {
        this.size = C.getSize();
        this.brushType = C.getBrushType();
        this.color = C.getColor();
        this.bgColor = C.getBgColor();
        this.sym_horizontal = C.getSymHorizontal();
        this.sym_vertical = C.getSymVertical();
        this.sym_N = C.getSymCross();
        this.sketchPoints = new ArrayList<>(C.getSketchPoints());
        this.colorPoints = new ArrayList<>(C.getColorPoints());
        this.sizePoints = new ArrayList<>(C.getSizePoints());
        this.brushPattern = new ArrayList<>(C.getBrushPattern());
    }

    //---------------------------- Getters -----------------------------------------------

    public int getSize() { return this.size; }

    public int getBrushType() {
        return this.brushType;
    }

    public Color getColor() {
        return this.color;
    }

    public Color getBgColor() { return this.bgColor; }

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

    public boolean getSymVertical() { return this.sym_vertical; }

    public boolean getSymHorizontal() { return this.sym_horizontal; }

    public int getSymCross() { return this.sym_N; }
}
