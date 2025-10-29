import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = times[0];
        long right = (long)n*times[times.length-1];
        long answer = 0;
        while(left<=right) {
            long mid = (left+right)/2;
            long sum = 0;
            for(int i=0 ; i<times.length ; i++) {
                sum += mid/times[i];
            }
            if(sum>=n) {
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}