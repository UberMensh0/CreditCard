import java.util.Scanner;
//Fop Top
public class Main {

    public static int Card(int[] Number) {
        int sum = 0;
        int total = 0;
        int sum1 = 0;

        for (int i = Number.length - 2; i >= 0; i -= 2) {
            Number[i] *= 2;
            for (; Number[i] > 0; Number[i] /= 10) {
                sum += Number[i] % 10;
            }
        }

        for (int j : Number) {
            total += j;
        }

        for (int i = Number.length - 2; i >= 0; i -= 2) {
            sum1 += Number[i];
        }

        return sum + total - sum1;
    }

    public static int[] convertStringToIntArray(String numberString) {
        int[] numberArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            numberArray[i] = Character.getNumericValue(digitChar);
        }
        return numberArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        String numberString = scanner.nextLine().trim();
        int[] numbers = convertStringToIntArray(numberString);

        int result = Card(numbers);

        if ((result % 10) == 0) {
            if (numberString.startsWith("4")) {
                System.out.println("Visa");
            } else if (numberString.startsWith("22") || numberString.startsWith("51") || numberString.startsWith("52") || numberString.startsWith("53") || numberString.startsWith("54") || numberString.startsWith("55")) {
                System.out.println("MasterCard");
            } else if (numberString.startsWith("34") || numberString.startsWith("37")) {
                System.out.println("American Express");
            } else {
                System.out.println("Card type not recognized.");
            }
        } else {
            System.out.println("Invalid card.");
        }
    }
}
