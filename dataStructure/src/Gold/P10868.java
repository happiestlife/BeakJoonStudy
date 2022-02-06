package Gold;

import java.io.*;

public class P10868 {
    public static final int MAX = 1000000001;
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
    public static int cal(int a, int b){
        return min(a, b);
    }
    public static int init(int seg[], int arr[], int start, int end, int node) {
        if(start == end) return seg[node] = arr[start];

        int mid = (start + end)/2;
        return seg[node] = cal(init(seg, arr, start, mid, node * 2)
                           ,init(seg, arr, mid + 1, end, node * 2 + 1));
    }

    public static int search(int seg[], int start, int end, int a, int b, int node) {
        if(start > b || end < a) return MAX;
        else if(a <= start && end <= b) return seg[node];
        else {
            int mid = (start + end)/2;
            return cal(search(seg, start, mid, a, b, node * 2),
                    search(seg, mid + 1, end, a, b, node * 2 + 1));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int seg[] = new int[4*N + 1];
        int arr[] = new int[N+1];
        for(int i = 1; i < N+1; i++)
            arr[i] = Integer.parseInt(br.readLine());

        init(seg, arr, 1, N, 1);

//        for(int i = 1; i < seg.length; i++)
//            System.out.print(seg[i] + " ");

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            bw.write(search(seg, 1, N, a, b, 1)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
