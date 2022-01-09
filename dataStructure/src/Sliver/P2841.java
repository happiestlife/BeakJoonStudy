package Sliver;//https://www.acmicpc.net/problem/2841

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2841 {
    public static void main(String args[]) throws IOException {
        int N, P;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> mheap[] = new PriorityQueue[7];
        for(int i = 1; i < 7; i++){
            mheap[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        P = Integer.parseInt(stk.nextToken());

        int melody, fret, count = 0;
        String input[];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            melody = Integer.parseInt(input[0]);
            fret = Integer.parseInt(input[1]);

            if(mheap[melody].isEmpty()) {
                count++;
                mheap[melody].add(fret);
                continue;
            }
            else if(mheap[melody].peek() == fret) continue;
            else if(mheap[melody].peek() > fret) {
                while(!mheap[melody].isEmpty() && mheap[melody].peek() > fret){
                    mheap[melody].poll();
                    count++;
                }
                if(!mheap[melody].isEmpty() && mheap[melody].peek() == fret) continue;
            }
            count++;
            mheap[melody].add(fret);
        }

        System.out.println(count);
    }
}
