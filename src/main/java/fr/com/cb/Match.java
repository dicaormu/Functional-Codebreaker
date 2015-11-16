package fr.com.cb;


import fr.com.strategy.CustomProcessor;

public class Match {

    private Game game;


    public String play(String number, CustomProcessor<String> moves) {
        game = Game.build(number).orElseThrow(IllegalStateException::new);
        String line, matchFactor = CustomProcessor.FINALIZER;
        while (!isWin(matchFactor, number.length()) && (line = moves.nextLine()) != CustomProcessor.FINALIZER) {
            matchFactor = game.guessNumber(line);
        }
        return matchFactor;
    }

    public boolean isWin(String response, int len) {
        String regex = "\\+*";
        return response.matches(regex) && response.length() == len;
    }

}
