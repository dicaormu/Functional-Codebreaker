package fr.com.cb;


import fr.com.strategy.CustomProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Match {

    private final Logger logger = LoggerFactory.getLogger(Match.class);
    private Game game;

    public String play(String number, CustomProcessor<String> moves) {
        game = Game.build(number).orElseThrow(IllegalStateException::new);
        String line, matchFactor = CustomProcessor.FINALIZER;
        while (!isWin(matchFactor, number.length()) && (line = moves.nextLine()) != CustomProcessor.FINALIZER) {
            matchFactor = game.guessNumber(line);
            logger.debug("Getting  {} for number {} ", matchFactor, line);
        }
        return matchFactor;
    }

    private boolean isWin(String response, int len) {
        String regex = "\\+*";
        return response.matches(regex) && response.length() == len;
    }

}
