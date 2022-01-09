package Sliver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p13335 {
    private static class Bridge{
        private int sum;
        private int length;
        private int maxWeight;
        private Queue<Integer> outTime = new LinkedList<>();
        private Queue<Integer> onTruck = new LinkedList<>();

        public Bridge(int length, int maxWeight){
            sum = 0;
            this.length = length;
            this.maxWeight = maxWeight;
        }

        boolean isTruckOnBridge(){
            return onTruck.size() != 0;
        }

        void process(int time){
            if(!outTime.isEmpty() && outTime.peek() == time){
                sum -= onTruck.peek();
                outTime.poll();
                onTruck.poll();
            }
        }

        boolean add(int truck, int time){
            process(time);
            if(sum+truck > maxWeight) return false;
            else{
                sum += truck;
                onTruck.add(truck);
                outTime.add(time+length);
                return true;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        int n, w, L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        w = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int truck[] = new int[n];
        for(int i = 0; i < n; i++)
            truck[i] = Integer.parseInt(stk.nextToken());

        Bridge bridge = new Bridge(w, L);
        int time = 0, truckidx = 0;
        while(true){
            if(truckidx == n) bridge.process(time);
            else { if (bridge.add(truck[truckidx], time)) truckidx++; }

            time++;

            if(truckidx >= n && !bridge.isTruckOnBridge()) break;
        }
        System.out.println(time);

        br.close();
        bw.close();
    }
}
