package fr.com.cb;


import fr.com.strategy.CustomProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Game {

    private final String number;

    private Game(String number) {
        this.number = number;
    }

    public static Optional<Game> build(String number) {
        final String regex = "[0-9]+";
        return Optional.ofNullable(number)
                .filter(n -> n.matches(regex))
                .filter(n -> n.length() > 0)
                .map(Game::new);
    }

    public String guessNumber(String guess) {
        final Map<Character, String> map = new HashMap();
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char actualChar = number.charAt(i);
            String answerState = CustomProcessor.FINALIZER;
            if (GameLogic.notSamePositionNorPresent.test(guessChar, map)) {
                answerState = GameLogic.assingSymbol.apply(number, guessChar, actualChar);
            }
            map.put(guessChar, answerState);
        }
        return map.values().stream()
                .collect(joining());
    }

    public String getNumber() {
        return number;
    }

}