import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static int N, total, ans;
    static int[] arr;
    static int[][] room, stairInfo, people,state;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1 ; tc<=T ; tc++) {
            N = sc.nextInt();
             
            room = new int[N][N];
            stairInfo = new int[2][3];
            total = 1;
            int stairidx = 0;
            for(int i=0 ; i<N ; i++) {
                for(int j=0 ; j<N ; j++) {
                    room[i][j] = sc.nextInt();
                    if(room[i][j]==1) total++;
                    if(room[i][j]>1) {
                        stairInfo[stairidx][0] = i;
                        stairInfo[stairidx][1] = j;
                        stairInfo[stairidx][2] = room[i][j];
                        stairidx++;
                    }
                }
            }
             
            people = new int[total][2];
             
            total = 1;
             
            for(int i=0 ; i<N ; i++) {
                for(int j=0 ; j<N ; j++) {
                    if(room[i][j]==1) {
                        people[total][0] = Math.abs(stairInfo[0][0]-i) + Math.abs(stairInfo[0][1]-j);
                        people[total][1] = Math.abs(stairInfo[1][0]-i) + Math.abs(stairInfo[1][1]-j);
                        total++;
                    }
                }
            }
            state = new int[total][3];
             
            ans = 987654321;
            arr = new int[total];
             
            combi(1);
             
            System.out.println("#"+tc+" "+ans);
        }
    }
     
    static void combi(int idx) {
        if(idx>=total) {
            lunchTime();
            return;
        }
         
        arr[idx] = 1;
        combi(idx+1);
        arr[idx] = 2;
        combi(idx+1);
    }
     
    static void lunchTime() {
        for(int j=1 ; j<total ; j++) {
            if(arr[j]==1) {
                state[j][0] = people[j][0];
                state[j][1] = 1;
            } else {
                state[j][0] = people[j][1];
                state[j][1] = 2;
            }
             
        }
        int t=0;
        int arriveP = 0;
        int[] arr1 = new int[total];
        int[] arr2 = new int[total];
        int idx1 = 1;
        int idx2 = 1;
        int cnt1 = 1;
        int cnt2 = 1;
        while(true) {
            t++;
            boolean[] act = new boolean[total];
            for(int k=1 ; k<total ; k++) {
                if(state[k][1]>0) {
                    state[k][0]--;
                    act[k] = true;
                    if(state[k][0]==0) {
                        state[k][2] = stairInfo[state[k][1]-1][2]+1;
                        state[k][1] *= -1;
                        if(state[k][1]==-1) {
                            arr1[idx1++] = k;
                        } else if(state[k][1]==-2) {
                            arr2[idx2++] = k;
                        }
                    }
                } 
            }
            for(int k=cnt1 ; k<cnt1+3 ; k++) {
                if( k==idx1 || act[arr1[k]]) break;
                state[arr1[k]][2]--;
                if(state[arr1[k]][2]==0) {
                    state[arr1[k]][1] = 0;
                    arriveP++;
                    cnt1++;
                }
            }
            for(int k=cnt2 ; k<cnt2+3 ; k++) {
                if(k==idx2 || act[arr2[k]]) break;
                 
                state[arr2[k]][2]--;
                if(state[arr2[k]][2]==0) {
                    state[arr2[k]][1] = 0;
                    arriveP++;
                    cnt2++;
                }
            }
            if(arriveP==total-1) break;
        }
        if(ans>t) ans=t;
    }
}