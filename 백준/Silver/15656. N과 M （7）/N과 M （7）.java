import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[]  arr1, arr2;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr1 = new int[N];
		
		s = br.readLine();
		st = new StringTokenizer(s);
		for(int i=0 ; i<N ; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		arr2 = new int[M];
		Arrays.sort(arr1);
		permu(0);
		System.out.println(sb);
	}
	
	static void permu(int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				sb.append(arr2[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int[] visited2 = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			if(visited2[i]>0) continue;
			
			arr2[sidx] = arr1[i];
			for(int j=i ; j<N ; j++) {
				if(arr1[j]==arr1[i]) {
					visited2[j]++;
				}
			}
			permu(sidx+1);
		}
	}
}

