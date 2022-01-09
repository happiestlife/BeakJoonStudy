package Sliver;//https://www.acmicpc.net/problem/1927

import java.io.*;

public class P1927 {
    private static class mheap{
        private final int MAX = 100001;
        private int data[];
        private int count;

        private mheap(){
            data = new int[MAX];
            for(int i = 0; i < MAX; i++)
                data[i] = -1;
            count = 0;
        }

        private void add(int x){
            data[++count] = x;
            int i = count;
            while(data[i/2] > data[i]){
                int tmp = data[i/2];
                data[i/2] = data[i];
                data[i] = tmp;
                i /= 2;
            }
        }

        private int pop(){
            if( count == 0) return 0;

            int result = data[1];
            data[1] = data[count--];
            int i = 1;
            while(i * 2 <= count){
                if(count == i * 2){
                    if(data[i] > data[i*2]){
                        int tmp = data[i];
                        data[i] = data[i*2];
                        data[i*2] = tmp;
                    }
                    break;
                }else{
                    int smallind = data[i*2] > data[i*2 + 1] ? i*2 + 1 : i*2;
                        if(data[i] > data[smallind]) {
                            int tmp = data[i];
                            data[i] = data[smallind];
                            data[smallind] = tmp;
                        }
                        i = smallind;
                }
            }
            return result;
        }
    }
    public static void main(String args[]) throws IOException {
        int N, x;
        mheap heap = new mheap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(br.readLine());
            if( x == 0 ) bw.write(heap.pop() + "\n");
            else heap.add(x);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
