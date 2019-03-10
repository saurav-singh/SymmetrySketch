package View;

import Controller.MenuButtonListener;
import javax.swing.*;
import java.awt.*;

public class TopMenu extends JPanel {

    //
    private JButton file;
    private JButton brush;
    private JButton eraser;
    private JButton color;
    private JButton size;
    private JButton clear;
    private JButton symmetry;
    private JButton background;

    public TopMenu() {

        //Initialize Buttons using custom button class
        file = new MenuButton("File", "file.png");
        brush = new MenuButton("Brush", "brush.png");
        eraser = new MenuButton("Eraser", "eraser.png");
        color = new MenuButton("Color", "color.png");
        size = new MenuButton("Size", "size.png");
        clear = new MenuButton("Clear", "clear.png");
        background = new MenuButton("Bkground", "background.png");
        symmetry = new MenuButton("Symmetry", "symmetry.png");


        //Set Top menu Layout
        this.setLayout(new GridLayout(1, 8));

        //Add Buttons to the top menu
        this.add(file);
        this.add(brush);
        this.add(eraser);
        this.add(color);
        this.add(size);
        this.add(clear);
        this.add(symmetry);
        this.add(background);

        //Add mouse listener
        file.addMouseListener(new MenuButtonListener(file));
        brush.addMouseListener(new MenuButtonListener(brush));
        eraser.addMouseListener(new MenuButtonListener(eraser));
        color.addMouseListener(new MenuButtonListener(color));
        size.addMouseListener(new MenuButtonListener(size));
        clear.addMouseListener(new MenuButtonListener(clear));
        background.addMouseListener(new MenuButtonListener(background));
        symmetry.addMouseListener(new MenuButtonListener(symmetry));

    }

}

