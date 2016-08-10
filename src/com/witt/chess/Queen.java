package com.witt.chess;

public class Queen implements Piece {

    public static final Queen QUEEN = new Queen();

    @Override
    public boolean isValidPosition(Board board, int x, int y) {
        if (!board.isSafe(x, y)) return false;
        for (int i = 0; i < board.w; i++) {
            if (board.isTaken(i, y)) return false;
            if (board.isTaken(i, y + (x - i))) return false;
            if (board.isTaken(i, y - (x - i))) return false;
        }
        for (int i = 0; i < board.h; i++) {
            if (board.isTaken(x, i)) return false;
        }
        return true;
    }

    @Override
    public void placeAt(Board board, int x, int y) {
        board.take(x, y, this);
        for (int i = 0; i < board.w; i++) {
            if (i == x) continue;
            board.mark(i, y);
            board.mark(i, y + (x - i));
            board.mark(i, y - (x - i));
        }
        for (int i = 0; i < board.h; i++) {
            if (i != y) board.mark(x, i);
        }
    }

    @Override
    public void removeFrom(Board board, int x, int y) {
        board.free(x, y);
        for (int i = 0; i < board.w; i++) {
            if (i == x) continue;
            board.unmark(i, y);
            board.unmark(i, y + (x - i));
            board.unmark(i, y - (x - i));
        }
        for (int i = 0; i < board.h; i++) {
            if (i != y) board.unmark(x, i);
        }
    }

    @Override
    public String toString() {
        return "Q";
    }
}
