package com.witt.chess;

public class Knight implements Piece {

    private int[][] moves = {
            {-2, -1},
            {-1, -2},
            { 1, -2},
            { 2, -1},
            { 2,  1},
            { 1,  2},
            {-1,  2},
            {-2,  1}
    };

    @Override
    public boolean isValidPosition(Board board, int x, int y) {
        if (!board.isSafe(x, y)) return false;
        for (int[] move : moves) {
            if (board.isTaken(x + move[0], y + move[1])) return false;
        }
        return true;
    }

    @Override
    public void placeAt(Board board, int x, int y) {
        board.take(x, y);
        for (int[] move : moves) {
            board.mark(x + move[0], y + move[1]);
        }
    }

    @Override
    public void removeFrom(Board board, int x, int y) {
        board.free(x, y);
        for (int[] move : moves) {
            board.unmark(x + move[0], y + move[1]);
        }
    }
}
