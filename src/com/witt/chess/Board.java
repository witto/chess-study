package com.witt.chess;

import java.util.Arrays;

public class Board {
    public final int w;
    public final int h;
    private final int[][] board;

    public Board(int w, int h) {
        this.w = w;
        this.h = h;
        board = new int[w][h];
    }

    public boolean isSafe(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return false;
        return board[x][y] == 0;
    }

    public boolean isTaken(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return false;
        return board[x][y] == -1;
    }

    public void mark(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        board[x][y]++;
    }

    public void unmark(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        board[x][y]--;
    }

    public void take(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        board[x][y] = -1;
    }

    public void free(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        board[x][y] = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            sb.append(Arrays.toString(board[i])).append("\n");
        }
        return sb.toString();
    }

}
