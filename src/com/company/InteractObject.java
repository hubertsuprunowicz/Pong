package com.company;

import java.awt.*;

public abstract class InteractObject {
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

    public InteractObject(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy) {
        this.x = x;
        this.y = y;
        this.objWidth = objWidth;
        this.objHeight = objHeight;
        this.dx = dx;
        this.dy = dy;
        this.c = Color.WHITE;
    }

    public InteractObject() {
        this.x = 0;
        this.y = 0;
        this.objWidth = 0;
        this.objHeight = 0;
        this.dx = 0;
        this.dy = 0;
        this.c = Color.WHITE;
    }

    public void draw(Graphics g){ g.setColor(c); }

    public abstract void move(Integer boardWidth, Integer boardHeight, Integer dx, Integer dy, Integer pX, Integer pY);

    public Integer leftSideOf(Integer x, Integer objWidth) {
        return x-(objWidth/2);
    }
    public Integer rightSideOf(Integer x, Integer objWidth) {
        return x+(objWidth/2);
    }
    public Integer topSideOf(Integer y, Integer objHeight) {
        return y-(objHeight/2);
    }
    public Integer bottomSideOf(Integer y, Integer objHeight) {
        return y+(objHeight/2);
    }

//    public Integer getX() { return this.x; }
//    public Integer getY() { return this.y; }
//
//    public void setX(Integer x) { this.x = x; }
//    public void setY(Integer y) { this.y = y; }
//
//    public Integer getDx() { return this.dx; }
//    public Integer getDy() { return this.dy; }
//
//    public void setDx(Integer dx) { this.dx = dx; }
//    public void setDy(Integer dy) { this.dy = dy; }

}
