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
        CustomProcessor<String> compute = new ListProcessor(tests);
        assertEquals(match.play("1234", compute), "++++");
    }

    @org.junit.Test
    public void should_lose_game() throws Exception {
        i = 0;
        Match match = new Match();
        List<String> tests = Arrays.asList("2340", "1908");
        CustomProcessor<String> compute = new ListProcessor(tests);
        assertEquals(match.play("1234", compute), "+");
    }

    public class ListProcessor implements CustomProcessor<String> {

        List<String> toProcess;
        int processing;

        public ListProcessor(List process) {
            this.toProcess = process;
            processing = 0;
        }

        @Override
        public String nextLine() {
            return toProcess.get(processing++);
        }

        @Override
        public Boolean hasNext() {
            return toProcess.size() >= processing + 1;
        }
    }
}