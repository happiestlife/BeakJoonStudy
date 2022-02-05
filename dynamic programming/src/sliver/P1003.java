// https://www.acmicpc.net/problem/1003

package sliver;

import java.io.*;

public class P1003 {
    public static final int MAX = 41;
    public static class Fibo{
        private int zero;
        private int one;

        public Fibo(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void cal(Fibo fibo[], int ind, int idx) {
        if(ind < 2) {
            fibo[0] = new Fibo(1, 0);
            fibo[1] = new Fibo(0, 1);
            ind = 2;
        }
        for(int i = ind; i <= idx; i++) {
            fibo[i] = new Fibo(fibo[i - 1].zero + fibo[i - 2].zero,
                            fibo[i - 1].one + fibo[i - 2].one);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ind = -1;
        Fibo fibo[] = new Fibo[MAX];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if(ind == -1 || num > ind){
                cal(fibo, ind, num);
                ind = num;
            }
            bw.write(fibo[num].zero + " " + fibo[num].one + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
