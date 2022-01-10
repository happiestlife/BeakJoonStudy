package Else;//https://www.acmicpc.net/problem/22942

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22942 {
    int start;
    int end;
    public P22942(int center, int radius){
        this.start = center - radius;
        this.end = center + radius;
    }
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int circleNum = Integer.parseInt(br.readLine());
        P22942 circlesData[] = new P22942[circleNum];
        int endPoint = 0;
        for(int i = 0; i < circleNum; i++){
            stk = new StringTokenizer(br.readLine());
            int center = Integer.parseInt(stk.nextToken());
            int radius = Integer.parseInt(stk.nextToken());
            circlesData[i] = new P22942(center, radius);
            if(endPoint < center+radius)
                endPoint = center + radius;
        }

        int makePositive = 1000000;
        int maxRadius = 20000;
        int condition = makePositive + maxRadius;
        boolean isSuccess = true;
        int parenthesisCheck = 0;
        char circles[] = new char[endPoint+condition];
        for(int i = 0; i < circleNum; i++){
            circles[circlesData[i].start - 1 + condition] = '(';
            circles[circlesData[i].end - 1 + condition] = ')';

            for(int j = circlesData[i].start  + condition; j < circlesData[i].end-1  + condition; j++)
                if (circles[j] == '(' || circles[j] == ')')
                    parenthesisCheck++;

            if(parenthesisCheck % 2 == 1){
                System.out.println("NO");
                isSuccess = false;
                break;
            }
            parenthesisCheck = 0;
        }
        if(isSuccess)
            System.out.println("YES");

        br.close();
    }
}
