package fr.com.cb;

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
    public void should_not_init_game_when_long_number() throws Exception {
        Optional<Game> maybeGame = build("12345");
        assertFalse(maybeGame.isPresent());
    }

    @org.junit.Test
    public void should_init_game() throws Exception {
        Optional<Game> maybeGame = build("1234");
        assertTrue(maybeGame.isPresent());
        assertEquals(maybeGame.get().getNumber().length(), 4);

    }


}