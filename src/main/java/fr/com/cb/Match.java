package fr.com.cb;


import fr.com.strategy.CustomProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Match {

    private final Logger logger = LoggerFactory.getLogger(Match.class);
    private Game game;

    public String play(String number, CustomProcessor<String> moves) {
        game = Game.build(number).orElseThrow(IllegalStateException::new);
        String matchFactor = CustomProcessor.FINALIZER;
        while (!game.isWin() && moves.hasNext()) {
            String line = moves.nextLine();
            matchFactor = game.guessNumber(line);
            logger.debug("Getting  {} for number {} ", matchFactor, line);
        }
        return matchFactor;
    }
}
