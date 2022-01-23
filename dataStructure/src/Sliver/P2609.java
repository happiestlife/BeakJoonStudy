// https://www.acmicpc.net/problem/2609

package Sliver;

import java.io.*;
import java.util.ArrayList;

public class P2609{
    public static int maxCommonDivision(int a, int b, ArrayList<Integer> prime) {
        int result = 1;
        for(int i = 0; i < prime.size(); i++){
            int p = prime.get(i);
            while(a % p == 0 && b % p == 0){
                result *= p;
                a /= p;
                b /= p;
            }
        }

        return result;
    }

    public static ArrayList<Integer> getPrime(boolean isPrime[]) {
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 2; i < isPrime.length; i++){
            if(isPrime[i] == true) {
                prime.add(i);
                for (int j = 2; i * j < isPrime.length; j++)
                    isPrime[i * j] = false;
            }
        }
        return prime;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int min = a < b ? a : b;
        ArrayList<Integer> prime = new ArrayList<>();
        boolean isPrime[] = new boolean[min+1];
        for(int i = 0; i < isPrime.length; i++)
            isPrime[i] = true;
        prime = getPrime(isPrime);

        int mcd = maxCommonDivision(a, b, prime);
        System.out.println(mcd);
        System.out.println(a * b / mcd);

        br.close();
    }
}
