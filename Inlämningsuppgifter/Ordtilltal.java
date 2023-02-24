import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("noll", 0);
        wordToNumber.put("en", 1);
        wordToNumber.put("ett", 1);
        wordToNumber.put("två", 2);
        wordToNumber.put("tre", 3);
        wordToNumber.put("fyra", 4);
        wordToNumber.put("fem", 5);
        wordToNumber.put("sex", 6);
        wordToNumber.put("sju", 7);
        wordToNumber.put("åtta", 8);
        wordToNumber.put("nio", 9);
        wordToNumber.put("tio", 10);
        wordToNumber.put("elva", 11);
        wordToNumber.put("tolv", 12);
        wordToNumber.put("tretton", 13);
        wordToNumber.put("fjorton", 14);
        wordToNumber.put("femton", 15);
        wordToNumber.put("sexton", 16);
        wordToNumber.put("sjutton", 17);
        wordToNumber.put("arton", 18);
        wordToNumber.put("nitton", 19);
        wordToNumber.put("tjugo", 20);
        wordToNumber.put("trettio", 30);
        wordToNumber.put("fyrtio", 40);
        wordToNumber.put("femtio", 50);
        wordToNumber.put("sextio", 60);
        wordToNumber.put("sjuttio", 70);
        wordToNumber.put("åttio", 80);
        wordToNumber.put("nittio", 90);
        wordToNumber.put("hundra", 100);
        wordToNumber.put("tusen", 1000);
        wordToNumber.put("miljon", 1000000);
        wordToNumber.put("miljard", 1000000000);

        String[] words = input.split(" ");
        long number = 0;
        long currentSegment = 0;
        for (String word : words) {
            int value = wordToNumber.get(word);
            if (value == 100 || value == 1000 || value >= 1000000) {
                currentSegment *= value;
                number += currentSegment;
                currentSegment = 0;
            } else {
                currentSegment += value;
            }
        }

        number += currentSegment;
        System.out.println(number);
    }
}
