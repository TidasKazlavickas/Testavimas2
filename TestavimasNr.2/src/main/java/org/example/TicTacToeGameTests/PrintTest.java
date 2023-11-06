package org.example.TicTacToeGameTests;

import org.example.TicTacToeGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintTest {
    private TicTacToeGame game;

    @Before
    public void setUp() {
        game = new TicTacToeGame(3, "X");
    }

    @Test
    public void testXWins() {
        game.board[0][0].setText("X");
        game.board[1][1].setText("X");
        game.board[2][2].setText("X");
        assertTrue(game.checkWinner());
        assertEquals("X", game.getCurrentPlayer());
    }

    @Test
    public void testOWins() {
        game.board[0][2].setText("O");
        game.board[1][1].setText("O");
        game.board[2][0].setText("O");
        assertTrue(game.checkWinner());
        assertEquals("O", game.getCurrentPlayer());
    }

    @Test
    public void testTieGame() {
        game.board[0][0].setText("X");
        game.board[0][1].setText("O");
        game.board[0][2].setText("X");
        game.board[1][0].setText("X");
        game.board[1][1].setText("O");
        game.board[1][2].setText("O");
        game.board[2][0].setText("O");
        game.board[2][1].setText("X");
        game.board[2][2].setText("X");
        assertFalse(game.checkWinner());
        assertTrue(game.isBoardFull());
    }
}

