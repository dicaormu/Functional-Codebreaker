package fr.com.cb;

import fr.com.strategy.CustomProcessor;

import java.util.Map;
import java.util.function.BiPredicate;

import static java.lang.String.valueOf;

public class GameLogic {

    final static BiPredicate<Character, Map<Character, String>> notSamePositionNorPresent = (s, m) -> {
        final String defaultValue = m.getOrDefault(s, CustomProcessor.FINALIZER);
        return defaultValue.equals(CustomProcessor.MATCH) || defaultValue.equals(CustomProcessor.FINALIZER);
    };

    final static TriFunction<String, Character, Character, String> assignSymbol = (number, guessChar, actualChar) -> {
        final boolean containsGuess = number.contains(valueOf(guessChar));
        if (containsGuess)
            return actualChar == guessChar ?
                    CustomProcessor.EXACT_MATCH : CustomProcessor.MATCH;
        else
            return CustomProcessor.FINALIZER;
    };

    @FunctionalInterface
    public interface TriFunction<T, U, S, R> {
        R apply(T t, U u, S s);
    }
}
