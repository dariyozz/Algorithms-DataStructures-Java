package findRank_heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CompetitorRankWithHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int score;

        for (int i = 0; i < N; i++) {
            score = scanner.nextInt();
            maxHeap.add(score);
        }
        int targetScore = scanner.nextInt();

        int rank = 1;
        while (!maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            if (current > targetScore) {
                rank++;
            }
        }
        System.out.println(rank);
        scanner.close();
    }
}
