package snake_game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class game implements KeyListener {
    private final snake snake;
    private final eat food;
    private final graphics graphic;
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimensions = 20;

    public game() {
        JFrame window = new JFrame();
        snake = new snake();
        food = new eat(snake);
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
                snake.grow();
                food.random(snake);
            } else if (check_die() || check_collision_self()) {
                graphic.status = "end";
            } else {
                snake.move();
            }
        }
    }

    public boolean check_die() {
        return snake.get_x() < 0 || snake.get_x() >= width * dimensions || snake.get_y() < 0 || snake.get_y() >= height * dimensions;
    }

    public boolean check_food() {
        return snake.get_x() == food.getx() * dimensions && snake.get_y() == food.gety() * dimensions;
    }

    public boolean check_collision_self() {
        for (int i = 1; i < snake.getbody().size(); i++) {
            if (snake.get_x() == snake.body.get(i).x &&
                    snake.get_y() == snake.body.get(i).y) {
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
            if (keycode == KeyEvent.VK_UP&& !Objects.equals(snake.get_move(), "d")) {
                //up
                snake.up();
            } else if (keycode == KeyEvent.VK_DOWN&& !Objects.equals(snake.get_move(), "u")) {
                //down
                snake.down();
            } else if (keycode == KeyEvent.VK_LEFT&& !Objects.equals(snake.get_move(), "r")) {
                //left
                snake.left();
            } else if (keycode == KeyEvent.VK_RIGHT&& !Objects.equals(snake.get_move(), "l")) {
                //right
                snake.right();
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
        return snake;
    }

    public eat getFood() {
        return food;
    }

}
