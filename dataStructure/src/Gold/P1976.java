package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1976 {
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int node, boolean isVisited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int v = q.poll();
            isVisited[v] = true;

            ArrayList<Integer> link = graph.get(v);
            for(int i = 0; i < link.size(); i++){
                if(isVisited[link.get(i)] == false)
                    q.add(link.get(i));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean isVisited[] = new boolean[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(null);
        for(int i = 1; i <= N; i++){
            graph.add(new ArrayList<Integer>());

            String input[] = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                if(input[j].equals("1"))
                    graph.get(i).add(j+1);
            }
        }
        String route[] = br.readLine().split(" ");

        int component = 0;
        for(int i = 1; i <= route.length; i++) {
            int node = Integer.parseInt(route[i-1]);
            if (isVisited[node] == false) {
                bfs(graph, node, isVisited);
                component++;
            }
        }

        if(component > 1) System.out.println("NO");
        else System.out.println("YES");

        br.close();
    }
}
