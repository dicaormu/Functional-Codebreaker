package fr.test.cb;

import fr.test.suppliers.CustomProcessor;

import java.util.Map;
import java.util.function.BiPredicate;

import static java.lang.String.valueOf;

public class GameLogic {

    final static BiPredicate<Character, Map<Character, String>> notSamePositionNorPresent = (s, m) -> {
        final String defaultValue = m.getOrDefault(s, CustomProcessor.FINALIZER);
        return defaultValue.equals("-") || defaultValue.equals(CustomProcessor.FINALIZER);
    };
    final static TriFunction<String, Character, Character, String> assingSymbol = (number, guessChar, actualChar) ->
            number.contains(valueOf(guessChar)) ?
                    (actualChar == guessChar ?
                            "+" : "-") : CustomProcessor.FINALIZER;

    @FunctionalInterface
    public interface TriFunction<T, U, S, R> {
        R apply(T t, U u, S s);
    }


}
