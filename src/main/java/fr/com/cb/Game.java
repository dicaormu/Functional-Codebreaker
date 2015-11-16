package fr.com.cb;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class Game {

    private final String number;
    private String lastGuess;

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
        lastGuess = guess;
        final Map<Character, State> map = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char actualChar = number.charAt(i);
             State answerState = State.NO_MATCH;
            if (notSamePositionNorPresent(guessChar, map)) {
                answerState = assignSymbol(number, guessChar, actualChar);
            }
            map.put(guessChar, answerState);
        }
        return map.values().stream().map(c->c.toString())
                .collect(joining());
    }

    private State assignSymbol(String number, Character guessChar, Character actualChar){
        final boolean containsGuess = number.contains(valueOf(guessChar));
        if (containsGuess)
            return actualChar == guessChar ?
                   State.EXACT_MATCH : State.SINGLE_MATCH;
        else
            return State.NO_MATCH;
    }


    private Boolean notSamePositionNorPresent(Character guessChar, Map<Character, State> map){
        final State currentStateValue = map.getOrDefault(guessChar, State.NO_MATCH);
        return currentStateValue.equals(State.SINGLE_MATCH) || currentStateValue.equals(State.NO_MATCH);
    }



    public boolean isWin() {
        return lastGuess != null && lastGuess.equals(number);
    }

    public String getNumber() {
        return number;
    }


    public enum State {
        EXACT_MATCH('+'), SINGLE_MATCH('-'), NO_MATCH(' ');

        Character representation;

        State(Character representation){
            this.representation=representation;
        }

        public String toString(){
            return representation.toString().trim();
        }
    }
}