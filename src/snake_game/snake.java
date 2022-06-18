package snake_game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class snake {
    public ArrayList<Rectangle> body;
    private String move; //nothing up down left right

    public snake() {
        body = new ArrayList<>();
        Rectangle temp = new Rectangle(game.dimensions, game.dimensions);
        temp.setLocation(game.width / 2 * game.dimensions, game.height / 2 * game.dimensions);
        body.add(temp);

        int d = game.dimensions;
        temp = new Rectangle(d, d);
        int w = game.width;
        int h = game.height;
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);
        move = "nothing";
    }

    public void move() {
        if (!Objects.equals(move, "nothing")) {
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(game.dimensions, game.dimensions);
            if (Objects.equals(move, "u")) {
                temp.setLocation(first.x, first.y - game.dimensions);

            } else if (Objects.equals(move, "d")) {
                temp.setLocation(first.x, first.y + game.dimensions);
            } else if (Objects.equals(move, "l")) {
                temp.setLocation(first.x - game.dimensions, first.y);
            } else {
                temp.setLocation(first.x + game.dimensions, first.y);
            }
            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(game.dimensions, game.dimensions);
        if (Objects.equals(move, "u")) {
            temp.setLocation(first.x, first.y - game.dimensions);

        } else if (Objects.equals(move, "d")) {
            temp.setLocation(first.x, first.y + game.dimensions);
        } else if (Objects.equals(move, "l")) {
            temp.setLocation(first.x - game.dimensions, first.y);
        } else {
            temp.setLocation(first.x + game.dimensions, first.y);
        }
        body.add(0, temp);
    }

    public ArrayList<Rectangle> getbody() {
        return body;
    }

    public int get_x() {
        return body.get(0).x;
    }

    public int get_y() {
        return body.get(0).y;
    }

    public String get_move() {
        return move;
    }

    public void up() {
        move = "u";
    }

    public void down() {
        move = "d";
    }

    public void left() {
        move = "l";
    }

    public void right() {
        move = "r";
    }
}
