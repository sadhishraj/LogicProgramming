package org.logicalprogramming;

public class StreamDemo {

    public static void main(String[] args) {

        String text = "HHello World";

        for (int i = 0; i < text.length(); i++) {
            int count = 1;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j) && i != j) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(text.charAt(i));
                break;
            }

        }


    }
}
