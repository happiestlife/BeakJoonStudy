package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P13549 {
    public static class Loc{
        private int location;
        private int time;

        public Loc(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        final int MAX = 100000;
        boolean isVisited[] = new boolean[MAX+1];

        Queue<Loc> manner = new LinkedList<>();
        manner.add(new Loc(N, 0));
        isVisited[N] = true;
        while (!manner.isEmpty() && manner.peek().location != K) {
            Loc loc = manner.poll();
            isVisited[loc.location] = true;

            if(loc.location * 2 <= MAX && isVisited[loc.location * 2] == false)
                manner.add(new Loc(loc.location * 2, loc.time));
            if(0 <= loc.location - 1 && isVisited[loc.location - 1] == false)
                manner.add(new Loc(loc.location - 1, loc.time + 1));
            if(loc.location + 1 <= MAX && isVisited[loc.location + 1] == false)
                manner.add(new Loc(loc.location + 1, loc.time + 1));
        }

        System.out.println(manner.peek().time);
        br.close();
    }
}
