package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2042 {
    public static long arr[];
    public static long cal(long a, long b){
        return a + b;
    }
    public static long build(long tree[], int node, int start, int end){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = cal(build(tree, node * 2, start, mid)
                            ,build(tree, node * 2 + 1, mid + 1, end));
    }
    public static long update(long tree[], long newData, int idx, int node, int start, int end){
        if(idx < start || idx > end) return tree[node];

        if(start == end && idx == start) return tree[node] = newData;

        int mid = (start + end)/2;
        tree[node] = cal(update(tree, newData, idx, node * 2, start, mid)
                     ,update(tree, newData, idx, node * 2 + 1, (mid + 1), end));
        return tree[node];
    }

    public static long get(long tree[], int left, int right, int node, int start, int end){
        if(right < start || left > end) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start + end)/2;
        return cal(get(tree, left, right, node*2, start, mid)
                    ,get(tree, left, right, node*2+1, mid+1, end));
    }

    public static void main(String args[]) throws IOException {
        int N, M, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new long[N+1];
        long tree[] = new long[4*N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Long.parseLong(br.readLine());

        build(tree, 1, 1, N);

        int a, b;
        long c;
        for(int i = 0; i < M+K; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Long.parseLong(input[2]);

            if(a == 1) update(tree, c, b, 1, 1, N);
            else System.out.println(get(tree, b, (int)c, 1, 1, N));
        }

        br.close();
    }
}
