package Sliver;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17225 {
    private static class Order{
        private String color;
        private int makeT;

        public Order(String color, int makeT) {
            this.color = color;
            this.makeT = makeT;
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

        PriorityQueue<Order> mheap = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if( o1.makeT > o2.makeT ) return 1;
                else if(o1.makeT  < o2.makeT ) return -1;
                else {
                    if(o1.color.equals("B")){
                        if(o2.color.equals("B"))
                            return 0;
                        else return -1;
                    }else{
                        if(o2.color.equals("B"))
                            return 1;
                        else return 0;
                    }
                }
            }
        });


       for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");;

            orderTime = Integer.parseInt(input[0]);
            color = input[1];
            num = Integer.parseInt(input[2]);

            int makeT = (color.equals("B") ? A : B);
            for(int j = 0; j < num; j++){
                mheap.add(new Order(color, orderTime + j * makeT));
            }
        }

        String sm = "";
        String js = "";
        int number = 1, smnum = 0, jsnum = 0;
        while (!mheap.isEmpty()) {
            Order o = mheap.poll();
            if(o.color.equals("B")){
                sm += number + " ";
                smnum++;
            }
            else{
                js += number + " ";
                jsnum++;
            }
            number++;
        }

        System.out.println(smnum);
        System.out.println(sm);
        System.out.println(jsnum);
        System.out.println(js);

        br.close();
    }
}
