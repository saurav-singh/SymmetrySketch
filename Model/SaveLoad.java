package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class SaveLoad {

    //Save method - Saves ConfigSave object
    public static void save(ConfigSave config, String fileName) {

        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(config);
            f.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Load method - Loads ConfigSave object
    public static void load(String fileName){

        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(f);
            ConfigSave CS = (ConfigSave) in.readObject();

            Config config = new Config();
            config.loadData(CS);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Export method - Saves ArtCanvas as image
    public static void export(Component canvas, String fileName){

        try {
            BufferedImage image = new BufferedImage(canvas.getWidth(),canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
            canvas.paint(image.getGraphics());
            ImageIO.write(image,"jpg",new File(fileName+".jpg"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
