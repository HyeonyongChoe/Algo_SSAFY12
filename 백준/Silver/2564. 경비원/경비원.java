import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int N = sc.nextInt();
		int[][] store = new int[N][2];
		
		for(int i=0 ; i<N ; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		int posLine = sc.nextInt();
		int posDis = sc.nextInt();
		
		int ans = 0;
		for(int i=0 ; i<N ; i++) {
			if(store[i][0]==posLine) {
				ans += Math.abs(store[i][1]-posDis);
			} else if((store[i][0]+posLine)%4==3) {
				if((store[i][0]+posLine)/4==1) {
					ans += W+Math.min(store[i][1]+posDis,2*H-(store[i][1]+posDis) );
				} else {
					ans += H+Math.min(store[i][1]+posDis,2*W-(store[i][1]+posDis) );
				}
			} else {
				if(posLine==1) {
					if(store[i][0]==3) {
						ans += posDis+store[i][1];
					} else {
						ans += W-posDis+store[i][1];
					}
				} else if(posLine==2) {
					if(store[i][0]==3) {
						ans += posDis+H-store[i][1];
					} else {
						ans += W-posDis+H-store[i][1];
					}
				} else if(posLine==3) {
					if(store[i][0]==1) {
						ans += posDis+store[i][1];
					} else {
						ans += H-posDis+store[i][1];
					}
				} else if(posLine==4) {
					if(store[i][0]==1) {
						ans += posDis+W-store[i][1];
					} else {
						ans += H-posDis+W-store[i][1];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
