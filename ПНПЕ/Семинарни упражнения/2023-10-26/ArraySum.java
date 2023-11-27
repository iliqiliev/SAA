public class ArraySum {
    public static void main(String[] args) {

        int[] array = { 5, 17, -3, 8, 0, -7, 12, 15, 20, -6, 6, 4, -7, 16 };
        int arraySum = 0;

        for (int element : array) {
            arraySum += element;
        }

        System.out.println("The sum of all elements in the array is " + arraySum);

        System.out.println("\nIliya Iliev");

    }
}
