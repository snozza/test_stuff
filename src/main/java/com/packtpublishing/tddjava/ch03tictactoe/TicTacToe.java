package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setCell(x, y);
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside the board");
        }
    }

    private void setCell(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Cell is already filled");
        }
        board[x - 1][y - 1] = 'X';
    }

    public char nextPlayer() {
        return 'X';
    }
}