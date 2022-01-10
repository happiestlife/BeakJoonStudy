//https://www.acmicpc.net/problem/4889

package Sliver;

import java.io.*;
import java.util.Stack;

public class P4889 {
    public static int cal(String input){
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '{') stack.push(c);
            else {
                if(stack.empty()){
                    count++;
                    stack.push('{');
                    continue;
                }
                stack.pop();
            }
        }
        while(!stack.empty()){
            stack.pop();
            stack.pop();
            count++;
        }

        return count;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while(true){
            String input = br.readLine();
            if(input.charAt(0) == '-') break;

            bw.write(idx++ + ". " + cal(input) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
