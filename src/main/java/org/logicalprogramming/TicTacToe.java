package org.logicalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToe {

    public static void main(String[] args) {
//        Determine whether a tic tac toe board is won
//        {{'O', 'O', 'O'}, {'X', 'X', 'O'}, {'O', 'X', 'X'}}
//        ooo
//        xxo
//        oxx
//        o wins
        List<List<String>> ticTacToeList = List.of(List.of("X", "O", "X"), List.of("X", "X", "O"), List.of("O", "X", "X"));
        String winner = determineWinner(ticTacToeList);
        if (Objects.isNull(winner)) {
            System.out.println("No Winner");
        } else {
            System.out.println("Winner is : " + winner);
        }
    }

    private static String determineWinner(List<List<String>> ticTacToeList) {
        String ticTacToeChar = null;
        String winner = null;
        int charCount = 0;
        List<String> xList = List.of("X", "X", "X");
        List<String> oList = List.of("O", "O", "O");

        // left to Right
        System.out.println("Checking left to Right");
        for (int i = 0; i < ticTacToeList.size(); i++) {
            if (ticTacToeList.get(i).equals(xList)) {
                return "X";
            } else if (ticTacToeList.get(i).equals(oList)) {
                return "O";
            }
        }
        // top to bottom
        System.out.println("Checking Top to Bottom");
        for (int j = 0; j < ticTacToeList.getFirst().size(); j++) {
            List<String> topToBottom = new ArrayList<>();
            for (int i = 0; i < ticTacToeList.size(); i++) {
                topToBottom.add(ticTacToeList.get(i).get(j));
            }
            if (topToBottom.equals(xList)) {
                return "X";
            } else if (topToBottom.equals(oList)) {
                return "O";
            }
        }

        List<String> topLeftToBottomRight = new ArrayList<>();
        // top left to bottom Right
        System.out.println("Checking TopLeft to BottomRight");
        for (int i = 0; i < ticTacToeList.size(); i++) {
            topLeftToBottomRight.add(ticTacToeList.get(i).get(i));
        }

        if (topLeftToBottomRight.equals(xList)) {
            return "X";
        } else if (topLeftToBottomRight.equals(oList)) {
            return "O";
        }

        List<String> topRightToBottomLeft = new ArrayList<>();
        // top Right to bottom Left
        System.out.println("Checking TopRight to BottomLeft");
        for (int i = 0; i < ticTacToeList.size(); i++) {
            topRightToBottomLeft.add(ticTacToeList.get(i).get(ticTacToeList.size() - i - 1));
        }

        if (topRightToBottomLeft.equals(xList)) {
            return "X";
        } else if (topRightToBottomLeft.equals(oList)) {
            return "O";
        }

        return null;
    }
}
