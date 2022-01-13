package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5002 {
    private static String line;
    public static int cal(Stack<Character> stack, int idx){
        char c = line.charAt(idx);
        if(stack.empty()) {
            stack.push(c);
            return 0;
        }

        char stackSex = stack.peek();
        char oppSex = (stackSex == 'M') ? 'W' : 'M';

        if (c == stackSex && idx < line.length()-1 && line.charAt(idx+1) == oppSex) {
            stack.pop();
            stack.push(c);
            return 1;
        } else if (c == stackSex) stack.push(c);
        else stack.pop();

        return 0;
    }
    public static void main(String args[]) throws IOException {
        int X;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        line = br.readLine();

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < line.length(); i++){
            int increase = cal(stack, i);
            count += increase + 1;
            i += increase;

            if(stack.size() > X){
                count--;
                break;
            }
        }

        System.out.println(count);

        br.close();
    }
}
