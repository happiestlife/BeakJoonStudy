package Sliver;//https://www.acmicpc.net/problem/4358

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class P4358 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashmap = new HashMap<>();

        int count = 0;
        while(true){
            String name = br.readLine();
            if(name == null || name.equals("")) break;

            if(hashmap.containsKey(name)){
                hashmap.put(name, hashmap.get(name)+1);
            }else
                hashmap.put(name, 1);
            count++;
        }

        Set<String> keys = hashmap.keySet();
        String keyarr[] = keys.toArray(new String[keys.size()]);
        Arrays.sort(keyarr);

        for(int i = 0; i < keyarr.length; i++){
            System.out.printf("%s %.4f \n", keyarr[i], hashmap.get(keyarr[i])/(double)count * 100);
        }

        br.close();
        bw.close();
    }
}
