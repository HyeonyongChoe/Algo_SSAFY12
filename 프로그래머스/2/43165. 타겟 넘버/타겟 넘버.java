class Solution {
    int tmp, answer;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,target);
        return answer;
    }
    
    void dfs(int now, int[] numbers, int target) {
        if(now==numbers.length && tmp==target) {
            answer++;
            return;
        } 
        if(now>=numbers.length) return;
        
        tmp += numbers[now];
        dfs(now+1,numbers,target);
        tmp -= 2*numbers[now];
        dfs(now+1,numbers,target);
        tmp += numbers[now];
        return;
    }
}