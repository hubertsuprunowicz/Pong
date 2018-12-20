package com.company;

import java.awt.*;

public class InteractObject {
    protected Integer x,y;
    protected Integer sizeX, sizeY;
    protected Integer dx, dy;
    protected Color c;

    public InteractObject(Integer x, Integer y, Integer sizeX, Integer sizeY, Integer dx, Integer dy, Color c){
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.dx = dx;
        this.dy = dy;
        this.c = c;
    }

    public void draw(Graphics g){
        g.setColor(c);
    }

    final public void move(Integer width, Integer height) {
        x += dx;
        y += dy;

        if( x >= width-sizeX || x <= 0 ) {
            dx = -dx;
        }

        if( y >= height-sizeY || y <= 0) {
            dy = -dy;
        }
    }

    public Integer getDx() {
        return this.dx;
    }

    public Integer getDy() {
        return this.dy;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public void setDy(Integer dy) {
        this.dy = dy;
    }


}
