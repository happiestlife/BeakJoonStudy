// https://www.acmicpc.net/problem/2839

package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 4 || N == 7) {
            System.out.println(-1);
        }
        else {
            int x = N % 5;
            switch (x){
                case 0:
                    System.out.println(N/5);
                    break;
                case 1:
                    System.out.println((N/5-1 + 2));
                    break;
                case 2:
                    System.out.println((N/5-2 + 4));
                    break;
                case 3:
                    System.out.println((N/5 + 1));
                    break;
                case 4:
                    System.out.println((N/5-1 + 3));
                    break;
            }
        }
        br.close();
    }
}
