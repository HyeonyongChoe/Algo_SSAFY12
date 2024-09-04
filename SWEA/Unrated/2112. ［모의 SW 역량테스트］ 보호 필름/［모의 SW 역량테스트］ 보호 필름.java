import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K, ans;
	static int[][] film, newfilm;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			film = new int[D][W];
			
			for(int i=0 ; i<D ; i++) {
				for(int j=0 ; j<W ; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			
			ans = 987654321;
			arr = new int[D];
			newfilm = new int[D][W];
			for(int n=0 ; n<=K ; n++) {
				permu(0,0,n);
				if(ans!=987654321) break;
			}
			if(ans==987654321) ans = K;
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	static void permu(int sidx, int idx, int N) {
		
		if(sidx>=N) {
			int cnt = 0;
//			System.out.println(Arrays.toString(arr));
			for(int i=0 ; i<D ; i++) {
				if(arr[i]!=0) cnt++;
				for(int j=0 ; j<W ; j++) {
					if(arr[i]==0) {
						newfilm[i][j] = film[i][j];
					} else if (arr[i] == 1) {
						newfilm[i][j] = 1;
					} else {
						newfilm[i][j] = 0;
					}
				}
			}
			if(filmChk()) {
				if(ans>cnt) ans = cnt;
			}
			return;
		}
		if(idx>=D) return;
		
		for(int i=0 ; i<3 ; i++) {
			arr[idx] = i;
			if(i!=0) permu(sidx+1,idx+1,N);
			else permu(sidx,idx+1,N);
			arr[idx] = 0;
		}
	}
	
	
	static boolean filmChk() {
		for(int j=0 ; j<W ; j++) {
			int a = 0;
			int b = 0;
			
			boolean aflag = false;
			boolean bflag = false;
			int last = newfilm[0][j];
			if(last==0) a++;
			else b++;
			for(int i=1 ; i<D ; i++) {
				if(newfilm[i][j]!=last) {
					last = 1-last;
					a = 0;
					b = 0;
					if(last==0) {
						a++;
					} else {
						b++;
					}
				} else {
					if(last==0) {
						a++;
					} else {
						b++;
					}
				}
				if(a==K) {
					aflag = true;
					break;
				}
				if(b==K) {
					bflag = true;
					break;
				}
			}
			if(!aflag && !bflag) return false;
		}
		return true;
	}
}
