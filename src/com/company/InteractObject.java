package com.company;

import java.awt.*;

public abstract class InteractObject implements SizeObject {
    protected Integer x,y;
    protected Integer objWidth, objHeight;
    protected Integer dx, dy;
    protected Color c;

    public InteractObject(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy, Color c) {
        this.x = x;
        this.y = y;
        this.objWidth = objWidth;
        this.objHeight = objHeight;
        this.dx = dx;
        this.dy = dy;
        this.c = c;
    }

    public InteractObject(Integer x, Integer y, Color c) {
        this.x = x;
        this.y = y;
        this.objWidth = 0;
        this.objHeight = 0;
        this.dx = 0;
        this.dy = 0;
        this.c = c;
    }

    public void draw(Graphics g){ g.setColor(c); }

    public abstract void move(Integer boardWidth, Integer boardHeight, Integer dx, Integer dy, Integer pX, Integer pY);

    public Integer getX() { return this.x; }
    public Integer getY() { return this.y; }

    public void setX(Integer x) { this.x = x; }
    public void setY(Integer y) { this.y = y; }

    public Integer getDx() { return this.dx; }
    public Integer getDy() { return this.dy; }

    public void setDx(Integer dx) { this.dx = dx; }
    public void setDy(Integer dy) { this.dy = dy; }

}
