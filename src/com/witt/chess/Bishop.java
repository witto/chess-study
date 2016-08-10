package com.witt.chess;

public class Bishop implements Piece {

    public static final Bishop BISHOP = new Bishop();

    @Override
    public boolean isValidPosition(Board board, int x, int y) {
        if (!board.isSafe(x, y)) return false;
        for (int i = 0; i < board.w; i++) {
            if (board.isTaken(i, y + (x - i))) return false;
            if (board.isTaken(i, y - (x - i))) return false;
        }
        return true;
    }

    @Override
    public void placeAt(Board board, int x, int y) {
        board.take(x, y, this);
        for (int i = 0; i < board.w; i++) {
            if (i == x) continue;
            board.mark(i, y + (x - i));
            board.mark(i, y - (x - i));
        }
    }

    @Override
    public void removeFrom(Board board, int x, int y) {
        board.free(x, y);
        for (int i = 0; i < board.w; i++) {
            if (i == x) continue;
            board.unmark(i, y + (x - i));
            board.unmark(i, y - (x - i));
        }
    }

    @Override
    public String toString() {
        return "B";
    }
}
