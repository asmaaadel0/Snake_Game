package snake_game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class game implements KeyListener {
    private snake player;
    private food food;
    private graphics graphics;
    private JFrame window;
    static int width = 40;
    static int height = 40;
    static int dimensions = 30;
    public game()
    {
        window=new JFrame();
        window.setTitle("snake game");
        window.setSize(width * dimensions, height * dimensions);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_W){
            //up
        }
        else if(keycode==KeyEvent.VK_S){
            //down
        }
        else if(keycode==KeyEvent.VK_A){
            //left
        }
        else if(keycode==KeyEvent.VK_D){
            //right
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
