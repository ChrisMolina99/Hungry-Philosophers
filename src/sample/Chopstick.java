package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Chopstick{
    private int id;
    private boolean inUse;
    private Rectangle ch;

    Chopstick(int id, Rectangle ch){
        this.id = id;
        this.inUse = false;
        this.ch = ch;
    }

    public synchronized void release(){
        synchronized (ch) {
            ch.setFill(Color.BLUE);
            inUse = false;
        }
    }

    public synchronized void take(){
        synchronized (ch){
            ch.setFill(Color.BLUEVIOLET);
            inUse = true;
        }
    }

    public synchronized boolean isInUse(){
        return inUse;
    }

    public synchronized int getId(){
        return id;
    }
}
