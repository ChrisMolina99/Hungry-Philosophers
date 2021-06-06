package sample;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Controller {
    private Circle[] ph;
    private Rectangle[] ch;

    @FXML
    Circle ph0, ph1, ph2, ph3, ph4;

    @FXML
    Rectangle ch0, ch1, ch2, ch3, ch4;

    @FXML
    public void initialize(){
        ph = new Circle[5];
        ch = new Rectangle[5];

        ph[0] = ph0; ph[1] = ph1; ph[2] = ph2; ph[3] = ph3; ph[4] = ph4;
        ch[0] = ch0; ch[1] = ch1; ch[2] = ch2; ch[3] = ch3; ch[4] = ch4;

        //Create the chopstick objects and assign the respective rectangle
        ArrayList<Chopstick> chopsticks = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            chopsticks.add(new Chopstick(i, ch[i]));

        //Create the philosopher objects and assign each circle
        ArrayList<Philosopher> philosophers = new ArrayList<>();
        philosophers.add(new Philosopher(0, chopsticks.get(4), chopsticks.get(0), ph[0]));
        for(int i = 1; i < 5; i++)
            philosophers.add(new Philosopher(i, chopsticks.get(i - 1), chopsticks.get(i), ph[i]));

        //Start a thread for each philosopher
        for(Philosopher x : philosophers)
            new Thread(x).start();
    }


}
