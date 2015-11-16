package fr.com.cb;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Game {

    private final String number;
    private String lastGuess;

    private Game(String number) {
        this.number = number;
    }

    public static Optional<Game> build(String number) {
        final String regex = "[0-9]{4}";
        return Optional.ofNullable(number)
                .filter(n -> n.matches(regex))
                .filter(n -> n.length() > 0)
                .map(Game::new);
    }

    public String guessNumber(String guess) {
        lastGuess = guess;
        final Map<Character, State> map = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char actualChar = number.charAt(i);
            State answerState = State.NO_MATCH;
            if (notSamePositionNorPresent(guessChar, map)) {
                answerState = State.assignSymbol(number, guessChar, actualChar);
            }
            map.put(guessChar, answerState);
        }
        return map.values().stream().map(c -> c.toString())
                .collect(joining());
    }

    public boolean isWin() {
        return lastGuess != null && lastGuess.equals(number);
    }

    public String getNumber() {
        return number;
    }

    private Boolean notSamePositionNorPresent(Character guessChar, Map<Character, State> map) {
        final State currentStateValue = map.getOrDefault(guessChar, State.NO_MATCH);
        return currentStateValue.equals(State.SINGLE_MATCH) || currentStateValue.equals(State.NO_MATCH);
    }


}