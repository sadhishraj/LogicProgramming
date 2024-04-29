package org.logicalprogramming;

import java.util.List;
import java.util.Objects;

/**
 * This program determines whether coins of different weight can be split
 */
public class SplitGoldCoin {
    // Question:
    // Two thieves stole pure gold coins. each coins weight is in the array.
    // array = [10, 20, 54, 342, 12]
    // you need to write a program to find it if it can be split exactly among them, return true or false
    // [4, 10, 3, 5, 11, 3] -> true
    // [10, 20, 54, 342, 12] -> false

    // Pseudocode:
    // Step1: Check whether the sum of elements in array is even number.
    // Step2: If sum of elements is odd number, return false.
    // Step3: If sum of elements is even number, then divide it by 2 to get target weight.
    // Step4: Take the first number and in a for loop, add with remaining numbers.
    // Step 5: If on adding particular number makes the weight greater than target weight, skip that number


    public static void main(String[] args) {
        List<Integer> coinList = List.of( 11, 5, 3, 5, 11, 3, 4, 10, 2, 4);
        System.out.println(isCoinSplittable(coinList));
    }

    public static boolean isCoinSplittable(List<Integer> coinList) {
        int totalCoinWeight = coinList.stream().mapToInt(Integer::intValue).sum();
        int remainder = totalCoinWeight % 2;
        if (remainder != 0 || coinList.size() < 2) {
            return false;
        }
        int targetCoinWeight = totalCoinWeight / 2;

        if (coinList.size() == 2 && targetCoinWeight == coinList.getFirst()) {
            return true;
        }

        for (int i = 1; i < coinList.size(); i++) {
            int total = coinList.getFirst() + coinList.get(i);
            if(Objects.equals(total, targetCoinWeight)) {
                return true;
            }
            for (int j = i + 1; j < coinList.size(); j++) {
                if(Objects.equals(total + coinList.get(j), targetCoinWeight)) {
                    return true;
                } else if (total + coinList.get(j) < targetCoinWeight) {
                    total = total + coinList.get(j);
                }
            }
        }
        return false;
    }
}
