// https://www.acmicpc.net/problem/1202

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1202 {
    private static class Jewel{
        private int weight;
        private int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        ArrayList<Jewel> jewels = new ArrayList<>();

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);

            jewels.add(new Jewel(weight, price));
        }
        jewels.sort(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.weight - o2.weight;
            }
        });

        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for(int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        long result = 0;
        PriorityQueue<Jewel> maxPrice = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o2.price - o1.price;
            }
        });

        int idx = 0;
        while (!jewels.isEmpty() && !bag.isEmpty()) {
            for(int i = idx; i < jewels.size(); i++){
                Jewel j = jewels.get(i);
                if(bag.peek() < j.weight) break;
                maxPrice.add(j);
                idx++;
            }

            if(maxPrice.isEmpty()){
                bag.poll();
                continue;
            }

            Jewel j = maxPrice.poll();
            //System.out.println(j.price);
            result += j.price;
            bag.poll();
        }

        System.out.println(result);
        br.close();
    }
}
