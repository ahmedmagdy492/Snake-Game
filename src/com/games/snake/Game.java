package com.games.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends KeyAdapter
{
    private boolean isPlaying;
    private Snake snake;
    private final Graphics g;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 720;

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
        snake = new Snake(new Point(20, 20));
        mainWindow.addKeyListener(this);
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
            draw();
        }
    }

    public void start()
    {
        g.setColor(Color.white);
        int strWidth = g.getFontMetrics().stringWidth("Press Any Key To Start ...");
        g.drawString("Press Any Key To Start ...", (WIDTH - strWidth) / 2, HEIGHT / 2);

        isPlaying = true;
        while(isPlaying)
        {
            logic();
        }
    }

    public void stop()
    {
        isPlaying = false;
    }

    public void logic()
    {

    }

    public void draw()
    {
        g.setColor(Color.white);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        g.fillRect(snake.getShape().x, snake.getShape().y, snake.getShape().width, snake.getShape().height);
        g.setColor(Color.white);
    }
}
