package fr.com.cb.service;

import fr.com.cb.Game;
import fr.com.cb.State;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;


public class GameServiceImpl implements GameService {
    final Game game;

    public GameServiceImpl(String number) {
        game = Game.build(number).orElseThrow(IllegalStateException::new);
    }

    @Override
    public String guessNumber(String guess) {
        game.setLastGuess(guess);
        final Map<Character, State> map = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char actualChar = game.getNumber().charAt(i);
            State answerState = State.NO_MATCH;
            if (notSamePositionNorPresent(guessChar, map)) {
                answerState = State.assignSymbol(game.getNumber(), guessChar, actualChar);
            }
            map.put(guessChar, answerState);
        }
        return map.values().stream().map(c -> c.toString())
                .collect(joining());
    }

    @Override
    public boolean isWin() {
        return game.isWin();
    }

    private boolean notSamePositionNorPresent(Character guessChar, Map<Character, State> map) {
        final State currentStateValue = map.getOrDefault(guessChar, State.NO_MATCH);
        return currentStateValue.equals(State.SINGLE_MATCH) || currentStateValue.equals(State.NO_MATCH);
    }

}
