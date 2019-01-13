package com.company;

import java.util.concurrent.ThreadLocalRandom;

class Direction {
    private static int randDirection;

    Direction(int value) {
        randDirection = ThreadLocalRandom.current().nextInt(0, 2);
        randDirection = (randDirection == 1) ? value : -value;
    }

    Integer getDirection(){
        return randDirection;
    }

}