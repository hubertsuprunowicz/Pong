package com.company;

import java.awt.*;

public class Ball extends InteractObject {

    public Ball(Integer x, Integer y, Integer sizeX, Integer sizeY, Integer dx, Integer dy, Color c) {
        super(x,y,sizeX,sizeY,dx,dy,c);
    }

    public Ball(Integer x, Integer y, Color c) {
        super(x,y,c);
        this.dx = 0;
        this.dy = 0;
        this.sizeX = 35;
        this.sizeY = 35;
    }

    @Override
    public void move(Integer boardWidth, Integer boardHeight) {
        x += dx;
        y += dy;

        if( x >= boardWidth-sizeX || x <= 0 ) {
            dx = -dx;
        }

        if( y >= boardHeight-sizeY || y <= 0) {
            dy = -dy;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x, y, sizeX, sizeY);
    }
}
