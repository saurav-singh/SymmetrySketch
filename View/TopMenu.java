package View;

import Model.Config;

import javax.swing.*;
import java.awt.*;

public class TopMenu extends JPanel {

    Point position;

    public TopMenu() {

        this.setLayout(new GridLayout(1, 8));
        this.add(new MenuButton("File","Apple"));
        this.add(new MenuButton("Brush","brush"));
        this.add(new MenuButton("Eraser","brush"));
        this.add(new MenuButton("Color","brush"));
        this.add(new MenuButton("Size","brush"));
        this.add(new MenuButton("Clear","brush"));
        this.add(new MenuButton("Symmetry","brush"));
        this.add(new MenuButton("Something", "hello"));

    }

}

