// https://www.acmicpc.net/problem/2357

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P2357 {
    public static final int MIN = 0;
    public static final int MAX = 1;
    public static int arr[];
    public static int op;
    public static int cal(int a, int b){
        if(op == MIN) return a < b ? a : b;
        else return a > b ? a : b;
    }
    public static int build(int tree[], int node, int start, int end){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = cal(build(tree, node * 2, start, mid)
                ,build(tree, node * 2 + 1, mid + 1, end));
    }

    public static int get(int tree[], int left, int right, int node, int start, int end){
        if(right < start || left > end) {
            if(op == MIN) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }

        if(left <= start && end <= right) return tree[node];

        int mid = (start + end)/2;
        return cal(get(tree, left, right, node*2, start, mid)
                ,get(tree, left, right, node*2+1, mid+1, end));
    }
    public static void main(String args[]) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N+1];
        int minTree[] = new int[4*N + 1];
        int maxTree[] = new int[4*N + 1];
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        op = MIN;
        build(minTree, 1, 1, N);
        op = MAX;
        build(maxTree, 1, 1, N);

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            op = MIN;
            System.out.print(get(minTree, x, y, 1, 1, N) + " ");
            op = MAX;
            System.out.println(get(maxTree, x, y, 1, 1, N));
        }
        br.close();
    }
}
