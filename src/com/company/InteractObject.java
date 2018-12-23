package com.company;

import java.awt.*;

public abstract class InteractObject{
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

    public InteractObject(Integer x, Integer y, Color c){
        this.x = x;
        this.y = y;
        this.sizeX = 0;
        this.sizeY = 0;
        this.dx = 0;
        this.dy = 0;
        this.c = c;
    }

    public void draw(Graphics g){
        g.setColor(c);
    }

    public abstract void move(Integer boardWidth, Integer boardHeight, Integer dx, Integer dy);

    public Integer getX() { return this.x; }
    public Integer getY() { return this.y; }

    public void setX(Integer x) { this.x = x; }
    public void setY(Integer y) { this.y = y; }

    public Integer getDx() { return this.dx; }
    public Integer getDy() { return this.dy; }

    public void setDx(Integer dx) { this.dx = dx; }
    public void setDy(Integer dy) { this.dy = dy; }

}
