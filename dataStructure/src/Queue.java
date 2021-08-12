import java.util.*;

public class Queue {
    private int data[];
    private int front;
    private int back;
    private int fullSize;
    private int count;

    public Queue(int size){
        front = 0;
        back = 0;
        fullSize = size;
        count = 0;
        data = new int[size+1];
    }
    public int size() {
        return count;
    }
    public int full() {
        if(size()==fullSize)
            return 1;
        else
            return -1;
    }
    public int empty() {
        if(size()==0)
            return 1;
        else
            return 0;
    }

    public void push(int num) {
        if(full()==1)
            return;
        for(int i = count - 1; i >= 0; i--)
            data[i+1] = data[i];
        data[0] = num;

        if(count != 0) front++;
        count++;
    }
    public int pop() {
        if(empty() == 1)
            return -1;
        count--;
        if(front != 0)
            return data[front--];
        else
            return data[front];

    }
    public int front() {
        if(empty() == 1)
            return -1;
        return data[front];
    }
    public int back() {
        if(empty() == 1)
            return -1;
        return data[back];
    }

    public static void main(String args[]) {
        int size = 10;
        Queue q = new Queue(size);
        Scanner s = new Scanner(System.in);
        int commandsCount = s.nextInt();
        s.nextLine();
        for(int i = 0; i < commandsCount; i++) {
            String command = s.nextLine();
            if(command.contains("push")) {
                int data = Integer.parseInt(command.substring(5));
                q.push(data);
            }else {
                switch(command) {
                    case "pop":
                        System.out.println(q.pop());
                        break;
                    case "size":
                        System.out.println(q.size());
                        break;
                    case "empty":
                        System.out.println(q.empty());
                        break;
                    case "front":
                        System.out.println(q.front());
                        break;
                    case "back":
                        System.out.println(q.back());
                        break;
                }
            }
        }
    }
}