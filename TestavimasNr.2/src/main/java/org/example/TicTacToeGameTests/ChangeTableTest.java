package org.example.TicTacToeGameTests;

import org.example.TicTacToeGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeTableTest {
    private TicTacToeGame game;

    @Before
    public void setUp() {
        game = new TicTacToeGame(3, "X");
    }

    @Test
    public void testChangeBoardSizeTo4x4() {
        game.setBoardSize(4);
        assertEquals(4, game.getBoardSize());
    }

    @Test
    public void testChangeBoardSizeTo5x5() {
        game.setBoardSize(5);
        assertEquals(5, game.getBoardSize());
    }

    @Test
    public void testChangeBoardSizeTo3x3() {
        game.setBoardSize(3);
        assertEquals(3, game.getBoardSize());
    }
}

