package Gold;

import java.io.*;
import java.util.*;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String inst = br.readLine();

            int n = Integer.parseInt(br.readLine());
            boolean forward = true;
            Deque<String> arr = new ArrayDeque<>();
            String data = br.readLine();
            data = data.substring(1, data.length()-1);
            StringTokenizer stk = new StringTokenizer(data, ",");
            for(int j = 0; j < n; j++)
                arr.add(stk.nextToken());

            boolean isFail = false;
            for(int j = 0; j < inst.length(); j++) {
                char cmd = inst.charAt(j);
                if (cmd == 'R'){
                    if(forward) forward = false;
                    else forward = true;
                }
                else{
                    if(arr.isEmpty()){
                        isFail = true;
                        break;
                    }
                    if(forward) arr.poll();
                    else arr.pollLast();
                }
            }

            if(isFail) bw.write("error\n");
            else{
                bw.write("[");
                while(!arr.isEmpty()){
                   if(forward)bw.write(arr.pollFirst());
                   else bw.write(arr.pollLast());
                   if(arr.isEmpty()) break;
                    bw.write(",");
                };
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
