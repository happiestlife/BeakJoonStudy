// https://www.acmicpc.net/problem/1715

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            heap.add(Integer.parseInt(br.readLine()));

        int result = 0;
        while (heap.size() > 1) {
            int comp = heap.poll() + heap.poll();
            result += comp;
            heap.add(comp);
        }
        System.out.println(result);
        br.close();
    }
}
