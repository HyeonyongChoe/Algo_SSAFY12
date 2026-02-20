class Solution {
    public int solution(int[][] sizes) {

        int max_w = 0;
        int max_h = 0;
        for(int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            if(w<h) {
                int tmp = h;
                h = w;
                w = tmp;
            }
            if(max_h<h) max_h = h;
            if(max_w<w) max_w = w;
        }
        return max_w*max_h;
    }
}