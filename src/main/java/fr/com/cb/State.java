package fr.com.cb;


public enum State {
    EXACT_MATCH('+'), SINGLE_MATCH('-'), NO_MATCH(' ');

    Character representation;

    State(Character representation) {
        this.representation = representation;
    }

    public static State assignSymbol(String number, Character guessChar, Character actualChar) {
        final boolean containsGuess = number.contains(guessChar.toString());
        if (containsGuess)
            return actualChar == guessChar ?
                    EXACT_MATCH : SINGLE_MATCH;
        else
            return NO_MATCH;
    }

    public String toString() {
        return representation.toString().trim();
    }
}
