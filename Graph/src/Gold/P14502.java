//https://www.acmicpc.net/problem/14502

package Gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {
    private static final int VIRUS = 2;
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static int rowMove[] = {-1, 0, 1, 0};
    private static int colMove[] = {0, 1, 0, -1};

    public static Point convertPoint(int data, int M) {
        int row = data / M;
        int col = data % M;
        return new Point(row, col);
    }

    public static boolean convert(int graph[][], int wall[], int flag) {
        int M = graph[0].length;
        for(int i = 0; i < wall.length; i++){
            Point p = convertPoint(wall[i], M);
            int row = p.x;
            int col = p.y;
            graph[row][col] = flag;
        }
        return true;
    }

    public static void findEmpty(int graph[][], int wall[], int level, int max) {
        int N = graph.length;
        int M = graph[0].length;
        Point p = convertPoint(wall[level], M);
        while(wall[level] < max && graph[p.x][p.y] != EMPTY){
            wall[level]++;
            p = convertPoint(wall[level], M);
        }
        if(level < 2) wall[level+1] = wall[level] + 1;
    }

    public static int bfs(int graph[][], int safeRoom, ArrayList<Point> virus) {
        Queue<Point> q = new LinkedList<>();
        for(Point p : virus)
            q.add(p);

        while (!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int x = p.x + rowMove[i];
                int y = p.y + colMove[i];
                if(x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) continue;

                if(graph[x][y] == EMPTY) {
                    graph[x][y] = VIRUS;
                    q.add(new Point(x, y));
                    safeRoom--;
                }
            }
        }
        return safeRoom;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int safeRoom = 0;
        ArrayList<Point> virus = new ArrayList<>();
        int graph[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if(graph[i][j] == EMPTY) safeRoom++;
                else if(graph[i][j] == VIRUS) virus.add(new Point(i, j));
            }
        }


        int wall[] = new int[3];
        wall[0] = 0;

        int result = 0;
        int tmp[][] = new int[N][M];
        while(wall[0] < N * M - 2) {
            findEmpty(graph, wall, 0, N*M-2);
            if( wall[0] >= N*M-2) break;

            while(wall[1] < N * M - 1) {
                findEmpty(graph, wall, 1, N*M-1);
                if( wall[1] >= N*M-1) break;

                while(wall[2] < N * M) {
                    findEmpty(graph, wall, 2, N*M);
                    if( wall[2] >= N*M) break;

                    for(int i = 0; i < N; i++)
                        for(int j = 0; j < M; j++)
                            tmp[i][j] = graph[i][j];

                    convert(tmp, wall, WALL);

                    int data = bfs(tmp, safeRoom-3, virus);
                    result = result > data ? result : data;

                    wall[2]++;
                }
                wall[1]++;
                wall[2] = wall[1] + 1;
            }
            wall[0]++;
            wall[1] = wall[0] + 1;
        }

        System.out.println(result);
        br.close();
    }
}
