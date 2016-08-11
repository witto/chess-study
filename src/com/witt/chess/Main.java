package com.witt.chess;

import java.util.*;

import static com.witt.chess.Bishop.BISHOP;
import static com.witt.chess.King.KING;
import static com.witt.chess.Knight.KNIGHT;
import static com.witt.chess.Queen.QUEEN;
import static com.witt.chess.Rook.ROOK;

public class Main {

    public static void main(final String[] args) {
        Stack<Piece> pieces = new Stack<>();
        pieces.addAll(Arrays.asList(KING, KING, QUEEN));
        Board board = new Board(3, 3);
        Set<Board> solutions = new HashSet<>();
        place(board, pieces, solutions, 0, 0);
        System.out.println(solutions);

        pieces.clear();
        pieces.addAll(Arrays.asList(ROOK, ROOK, KNIGHT, KNIGHT, KNIGHT, KNIGHT));
        board = new Board(4, 4);
        solutions = new HashSet<>();
        place(board, pieces, solutions, 0, 0);
        System.out.println(solutions);

        long start = System.currentTimeMillis();
        pieces.clear();
        pieces.addAll(Arrays.asList(KING, KING, QUEEN, QUEEN, BISHOP, BISHOP, KNIGHT));
        board = new Board(7, 7);
        solutions = new HashSet<>(4_000_000);
        place(board, pieces, solutions, 0, 0);
        System.out.println(solutions.size());
        System.out.println(solutions.iterator().next());
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void place(Board board, Stack<Piece> pieces, Set<Board> solutions, int startX, int startY) {
        if (pieces.isEmpty()){
            if (!solutions.contains(board)) solutions.add(new Board(board));
            return;
        }
        Piece piece = pieces.pop();
        for (int i = startX; i < board.w; i++) {
            for (int j = i == startX ? startY : 0; j < board.h; j++) {
                if (piece.isValidPosition(board, i, j)) {
                    piece.placeAt(board, i, j);
                    boolean fromStart = pieces.isEmpty() || !piece.equals(pieces.peek());
                    place(board, pieces, solutions, fromStart ? 0 : i, fromStart ? 0 : j);
                    piece.removeFrom(board, i, j);
                }
            }
        }
        pieces.push(piece);
    }
}
