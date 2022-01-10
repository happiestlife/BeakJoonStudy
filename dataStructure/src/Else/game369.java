package Else;

import java.util.Scanner;
public class game369 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numSize = 5;
		int count, num;
		int cipherCount;
		int cipherTmp[] = new int[numSize];
		int cipher[] = new int[numSize];
		
		for(int i = 1; i < 100000; i++) {
			num = i;
			count = 0; cipherCount = 0;
			while(true) {
				cipherTmp[cipherCount++] = num%10;
				num = num/10;
				if(num == 0) break;
			}

			for(int j = 0; j < cipherCount; j++)
				cipher[j] = cipherTmp[cipherCount - 1 - j];
			
			for(int j = 0; j < cipherCount; j++) {
				if(i % 10 != 0 && cipher[j] % 3 == 0) count++;
			}

			if(count != 0) {
				System.out.print(i + " 박수 ");
				for(int j = 0; j < count; j++)
					System.out.print("짝");
				System.out.println();
			}
		}
	}
}
