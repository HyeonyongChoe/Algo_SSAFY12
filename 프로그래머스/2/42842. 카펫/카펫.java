class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        
        for(int i=2 ; i<brown/2 ; i++) {
            int h = i-2;
            int w = brown/2 - i;
            if(w*h==yellow) {
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }
        return answer;
    }
}