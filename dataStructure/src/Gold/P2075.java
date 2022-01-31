// https://www.acmicpc.net/problem/2075

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2075 {
    public static class Index{
        private int num;
        private int idx;

        public Index(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int table[][] = new int[N][N];
        int tidx[] = new int[N];
        for(int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            tidx[i] = N-1;
            for (int j = 0; j < input.length; j++)
                table[i][j] = Integer.parseInt(input[j]);
        }

        PriorityQueue<Index> max = new PriorityQueue<>(new Comparator<Index>() {
            @Override
            public int compare(Index o1, Index o2) {
                return o2.num - o1.num;
            }
        });
        for(int i = 0; i < N; i++)
            max.add(new Index(table[N - 1][i], i));


        for (int i = 0; i < N-1; i++) {
            Index ind = max.poll();
            int x = ind.idx;
            if(tidx[x] > 0)
                max.add(new Index(table[--tidx[x]][x], x));
        }

        System.out.println(max.poll().num);

        br.close();
    }
}
