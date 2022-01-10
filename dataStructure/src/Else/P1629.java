package Else;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P1629 {
    static long get_n_k(long a, long b, long c){
        if(b == 1)
            return a % c;

        long n_k = get_n_k(a, b / 2, c);

        if (b % 2 == 1)
            return (n_k * n_k * a) % c;
        else
            return (n_k * n_k) % c;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a, b, c;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Long.parseLong(stk.nextToken());
        b = Long.parseLong(stk.nextToken());
        c = Long.parseLong(stk.nextToken());

        long r = get_n_k(a, b, c);
        System.out.println(r);
    }
}
