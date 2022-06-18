package snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class graphics extends JPanel implements ActionListener {

    public String status;
    private final snake s;
    private final food f;
    private final game g;

    public graphics(game g)
    {
        status="start";
        Timer time = new Timer(100, this);
        time.start();
        this.g=g;
        this.s=g.getPlayer();
        this.f=g.getFood();
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }
    public void paintComponent(Graphics graph)
    {
        super.paintComponent(graph);
        Graphics2D g=(Graphics2D) graph;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,game.width*game.dimensions+5,game.height*game.dimensions+5);
        if(Objects.equals(status, "start"))
        {
            g.setColor(Color.white);
            g.drawString("press any key to start",game.width/2*game.dimensions-40,game.height/2*game.dimensions-20);
        }
        else if(Objects.equals(status, "running"))
        {
            g.setColor(Color.YELLOW);
            g.fillRect(f.getx()*game.dimensions,f.gety()*game.dimensions,game.dimensions,game.dimensions);
            g.setColor(Color.GREEN);
            for (Rectangle r:s.body)
            {
                g.fill(r);
            }
        }
        else{
            g.setColor(Color.white);
            g.drawString("your score: "+(s.body.size()-3),game.width/2*game.dimensions-40,game.height/2*game.dimensions-20);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    repaint();
    g.update();
    }
}
