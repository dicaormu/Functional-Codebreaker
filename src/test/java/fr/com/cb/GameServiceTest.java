package fr.com.cb;

import fr.com.cb.service.GameService;
import fr.com.cb.service.GameServiceImpl;

import static org.junit.Assert.assertEquals;


public class GameServiceTest {
    @org.junit.Test
    public void should_return_un_exact_match() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("9208");
        assertEquals(result, "+");

    }

    @org.junit.Test
    public void should_return_un_match() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("0981");
        assertEquals(result, "-");
    }

    @org.junit.Test
    public void should_return_un_exact_match_et_un_match() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("1049");
        assertEquals(result, "+-");
    }


    @org.junit.Test
    public void should_return_deux_exact_matchs_et_un_match() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("1245");
        assertEquals(result, "++-");
    }

    @org.junit.Test
    public void should_return_un_match_si_double() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("2002");
        assertEquals(result, "-");
    }

    @org.junit.Test
    public void should_return_un_exact_match_si_double() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("2200");
        assertEquals(result, "+");
    }

    @org.junit.Test
    public void should_return_win() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("1234");
        assertEquals(result, "++++");
    }

    @org.junit.Test
    public void should_return_reverse_entree() throws Exception {
        GameService service = new GameServiceImpl("1234");
        String result = service.guessNumber("4321");
        assertEquals(result, "----");
    }
}
