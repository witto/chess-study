package com.witt.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        List<Piece> pieces = new ArrayList<Piece>(Arrays.asList(new King(), new King(), new Rook()));
        Board board = new Board(3, 3);
        place(board, pieces);

        pieces = new ArrayList<Piece>(Arrays.asList(new Rook(), new Rook(), new Knight(), new Knight(), new Knight(), new Knight()));
        board = new Board(4, 4);
        place(board, pieces);
    }

    private static void place(Board board, List<Piece> pieces) {
        if (pieces.isEmpty()){
            System.out.println(board);
            return;
        }
        Piece piece = pieces.remove(0);
        for (int i = 0; i < board.w; i++) {
            for (int j = 0; j < board.h; j++) {
                if (piece.isValidPosition(board, i, j)) {
                    piece.placeAt(board, i, j);
                    place(board, pieces);
                    piece.removeFrom(board, i, j);
                }
            }
        }
        pieces.add(piece);
    }
}
