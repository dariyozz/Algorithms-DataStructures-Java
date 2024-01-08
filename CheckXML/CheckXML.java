package CheckXML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class CheckXML {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        int valid = 1;

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        System.out.println(valid);

        br.close();
    }
}