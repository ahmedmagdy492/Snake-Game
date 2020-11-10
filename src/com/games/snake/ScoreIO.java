package com.games.snake;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.stream.Stream;

class ScoreIO
{
    private ScoreIO(){ }

    static String readLastScore() throws IOException {
        BufferedReader reader = null;
        try
        {
            FileReader fr = new FileReader("file.txt");
            reader = new BufferedReader(fr);
            String str = reader.readLine();
            reader.close();
            return str;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            if(reader != null)
                reader.close();
            return null;
        }
    }

    static void writeLastScore(String score) throws IOException {
        BufferedWriter bw = null;
        try
        {
            FileWriter fw = new FileWriter("file.txt");
            bw = new BufferedWriter(fw);
            bw.write(score);
            bw.close();
        }
        catch (Exception ex)
        {
            if(bw != null)
                bw.close();
            ex.printStackTrace();
        }
    }
}
