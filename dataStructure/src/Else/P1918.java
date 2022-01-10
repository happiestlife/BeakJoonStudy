package Else;//https://www.acmicpc.net/problem/1918

import java.io.*;
import java.util.Stack;

public class P1918 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String equation = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.empty()) {
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        bw.write(stack.pop());
                    }
                    break;
                case '+':
                case '-':
                    if(stack.empty() || stack.peek() == '(')
                        stack.push(c);
                    else {
                        while(!stack.empty() && stack.peek() != '(') {
                            bw.write(stack.pop());
                        }
                        stack.push(c);
                    }
                    break;
                case '*':
                case '/':
                    if(stack.empty() || stack.peek() == '(' ||
                       stack.peek() == '+' || stack.peek() == '-')
                        stack.push(c);
                    else {
                        bw.write(stack.pop());
                        stack.push(c);
                    }
                    break;
                default:
                    bw.write(c);
                    break;
            }
        }
        while(!stack.empty())
            bw.write(stack.pop());
        bw.flush();
        br.close();
        bw.close();
    }
}
