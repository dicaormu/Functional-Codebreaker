package fr.com.strategy;

import fr.com.cb.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyBoardProcessor implements CustomProcessor<String> {

    BufferedReader in;
    String lastLine = " ";

    public KeyBoardProcessor() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public Boolean hasNext() {
        return lastLine != null && lastLine.length() > 0;
    }

    @Override
    public String nextLine() {
        try {
            return lastLine = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Game.State.NO_MATCH.toString();
    }
}
