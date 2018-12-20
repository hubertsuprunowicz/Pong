package com.company;

import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    private Timer time;
    private Ball ball;
    private Player player;
    private final Integer width = 1904;
    private final Integer height = 970;

    Board() {
        super();

        ball = new Ball(width/2,height/2,35,35,10, 10, Color.WHITE);

        time = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move(width, height);
                repaint();
            }
        });
    }

    public void add(String item) {
        switch (item) {
            case "ball":
                ball.setX(width/2);
                ball.setY(height/2);
                repaint();
                time.stop();
                break;

            case "player":
                break;

                default:
                    break;
        }

    }

    public void stopGame() {
        time.stop();
    }

    public void startGame() {
        time.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }
}
