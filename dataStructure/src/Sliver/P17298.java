package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.print(result.pop() + " ");
        }

        br.close();
    }
}
