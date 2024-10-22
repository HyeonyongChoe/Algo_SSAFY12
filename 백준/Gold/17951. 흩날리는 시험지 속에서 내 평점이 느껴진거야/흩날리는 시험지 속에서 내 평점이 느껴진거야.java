import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] paper = new int[N];
        int start = 21;
        int end = 0;
        
        for (int i = 0; i < N; i++) {
            paper[i] = sc.nextInt();
            end += paper[i];
            start = Math.min(start, paper[i]);
        }
        
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int tmp = 0;
            
            for (int i = 0; i < N; i++) {
                tmp += paper[i];
                if (tmp >= mid) {
                    cnt++;
                    tmp = 0; // 다음 묶음을 위해 초기화
                }
            }
            
            if (cnt < K) {
                end = mid - 1;
            } else {
                ans = mid; // 현재 mid가 가능한 경우
                start = mid + 1; // 더 큰 mid를 찾기 위해
            }
        }
        
        System.out.println(ans); // 최종 답안 출력
    }
}
