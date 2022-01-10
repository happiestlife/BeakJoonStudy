package Else;

import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class P2800 {
    int openIndex;
    int closeIndex;
    public P2800(int openIndex, int closeIndex){
        this.openIndex = openIndex;
        this.closeIndex = closeIndex;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        // 괄호 위치 구하기
        Vector<P2800> parenthesesIndex = new Vector<>();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')')parenthesesIndex.add(new P2800(stack.pop(), i));
        }

        Queue<P2800> index = new LinkedList<>();
        Vector<Queue> deleteWay = new Vector<>();

        int deleteWayIndex = 2;
        for(int i = 0; i < parenthesesIndex.size(); i++){
            if(i == 0){
                for(int j = 0; j < deleteWay.size(); j++){
                    StringBuilder sb = new StringBuilder(input);
                    for(int k = 0; k < deleteWay.get(j).size(); k++) {
                        Queue<P2800> q = deleteWay.get(j);
                        int a = q.poll().openIndex;
                        int b = q.poll().closeIndex;
                        System.out.println(a+", "+b);
                        sb.deleteCharAt(a);
                        sb.deleteCharAt(b );
                    }
                    bw.write(String.valueOf(sb)+'\n');
                }
            }
        }

        bw.flush();
    }
}
/*


        int index = 2;
        for(int i = 0; i < parenthesesIndex.size(); i++){
            if(i == 0){
                for(int j = 0; j < deleteOrderWay.size(); j++){
                    StringBuilder sb = new StringBuilder(input);
                    for(int k = 0; k < deleteOrderWay.get(j).order.length; k++) {
                        sb.deleteCharAt(deleteOrderWay.get(j).order[k].openIndex);
                        sb.deleteCharAt(deleteOrderWay.get(j).order[k].closeIndex);
                    }
                    bw.write(String.valueOf(sb));
                }
            }
        }

        bw.flush();

else{
                for(int j = 0; j < deleteOrderWay.size()+1; j++){
                    if(j == 0){

                    }
                    StringBuilder sb = new StringBuilder(input);
                    for(int k = 0; k < deleteOrderWay.get(j).order.length; k++) {
                        sb.deleteCharAt(k);
                    }
                    bw.write(String.valueOf(sb));
                }
            }
 */
