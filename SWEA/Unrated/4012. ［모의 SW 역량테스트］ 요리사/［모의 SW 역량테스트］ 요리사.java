import java.util.Scanner;
 
public class Solution {
    static int N, ans;
    static int[] chk;
    static int[][] synergy;
     
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1 ; tc<=T ; tc++) {
            N = sc.nextInt();
             
            synergy = new int[N][N];
            for(int i=0 ; i<N ; i++) {
                for(int j=0 ; j<N ; j++) {
                    synergy[i][j] = sc.nextInt();
                }
            }
            chk = new int[N];
            ans = 1000000;
            powerset(0,0);
            System.out.println("#"+tc+" "+ans);
        }
    }
     
    static void powerset(int idx, int sidx) {
        if(idx>=N && sidx<N/2) return;
         
        if(sidx==N/2) {
            int tmp1 = 0;
            int tmp2 = 0;
            for(int i=0 ; i<N ; i++) {
                if(chk[i]==1) {
                    for(int j=0 ; j<N ; j++) {
                        if(chk[j]==1) {
                            tmp1 += synergy[i][j];
                        }
                    }
                } else {
                    for(int j=0 ; j<N ; j++) {
                        if(chk[j]==0) {
                            tmp2 += synergy[i][j];
                        }
                    }
                }
            }
            if(ans>Math.abs(tmp1-tmp2)) ans = Math.abs(tmp1-tmp2); 
            return;
        }
        chk[idx] = 1;
        powerset(idx+1,sidx+1);
        chk[idx] = 0;
        powerset(idx+1,sidx);
    }
}