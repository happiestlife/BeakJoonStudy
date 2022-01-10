package Sliver;

import java.util.*;
import java.io.*;

public class t {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> al = new ArrayList<>(); //오름차순으로 정렬하기 위해서

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
        String str = ""; //원래 수열
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            String unit = st.nextToken();
            al.add(unit);
            str += unit;
        }

        //////////////////////////////////////////입력 끝

        Collections.sort(al, (o1, o2) ->{
            return o1.compareTo(o2);
        }); //오름차순

        String answer = "";

        for(String str2 : al) {
            answer += str2;
        }

        System.out.println(bfs(str, answer));
    }

    static int bfs(String str, String answer){
        Queue<SortingGame> q = new ArrayDeque<>();
        Set<String> visit = new HashSet<>(); //중복을 피하기 위해서 사용
        q.offer(new SortingGame(str, 0));

        while (!q.isEmpty()) {
            SortingGame sg = q.poll();
            String result = sg.str;
            int count = sg.count;

            if(result.equals(answer))
                return count;

            if(!visit.contains(result)){
                visit.add(result);
                for(int i = 0; i <= N - K; i++){
                    String mid = usingSb(result.substring(i, K + i));
                    String head_tail = result.substring(0, i) + mid + result.substring(i + K, result.length());
                    q.offer(new SortingGame(head_tail, count + 1));
                }
            }
        }
        return -1;
    }
    //sb를 사용하는 이유는 reverse라는 메소드를 사용하기 위해,,
    static String usingSb(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}

class SortingGame{
    String str;
    int count;

    public SortingGame(String str, int count) {
        this.str = str;
        this.count = count;
    }
}