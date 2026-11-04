import java.util.*;

class Solution {
    int cnt, answer;
    
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        return answer;
    }
    
    void dfs(StringBuilder sb, String word) {
        if(sb.toString().equals(word)) {
            answer = cnt;
            return;
        }
        if(sb.length()>=5) return;
        
        for(char c : "AEIOU".toCharArray()) {
            sb.append(c);
            cnt++;
            dfs(sb,word);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}