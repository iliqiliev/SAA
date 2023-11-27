public class ArrayMax {
    public static void main(String[] args) {

        int[] array = { 5, 17, -3, 8, 0, -7, 12, 15, 20, -6, 6, 4, -7, 16 };
        int arrayMax = array[0], arrayMaxIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > arrayMax) {
                arrayMax = array[i];
                arrayMaxIndex = i;
            }

        }

        System.out.println("The element with the largest numeric value is " + arrayMax
                + ". It is located at index " + arrayMaxIndex);

        System.out.println("\nIliya Iliev");
    }
}
