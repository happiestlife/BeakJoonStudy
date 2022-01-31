// https://www.acmicpc.net/problem/7662

package Gold;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P7662 {
    public static void delete(PriorityQueue<Integer> p, Map<Integer, Integer> map){
        while(!p.isEmpty() && !map.containsKey(p.peek())){
            p.poll();
        }
        int x = p.poll();
        if(map.get(x) == 0) map.remove(x);
        else map.put(x, map.get(x)-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                String input[] = br.readLine().split(" ");
                if(input[0].equals("I")){
                    int data = Integer.parseInt(input[1]);
                    max.add(data);
                    min.add(data);
                    if(map.containsKey(data))
                        map.put(data, map.get(data)+1);
                    else
                        map.put(data, 0);
                } else{
                    if(map.isEmpty()){
                        continue;
                    }

                    if(input[1].equals("-1")) delete(min, map);
                    else delete(max, map);
                }
            }

            while(!map.isEmpty() && !map.containsKey(max.peek())){
                max.poll();
            }
            while(!map.isEmpty() && !map.containsKey(min.peek())){
                min.poll();
            }

            if(map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(max.peek() +" "+ min.peek()+"\n");

            map.clear();
            max.clear();
            min.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
