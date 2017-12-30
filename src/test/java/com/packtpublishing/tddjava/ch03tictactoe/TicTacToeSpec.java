package com.packtpublishing.tddjava.ch03tictactoe;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 3);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 3);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
   }

   @Test
    public void givenLastPlayerWasXWhenNextPlayerThen0() {
        ticTacToe.play(1, 1);
        assertEquals('0', ticTacToe.nextPlayer());
   }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 2);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // 0
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // 0
        String actual = ticTacToe.play(3, 1);
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1,1); // 0
        ticTacToe.play(3,1); // X
        ticTacToe.play(1,2); // 0
        ticTacToe.play(2,2); // X
        String actual = ticTacToe.play(1, 3);
        assertEquals("0 is the winner", actual);
    }
}