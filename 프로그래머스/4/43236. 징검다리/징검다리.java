import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int answer = 0;
        while(left<=right) {
            int mid = (left+right)/2;
            int cnt = 0;
            int now = 0;
            for(int i=0 ; i<rocks.length ; i++) {
                if(rocks[i]-now<mid) cnt++;
                else now=rocks[i];
            }
            if(distance-now<mid) cnt++;
            
            if(cnt<=n) {
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
                System.out.println(mid);
            }
        }
        return answer;
    }
}