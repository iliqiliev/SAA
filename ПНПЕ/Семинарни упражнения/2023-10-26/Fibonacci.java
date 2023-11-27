import java.lang.Math;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println("The first 15 numbers of the Fibonacci sequence:");

        for (int i = 0; i < 15; i++) {
            // Binet's Formula
            int current = (int) (((Math.pow(((1 + Math.sqrt(5)) / 2), i)) - (Math.pow(((1 - Math.sqrt(5)) / 2), i)))
                                / (Math.sqrt(5)));

            System.out.print(i + " - " + current + "; ");
        }

        System.out.println("\n\nIliya Iliev");

    }
}