package ShakerSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    static void shakerSort(int a[], int n) {
        // Vasiot kod tuka
//
//        int start = 0, end = a.length - 1;
//        while (start != end) {
//            int min = 99999, max = -9999, minInx = -1;
//            for (int i = start; i <= end; i++) {
//                if (a[i] < min) {
//                    min = a[i];
//                    minInx = i;
//                }
//            }
//            if (minInx >= 0) {
//                int tmp = a[minInx];
//                for (int i = minInx; i > start; i--) {
//                    a[i] = a[i - 1];
//                }
//                a[start] = tmp;
//                for (int i = minInx + 1; i < end; i++) {
//                    for (int j = minInx + 1; j < end; j++) {
//                        if (a[i] > a[j + 1]) {
//                            int tmp2 = a[i];
//                            a[i] = a[j + 1];
//                            a[j + 1] = tmp2;
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
//            start++;
//            if (start == end) {
//                for (int i = 0; i < n; i++) {
//                    System.out.print(a[i] + " ");
//                }
//                System.out.println();
//                break;
//            }
//            for (int i = start; i < end; i++) {
//                if (a[i] > a[i + 1]) {
//                    int tmp = a[i];
//                    a[i] = a[i + 1];
//                    a[i + 1] = tmp;
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
//            end--;
//        }
        int currPos = 0;
        int temp;
        for(int i = 0; i < (n + 1) / 2; i++) {
            boolean swap = false;

            for(int j = n - 1; j > currPos; j--) {
                if(a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    swap = true;
                }
            }
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();

            for(int j = currPos; j < n - 1; j++) {
                if(a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swap = true;
                }
            }
            currPos++;
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();

            if(!swap) break;
        }
    }


    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        shakerSort(a,n);
    }
}