package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    private Timer time;
    public Ball ball;
    protected Integer width, height;

    Board() {
        super();
        ball = new Ball(200, 200, 50, 10,10, Color.WHITE);
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

        Random rand = new Random();

        ball.draw(g);
        for(int i=0; i<100; i++) {
            time.start();
        }

//        Kolo k = new Kolo(200,200,100,0,1,Color.BLACK);
//        k.draw(g);
    }
}
