package fr.test.suppliers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyBoardProcessor implements CustomProcessor<String> {

    BufferedReader in;

    public KeyBoardProcessor() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FINALIZER;
    }
}
