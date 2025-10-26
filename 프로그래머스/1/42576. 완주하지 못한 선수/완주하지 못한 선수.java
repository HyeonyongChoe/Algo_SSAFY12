import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String parti : participant) {
            if(!map.containsKey(parti)) {
                map.put(parti,1);
            } else {
                map.replace(parti,map.get(parti)+1);
            }
        }
        
        for(String compl : completion) {
            map.replace(compl, map.get(compl)-1);
            if(map.get(compl)==0) {
                map.remove(compl);
            }
        }
        for(String answer : map.keySet()) {
            return answer;
        }
        String answer = "";
        return answer;
    }
}