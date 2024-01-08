package WordPairs;

import java.util.Scanner;

public class CountWordPairs {

    //TODO: implement function
    public static int countWordPairs(String[] words) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            char prva = words[i].charAt(0);
            for (int j = i; j < words.length; j++) {
                if (j == i) continue;
                if (words[j].charAt(0) == prva) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String words[] = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));

    }
}