//https://www.acmicpc.net/problem/2493

import java.io.*;
import java.util.StringTokenizer;

public class P2493 {
    int index;
    int height;

    public P2493(int index, int height) {
        this.index = index;
        this.height = height;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int towerNum = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int towers[] = new int[towerNum];
        for (int i = 0; stk.hasMoreTokens(); i++)
            towers[i] = Integer.parseInt(stk.nextToken());

        P2493 compareData[] = new P2493[towerNum];
        int compareDataSize = 0;
        for (int i = 0; ; i++) {
            int j = compareDataSize - 1;
            for (; j >= 0; j--) {
                if (compareData[j].height > towers[i]) {
                    bw.write(compareData[j].index+1 + " ");
                    break;
                }
            }
            if (j == -1) {
                bw.write("0 ");
            }

            if (i == towerNum - 1)
                break;
            else if (towers[i] >= towers[i + 1]) {
                compareData[compareDataSize++] = new P2493(i, towers[i]);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
