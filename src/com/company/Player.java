package com.company;

import java.awt.*;

public class Player extends InteractObject  {
    public Integer points = 0;

    public Player(Integer x, Integer y, Integer objWidth, Integer objHeight, Integer dx, Integer dy, Color c) {
        super(x,y,objWidth,objHeight,dx,dy,c);
    }

    public void move(Integer boardWidth, Integer boardHeight, Integer _dx, Integer _dy, Integer pX, Integer pY) {
        //y += dy;

        // Here starts very complicated AI algorithm
        if(pY != 0) y = pY;
        // Here ends.

        if(y-objHeight/2 <= 0) { y = objHeight/2; } // Top
        else if(y >= boardHeight - objHeight/2) { y = boardHeight - objHeight/2; } // Bottom
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x-(objWidth/2), y-(objHeight/2), objWidth, objHeight);
    }

}
