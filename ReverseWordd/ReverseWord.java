package ReverseWordd;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        char[] a = word.toCharArray();
        String rev = "";

        for(int i = a.length - 1; i >= 0; --i) {
            rev = rev + a[i];
        }

        System.out.println(rev);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] zborovi = new String[n];

        int i;
        for(i = 0; i < n; ++i) {
            zborovi[i] = in.next();
        }

        in.close();

        for(i = 0; i < n; ++i) {
            printReversed(zborovi[i]);
        }

    }
}
