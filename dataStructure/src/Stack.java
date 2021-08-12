
import java.util.*;

public class Stack {
    public int num[];
    private int size;
    public int count;

    public Stack(int size) {
        this.num = new int[size];
        this.size = size;
        this.count = 0;
    }

    public int size() {
        return count;
    }
    public int empty() {
        return count == 0? 1 : 0;
    }
    public void push(int data) {
        if(count == size) {
            return;
        }
        num[count++] = data;
    }
    public int pop() {
        if(empty() == 1) {
            return -1;
        }
        else
            return num[--count];
    }
    public int top() {
        if(empty() == 1)
            return -1;
        else
            return num[count-1];
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Stack stack = new Stack(100);
        int commandNum = s.nextInt();

        System.out.println("Stack");
        for(int i = 0; i < commandNum; i++) {
            String command = s.nextLine();
            if(command.contains("push")) {
                String str = command.substring(5);
                int data = Integer.parseInt(str);
                stack.push(data);
            }
            else {
                switch(command) {
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.empty());
                        break;
                    case "pop":
                        System.out.println(stack.pop());
                        break;
                    case "top":
                        System.out.println(stack.top());
                        break;
                }
            }
        }
        System.exit(0);
    }
}