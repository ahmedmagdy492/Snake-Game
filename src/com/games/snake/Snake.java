package com.games.snake;

import java.awt.*;

public class Snake extends GameObject
{
    private int len;
    private Directions curDirection;
    private final float speed;
    private Rectangle shape;
    private int width, height;

    Snake(Point startPosition)
    {
        len = 0;
        curDirection = Directions.RIGHT;
        speed = 14f;
        position = new Point(startPosition);
        width = 80;
        height = 40;
        shape = new Rectangle(position.x, position.y, width, height);
    }

    Rectangle getShape() {
        return shape;
    }

    public int increaseLen() {
        len++;
        width += 10;
        shape.width = width;
        return len;
    }

    boolean onCollision(Ball ball)
    {
        return ((ball.position.y >= position.y && ball.position.y <= position.y + shape.height) ||
                (ball.position.y + ball.getShape().height >= position.y &&
                        ball.position.y + ball.getShape().height <= position.y + shape.height)) &&
                (ball.position.x >= position.x && ball.position.x <= position.x + shape.width);
    }

    void move(Directions dir)
    {
        switch(dir)
        {
            case UP: {
                position.y -= speed;
                break;
            }
            case DOWN: {
                position.y += speed;
                break;
            }
            case LEFT: {
                if(position.x + width <= 0)
                {
                    position.x = Game.WIDTH;
                }
                position.x -= speed;
                break;
            }
            case RIGHT: {
                if(position.x >= Game.WIDTH)
                {
                    position.x = -width;
                }
                position.x += speed;
                break;
            }
        }
        shape = new Rectangle(position.x, position.y, width, height);
    }

}
