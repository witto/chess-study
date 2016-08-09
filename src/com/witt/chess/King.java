package com.witt.chess;

public class King implements Piece {

    @Override
    public boolean isValidPosition(Board board, int x, int y) {
        if (!board.isSafe(x, y)) return false;
        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                if (board.isTaken(i, j)) return false;
            }
        }
        return true;
    }

    @Override
    public void placeAt(Board board, int x, int y) {
        board.take(x, y);
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x || j != y) board.mark(i, j);
            }
        }
    }

    @Override
    public void removeFrom(Board board, int x, int y) {
        board.free(x, y);
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x || j != y) board.unmark(i, j);
            }
        }
    }
}
