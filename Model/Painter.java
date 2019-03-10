package Model;

import View.ArtCanvas;

public class Painter {

    //---------------------------- Attribute ------------------------------------------

    private static ArtCanvas canvas;

    //---------------------------- Constructor -----------------------------------------

    public Painter(ArtCanvas c){
        this.canvas = c;
    }

    //---------------------------- Static Constructor ----------------------------------

    public Painter(){}

    //---------------------------- Helper Methods --------------------------------------

    //Repaints the canvas
    public void re_paint(){ this.canvas.repaint(); }

    //Loads data into canvas from config
    public void load_data() {
        Config config = new Config();
        this.canvas.loadData(config);
    }

    //Returns current canvas
    public ArtCanvas getCanvas() { return canvas; }

}
