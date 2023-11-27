public class ArrayV {
    public static void main(String[] args) {

        int[] V = { 5, 17, -3, 8, 0, -7, 12, 15, 20, -6, 6, 4, -7, 16 };
        int[] V2 = new int[V.length];

        System.out.println("V2:");

        for (int i = 0; i < V.length; i++) {
            
            if (V[i] > 0 && (V[i] % 3 == 0 || V[i] % 5 == 0)) {
                V2[i] = 2 * V[i];
            } else if (V[i] > -5 && V[i] < 0) {
                V2[i] = 3 * V[i];
            } else {
                V2[i] = V[i];
            }

            System.out.print(V2[i] + "; ");
        }

        System.out.println("\n\nIliya Iliev");

    }
}