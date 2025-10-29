import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] node = new ArrayList[n+1];
        for(int i=0 ; i<n+1; i++) {
            node[i] = new ArrayList<>();
        }
        for(int[] e : edge) {
            node[e[0]].add(e[1]);
            node[e[1]].add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(1);
        visited[1] = true;
        int answer = 1;
        while(!queue.isEmpty()) {
            answer = queue.size();
            
            for(int i=0 ; i<answer ; i++) {
                int now = queue.poll();
                for(int nxt : node[now]) {
                    if(!visited[nxt]) {
                        queue.add(nxt);
                        visited[nxt] = true;
                    }
                }
                
            }
        }
        return answer;
    }
}