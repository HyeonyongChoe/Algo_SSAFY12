import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map, melt;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        melt = new int[N][M];
        
        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<M ; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        int cnt = 1;
        while(cnt==1) {
            for(int r=0 ; r<N ; r++) {
                for(int c=0 ; c<M ; c++) {
                    if(map[r][c]!=0) {
                        melt[r][c] = 0;
                        for(int d=0 ; d<4 ; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if(map[nr][nc]==0) melt[r][c]++;
                        }
                    }
                }
            }
            
            for(int r=0 ; r<N ; r++) {
            	for(int c=0 ; c<M ; c++) {
            		if(melt[r][c]!=0) {
            			map[r][c] -= melt[r][c];
            			if(map[r][c]<0) map[r][c] = 0;
            		}
            	}
            }
            cnt = 0;
            visited = new boolean[N][M];
            for(int r=0 ; r<N ; r++) {
            	for(int c=0 ; c<M ; c++) {
            		if(map[r][c]!=0 && !visited[r][c]) {
            			cnt++;
            			dfs(r,c);
            		}
            	}
            }
            ans++;
            if(cnt==0) {
            	ans = 0;
            	break;
            }
        }
        
        System.out.println(ans);
    }


	static void dfs(int r, int c) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
	}
}
