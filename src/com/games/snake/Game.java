package com.games.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends KeyAdapter
{
    private boolean isPlaying;
    private int score;
    private int ballSpawnTime;
    private final Snake snake;
    private final Ball ball;
    private final Graphics g;
    private static final int ballSpawnRate = 150;
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 720;
    public final static JFrame mainWindow;

    static{
        Dimension preferredResolution = new Dimension(WIDTH, HEIGHT);
        mainWindow = new JFrame();
        mainWindow.setTitle("Snake Game");
        mainWindow.setSize(preferredResolution);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane().setBackground(Color.BLACK);
    }

    public Game()
    {
        isPlaying = false;
        g = mainWindow.getGraphics();
        snake = new Snake(new Point((WIDTH - 80 )/ 2, HEIGHT / 2));
        mainWindow.addKeyListener(this);
        ball = new Ball();
        ballSpawnTime = 0;
        score = 0;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(isPlaying)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    snake.move(Directions.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    snake.move(Directions.DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.move(Directions.RIGHT);
                    break;
                case KeyEvent.VK_LEFT:
                    snake.move(Directions.LEFT);
                    break;
                case KeyEvent.VK_ESCAPE:
                    stop();
                    break;
            }
            g.clearRect(0, 0, WIDTH, HEIGHT);
            if(ballSpawnTime < ballSpawnRate)
            {
                if(ballSpawnTime == 1)
                {
                    ball.spawn();
                }
                ballSpawnTime++;
            }
            else
            {
                ballSpawnTime = 0;
            }
            draw();
            logic();
        }
    }

    public void start()
    {
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", Font.BOLD, 65));
        g.drawString("Snake Game", (WIDTH - g.getFontMetrics().stringWidth("Snake Game")) / 2, HEIGHT / 2 - 100);
        g.setFont(new Font("Tahoma", Font.BOLD, 16));
        int strWidth = g.getFontMetrics().stringWidth("Press Any Key To Start ...");
        g.drawString("Press Any Key To Start ...", (WIDTH - strWidth) / 2, HEIGHT / 2);
        isPlaying = true;
    }

    public void stop()
    {
        isPlaying = false;
    }

    public void logic()
    {
        boolean isCollided = snake.onCollision(ball);
        if(isCollided)
        {
            score++;
            System.out.println("Score: " + score);
            g.setColor(Color.WHITE);
            g.clearRect(ball.position.x, ball.position.y, ball.getShape().width, ball.getShape().height);
            snake.increaseLen();
            ball.spawn();
        }
    }

    public void draw()
    {
        g.setFont(new Font("Tahoma", Font.BOLD, 16));
        g.setColor(Color.white);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        g.fillRect(snake.getShape().x, snake.getShape().y, snake.getShape().width, snake.getShape().height);
        g.setColor(Color.YELLOW);
        g.fillRect(ball.getShape().x, ball.getShape().y, ball.getShape().width, ball.getShape().height);
        g.setColor(Color.white);

        // drawing the menu
        g.setColor(Color.BLACK);
        g.fillRect(0, HEIGHT - 70, WIDTH, 70);
        g.setColor(Color.white);
        g.drawString("Score: " + score, 20, HEIGHT - 50);
    }
}
