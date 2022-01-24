//https://www.acmicpc.net/problem/17413

package Sliver;

import java.io.*;
import java.util.Stack;

public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '<') {
                while(!stack.empty()){
                    bw.write(stack.pop());
                }
                while(c != '>'){
                    bw.write(c);
                    c = line.charAt(++i);
                }
                bw.write('>');
            }else if(c == ' '){
                while(!stack.empty()){
                    bw.write(stack.pop());
                }
                bw.write(c);
            }else
                stack.push(c);
        }
        while(!stack.empty())
            bw.write(stack.pop());

        bw.flush();
        bw.close();
        br.close();
    }
}
