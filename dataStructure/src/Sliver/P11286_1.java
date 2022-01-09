package Sliver;//https://www.acmicpc.net/problem/11286

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286_1 {
    public static void main(String args[]) throws IOException {
        int N, x;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> mheap = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer parent, Integer child) {
                int pdata = Math.abs(parent);
                int cdata = Math.abs(child);

                if (pdata < cdata) return -1;
                else if (pdata > cdata) return 1;
                else {
                    if(parent > child) return 1;
                    else if(parent == child) return 0;
                    else return -1;
                }
            }
        });


        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(br.readLine());
            if( x == 0 ) {
                if(mheap.peek() == null)
                    bw.write("0\n");
                else
                    bw.write(mheap.poll() + "\n");
            }
            else mheap.add(x);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
