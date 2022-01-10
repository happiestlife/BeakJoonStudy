package Else;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    private static int sequenceNum = 0;
    private static boolean isFind = false;
    static void traversal(int size, int x, int y, int findx, int findy) {
        // degenerate case
        if (size == 2) {
            if (x <= findx && findx < x + 2 && y <= findy && findy < y + 2) {
                for (int i = x; i < x + 2; i++) {
                    for (int j = y; j < y + 2; j++) {
                        if (i == findx && j == findy) {
                            System.out.printf("%d", sequenceNum);
                            isFind = true;
                            return;
                        }
                        sequenceNum++;
                    }
                }
            }
        }
        if (x <= findx && findx < x + size && y <= findy && findy < y + size) {
            if (!isFind) traversal(size / 2, x, y, findx, findy);
            if (!isFind) traversal(size / 2, x, y + size / 2, findx, findy);
            if (!isFind) traversal(size / 2, x + size / 2, y, findx, findy);
            if (!isFind) traversal(size / 2, x + size / 2, y + size / 2, findx, findy);
        }
        else {
            sequenceNum += size * size;
        }

    }
    public static void main(String args[]) throws IOException {
        int n, x, y;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());

        int size = 1;
        for (int i = 0; i < n; i++)
            size *= 2;

        traversal(size, 0, 0, x, y);
    }
}
