import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i=0 ; i<answers.length ; i++) {
            if(p1[i%5]==answers[i]) score1++;
            if(p2[i%8]==answers[i]) score2++;
            if(p3[i%10]==answers[i]) score3++;
        }
        int score_max = 0;
        if(score1>score_max) score_max = score1;
        if(score2>score_max) score_max = score2;
        if(score3>score_max) score_max = score3;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        if(score1==score_max) arr.add(1);
        if(score2==score_max) arr.add(2);
        if(score3==score_max) arr.add(3);
        
        int[] answer = new int[arr.size()];
        for(int i=0 ; i<arr.size() ; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}