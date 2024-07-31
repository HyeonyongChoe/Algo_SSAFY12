import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1 ; tc<=T ; tc++) {
			int tCase = sc.nextInt();
			int[][] arr = new int[100][100];
			int max = -1;
			
			for(int i=0 ; i<100 ; i++) {
				int tmp = 0;
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = sc.nextInt();
					tmp += arr[i][j];
				}
				if(tmp > max) max = tmp;
			}
			int tmp2 = 0;
			int tmp3 = 0;
			
			for(int j=0 ; j<100 ; j++) {
				int tmp = 0;
				for(int i=0 ; i<100 ; i++) {
					tmp += arr[i][j];
					if (i==j) tmp2+=arr[i][j];
					if (i+j==99) tmp3+=arr[i][j];
				}
				if(tmp > max) max = tmp;
			}
			if(tmp2>max) max=tmp2;
			if(tmp3>max) max=tmp3;
			
			System.out.println("#"+tCase+" "+max);
		}
	}
}
