public class ArrayMin {
    public static void main(String[] args) {
        
        int[] array = { 5, 17, -3, 8, 0, -7, 12, 15, 20, -6, 6, 4, -7, 16 };
        int arrayMin = array[0], arrayMinIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] < arrayMin) {
                arrayMin = array[i];
                arrayMinIndex = i;
            }

        }

        System.out.println("The element with the smallest numeric value is " + arrayMin
                + ". It is located at index " + arrayMinIndex);

        System.out.println("\nIliya Iliev");

    }
}
