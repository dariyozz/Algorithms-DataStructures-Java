package OddEvenSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        int[] tmpOdd = new int[a.length];
        int[] tmpEven = new int[a.length];
        int tmpEvenCount = 0, tmpOddCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                tmpOdd[tmpOddCount++] = a[i];
            } else if (a[i] % 2 == 0) {
                tmpEven[tmpEvenCount++] = a[i];
            }
        }
        boolean swapped;
        for (int i = 0; i < tmpOddCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < tmpOddCount - 1; j++) {
                if (tmpOdd[j] > tmpOdd[j + 1]) {
                    int tmp = tmpOdd[j];
                    tmpOdd[j] = tmpOdd[j + 1];
                    tmpOdd[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        for (int i = 0; i < tmpEvenCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < tmpEvenCount - 1; j++) {
                if (tmpEven[j] < tmpEven[j + 1]) {
                    int tmp = tmpEven[j];
                    tmpEven[j] = tmpEven[j + 1];
                    tmpEven[j + 1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        for (int i = 0; i < tmpOddCount; i++) {
            a[i] = tmpOdd[i];
        }
        int p = 0;
        for (int i = tmpOddCount; i < n; i++) {
            a[i] = tmpEven[p++];
        }
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}
