package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Board extends JPanel {
    private Timer time;
    private Ball ball;
    private Player player;

    private Integer playerY;

    /* get resolution from UI class*/
    private final Integer width = 1904;
    private final Integer height = 970;
    private final Integer margin = 20;

    Board() {
        super();

        ball = new Ball(width/2,height/2,35,35,10, 10, Color.WHITE);
        player = new Player(margin ,height/2,30,100,0, 0, Color.WHITE);

        // Binding Keys
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down");

        // Actions taken for specified ID key
        ActionMap ap = this.getActionMap();
        ap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setY(player.getY()-10);
            }
        });
        ap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setY(player.getY()+10);
            }
        });


        time = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move(width, height, 10, 10, player.getX(), player.getY());
                player.move(width, height, 0, 10,0, 0);
                repaint();
            }
        });
    }

    public void add(String item) {
        switch (item.toLowerCase()) {
            case "ball":
                ball.setX(width/2);
                ball.setY(height/2);
                repaint();
                time.stop();
                break;
            case "player":
                player.setX(20);
                player.setY(height/2);
                repaint();
                time.stop();
                break;

                default:
                    // TRY CATCH EXCEPTION
                    break;
        }

    }

    public void stopGame() {
        this.playerY = player.getY();
        time.stop();
    }

    public void startGame() {
        time.start();
        player.setY( Objects.requireNonNullElse(this.playerY, player.getY()) );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player.draw(g);
    }

}
