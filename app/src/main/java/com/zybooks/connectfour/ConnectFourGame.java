package com.zybooks.connectfour;

import java.util.Random;

public class ConnectFourGame {
    public static final int ROWS = 6;
    public static final int COLS = 7;

    private boolean[][] board;

    public ConnectFourGame() { board = new boolean[ROWS][COLS];}

    public void newGame() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = false;
            }
        }
    }

    public String getState() {
        StringBuilder boardString = new StringBuilder();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                char value = board[row][col] ? 'T' : 'F';
                boardString.append(value);
            }
        }
        return boardString.toString();
    }
}
