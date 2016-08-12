package com.witt.chess;

import java.util.*;

import static com.witt.chess.Bishop.BISHOP;
import static com.witt.chess.King.KING;
import static com.witt.chess.Knight.KNIGHT;
import static com.witt.chess.Queen.QUEEN;
import static com.witt.chess.Rook.ROOK;

public class Main {

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the board dimensions:");

        System.out.print("M:");
        int m = scanner.nextInt();

        System.out.print("N:");
        int n = scanner.nextInt();

        System.out.print("Please enter the piece set (example: KKKQQBBNR):");
        String piecesStr = scanner.next("[KQBNRkqbnr]+");

        System.out.print("Print all solutions (Y/N)?");
        boolean shouldPrintAllSolutions = scanner.next("[ynYN]").equalsIgnoreCase("Y");

        List<Piece> pieces = createPieceList(piecesStr);

        long start = System.currentTimeMillis();

        Board board = new Board(m, n);
        Set<Board> solutions = PiecesPlacer.place(pieces, board);

        long elapsedTime = System.currentTimeMillis() - start;

        if (shouldPrintAllSolutions) {
            System.out.println("Solutions found:");
            solutions.forEach(System.out::println);
        } else {
            System.out.println("Sample solution:");
            System.out.println(solutions.iterator().next());
        }
        System.out.println(String.format("Number of solutions: %s", solutions.size()));
        System.out.println(String.format("Processing time: %s ms.", elapsedTime));
    }

    private static List<Piece> createPieceList(String piecesStr) {
        List<Piece> pieces = new ArrayList<>(piecesStr.length());
        for (char p : piecesStr.toUpperCase().toCharArray()) {
            switch (p) {
                case 'K':
                    pieces.add(KING);
                    break;
                case 'Q':
                    pieces.add(QUEEN);
                    break;
                case 'B':
                    pieces.add(BISHOP);
                    break;
                case 'N':
                    pieces.add(KNIGHT);
                    break;
                case 'R':
                    pieces.add(ROOK);
                    break;
            }
        }
        return pieces;
    }
}
