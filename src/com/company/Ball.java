package com.company;

import java.awt.*;

public class Ball extends InteractObject {
    private final static Integer MAX_SPEED = 13;
    private Player racket = new Player();
    private Integer bounceCounting = 0;

    public Ball(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy, Color c) {
        super(x,y,objWidth,objHeight,dx,dy,c);
    }

    public Ball(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy) {
        super(x, y, objWidth, objHeight, dx, dy);
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.objWidth = objWidth;
        this.objHeight = objHeight;
    }

    protected Boolean rightWallCollide(Integer boardWidth) { return (x + (objWidth/2) >= boardWidth); }
    protected Boolean leftWallCollide() { return (x - (objWidth/2) <= 0); }
    public void isMoving(Integer playerDy) { this.racket.dy = playerDy; }

    @Override
    public void move(Integer boardWidth, Integer boardHeight, Integer aiX, Integer aiY, Integer playerX, Integer playerY) {
        x += dx;
        y += dy;

        racket.objWidth = 5;
        racket.objHeight = boardHeight/4;

        // Colliding with walls
        if( y+objHeight/2 >= boardHeight || y-objHeight/2 <= 0) {
            dy = -dy;
            y += dy;
        }

        // Left Racket = PLAYER
        if(leftSideOf(x,objWidth) <= rightSideOf(playerX, racket.objWidth )) {
            if (topSideOf(y, objHeight) >= topSideOf(playerY, racket.objHeight)  && bottomSideOf(y, objHeight) <= bottomSideOf(playerY, racket.objHeight) ) {
                dx = -dx;
                bounceCounting++;
                increaseSpeed(dx,dy);

            }
        }

        // Right racket = AI
        if(rightSideOf(x,objWidth) >= leftSideOf(aiX, racket.objWidth)) {
            if (topSideOf(y, objHeight) >= topSideOf(aiY, racket.objHeight) && bottomSideOf(y, objHeight) <= bottomSideOf(aiY, racket.objHeight)) {
                dx = -dx;
                bounceCounting++;
                increaseSpeed(dx,dy);
            }
        }
    }

    private void increaseSpeed(Integer dx, Integer dy) {
        if(bounceCounting % 3 == 0) {
            if (Math.abs(dx) < MAX_SPEED || Math.abs(dy) < MAX_SPEED) {
                if (dx < 0) this.dx--;
                else this.dx++;

                if (dy < 0) this.dy--;
                else this.dy++;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x-(objWidth/2), y-(objHeight/2), objWidth, objHeight);
    }
}
