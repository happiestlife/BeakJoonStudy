// https://www.acmicpc.net/problem/1149

package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149 {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static long term[][];
    public static long min(long x, long y) {
        return x < y ?  x : y;
    }
    public static long min(long x, long y, long z) {
        return x < y ? (x < z ? x : z) : (y < z ? y : z);
    }

    public static long dp(int cost[][], int idx, int color) {
        if(idx == 1) return term[idx][color] = cost[idx][color];
        else if(term[idx][color] != 0) return term[idx][color];

        if(color == RED)
            term[idx][color] = min(cost[idx][color] + dp(cost, idx-1, GREEN),
                                cost[idx][color] + dp(cost, idx-1, BLUE));
        else if(color == GREEN)
            term[idx][color] = min(cost[idx][color] + dp(cost, idx-1, RED),
                                cost[idx][color] + dp(cost, idx-1, BLUE));
        else
            term[idx][color] = min(cost[idx][color] + dp(cost, idx-1, RED),
                                 cost[idx][color] + dp(cost, idx-1, GREEN));

        return term[idx][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cost[][] = new int[N+1][3];
        term = new long[N+1][3];
        for (int i = 1; i < N+1; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(input[j]);
        }

        for(int i = 0; i < 3; i++)
            dp(cost, N, i);

        System.out.println(min(term[N][RED], term[N][GREEN], term[N][BLUE]));

        br.close();
    }
}
