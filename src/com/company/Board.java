package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    private Timer time;
    protected Ball ball;
    protected Integer width, height;

    Board() {
        super();

        ball = new Ball(200, 200, 30, 0,0, Color.WHITE);
        time = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move(width,height);
                repaint();
            }
        });

    }


    public void add(String item) {
        Random random = new Random();
        switch (item) {
            case "ball":
                ball = new Ball(200, 200, 30, 10,random.nextInt(9)+1, Color.WHITE);
                break;
            case "player":
                break;

                default:
                    break;
        }

        time = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move(width,height);
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.width = getWidth();
        this.height = getHeight();

        ball.draw(g);
        time.start();


//        Kolo k = new Kolo(200,200,100,0,1,Color.BLACK);
//        k.draw(g);
    }
}
