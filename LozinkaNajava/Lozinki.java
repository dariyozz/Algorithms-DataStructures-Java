package LozinkaNajava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void insertUser(String username, String password, int tableSize, String[][] hashTable) {
        int index = hashFunction(username, tableSize);
        while (hashTable[index][0] != null) {
            index = (index + 1) % tableSize;  // Linear probing for collisions
        }
        hashTable[index][0] = username;
        hashTable[index][1] = password;
    }

    private static int hashFunction(String key, int tableSize) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c;
        }
        return hash % tableSize;
    }

    private static void isValidUser(String username, String password, int tableSize, String[][] hashTable) {
        int index = hashFunction(username, tableSize);
        int attempts = 0;
        while (hashTable[index][0] != null) {
            if (hashTable[index][0].equals(username) && hashTable[index][1].equals(password)) {
                System.out.println("Najaven");
                return;
            } else {
                attempts++;
                if (attempts > tableSize) {
                    System.out.println("Nenajaven");
                    return;
                }
                index = (index + 1) % tableSize;
            }
        }
        System.out.println("Nenajaven");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tableSize = 2 * N;
        String[][] hashTable = new String[tableSize][2];
        for (int i = 1; i <= N; i++) {
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            insertUser(pom[0], pom[1], tableSize, hashTable);
        }
        while (true) {
            String userLogin = br.readLine();
            String[] usernamePass = userLogin.split(" ");
            if (userLogin.equals("KRAJ")) {
                break;
            }
            isValidUser(usernamePass[0], usernamePass[1], tableSize, hashTable);

        }
    }
}
