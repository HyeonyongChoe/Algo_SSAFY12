import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			String[] word = sc.next().split("");
			String[] num = new String[4*N/4];
			
			for(int i=0 ; i<N ; i++) {
				String[] tmp = new String[N/4];
				for(int j=0 ; j<N/4; j++) {
					tmp[j] = word[(i+j)%N];
				}
				String a = String.join("", tmp);
				num[i] = a;
			}
			Arrays.sort(num);
			
			String tmp = "";
			int cnt = 0;
			for(int i=0 ; i<4*N/4 ; i++) {
				if(!num[4*N/4-1-i].equals(tmp)) {
					tmp = num[4*N/4-1-i];
					cnt++;
				}
				if(cnt==K) break;
			}
			
			int ans = 0;
			for(int i=0 ; i<tmp.length() ; i++) {
				if('0' <= tmp.charAt(i) && tmp.charAt(i) <='9') {
					ans = ans*16 + tmp.charAt(i)-'0';					
				} else {
					ans = ans*16 + tmp.charAt(i)-'A'+10;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
