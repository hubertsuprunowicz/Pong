package com.company;

import java.awt.*;

public class Player extends InteractObject  {

    public Player(Integer x, Integer y, Integer sizeX, Integer sizeY, Integer dx, Integer dy, Color c) {
        super(x,y,sizeX,sizeY,dx,dy,c);
    }


    public void move(Integer boardWidth, Integer boardHeight, Integer _dx, Integer _dy) {
        if(y <= 0) {
            y = 0;
        }

        if(y >= boardHeight - sizeY) {
            y = boardHeight - sizeY;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x, y, sizeX, sizeY);
    }



}
