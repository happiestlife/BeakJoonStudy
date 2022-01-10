// https://www.acmicpc.net/problem/1327
// 여러가지를 고려해야하는 문제로 일반적인 경로 하나만으로는
// 문제를 해결할 수 없다. 따라서 모든 경우를 고려하는 코드를 작성하고
// bfs를 활용하여 최소한의 계산 결과를 도출한다.

package Sliver;

import java.io.*;
import java.util.*;

 public class P1327 {
    private static int N, K;

    private static class Case{
        private String str;
        private int count;

        public Case(String str, int count){
            this.str = str;
            this.count = count;
        }
    }

    public static String reverse(String input, int idx){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(input);

        for(int i = idx; i < idx + K; i++)
            stack.push(input.charAt(i));

        for(int i = idx; i < idx + K; i++)
            sb.setCharAt(i, stack.pop());

        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        String input = br.readLine().replace(" ", "");

        char tmp[] = new char[input.length()];
        for(int i = 0; i < input.length(); i++)
            tmp[i] = input.charAt(i);
        Arrays.sort(tmp);

        String right = new String();
        for(int i = 0; i < tmp.length; i++) {
            if (tmp[i] == ' ') continue;
            right += tmp[i];
        }

        boolean isSuccess = false;
        Queue<Case> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.offer(new Case(input, 0));
        while(!q.isEmpty()){
            Case c = q.poll();
            String caseStr = c.str;

            if(c.str.equals(right)){
                isSuccess = true;
                System.out.println(c.count);
                break;
            }

            if(!set.contains(caseStr)){
                set.add(caseStr);
                for(int i = 0; i <= N-K; i++){
                    String test = reverse(caseStr, i);
                    q.offer(new Case(test, c.count+1));
                }
            }
        }
        if(!isSuccess)
            System.out.println(-1);

        br.close();
    }
}
