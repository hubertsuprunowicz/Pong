package com.company;

import java.awt.*;

public class Ball extends InteractObject {

    // Not final due to future implementation of powers(change height)
    private Integer racketWidth = 30;
    private Integer racketHeight= 100;


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

    /* Add player object */
    @Override
    public void move(Integer boardWidth, Integer boardHeight, Integer _dx, Integer _dy, Integer playerX, Integer playerY) {
        x += dx;
        y += dy;

        // Colliding with walls
        if( x+objWidth >= boardWidth || x <= 0 ) { dx = -dx; }
        if( y+objHeight >= boardHeight || y <= 0) { dy = -dy; }

        // Colliding with Player:
        // Right side of racket
        if(     x-objWidth/2 <= playerX+racketWidth/2 &&
                y-objHeight/2 <= playerY+racketHeight/2 &&
                y-objHeight/2 >= playerY-racketHeight/2)
        { dx = -dx; }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x, y, objWidth, objHeight);
    }
}
