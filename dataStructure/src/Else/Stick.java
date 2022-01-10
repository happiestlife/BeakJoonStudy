package Else;//https://www.acmicpc.net/problem/10799

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Stick {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stickNum = 0;
        int sticksPart = 0;
        char before = 0;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(') {
                stickNum++;
            }
            else if(c == ')'){
                if(before == '(') {
                    stickNum--;
                    sticksPart += stickNum;
                }
                else {
                    sticksPart++;
                    stickNum--;
                }
            }
            before = c;
        }

        System.out.println(sticksPart);
        br.close();
    }
}
