package com.company;

import java.awt.*;

public class Player extends InteractObject  {

    public Player(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy, Color c) {
        super(x,y,objWidth,objHeight,dx,dy,c);
    }

    public void move(Integer boardWidth, Integer boardHeight, Integer _dx, Integer _dy, Integer pX, Integer pY) {
        if(y <= 0) {
            y = 0;
        }

        if(y >= boardHeight - objHeight) {
            y = boardHeight - objHeight;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x, y, objWidth, objHeight);
    }

}
