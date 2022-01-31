// https://www.acmicpc.net/problem/17298

package Gold;

import java.io.*;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> result = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");

        for(int i = N-1; i >= 0; i--){
            int data = Integer.parseInt(input[i]);
            while(!stack.isEmpty() && stack.peek() <= data)
                stack.pop();

            if(stack.isEmpty()) result.add(-1);
            else result.add(stack.peek());

            stack.add(data);
        }

        while (!result.isEmpty()) {
            bw.write(result.pop() + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
