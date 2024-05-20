package javas.obstacles;

import javas.Obstacle;

import java.util.Random;

public class Snake extends Obstacle {



    public Snake() {
        super(4, "Yılan", randDamage() , 12, 4);
    }

    public static int randDamage(){
        Random rand = new Random();
        return rand.nextInt(3,7) ;
    }

}
