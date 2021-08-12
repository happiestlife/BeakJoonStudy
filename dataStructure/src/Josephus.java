//https://www.acmicpc.net/problem/1158

import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {
    int num;
    boolean isUsed;
    public Main(int num){
        this.num = num;
        isUsed = false;
    }
    public static void print(Queue<Integer> result){
        System.out.print("<");
        while(true){
            int num = result.poll();
            System.out.print(num);
            if(result.peek() == null) break;
            System.out.print(", ");
        }
        System.out.println(">");
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Queue<Integer> result = new LinkedList<>();
        int size = Integer.parseInt(stk.nextToken());
        int type = Integer.parseInt(stk.nextToken());
        Main num[] = new Main[size];
        for(int i = 0; i < size; i++)
            num[i] = new Main(i+1);

        int index = -1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < type; j++){
                index = (index+1) % size;
                if(num[index].isUsed){
                    j--;
                    continue;
                }
            }
            result.add(num[index].num);
            num[index].isUsed = true;
        }
        print(result);
    }
}
