import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int tmp = 0;
        int t = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]) {
                    if(o1[1]==o2[1]) return o1[0]-o2[0];
                    return o1[1]-o2[1];
                }
                return o1[2] - o2[2];
            }
        });
        
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    if(o1[2]==o2[2]) return o1[0]-o2[0];
                    return o1[2]-o2[2];
                }
                return o1[1] - o2[1];
            }
        });
        for(int i=0 ; i<jobs.length ; i++) {
            pq2.add(new int[] {i,jobs[i][0],jobs[i][1]});
        }
        pq.add(pq2.poll());
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(t<now[1]) t=now[1];
            t += now[2];
            tmp += t - now[1];
            if(pq.isEmpty() && !pq2.isEmpty() && pq2.peek()[1]>t) {
                t=pq2.peek()[1];
                pq.add(pq2.poll());
            }
            
            while(!pq2.isEmpty() && pq2.peek()[1]<=t) {
                pq.add(pq2.poll());
            }
        }
        answer = tmp / jobs.length;
        return answer;
    }
}