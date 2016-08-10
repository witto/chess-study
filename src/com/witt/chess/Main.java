package com.witt.chess;

import java.util.*;

import static com.witt.chess.Bishop.BISHOP;
import static com.witt.chess.King.KING;
import static com.witt.chess.Knight.KNIGHT;
import static com.witt.chess.Queen.QUEEN;
import static com.witt.chess.Rook.ROOK;

public class Main {

    public static void main(final String[] args) {
        List<Piece> pieces = new ArrayList<>(Arrays.asList(KING, KING, QUEEN));
        Board board = new Board(3, 3);
        Set<Board> solutions = new HashSet<>();
        place(board, pieces, solutions);
        System.out.println(solutions);

        pieces = new ArrayList<>(Arrays.asList(ROOK, ROOK, KNIGHT, KNIGHT, KNIGHT, KNIGHT));
        board = new Board(4, 4);
        solutions = new HashSet<>();
        place(board, pieces, solutions);
        System.out.println(solutions);

        long start = System.currentTimeMillis();
        pieces = new ArrayList<>(Arrays.asList(KING, KING, QUEEN, QUEEN, BISHOP, BISHOP, KNIGHT));
        board = new Board(7, 7);
        solutions = new HashSet<>(4_000_000);
        place(board, pieces, solutions);
        System.out.println(solutions.size());
        //System.out.println(solutions);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void place(Board board, List<Piece> pieces, Set<Board> solutions) {
        if (pieces.isEmpty()){
            if (!solutions.contains(board)) solutions.add(new Board(board));
            if (solutions.size() % 10000 == 0) System.out.println(solutions.size());
            return;
        }
        Piece piece = pieces.remove(0);
        for (int i = 0; i < board.w; i++) {
            for (int j = 0; j < board.h; j++) {
                if (piece.isValidPosition(board, i, j)) {
                    piece.placeAt(board, i, j);
                    place(board, pieces, solutions);
                    piece.removeFrom(board, i, j);
                }
            }
        }
        pieces.add(piece);
    }
}
