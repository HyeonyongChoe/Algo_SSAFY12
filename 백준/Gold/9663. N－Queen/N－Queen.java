import java.util.Scanner;

public class Main {
	static int[][] visited;
    static int N, ans;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
         
        N = sc.nextInt();
        visited = new int[N][N];
         
        ans = 0;
        permu(0);
        System.out.println(ans);
    }
     
    static void permu(int idx) {
        if(idx>=N) {
            ans++;
            return;
        }
         
        for(int i=0 ; i<N ; i++) {
            if(visited[idx][i]>0) continue;
            checkcell(idx,i,true);
            permu(idx+1);
            checkcell(idx,i,false);             
        }
    }
     
    static void checkcell(int r, int c, boolean t) {
        if(t) {
            for(int i=r+1 ; i<N ; i++) {
                visited[i][c]++;
            }
            for(int i=0 ; i<N ; i++) {
                visited[r][i] = visited[r][i] + 1;
            }
            for(int i=r+1 ; i<N ; i++) {
                if(r+c-i>=0) visited[i][r+c-i]++;
                if(c+i-r<N) visited[i][c+i-r]++;
            }
             
        } else {
            for(int i=r+1 ; i<N ; i++) {
                visited[i][c]--;
            }
            for(int i=0 ; i<N ; i++) {
                visited[r][i]--;
            }
            for(int i=r+1 ; i<N ; i++) {
                if(r+c-i>=0) visited[i][r+c-i]--;
                if(c+i-r<N) visited[i][c+i-r]--;
            }
        }
    }
}
