import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, ans;
	static int[] arr;
	static int[][] map, copiedMap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		arr = new int[5];
		ans = 0;
		
		permu(0);
		
		System.out.println(ans);
 	}
	
	static void permu(int idx) {
		
		if(idx == 5) {
			copiedMap = new int[N][N];
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					copiedMap[i][j] = map[i][j];
				}
			}
			
			for(int i=0 ; i<5 ; i++) {
				swipe(arr[i]);
			}
			
			int res = 0;
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(copiedMap[i][j]>res) res = copiedMap[i][j];
				}
			}
			if(ans<res) ans = res;
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			arr[idx] = i;
			permu(idx+1);
		}
	}
	
	static void swipe(int d) {
		if(d==0) {
			for(int c=0 ; c<N ; c++) {
				Stack<int[]> tmp = new Stack<>();
				for(int r=0 ; r<N ; r++) {
					if(copiedMap[r][c]==0) continue;
					if(tmp.isEmpty()) {
						tmp.add(new int[] {copiedMap[r][c],0});
					} else {
						if(tmp.peek()[1]==1) {
							tmp.add(new int[] {copiedMap[r][c],0});
						} else {
							if(tmp.peek()[0]==copiedMap[r][c]) {
								copiedMap[r][c] *= 2;
								tmp.pop();
								tmp.add(new int[] {copiedMap[r][c],1});
							} else {
								tmp.add(new int[] {copiedMap[r][c],0});
							}
						}
					}
					copiedMap[r][c] = 0;
				}
				
				int l = tmp.size();
				for(int r=l-1 ; r>=0 ; r--) {
					copiedMap[r][c] = tmp.pop()[0];
				}
			}
		} else if(d==1) {
			for(int r=0 ; r<N ; r++) {
				Stack<int[]> tmp = new Stack<>();
				for(int c=N-1 ; c>=0 ; c--) {
					if(copiedMap[r][c]==0) continue;
					if(tmp.isEmpty()) {
						tmp.add(new int[] {copiedMap[r][c],0});
					} else {
						if(tmp.peek()[1]==1) {
							tmp.add(new int[] {copiedMap[r][c],0});
						} else {
							if(tmp.peek()[0]==copiedMap[r][c]) {
								copiedMap[r][c] *= 2;
								tmp.pop();
								tmp.add(new int[] {copiedMap[r][c],1});
							} else {
								tmp.add(new int[] {copiedMap[r][c],0});
							}
						}
					}
					copiedMap[r][c] = 0;
				}
				
				int l = tmp.size();
				for(int c=N-l ; c<N ; c++) {
					copiedMap[r][c] = tmp.pop()[0];
				}
			}
		} else if(d==2) {
			for(int c=0 ; c<N ; c++) {
				Stack<int[]> tmp = new Stack<>();
				for(int r=N-1 ; r>=0 ; r--) {
					if(copiedMap[r][c]==0) continue;
					if(tmp.isEmpty()) {
						tmp.add(new int[] {copiedMap[r][c],0});
					} else {
						if(tmp.peek()[1]==1) {
							tmp.add(new int[] {copiedMap[r][c],0});
						} else {
							if(tmp.peek()[0]==copiedMap[r][c]) {
								copiedMap[r][c] *= 2;
								tmp.pop();
								tmp.add(new int[] {copiedMap[r][c],1});
							} else {
								tmp.add(new int[] {copiedMap[r][c],0});
							}
						}
					}
					copiedMap[r][c] = 0;
				}
				
				int l = tmp.size();
				for(int r=N-l ; r<N ; r++) {
					copiedMap[r][c] = tmp.pop()[0];
				}
			}
		} else if(d==3) {
			for(int r=0 ; r<N ; r++) {
				Stack<int[]> tmp = new Stack<>();
				for(int c=0 ; c<N ; c++) {
					if(copiedMap[r][c]==0) continue;
					if(tmp.isEmpty()) {
						tmp.add(new int[] {copiedMap[r][c],0});
					} else {
						if(tmp.peek()[1]==1) {
							tmp.add(new int[] {copiedMap[r][c],0});
						} else {
							if(tmp.peek()[0]==copiedMap[r][c]) {
								copiedMap[r][c] *= 2;
								tmp.pop();
								tmp.add(new int[] {copiedMap[r][c],1});
							} else {
								tmp.add(new int[] {copiedMap[r][c],0});
							}
						}
					}
					copiedMap[r][c] = 0;
				}
				
				int l = tmp.size();
				for(int c=l-1 ; c>=0 ; c--) {
					copiedMap[r][c] = tmp.pop()[0];
				}
			}
		}
	}
}
