// https://www.acmicpc.net/problem/2667

package sliver;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2667 {
    public static int xmove[] = {-1, 0, 1, 0};
    public static int ymove[] = {0, 1, 0, -1};

    public static long bfs(int graph[][], int startx, int starty) {
        int N = graph.length;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startx, starty));

        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if(graph[p.x][p.y] != 1) continue;

            graph[p.x][p.y]++;
            count++;

            for (int i = 0; i < 4; i++) {
                int x = p.x + xmove[i];
                int y = p.y + ymove[i];

                if( (x < 0 || x > N-1 || y < 0 || y > N-1) ||
                    graph[x][y] != 1 )
                    continue;

                q.add(new Point(x, y));
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int graph[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++)
                graph[i][j] = input.charAt(j) - '0';
        }

        int count = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    count++;
                    heap.add(bfs(graph, i, j));
                }
            }
        }

        bw.write(count+"\n");
        while (!heap.isEmpty()) {
            bw.write(heap.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
