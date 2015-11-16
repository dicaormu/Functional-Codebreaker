package fr.com.cb;


import fr.com.cb.service.GameService;
import fr.com.cb.service.GameServiceImpl;
import fr.com.processor.CustomProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Match {

    private final Logger logger = LoggerFactory.getLogger(Match.class);


    public String play(String number, CustomProcessor<String> moves) {
        GameService service = new GameServiceImpl(number);
        String matchFactor = "";
        while (!service.isWin() && moves.hasNext()) {
            String line = moves.nextLine();
            matchFactor = service.guessNumber(line);
            logger.debug("Getting  {} for number {} ", matchFactor, line);
        }
        return matchFactor;
    }
}
