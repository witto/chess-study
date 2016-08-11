package com.witt.chess;

import java.util.*;

import static com.witt.chess.Bishop.BISHOP;
import static com.witt.chess.King.KING;
import static com.witt.chess.Knight.KNIGHT;
import static com.witt.chess.Queen.QUEEN;
import static com.witt.chess.Rook.ROOK;

public class Main {

    public static void main(final String[] args) {

        Board board = new Board(3, 3);
        Set<Board> solutions = PiecesPlacer.place(Arrays.asList(KING, KING, QUEEN), board);
        System.out.println(solutions);

        board = new Board(4, 4);
        solutions = PiecesPlacer.place(Arrays.asList(ROOK, ROOK, KNIGHT, KNIGHT, KNIGHT, KNIGHT), board);
        System.out.println(solutions);

        long start = System.currentTimeMillis();
        board = new Board(7, 7);
        solutions = PiecesPlacer.place(Arrays.asList(KING, KING, QUEEN, QUEEN, BISHOP, BISHOP, KNIGHT), board);
        System.out.println(solutions.size());
        System.out.println(solutions.iterator().next());
        System.out.println(System.currentTimeMillis() - start);
    }

}
