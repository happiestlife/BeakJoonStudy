//https://www.acmicpc.net/problem/20923

package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P20923 {
    private static Deque<Integer> dodo;
    private static Deque<Integer> su;

    public static int win(int doData, int suData){
        if(doData == 5 || suData == 5) return 0;
        else if(doData + suData == 5) return 1;
        else return -1;
    }

    public static boolean cal(int whoWin, Queue<Integer> doG, Queue<Integer> suG) {
        if(whoWin == 0){
            while(!suG.isEmpty()){
                dodo.add(suG.poll());
            }
            while (!doG.isEmpty()) {
                dodo.add(doG.poll());
            }
            return true;
        } else if (whoWin == 1) {
            while(!doG.isEmpty()){
                su.add(doG.poll());
            }
            while (!suG.isEmpty()) {
                su.add(suG.poll());
            }
            return true;
        }
        return false;
    }
    public static void main(String args[]) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dodo = new LinkedList<>();
        su = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            dodo.addFirst(Integer.parseInt(input[0]));
            su.addFirst(Integer.parseInt(input[1]));
        }

        Queue<Integer> doGround = new LinkedList<>();
        Queue<Integer> suGround = new LinkedList<>();
        int ddata = 0, sdata = 0;
        for(int i = 0; i < M; i++){
            // 게임 진행
            if (i % 2 == 0) {
                ddata = dodo.pollFirst();
                doGround.add(ddata);
            }
            else{
                sdata = su.pollFirst();
                suGround.add(sdata);
            }
            if(dodo.isEmpty() || su.isEmpty()) break;

            if(cal(win(ddata, sdata), doGround, suGround)){
                ddata = 0;
                sdata = 0;
            }
        }

        if(dodo.size() > su.size())
            System.out.println("do");
        else if(dodo.size() < su.size())
            System.out.println("su");
        else
            System.out.println("dosu");
        br.close();
    }
}
