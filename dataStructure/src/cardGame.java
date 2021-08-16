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

        while(num != 1){
            card.remove();
            card.add(card.poll());
            num--;
        }
        System.out.println(card.poll());
    }
}
