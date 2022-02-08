// https://www.acmicpc.net/problem/2178

package sliver;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {
    public static int xmove[] = {-1, 0, 1, 0};
    public static int ymove[] = {0, 1, 0, -1};

    public static void bfs(int graph[][]) {
        int N = graph.length-1;
        int M = graph[0].length-1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = p.x + xmove[i];
                int y = p.y + ymove[i];

                if( (x < 1 || x > N || y < 1 || y > M) ||
                    graph[x][y] == 0 || graph[x][y] > 1)
                    continue;

                if(x == N && y == M){
                    System.out.println(graph[p.x][p.y]+1);
                    return;
                }

                q.add(new Point(x, y));
                graph[x][y] = graph[p.x][p.y]+1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int graph[][] = new int[N+1][M+1];
        for(int i = 1; i < N+1; i++){
            String str = br.readLine();
            for (int j = 1; j < M+1; j++)
                graph[i][j] = str.charAt(j-1)-'0';
        }

        bfs(graph);

        br.close();
    }
}
