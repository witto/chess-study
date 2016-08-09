package com.witt.chess;

public class Hook implements Piece {

    @Override
    public boolean isValidPosition(Board board, int x, int y) {
        if (!board.isSafe(x, y)) return false;
        for (int i = 0; i < board.w; i++) {
            if (board.isTaken(i, y)) return false;
        }
        for (int i = 0; i < board.h; i++) {
            if (board.isTaken(x, i)) return false;
        }
        return true;
    }

    @Override
    public void placeAt(Board board, int x, int y) {
        board.take(x, y);
        for (int i = 0; i < board.w; i++) {
            if (i != x) board.mark(i, y);
        }
        for (int i = 0; i < board.h; i++) {
            if (i != y) board.mark(x, i);
        }
    }

    @Override
    public void removeFrom(Board board, int x, int y) {
        board.free(x, y);
        for (int i = 0; i < board.w; i++) {
            if (i != x) board.unmark(i, y);
        }
        for (int i = 0; i < board.h; i++) {
            if (i != y) board.unmark(x, i);
        }
    }
}
