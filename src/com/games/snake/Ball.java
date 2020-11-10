package com.games.snake;

import java.awt.*;
import java.util.Random;

class Ball extends GameObject
{
    private final Rectangle shape;
    private final int width;
    private final int height;

    Ball()
    {
        position = new Point();
        width = 40;
        height = 40;
        shape = new Rectangle();
    }

    Rectangle getShape() {
        return shape;
    }

    void spawn()
    {
        Random rand = new Random();
        position.x = rand.nextInt(Game.WIDTH - width);
        position.y = rand.nextInt(Game.HEIGHT - 70 - height);
        shape.x = position.x;
        shape.y = position.y;
        shape.width = width;
        shape.height = height;
    }
}
