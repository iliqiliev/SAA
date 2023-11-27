import java.util.Scanner;

public class BinomialCoefficientsArray {

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner readln = new Scanner(System.in);
        int x = 0;

        // Ensure valid input
        do {
            System.out.println("Enter a positive number: ");

            while (!(readln.hasNextInt())) {
                System.out.println("Invalid input! Enter a positive number:");
                readln.next();
            }
            x = readln.nextInt();
        } while (x <= 0);

        // x + 1 because I go from 0 to x
        int[] coefficientsArray = new int[x + 1];

        System.out.println("The binomial coefficients of " + x + " are:");
        for (int i = 0; i <= x; i++) {

            int current_coefficient = factorial(x) / (factorial(i) * factorial(x - i));
            coefficientsArray[i] = current_coefficient;

            System.out.print(current_coefficient + "; ");
        }

        readln.close();
        System.out.println("\n\nIliya Iliev");

    }
}
