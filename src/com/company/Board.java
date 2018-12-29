package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Board extends JPanel implements SizeObject {
    private Timer time;
    private Ball ball;
    private Player player;
    private Player ai;

    private Integer playerY;

    /* get resolution from UI class*/
    private Integer width ;
    private Integer height ;

    Board(Integer width, Integer height) {
        super();

        this.height = height;
        this.width = width;

        ball = new Ball(width/2,height/2, BALL_WIDTH, BALL_HEIGHT,-8, -8, Color.RED);
        player = new Player(10 ,height/2, RACKET_WIDTH, RACKET_HEIGHT,0, 0, Color.WHITE);
        ai = new Player(width-10 ,height/2, RACKET_WIDTH, RACKET_HEIGHT,0, 0, Color.WHITE);

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
                ball.move(width, height, ai.getX(), ai.getY(), player.getX(), player.getY());
                player.move(width, height, 0, 10,0, 0);
                ai.move(width, height, 0, 10, ball.getX(), ball.getY());
                repaint();

                if(ball.leftWallCollide(width)) {
                    endGame();
                    ai.points++;
                } else if(ball.rightWallCollide(width)) {
                    endGame();
                    player.points++;
                }
            }
        });
    }

    public void add(String item) {

        switch (item.toLowerCase()) {
            case "ball":
                ball.setX(width/2);
                ball.setY(height/2);
               // repaint();
                break;
            case "player":
                player.setX(10);
                player.setY(height/2);

                ai.setX(width-10);
                ai.setY(height/2);

                repaint();
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

    public void endGame() {
        add("player");
        add("ball");
        time.stop();
    }

    @Override
    public Dimension getPreferredSize() {
        // After rendering panel is getting minus 26 of initialised size
        return new Dimension(this.width,this.height + 26);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player.draw(g);
        ai.draw(g);
        g.drawLine(width/2,0,width/2,height);
        g.drawOval(width/2 - width/8, height/2 - height/4, width/4, height/2);

        this.width = getWidth();
        this.height = getHeight();

    }

}
