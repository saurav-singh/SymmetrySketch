package Model;

import View.ArtCanvas;

public class Painter {

    private static ArtCanvas canvas;

    public Painter(ArtCanvas c){
        this.canvas = c;
    }

    public Painter(){
        //for static call
    }

    public void re_paint(){
        this.canvas.repaint();
    }

    public void load_data() {
        Config config = new Config();
        this.canvas.loadData(config);
    }
}
