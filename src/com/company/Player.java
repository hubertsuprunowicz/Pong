package com.company;

import java.awt.*;

public class Player extends InteractObject {
    public Player(Integer x, Integer y, Integer sizeX, Integer sizeY, Integer dx, Integer dy, Color c) {
        super(x,y,sizeX,sizeY,dx,dy,c);
    }


    @Override
    public void move(Integer boardWidth, Integer boardHeight) {
        //
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x, y, sizeX, sizeY);
    }



}
