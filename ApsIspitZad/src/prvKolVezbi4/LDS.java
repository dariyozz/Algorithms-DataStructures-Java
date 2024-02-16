package prvKolVezbi4;



import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka
        int n = a.length;
        int[] dp = new int[n];

        // Initialize the dp array with 1 for each element
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLength = 1; // Initialize the maximum length

        // Iterate over the array and update the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the current element is less than the previous element
                // Update the dp array with the maximum length of decreasing sequence
                if (a[j] > a[i]) {
                    int b = Math.max(dp[i],dp[j]+1);
                    dp[i] = b;
                }
            }
            // Update the maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }



    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }

}


