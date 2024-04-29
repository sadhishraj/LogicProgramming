package org.logicalprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LargeWaterPatch {

    public static void main(String[] args) {
//        Given a matrix with zeroes and one where zero represents land and 1 represents water.
//        Find the largest patch of water. 2 cell are said to be connected if it is adjacent or diagonal to each other.
//        0 0 1 1
//        0 0 0 1
//        1 1 0 0
//        1 1 1 0
//        result: 5

        // Pseudocode: Create List<List<Integer>> and add all elements.
        // check if there is at least one water patch
        // check left side while you find "1" and make a count
        // check right side while you find "1" and make a count
        // check top while you find "1" and make a count
        // check bottom while you find "1" and make a count
        // check top left diagonal while you find "1" and make a count
        // check top right diagonal while you find "1" and make a count
        // check bottom left diagonal while you find "1" and make a count
        // check bottom right diagonal while you find "1" and make a count

        List<List<Integer>> landWaterMatrix = List.of(List.of(0, 0, 1, 1), List.of(0, 0, 0, 1), List.of(1, 1, 0, 0), List.of(1, 1, 1, 0));
        int largestWaterPatch = 0;
        ArrayList<String> waterPatchCell = new ArrayList<>();
        for (int i = 0; i < landWaterMatrix.size(); i++) {
            List<Integer> subList = landWaterMatrix.get(i);
            for (int j = 0; j < subList.size(); j++) {
                if (subList.get(j) == 1) {
                    waterPatchCell.add(String.valueOf(i) + String.valueOf(j));
                    ArrayList<String> waterPatchCellSub = getConnectedWaterPatch(landWaterMatrix, i, j);
                    waterPatchCell.addAll(waterPatchCellSub.stream().distinct().toList());
                    for (int k = 1; k < waterPatchCell.size(); k++) {
                        getConnectedWaterPatch(landWaterMatrix, (int) waterPatchCell.get(k).charAt(0), (int) waterPatchCell.get(k).charAt(1)).stream().distinct().toList();
                    }
//                    if (currentWaterPatch > largestWaterPatch) {
//                        largestWaterPatch = currentWaterPatch;
//                    }
                }
            }
        }
        // largestWaterPatch = getConnectedWaterPatch(landWaterMatrix);
        System.out.println(largestWaterPatch);
    }

    private static ArrayList<String> getConnectedWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        ArrayList<String> waterPatchCell = new ArrayList<>();
        if (isLeftWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i) + String.valueOf(j - 1));
        }
        if (isRightWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i) + String.valueOf(j + 1));
        }
        if (isTopWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i - 1) + String.valueOf(j));
        }
        if (isBottomWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i + 1) + String.valueOf(j));
        }
        if (isTopLeftWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i - 1) + String.valueOf(j - 1));
        }
        if (isTopRightWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i - 1) + String.valueOf(j + 1));
        }
        if (isBottomLeftWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i + 1) + String.valueOf(j - 1));
        }
        if (isBottomRightWaterPatch(landWaterMatrix, i, j)) {
            waterPatchCell.add(String.valueOf(i + 1) + String.valueOf(j + 1));
        }

//        for (int k = 1; k < waterPatchCell.size(); k++) {
//            getConnectedWaterPatch(landWaterMatrix, waterPatchCell, (int) waterPatchCell.get(k).charAt(0), (int) waterPatchCell.get(k).charAt(1));
//
//        }

        return waterPatchCell;
    }

    // checkLeft
    private static boolean isLeftWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (j == 0) {
            return false;
        }
        return landWaterMatrix.get(i).get(j - 1) == 1;
    }

    private static boolean isRightWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (j == landWaterMatrix.get(i).size() - 1) {
            return false;
        }
        return landWaterMatrix.get(i).get(j + 1) == 1;
    }

    private static boolean isTopWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == 0) {
            return false;
        }
        return landWaterMatrix.get(i - 1).get(j) == 1;
    }

    private static boolean isBottomWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == landWaterMatrix.size() - 1) {
            return false;
        }
        return landWaterMatrix.get(i + 1).get(j) == 1;
    }

    private static boolean isTopLeftWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == 0 || j == 0) {
            return false;
        }
        return landWaterMatrix.get(i - 1).get(j - 1) == 1;
    }

    private static boolean isTopRightWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == 0 || j == landWaterMatrix.get(i).size() - 1) {
            return false;
        }
        return landWaterMatrix.get(i - 1).get(j + 1) == 1;
    }

    private static boolean isBottomLeftWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == landWaterMatrix.size() - 1 || j == 0) {
            return false;
        }
        return landWaterMatrix.get(i + 1).get(j - 1) == 1;
    }

    private static boolean isBottomRightWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        if (i == landWaterMatrix.size() - 1 || j == landWaterMatrix.get(i).size() - 1) {
            return false;
        }
        return landWaterMatrix.get(i + 1).get(j + 1) == 1;
    }


    // checkRight
    private static HashSet<String> getRightWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = j + 1; k < landWaterMatrix.get(i).size(); k++) {
            if (landWaterMatrix.get(i).get(k) == 1) {
                waterPatchCell.add(String.valueOf(i) + k);
            } else {
                return waterPatchCell;
            }
        }
        return waterPatchCell;
    }

    // checkTop
    private static HashSet<String> getTopWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i - 1; k >= 0; k--) {
            if (landWaterMatrix.get(k).get(j) == 1) {
                waterPatchCell.add(String.valueOf(i) + k);
            } else {
                return waterPatchCell;
            }
        }
        return waterPatchCell;
    }

    // checkBottom
    private static HashSet<String> getBottomWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i + 1; k < landWaterMatrix.size(); k++) {
            if (landWaterMatrix.get(k).get(j) == 1) {
                waterPatchCell.add(String.valueOf(i) + k);
            } else {
                return waterPatchCell;
            }
        }
        return waterPatchCell;
    }

    // checkTopLeftDiagonal
    private static HashSet<String> getTopLeftDiagonalWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i - 1; k >= 0; k--) {
            for (int l = j - 1; l >= 0; l--) {
                if (landWaterMatrix.get(k).get(l) == 1) {
                    waterPatchCell.add(String.valueOf(i) + k);
                } else {
                    return waterPatchCell;
                }
            }
        }
        return waterPatchCell;
    }

    // checkTopRightDiagonal
    private static HashSet<String> getTopRightDiagonalWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i - 1; k >= 0; k--) {
            for (int l = j + 1; l < landWaterMatrix.get(k).size(); l++) {
                if (landWaterMatrix.get(k).get(l) == 1) {
                    waterPatchCell.add(String.valueOf(i) + k);
                } else {
                    return waterPatchCell;
                }
            }
        }
        return waterPatchCell;
    }

    // checkBottomLeftDiagonal
    private static HashSet<String> getBottomLeftDiagonalWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i + 1; k < landWaterMatrix.size(); k++) {
            for (int l = j - 1; l >= 0; l--) {
                if (landWaterMatrix.get(k).get(l) == 1) {
                    waterPatchCell.add(String.valueOf(i) + k);
                } else {
                    return waterPatchCell;
                }
            }
        }
        return waterPatchCell;
    }

    // checkBottomRightDiagonal
    private static HashSet<String> getBottomRightDiagonalWaterPatch(List<List<Integer>> landWaterMatrix, int i, int j) {
        HashSet<String> waterPatchCell = new HashSet<>();
        for (int k = i + 1; k < landWaterMatrix.size(); k++) {
            for (int l = j + 1; l < landWaterMatrix.get(k).size(); l++) {
                if (landWaterMatrix.get(k).get(l) == 1) {
                    waterPatchCell.add(String.valueOf(i) + k);
                } else {
                    return waterPatchCell;
                }
            }
        }
        return waterPatchCell;
    }
}
