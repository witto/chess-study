package com.witt.chess;

import java.util.Arrays;

public class Board {
    public final int w;
    public final int h;
    private final byte[][] marks;
    private final Piece[][] board;

    public Board(int w, int h) {
        this.w = w;
        this.h = h;
        marks = new byte[w][h];
        board = new Piece[w][h];
    }

    public Board(Board board) {
        this.w = board.w;
        this.h = board.h;
        this.board = new Piece[w][h];
        this.marks = null;
        for (int i = 0; i < w; i++) {
            System.arraycopy(board.board[i], 0, this.board[i], 0, h);
        }
    }

    public boolean isSafe(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return false;
        return marks[x][y] == 0;
    }

    public boolean isTaken(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return false;
        return marks[x][y] == -1;
    }

    public void mark(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        marks[x][y]++;
    }

    public void unmark(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        marks[x][y]--;
    }

    public void take(int x, int y, Piece piece) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        marks[x][y] = -1;
        board[x][y] = piece;
    }

    public void free(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        marks[x][y] = 0;
        board[x][y] = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                sb.append(board[i][j] == null ? "." : board[i][j]).append(" ");
            }
            if (marks != null) {
                sb.append(" | ");
                for (int j = 0; j < h; j++) {
                    sb.append(marks[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        if (w != board1.w) return false;
        if (h != board1.h) return false;
        return Arrays.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        int result = w;
        result = 31 * result + h;
        result = 31 * result + Arrays.deepHashCode(board);
        return result;
    }
}
