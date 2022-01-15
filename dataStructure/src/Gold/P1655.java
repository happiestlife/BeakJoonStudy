//https://www.acmicpc.net/problem/1655
// 우선순위 큐를 사용하여 전체를 오름차순으로 나열한다고 정의했을 때
// 왼쪽 반개는 max 힙, 오른쪽에는 min 힙 위치
// 답은 반드시 max 힙에서 출력하도록 적절히 2개의 힙에 데이터 입력

package Gold;

import java.io.*;
import java.util.*;

public class P1655 {
    public static void main(String args[]) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int d = Integer.parseInt(br.readLine());
            if(maxh.size() == minh.size()){
                if(!minh.isEmpty() && minh.peek() < d) {
                    maxh.add(minh.poll());
                    minh.add(d);
                }
                else maxh.add(d);
            }else{
                if(!maxh.isEmpty() && maxh.peek() > d) {
                    minh.add(maxh.poll());
                    maxh.add(d);
                }
                else minh.add(d);
            }

            bw.write(maxh.peek()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
