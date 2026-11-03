import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = 101;
        for(int i=0 ; i<wires.length ; i++) {
            ArrayList<Integer>[] tree = new ArrayList[n+1];
            for(int j=0 ; j<=n ; j++) {
                tree[j] = new ArrayList<>();
            }
            
            for(int j=0 ; j<wires.length ; j++) {
                if(j==i) continue;
                tree[wires[j][0]].add(wires[j][1]);
                tree[wires[j][1]].add(wires[j][0]);
            }
            int[] visited = new int[n+1];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            while(!queue.isEmpty()) {
                int now = queue.poll();
                if(visited[now]==0) {
                    visited[now]++;
                    count++;
                }
                for(int nxt : tree[now]) {
                    if(visited[nxt]==0) queue.add(nxt);
                }
            }
            
            int count2 = n-count;
            if(min>Math.abs(count2-count)) min = Math.abs(count2-count);
            if(min==0) break;
        }
        
        return min;
    }
}