package Sliver;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17225 {
    private static class Order implements Comparable<Order>{
        private String color;
        private int makeT;

        public Order(String color, int makeT) {
            this.color = color;
            this.makeT = makeT;
        }

        @Override
        public int compareTo(Order o) {
            if(makeT == o.makeT){
                if(color.equals("B") && o.color.equals("R")) return -1;
                else if (color.equals("R") && o.color.equals("B")) return 1;
                else return 0;
            }
            return makeT - o.makeT;
        }
    }

    public static void main(String args[]) throws IOException {
        int A, B, N;
        int orderTime, num;
        String color;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        PriorityQueue<Order> mheap = new PriorityQueue<>();

        int afinish = 0, bfinish = 0;
        for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");;

            orderTime = Integer.parseInt(input[0]);
            color = input[1];
            num = Integer.parseInt(input[2]);

            boolean isBlue = color.equals("B");
            int makeT = (isBlue ? A : B);
            int finishT = (isBlue ? afinish : bfinish);
            int startT = (finishT < orderTime ? orderTime : finishT);
            for(int j = 0; j < num; j++)
                mheap.add(new Order(color, startT + j * makeT));

            if(isBlue) afinish = startT + num * A;
            else bfinish = startT + num * B;
        }

        int sm[] = new int[100000];
        int js[] = new int[100000];
        int number = 1, smnum = 0, jsnum = 0;
        while (!mheap.isEmpty()) {
            Order o = mheap.poll();

            if(o.color.equals("B")) sm[smnum++] = number;
            else js[jsnum++] = number;

            number++;
        }

        System.out.println(smnum);
        for(int i = 0; i < smnum; i++)
            System.out.print(sm[i]+" ");
        System.out.println();
        System.out.println(jsnum);
        for(int i = 0; i < jsnum; i++)
            System.out.print(js[i]+" ");

        br.close();
    }
}
