package Else;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class cardGame {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> card = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= num; i++)
            card.offer(i);

        while(true){
            card.remove();
            card.add(card.poll());
            if(card.size() == 1) break;
        }
        System.out.println(card.poll());
        br.close();
    }
}
