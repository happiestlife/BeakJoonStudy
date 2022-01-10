package Else;//https://www.acmicpc.net/submit/2630/33586490

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static int whiteSquare, blueSquare;
    static int check(int [][]square, int x, int y, int size){
        int parity = square[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (parity != square[i][j])
                    return 0;
            }
        }
        return 1;
    }
    static void divide(int [][]square, int x, int y, int size){
        if (size == 1 || check(square, x, y, size) != 0) {
            if(square[x][y] == 1) blueSquare++;
            else whiteSquare++;
            return;
        }
        divide(square, x, y, size/2);
        divide(square, x + size/2, y, size/2);
        divide(square, x, y + size / 2, size/2);
        divide(square, x + size / 2, y + size / 2, size/2);
    }
    public static void main(String args[]) throws IOException {
        int FULLSIZE = 128;
        int square[][] = new int[FULLSIZE][FULLSIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; stk.hasMoreTokens(); j++)
                square[i][j] = Integer.parseInt(stk.nextToken());
        }

        divide(square, 0, 0, size);
        System.out.printf("%d\n", whiteSquare);
        System.out.printf("%d\n", blueSquare);

        br.close();
    }
}
