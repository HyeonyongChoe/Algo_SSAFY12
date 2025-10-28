import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        for(int i=0 ; i<speeds.length ; i++) {
            queue1.add(progresses[i]);
            queue2.add(speeds[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue1.isEmpty()) {
            for(int i=0 ; i<queue1.size() ; i++) {
                int p = queue1.poll();
                int s = queue2.poll();
                queue1.add(p+s);
                queue2.add(s);
            }
            int cnt = 0;
            while(!queue1.isEmpty()) {
                int p = queue1.peek();
                if(p>=100) {
                    cnt++;
                    queue1.poll();
                    queue2.poll();
                } else {
                    break;
                }
            }
            if(cnt!=0) ans.add(cnt);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0 ; i<ans.size() ; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}