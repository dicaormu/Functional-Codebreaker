package fr.com.cb;

import fr.com.strategy.CustomProcessor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MatchTest {
    int i;

    @org.junit.Test
    public void should_win_game() throws Exception {
        i = 0;
        Match match = new Match();
        List<String> tests = Arrays.asList("2340", "1234");
        CustomProcessor<String> compute = () -> {
            return tests.get(i++);
        };
        assertEquals(match.play("1234", compute), "++++");
    }

    @org.junit.Test
    public void should_lose_game() throws Exception {
        i = 0;
        Match match = new Match();
        List<String> tests = Arrays.asList("2340", "1908", "");
        CustomProcessor<String> compute = () -> {
            return tests.get(i++);
        };
        assertEquals(match.play("1234", compute), "+");
    }
}