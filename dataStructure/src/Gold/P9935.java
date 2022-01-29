// https://www.acmicpc.net/problem/9935

package Gold;

import java.io.*;
import java.util.*;

public class P9935 {
    public static class ArrChar{
        private char c;
        private int idx;

        public ArrChar(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
    public static void cal(PriorityQueue<ArrChar> rs, PriorityQueue<ArrChar> str, char b){
        while(!str.isEmpty() && str.peek().c < b) {
            rs.add(str.poll());
        }
        if(str.isEmpty()) return;

        while(b == str.peek().c) {
            str.poll();
            if (str.isEmpty()) return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        PriorityQueue<ArrChar> str = new PriorityQueue<>(new Comparator<ArrChar>() {
            @Override
            public int compare(ArrChar o1, ArrChar o2) {
                return o1.c - o2.c;
            }
        });
        for(int i = 0; i < input.length(); i++)
            str.add(new ArrChar(input.charAt(i), i));

        String boom = br.readLine();
        PriorityQueue<Character> hboom = new PriorityQueue<>();
        for(int i = 0; i < boom.length(); i++)
            hboom.add(boom.charAt(i));

        PriorityQueue<ArrChar> rs = new PriorityQueue<>(new Comparator<ArrChar>() {
            @Override
            public int compare(ArrChar o1, ArrChar o2) {
                return o1.idx - o2.idx;
            }
        });
        while(!hboom.isEmpty() && !str.isEmpty()){
            char b = hboom.poll();
            cal(rs, str, b);
        }

        while(!str.isEmpty())
            rs.add(str.poll());

        if(rs.isEmpty()) bw.write("FRULA");
        else {
            while(!rs.isEmpty())
                bw.write(rs.poll().c);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
