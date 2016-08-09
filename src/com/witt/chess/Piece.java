package com.witt.chess;

public interface Piece {
    boolean isValidPosition(Board board, int x, int y);
    void placeAt(Board board, int x, int y);
    void removeFrom(Board board, int x, int y);
}

