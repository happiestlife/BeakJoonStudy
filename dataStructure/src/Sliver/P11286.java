package Sliver;//https://www.acmicpc.net/problem/11286

import java.io.*;

public class P11286 {
    private static class mheap{
        private final int MAX = 100001;
        private int data[];
        private int count;

        private mheap(){
            data = new int[MAX];
            count = 0;
        }

        private void swap(int ind1, int ind2){
            int tmp = data[ind1];
            data[ind1] = data[ind2];
            data[ind2] = tmp;
        }

        private boolean compare(int pind, int cind){
            int pdata = Math.abs(data[pind]);
            int cdata = Math.abs(data[cind]);

            if( pdata < cdata ) return false;
            else if(pdata > cdata) swap(pind, cind);
            else{
                if(data[pind] > data[cind]) swap(pind, cind);
            }
            return true;
        }

        private void add(int x){
            data[++count] = x;
            if(count == 1) return;

            int i = count;
            while(true){
                if(compare(i/2, i) == false) break;
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
                    compare(i, i*2);
                    break;
                }else{
                    int smallpind;
                    if(Math.abs(data[i*2]) == Math.abs(data[i*2 + 1]))
                        smallpind = data[i*2] > data[i*2 + 1] ? i*2 + 1 : i*2;
                    else
                        smallpind = Math.abs(data[i*2]) > Math.abs(data[i*2 + 1]) ?
                                i*2 + 1 : i*2;

                    compare(i, smallpind);
                    i = smallpind;
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
