package snake_game;

import java.awt.*;
import java.util.ArrayList;

public class snake {
    private ArrayList<Rectangle>body;
    private int w=game.width;
    private int h=game.height;
    private int d=game.dimensions;
    public snake()
    {
        body = new ArrayList<>();
        Rectangle temp=new Rectangle(d,d);
        temp.setLocation(w/2*d,h/2*d);
        body.add(temp);

        temp=new Rectangle(d,d);
        temp.setLocation((w/2-1)*d,(h/2-1)*d);
        body.add(temp);

        temp=new Rectangle(d,d);
        temp.setLocation((w/2-2)*d,(h/2-2)*d);
        body.add(temp);
    }

}
