// https://www.acmicpc.net/problem/1260

package Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {
    private static ArrayList<Integer> graph[];
    private static boolean isVisited[];
    private static BufferedWriter bw;

    public static void dfs(int node) throws IOException {
        isVisited[node] = true;
        bw.write(node + " ");

        for(int to : graph[node]){
            if(isVisited[to] == false)
                dfs(to);
        }
    }
    public static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            if(isVisited[v] == true) continue;

            isVisited[v] = true;
            bw.write(v + " ");

            for(int to : graph[v]){
                if(isVisited[to] == false)
                    q.add(to);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M, V;
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        isVisited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i < graph.length; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 1; i < graph.length; i++)
            Collections.sort(graph[i]);

        dfs(V);
        bw.write("\n");

        isVisited = new boolean[N+1];
        bfs(V);

        bw.flush();
        bw.close();
        br.close();
    }
}
