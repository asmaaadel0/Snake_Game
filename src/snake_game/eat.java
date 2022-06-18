package snake_game;

import java.awt.*;

public class eat {
    private int x;
    private int y;


    public eat(snake player) {
        this.random(player);
    }

    public void random(snake s) {
        boolean touch_snake = true;

        while (touch_snake) {
            touch_snake=false;
            x = (int)(Math.random() * game.width - 1);
            y = (int)(Math.random() * game.height - 1);
            for (Rectangle r : s.body) {
                if (r.x == x && r.y == y) {
                    touch_snake = true;
                    break;
                }
            }
        }
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
}
