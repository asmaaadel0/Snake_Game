package snake_game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class game implements KeyListener {
    private final snake player;
    private final food food;
    private final graphics graphic;
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimensions = 20;

    public game() {
        JFrame window = new JFrame();
        player = new snake();
        food = new food(player);
        graphic = new graphics(this);
        window.add(graphic);
        window.setTitle("snake game");
        window.setSize(width * dimensions+2, height * dimensions + dimensions+4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        graphic.status = "running";
    }

    public void update() {
        if (Objects.equals(graphic.status, "running")) {
            if (check_food()) {
                player.grow();
                food.random(player);
            } else if (check_die() || checkcollision()) {
                graphic.status = "end";
            } else {
                player.move();
            }
        }
    }

    public boolean check_die() {
        return player.getx() < 0 || player.getx() >= width * dimensions || player.gety() < 0 || player.gety() >= height * dimensions;
    }

    public boolean check_food() {
        return player.getx() == food.getx() * dimensions && player.gety() == food.gety() * dimensions;
    }

    public boolean checkcollision() {
        for (int i = 1; i < player.getbody().size(); i++) {
            if (player.getx() == player.body.get(i).x &&
                    player.gety() == player.body.get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (Objects.equals(graphic.status, "running")) {
            if (keycode == KeyEvent.VK_UP&& !Objects.equals(player.getmove(), "d")) {
                //up
                player.up();
            } else if (keycode == KeyEvent.VK_DOWN&& !Objects.equals(player.getmove(), "u")) {
                //down
                player.down();
            } else if (keycode == KeyEvent.VK_LEFT&& !Objects.equals(player.getmove(), "r")) {
                //left
                player.left();
            } else if (keycode == KeyEvent.VK_RIGHT&& !Objects.equals(player.getmove(), "l")) {
                //right
                player.right();
            }
        }
        else
        {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public snake getPlayer() {
        return player;
    }

    public food getFood() {
        return food;
    }

}
