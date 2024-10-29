import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Integer> dp = new ArrayList<>();
		
		int[][] wires = new int[N][2];
		
		for(int i=0 ; i<N ; i++) {
			wires[i][0] = sc.nextInt(); 
			wires[i][1] = sc.nextInt(); 
		}
		
		Arrays.sort(wires, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		dp.add(wires[0][1]);
		
		for(int i=1 ; i<N ; i++) {
			int l = dp.size();
			
			if(dp.get(l-1)<wires[i][1]) {
				dp.add(wires[i][1]);
			} else {
				while(l>0 && dp.get(l-1)>wires[i][1]) {
					l--;
				}
				dp.set(l, wires[i][1]);
			}
			
		}
		
		System.out.println(N-dp.size());
	} 
}
