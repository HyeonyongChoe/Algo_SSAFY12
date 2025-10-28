import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, ArrayList<Integer>> genre_map = new HashMap<>();
        HashMap<String, Integer> genre_score = new HashMap<>();
        
        for(int i=0 ; i<genres.length ; i++) {
            if(!genre_score.containsKey(genres[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                genre_map.put(genres[i],list);
                genre_score.put(genres[i],plays[i]);
            } else {
                ArrayList<Integer> list = genre_map.get(genres[i]);
                list.add(i);
                genre_map.replace(genres[i],list);
                genre_score.replace(genres[i],genre_score.get(genres[i])+plays[i]);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        String[] genre_list = new String[genre_map.size()];
        
        int idx = 0;
        for(String genre : genre_map.keySet()) {
            pq.add(new int[] {idx, genre_score.get(genre)});
            genre_list[idx] = genre;
            idx++;
        }
        
        ArrayList<Integer> answer_list = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            int[] target = pq.poll();
            String genre = genre_list[target[0]];
            PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            for(int i : genre_map.get(genre)) {
                pq2.add(new int[] {i,plays[i]});
            }
            int cnt = 0;
            while(!pq2.isEmpty()) {
                answer_list.add(pq2.poll()[0]);
                cnt++;
                if(cnt==2) break;
            }
        }
        int[] answer = new int[answer_list.size()];
        for(int i=0 ; i<answer_list.size() ; i++) {
            answer[i] = answer_list.get(i);
        }
        
        return answer;
    }
}