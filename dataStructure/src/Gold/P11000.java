package Gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11000 {
    private static class Lecture{
        private int start;
        private int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lecture = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.start == o2.start) return o1.end - o2.end;

                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            lecture.add(new Lecture(start, end));
        }

        int maxRoom = 0, curRoom = 0;
        PriorityQueue<Integer> ongoing = new PriorityQueue<>();
        while (!lecture.isEmpty()) {
            while(!ongoing.isEmpty() && lecture.peek().start >= ongoing.peek()){
                ongoing.poll();
                curRoom--;
            }

            Lecture p = lecture.poll();

            curRoom++;
            ongoing.add(p.end);

            maxRoom = maxRoom > curRoom ? maxRoom : curRoom;
        }

        System.out.println(maxRoom);

        br.close();
    }
}
