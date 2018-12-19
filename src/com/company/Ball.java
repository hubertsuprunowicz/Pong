package com.company;

import java.awt.*;

public class Ball extends InteractObject {

    public Ball(Integer x, Integer y, Integer sizeX, Integer dx, Integer dy, Color c) {
        // dx & dy should be random
        super(x,y,sizeX,sizeX,dx,dy,c);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x, y, sizeX, sizeX);
    }
}
