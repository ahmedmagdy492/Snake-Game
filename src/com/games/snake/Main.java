package com.games.snake;

import java.io.File;

public class Main {

    public static void main(String[] args)
    {
        Game.mainWindow.setVisible(true);
        Game game = new Game();
        game.start();
    }
}
