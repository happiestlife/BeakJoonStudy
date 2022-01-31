// https://www.acmicpc.net/problem/7576

package Gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7576 {
    public static int bfs(int graph[][], Queue<Point> q, int apple) {
        int ripenApple = 0;
        int days = -1;

        int dayRipen = 0;
        while (!q.isEmpty()) {
            if(dayRipen == 0){
                dayRipen = q.size();
                days++;
            }
            Point n = q.poll();
            dayRipen--;
            if(graph[n.x][n.y] == 1) continue;

            graph[n.x][n.y] = 1;
            ripenApple++;
            if(ripenApple == apple) break;

            if(graph[n.x-1][n.y] == 0) q.add(new Point(n.x-1, n.y));
            if(graph[n.x][n.y+1] == 0) q.add(new Point(n.x, n.y+1));
            if(graph[n.x+1][n.y] == 0) q.add(new Point(n.x+1, n.y));
            if(graph[n.x][n.y-1] == 0) q.add(new Point(n.x, n.y-1));
        }

        if(ripenApple == apple) return days;
        else return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int graph[][] = new int[M+2][N+2];

        Queue<Point> q = new LinkedList<>();
        int apple = 0;
        for(int i = 1; i < M+1; i++){
            input = br.readLine().split(" ");
            for (int j = 1; j < N+1; j++) {
                int data = Integer.parseInt(input[j-1]);
                graph[i][j] = data;
                if(data == 1 || data == 0){
                    apple++;
                    if(data == 1){
                        graph[i][j] = 0;
                        q.add(new Point(i, j));
                    }
                }
            }
        }

        for(int i = 0; i < N+2; i++) {
            graph[0][i] = 2;
            graph[M+1][i] = 2;
        }
        for(int i = 0; i < M+2; i++){
            graph[i][0] = 2;
            graph[i][N+1] = 2;
        }

        System.out.println(bfs(graph, q, apple));

        br.close();
    }
}