package fr.com.cb;

import fr.com.cb.Game;

import java.util.Optional;

import static fr.com.cb.Game.build;
import static org.junit.Assert.*;


public class GameTest {

    @org.junit.Test
    public void should_not_init_game_when_null() throws Exception {
        Optional<Game> maybeGame = build(null);
        assertFalse(maybeGame.isPresent());
    }

    @org.junit.Test
    public void should_not_init_game_when_empty() throws Exception {
        Optional<Game> maybeGame = build("");
        assertFalse(maybeGame.isPresent());
    }

    @org.junit.Test
    public void should_not_init_game_when_not_number() throws Exception {
        Optional<Game> maybeGame = build("aaa");
        assertFalse(maybeGame.isPresent());
    }


    @org.junit.Test
    public void should_init_game() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        assertEquals(maybeGame.get().getNumber().length(), 4);

    }

    @org.junit.Test
    public void should_return_un_exact_match() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("9208");
        assertEquals(result, "+");

    }

    @org.junit.Test
    public void should_return_un_match() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("0981");
        assertEquals(result, "-");
    }

    @org.junit.Test
    public void should_return_un_exact_match_et_un_match() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("1049");
        assertEquals(result, "+-");
    }


    @org.junit.Test
    public void should_return_deux_exact_matchs_et_un_match() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("1245");
        assertEquals(result, "++-");
    }

    @org.junit.Test
    public void should_return_un_match_si_double() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("2002");
        assertEquals(result, "-");
    }

    @org.junit.Test
    public void should_return_un_exact_match_si_double() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("2200");
        assertEquals(result, "+");
    }

    @org.junit.Test
    public void should_return_win() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("1234");
        assertEquals(result, "++++");
    }
    @org.junit.Test
    public void should_return_reverse_entree() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        String result = maybeGame.orElseThrow(IllegalStateException::new).guessNumber("4321");
        assertEquals(result, "----");
    }

}