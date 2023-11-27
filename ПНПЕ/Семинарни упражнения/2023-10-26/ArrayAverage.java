public class ArrayAverage {
    public static void main(String[] args) {

        int[] array = { 5, 17, -3, 8, 0, -7, 12, 15, 20, -6, 6, 4, -7, 16 };
        int arraySum = 0;

        for (int element : array) {
            arraySum += element;
        }

        double arrayAverage = arraySum / array.length;

        System.out.println("The average value of all elements in the array is " + String.format("%.2f", arrayAverage));

        System.out.println("\nIliya Iliev");

    }
}
