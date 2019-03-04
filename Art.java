import Model.Config;
import Model.Painter;
import View.ArtCanvas;
import View.TopMenu;

import javax.swing.*;
import java.awt.*;

public class Art {

    public static void main(String[] args) {

        //Initialize JFrame
        JFrame frame = new JFrame("Symmetrik");
        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set frame in center
        frame.setLocationRelativeTo(null);

        //Initialize Model class
        Config config = new Config(frame);
        //Initialize ArtCanvas
        ArtCanvas canvas = new ArtCanvas(config);
        //Setup Canvas for Painter
        new Painter(canvas);

        //Initialize JPanel and Add menu and canvas into the frame
        JPanel GUI = new JPanel();
        GUI.setLayout(new BorderLayout());
        GUI.add(new TopMenu(), BorderLayout.NORTH);
        GUI.add(canvas, BorderLayout.CENTER);

        //Add panel to the frame
        frame.getContentPane().add(GUI);

        //Show frame
        frame.setVisible(true);
    }

}
