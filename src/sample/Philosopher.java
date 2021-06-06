package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Philosopher implements Runnable{
    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Circle ph;

    Thread t = new Thread();

    Philosopher(int id, Chopstick left, Chopstick right, Circle ph){
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
        this.ph = ph;
    }

    @Override
    public void run(){
        while(true) {
            eat();
            think();
        }
    }

    public void eat(){
       try{
           synchronized (leftChopstick){
               while(leftChopstick.isInUse());  //Wait until the left chopstick is available to pick
               leftChopstick.take();            //Pick the left chopstick

               synchronized (rightChopstick){
                   while(rightChopstick.isInUse()); //Wait until the right chopstick is available to pick
                   rightChopstick.take();           //Pick the right chopstick

                   ph.setFill(Color.DARKRED);   //Philosopher is eating

                   Thread.currentThread().sleep((int) (Math.random() * 3000));

                   rightChopstick.release();    //Release right chopstick
               }
               leftChopstick.release();     //Release left chopstick
           }
           synchronized (ph){
               ph.setFill(Color.BLUE);  //Philosopher stopped eating
           }
       }
       catch(InterruptedException e){
           e.printStackTrace();
       }
    }

    public void think(){
        try{
            ph.setFill(Color.BLUE);

            Thread.currentThread().sleep((int) (Math.random() * 3000));
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}