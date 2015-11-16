package fr.com.cb;

import java.util.Optional;


public class Game {
    private String number;
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

    public boolean isWin() {
        return lastGuess != null && lastGuess.equals(number);
    }

    public String getNumber() {
        return number;
    }

    public void setLastGuess(String lastGuess) {
        this.lastGuess = lastGuess;
    }
}
