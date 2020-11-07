package com.games.snake;

import java.awt.*;

public class Snake extends GameObject
{
    private int len;
    private Directions curDirection;
    private float speed;
    private Rectangle shape;

    Snake(Point startPosition)
    {
        len = 0;
        curDirection = Directions.RIGHT;
        speed = 14f;
        position = new Point(startPosition);
        shape = new Rectangle(position.x, position.y, 40, 50);
    }

    public Rectangle getShape() {
        return shape;
    }

    public void onCollision(GameObject obj)
    {

    }

    public void move(Directions dir)
    {
        switch(dir)
        {
            case UP:
                position.y -= speed;
                break;
            case DOWN:
                position.y += speed;
                break;
            case LEFT:
                position.x -= speed;
                break;
            case RIGHT:
                position.x += speed;
                break;
        }
        shape = new Rectangle(position.x, position.y, 50, 40);
    }

}
