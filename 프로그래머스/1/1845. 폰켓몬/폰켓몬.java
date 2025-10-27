import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.replace(num, map.get(num)+1);
            }
        }
        if(answer>map.size()) answer = map.size();
        
        return answer;
    }
}