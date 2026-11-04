import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int t=0 ; t<commands.length ; t++) {
            int i = commands[t][0]-1;
            int j = commands[t][1];
            int k = commands[t][2]-1;
            int[] arr = Arrays.copyOfRange(array,i,j);
            Arrays.sort(arr);
            answer[t] = arr[k];
        }
        return answer;
    }
}