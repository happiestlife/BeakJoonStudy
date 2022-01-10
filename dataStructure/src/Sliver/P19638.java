//https://www.acmicpc.net/problem/19638

package Sliver;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class P19638 {
    public static void main(String args[]) throws IOException {
        int N, height, T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        height = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        PriorityQueue<Integer> mheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++)
            mheap.add(Integer.parseInt(br.readLine()));

        int count = 0;
        for(int i = 0; i < T; i++){
            int data = mheap.poll();

            if( data >= height) count++;
            if( data > 1 ) data /= 2;

            mheap.add(data);
        }

        if(mheap.peek() < height)
            System.out.println("YES\n" + count);
        else
            System.out.println("NO\n" + mheap.peek());

        br.close();
        bw.close();
    }
}
