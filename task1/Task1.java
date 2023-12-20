package task1;

public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        int currentPosition = 0;
        do {
            System.out.print(array[currentPosition]);
            currentPosition = (currentPosition + m - 1) % n;
        } while (currentPosition != 0);

    }
}
