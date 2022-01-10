package Else;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2696 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int M = Integer.parseInt(br.readLine());
            bw.write((M/2+1)+"\n");

            int arr[] = new int[M];
            String nums = br.readLine();
            for(int j = 0; j < M/10; j++)
                nums += " " + br.readLine();

            StringTokenizer stk = new StringTokenizer(nums);
            for(int j = 0; stk.hasMoreTokens(); j++) {
                arr[j] = Integer.parseInt(stk.nextToken());

                if((j+1) % 2 == 1){
                    Arrays.sort(arr,0, j+1);
                    bw.write(arr[j/2]+" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
//23 41 13 22 -3 24 -31 -11 -8 -7 3 5 103 211 -311 -45 -67 -73 -81 -99 -33 24 56
