// https://www.acmicpc.net/problem/9012

import java.io.*;
import java.util.Stack;

public class parenthesesCheck {
    public static void main(String args[]) throws IOException{
        int j;
        String parenthesisString;
        Stack<Character> parenthesis;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandsNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < commandsNum; i++){
            parenthesisString = br.readLine();
            parenthesis = new Stack<>();
            for(j = 0; j < parenthesisString.length(); j++){
                char c = parenthesisString.charAt(j);
                if(c == '(' || c == '{' || c == '[')
                    parenthesis.push(c);
                else if(c == ')' || c == '}' || c == ']'){
                    if(parenthesis.empty()){                    // 닫는 괄호가 남아 있을때 ex. ())
                        System.out.println("NO");
                        //parenthesis.clear();
                        break;
                    }
                    else if(( parenthesis.peek() == '(' && c == ')') ||
                            ( parenthesis.peek() == '{' && c == '}') ||
                            ( parenthesis.peek() == '[' && c == ']'))
                        parenthesis.pop();
                    else {                                       // 여는 괄호와 닫는 괄호의 짝이 다를때 ex. {)
                        System.out.println("NO");
                        //parenthesis.clear();
                        break;
                    }
                }
            }
            if(parenthesis.empty() && j == parenthesisString.length())
                System.out.println("YES");
            else if (!parenthesis.empty() && j == parenthesisString.length())    // 여는 괄호가 남아 있을때 ex. (()
                System.out.println("NO");                                        // 짝이 다를 경우에도 여는  괄호가 남아 있을 수 있기 때문에
        }                                                                         // 끝까지 검사했는지 여부도 확인해준다.
    }
}