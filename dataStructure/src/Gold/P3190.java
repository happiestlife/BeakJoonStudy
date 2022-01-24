// https://www.acmicpc.net/problem/3190

package Gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P3190 {
    public static class Dir{
        private int second;
        private char dir;

        public Dir(int second, char dir) {
            this.second = second;
            this.dir = dir;
        }
    }
    public static final int UP = -1;
    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int APPLE = 2;
    public static int board[][];
    public static Deque<Point> worm;
    public static int dirSwitch(int dir, int change){
        if(change == 'L') dir--;
        else dir++;

        if(dir == -2) dir = LEFT;
        else if(dir == 3) dir = UP;

        return dir;
    }

    public static Point move(int dir, Point point){
        switch (dir){
            case UP: point.x--; break;
            case DOWN: point.x++; break;
            case RIGHT: point.y++; break;
            case LEFT: point.y--; break;
        }
        int x = point.x; int y = point.y;
        if(1 > x || x >= board.length || 1 > y || y >= board.length) return null;
        else if(board[x][y] == 1) return null;

        if (board[x][y] == 0) {
            Point p = worm.pollLast();
            board[p.x][p.y] = 0;
        }
        worm.addFirst(new Point(x, y));
        board[x][y] = 1;
        return point;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = 0;

        String input[];
        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            board[x][y] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Dir> q = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            input = br.readLine().split(" ");
            int sec = Integer.parseInt(input[0]);
            char dir = input[1].charAt(0);

            q.add(new Dir(sec, dir));
        }

        int sec = 0;
        int x = 1, y = 1;
        int dir = RIGHT;
        board[x][y] = 1;
        worm = new ArrayDeque<>();
        worm.addFirst(new Point(x, y));
        while(true){
            if(!q.isEmpty()){
                Dir d = q.peek();
                if (sec != 1 && d.second == sec) {
                    dir = dirSwitch(dir, d.dir);
                    q.poll();
                }
            }
            Point p = move(dir, new Point(x, y));
            if(p == null) break;
            else{
                x = p.x;
                y = p.y;
            }
            sec++;
        }

        System.out.println(sec+1);
        br.close();
    }
}

