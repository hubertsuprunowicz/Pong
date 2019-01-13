package com.company;

import java.awt.*;

public class Player extends InteractObject  {
    public Integer points = 0;
    private Integer delay = 0;

    public Player(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy) {
        super(x, y, objWidth, objHeight, dx, dy);
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.objWidth = objWidth;
        this.objHeight = objHeight;
    }

    public Player() {
        this.x = 0;
        this.y = 0;
        this.dx = 0;
        this.dy = 0;
        this.objWidth = 0;
        this.objHeight = 0;
    }

    public void move(Integer boardWidth, Integer boardHeight, Integer _dx, Integer _dy, Integer ballX, Integer ballY) {
        y += dy;

        // Here starts complex AI algorithm
        if(ballY != 0) {
            // React only if ball is near in 3/4 of boardWidth to AI
            if(ballX > boardWidth/4) {
//                LEVEL 1
//                if(y < ballY) y += 4;
//                if(y > ballY) y -= 4;

//                LEVEL 2
//                if(y < ballY) y += 7;
//                if(y > ballY) y -= 7;

//                LEVEL 3
                if(y < ballY) y += 11;
                if(y > ballY) y -= 11;
            }
        }
        // Here ends.

        if(y - objHeight/2 <= 0) { y = objHeight/2; } // Top
        else if(y >= boardHeight - objHeight/2) { y = boardHeight - objHeight/2; } // Bottom
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x-(objWidth/2), y-(objHeight/2), objWidth, objHeight);
    }

}
