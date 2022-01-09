import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackSequence {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sequenceNum = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<String> result = new LinkedList<>();

        int fail = 0;
        int num = 1;
        int sequenceArray[] = new int[sequenceNum];
        for(int i = 0; i < sequenceNum; i++)
            sequenceArray[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < sequenceNum; i++){
            if(num == 1){
                while(num <= sequenceArray[i]){
                    stack.push(num++);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            }else if(sequenceArray[i] < sequenceArray[i-1]){
                while (true) {
                    if(stack.empty()){
                        fail = 1;
                        break;
                    }
                    int data = stack.pop();
                    result.add("-");
                    if (data == sequenceArray[i]) break;
                }
            }else{
                if(num > sequenceArray[i]){
                    fail = 1;
                    break;
                }
                while(num <= sequenceArray[i]){
                    stack.push(num++);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            }
        }
        if(fail == 1)
            System.out.print("NO");
        else {
            while(!result.isEmpty()){
                System.out.println(result.poll());
            }
        }

        br.close();
    }
}
