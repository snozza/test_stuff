package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private static int SIZE = 3;
    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };
    private char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setCell(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == playerTotal ||
                    board[i][0] + board[i][1] + board[i][2] == playerTotal) {
                return true;
            }

        }
        return false;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside the board");
        }
    }

    private void setCell(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Cell is already filled");
        }
        board[x - 1][y - 1] = lastPlayer;
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return '0';
        }
        return 'X';
    }
}