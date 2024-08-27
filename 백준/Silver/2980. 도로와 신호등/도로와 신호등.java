import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int[][] trafficLight = new int[N][3];
		
		for(int i=0 ; i<N ; i++) {
			trafficLight[i][0] = sc.nextInt();
			trafficLight[i][1] = sc.nextInt();
			trafficLight[i][2] = sc.nextInt();
		}
		
		int d = 0;
		int t = 0;
		int idx = 0;
		while(d<=L) {
			t++;
			if(idx>=N) {
				d++;
			} else if( d<trafficLight[idx][0]) {
				d++;
			} else if(t%(trafficLight[idx][1]+trafficLight[idx][2])<trafficLight[idx][1]) {
				continue;
			} else {
				d++;
				idx++;
			}
		}
		
		System.out.println(t);
	}
}
