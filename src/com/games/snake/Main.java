package com.games.snake;

public class Main {

    public static void main(String[] args)
    {
        Game.mainWindow.setVisible(true);
        Game game = new Game();
        game.start();
    }
}
