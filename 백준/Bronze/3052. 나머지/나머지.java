import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] visited = new boolean[42];
		for(int i=0 ; i<10 ; i++) {
			int a = sc.nextInt();
			visited[a%42] = true;
		}
		
		int cnt = 0;
		for(int i=0 ; i<42 ; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt);
	}
}
