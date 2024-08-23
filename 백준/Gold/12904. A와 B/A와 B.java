import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String T = sc.next();
		
		int chk = 0;
		while(S.length()<T.length()) {
			if (T.charAt(T.length()-1)=='A') {
				chk = 0;
			} else {
				chk = 1;
			}
			if(chk==0) {
				String tmp = "";
				for(int i=0 ; i<T.length()-1 ; i++) {
					tmp = tmp+T.charAt(i);
				}
				T = tmp;
			} else {
				String tmp = "";
				for(int i=T.length()-2 ; i>=0 ; i--) {
					tmp = tmp+T.charAt(i);
				}
				T = tmp;
			}
		}
		if(S.equals(T)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}
