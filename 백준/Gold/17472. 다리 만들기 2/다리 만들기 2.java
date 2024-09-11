import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N, M, cnt, ans;
	static int[] parent;
	static int[][] map, bridge, tree;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	static boolean[] visited2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N][M];
		
		cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;
					cnt++;
					map[i][j] = cnt;
					dfs(i,j, cnt);
				}
			}
		}
		
		bridge = new int[cnt+1][cnt+1];
		
		for(int i=0 ; i<=cnt ; i++) {
			Arrays.fill(bridge[i], 987654321);
		}
		
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<M ; c++) {
				
				if(map[r][c]!=0) {
					for(int d=0 ; d<4 ; d++) {
						int start = map[r][c];
						int end = 0;
						int dis = 0;
						
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
							dis++;
							while(map[nr][nc]==0) {
								nr += dr[d];
								nc += dc[d];
								if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==map[r][c]) {
									break;
								} else if(map[nr][nc]==0) {
									dis++;
								} else if(map[nr][nc]!=0) {
									end = map[nr][nc];
									if(bridge[start][end]>dis && dis>1) {
										bridge[start][end] = dis;							
									}
									break;
								}
							}
						}
					}
				}
			}	
		}
		int tmp = 0;
		tree = new int[cnt*cnt][3];
		
		for(int i=0 ; i<cnt*cnt ; i++) {
			tree[i][2] = 987654321;
		}
		
		for(int r=1 ; r<=cnt ; r++) {
			for(int c=1 ; c<=cnt ; c++) {
				if(bridge[r][c]!=987654321) {
					tree[tmp][0] = r;
					tree[tmp][1] = c;
					tree[tmp][2] = bridge[r][c];
					tmp++;
				}
			}
		}
		
		Arrays.sort(tree, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
		
		visited2 = new boolean[cnt+1];
		int vCnt = 0;
		
		parent = new int[cnt+1];
        
        for(int i=0 ; i<=cnt ; i++) {
            parent[i] = i;
        }
        ans = 0;
         
        for(int i=0 ; i<tmp ; i++) {
            int px = findSet(tree[i][0]);
            int py = findSet(tree[i][1]);
             
            if(px != py) {
                union(px, py);
                ans += tree[i][2];
                visited2[tree[i][0]] = true;
                visited2[tree[i][1]] = true;
                vCnt++;
            }
             
            if(vCnt == cnt-1) break;
        }
		if(vCnt<cnt-1) ans = -1;
        if(ans==0) ans = -1;   
        for(int i=1 ; i<=cnt ; i++) {
        	if(!visited2[i]) {
        		ans = -1;
        		break;
        	}
        }
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int n) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || visited[nr][nc]) {
				continue;
			}
			visited[nr][nc] = true;
			map[nr][nc] = n;
			dfs(nr, nc, n);
		}
	}
	
	static int findSet(int x) {
        
        if(x != parent[x]) parent[x] = findSet(parent[x]);
        return parent[x];
    }
     
    static void union(int px, int py) {
        parent[py] = px;
    }
}
