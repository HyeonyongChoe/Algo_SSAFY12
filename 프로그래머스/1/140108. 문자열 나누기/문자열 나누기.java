class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            int tmp = 1;
            i++;
            while(i<s.length() && tmp!=0) {
                if(s.charAt(i)==c) {
                    tmp++;
                    i++;
                }
                else {
                    tmp--;
                    i++;
                }
                if(tmp==0) i--;
            }
            answer++;
        }
        return answer;
    }
}