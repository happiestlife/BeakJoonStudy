// https://www.acmicpc.net/problem/2839

package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2839 {
    public static class Case{
        private int num;
        private int weight;

        public Case(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static boolean cal(Case c, int addNum, int N, Queue<Case> q, Map<Integer, Integer> map) {
        int newWeight = c.weight + addNum;
        if (newWeight == N) {
            System.out.println(c.num + 1);
            return true;
        }
        else if (newWeight < N &&
                (map.containsKey(newWeight) == false || map.get(newWeight) > c.num + 1)) {
            q.add(new Case(c.num + 1, newWeight));
            map.put(newWeight, c.num+1);
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Case> q = new LinkedList<>();
        q.add(new Case(0, 0));
        boolean isSuccess = false;
        while (!q.isEmpty()) {
            Case c = q.poll();
            if(isSuccess = cal(c, 5, N, q, map)) break;
            if(isSuccess = cal(c, 3, N, q, map)) break;
        }
        if(!isSuccess) System.out.println("-1");

        br.close();
    }
}
