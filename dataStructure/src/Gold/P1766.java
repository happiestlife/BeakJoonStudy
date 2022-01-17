//https://www.acmicpc.net/problem/1766
// 경우의 수를 잘 따져봐야 한다.
// 한 문제에서 먼저 풀어야 할 문제가 여러개일 수 있기 때문에 문제를 풀었는지 여부는 boolean형으로 따지면 안된다.
// 풀어야할 문제에 대해서 2차원 배열을 이용하여 표현한다.
// 만약 먼저 풀어야하는 문제들을 모두 푼 문제를 출력하기 위해선 작은 문제( 쉬운 문제 )를 풀어야 한다는 조건 때문에
// 출력전 모든 문제의 번호는 min 힙에 넣고 출력해준다.
package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1766 {

    public static void main(String args[]) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int before, after;
        int needSolve[] = new int[N+1];
        ArrayList<Integer> rules[] = new ArrayList[N+1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            rules[i] = new ArrayList<>();
            needSolve[i] = 0;
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            before = Integer.parseInt(input[0]);
            after = Integer.parseInt(input[1]);

            rules[before].add(after);
            needSolve[after]++;
        }

        for(int i = 1; i <= N; i++)
            if(needSolve[i] == 0) q.add(i);

        while(!q.isEmpty()){
            int data = q.poll();

            ArrayList<Integer> rule = rules[data];
            for(int i = 0; i < rule.size(); i++) {
                int solved = rule.get(i);
                needSolve[solved]--;

                if(needSolve[solved] == 0) q.add(solved);
            }

            System.out.print(data + " ");
        }

        br.close();
    }
}
