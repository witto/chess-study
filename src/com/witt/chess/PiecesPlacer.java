package com.witt.chess;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PiecesPlacer {

    public static Set<Board> place(List<Piece> pieces, Board board) {
        Set<Board> solutions = new HashSet<>();
        Stack<Piece> pieceStack = new Stack<>();
        pieces.sort((p1, p2) -> p1.toString().compareTo(p2.toString()));
        pieceStack.addAll(pieces);
        place(board, pieceStack, solutions, 0, 0);
        return solutions;
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
