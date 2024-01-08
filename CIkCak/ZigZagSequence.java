package CIkCak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int cnt = 1, max = 0, sekv = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (cnt == 1) {
                if (a[i] > 0 && a[i + 1] < 0) {
                    cnt++;
                    sekv = 1;
                    continue;
                }
                if (a[i] < 0 && a[i + 1] > 0) {
                    cnt++;
                    sekv = 0;
                    continue;
                }
            }
            if (sekv == 1 && (a[i] < 0 && a[i + 1] > 0)) {
                cnt++;
                if (max < cnt) {
                    max = cnt;
                }
                sekv = 1 - sekv;
            } else if (sekv == 0 && (a[i] > 0 && a[i + 1] < 0)) {
                cnt++;
                if (max < cnt) {
                    max = cnt;
                }
                sekv = 1 - sekv;
            } else {
                if (max < cnt) {
                    max = cnt;
                }
                cnt = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}

