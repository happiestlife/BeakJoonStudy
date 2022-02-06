package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static long max(long x, long y) {
        return x > y ? x : y;
    }
    public static long dp(int stare[], long term[], int idx) {
        if(idx < 0) return 0;
        else if(idx == 0) return term[idx] = stare[idx];
        else if(term[idx] != 0) return  term[idx];

        return term[idx] = stare[idx]
                + max(stare[idx-1] + dp(stare, term, idx-3),
                        dp(stare, term, idx-2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int stare[] = new int[N];
        for(int i = 0; i < N; i++)
            stare[i] = Integer.parseInt(br.readLine());

        long term[] = new long[N];
        dp(stare, term, N-1);

        System.out.println(term[N-1]);

        br.close();
    }
}
