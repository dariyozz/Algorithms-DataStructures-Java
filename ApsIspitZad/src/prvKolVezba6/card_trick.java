//package prvKolVezba6;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
//
//public class card_trick {
//    public static int count(int N) {
//        // Vasiot kod tuka
//        Queue<Integer> cards = new ArrayQueue<>(1000);
//        Stack<Integer> shuffle = new Stack<>(7);
//        for (int i = 1; i <= 51; i++) cards.enqueue(i);
//
//        int totalNumberShuffles = 0;
//
//        while (cards.peek() != N) {
//
//            for (int i = 0; i < 7; i++) {
//                shuffle.push(cards.dequeue());
//            }
//
//            while (!shuffle.isEmpty()) {
//                cards.enqueue(shuffle.pop());
//                cards.enqueue(cards.dequeue());
//            }
//
//            totalNumberShuffles++;
//        }
//        return totalNumberShuffles;
//    }
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(count(Integer.parseInt(br.readLine())));
//    }
//
//}
