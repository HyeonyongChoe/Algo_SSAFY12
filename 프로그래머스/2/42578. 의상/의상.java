import java.util.*;

class Solution {    
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] tmp : clothes) {
            if(!map.containsKey(tmp[1])) {
                map.put(tmp[1],1);
            } else {
                map.replace(tmp[1],map.get(tmp[1])+1);
            }
        }
        
        for(String tmp : map.keySet()) {
            answer = answer*(map.get(tmp)+1);
        }
        
        answer--;
        
        return answer;
    }
}
