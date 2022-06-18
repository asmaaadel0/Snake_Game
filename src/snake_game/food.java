package snake_game;

import java.awt.*;

public class food {
    private int x;
    private int y;

    public food(snake player) {
        this.random(player);
    }

    public void random(snake s) {

        boolean onsnake = true;
        while (onsnake) {
            onsnake=false;
            x = (int)(Math.random() * game.width - 1);
            y = (int)(Math.random() * game.height - 1);
            for (Rectangle r : s.body) {
                if (r.x == x && r.y == y) {
                    onsnake = true;
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
