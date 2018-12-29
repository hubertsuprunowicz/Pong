package com.company;

import java.awt.*;

public class Ball extends InteractObject {

    public Ball(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy, Color c) {
        super(x,y,objWidth,objHeight,dx,dy,c);
    }

    public Ball(Integer x, Integer y, Color c) {
        super(x,y,c);
        this.dx = 0;
        this.dy = 0;
        this.objWidth = 35;
        this.objHeight = 35;
    }

    public Boolean rightWallCollide(Integer boardWidth) {

        if( x+objWidth/2 >= boardWidth) {
            System.out.println("hit right wall");

            return true;
        }

        return false;
    }

    public Boolean leftWallCollide(Integer boardWidth) {

        if( x-objWidth/2 <= 0 ) {
            System.out.println("hit left wall");
            return true;
        }

        return false;
    }

    /* Add player object */
    @Override
    public void move(Integer boardWidth, Integer boardHeight, Integer aiX, Integer aiY, Integer playerX, Integer playerY) {
        x += dx;
        y += dy;

        //TODO: add speedUp after hit with racket

        // Colliding with walls
        if( x+objWidth/2 > boardWidth || x-objWidth/2 < 0 ) { dx = -dx; }
        if( y+objHeight/2 > boardHeight || y-objHeight/2 < 0) { dy = -dy; }


        // Racket's right = PLAYER
        if(leftSideOf(x,objWidth) < rightSideOf(playerX,RACKET_WIDTH)) {
            if (topSideOf(y, objHeight) > topSideOf(playerY, RACKET_HEIGHT) && bottomSideOf(y, objHeight) < bottomSideOf(playerY, RACKET_HEIGHT)) {
                dx = -dx;
                x++;
            }
        }

        // Racket's left = AI
        if(rightSideOf(x,objWidth) > leftSideOf(aiX,RACKET_WIDTH)) {
            if (topSideOf(y, objHeight) > topSideOf(aiY, RACKET_HEIGHT) && bottomSideOf(y, objHeight) < bottomSideOf(aiY, RACKET_HEIGHT)) {
                dx = -dx;
                x--;
            }
        }


    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x-(objWidth/2), y-(objHeight/2), objWidth, objHeight);
    }
}
