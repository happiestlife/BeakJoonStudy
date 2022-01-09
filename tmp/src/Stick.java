import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Stick {
    public static void main(String args[]) throws IOException {
        Stack<Integer> stickStack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stickNum = 0;
        int sticksPart = 0;
        char before = 0;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(') {
                stickStack.push(0);
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
    }
}
