package PushZero;

import java.util.Scanner;

public class PushZero {
    public PushZero() {
    }

    public static int[] pushZerosToBeginning(int[] arr, int n) {
        int[] temp = new int[n];
        int cnt = 0;

        int i;
        for(i = 0; i < n; ++i) {
            if (arr[i] == 0) {
                temp[cnt++] = arr[i];
            }
        }

        for(i = 0; i < n; ++i) {
            if (arr[i] != 0) {
                temp[cnt++] = arr[i];
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];

        int i;
        for(i = 0; i < n; ++i) {
            numbers[i] = in.nextInt();
        }

        numbers = pushZerosToBeginning(numbers, n);
        in.close();
        System.out.println("Transformiranata niza e:");

        for(i = 0; i < n; ++i) {
            System.out.print(numbers[i] + " ");
        }

    }
}
