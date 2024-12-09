import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = sc.nextInt();
			
			LinkedList<String> code = new LinkedList<>();
			
			for(int i=0 ; i<N ; i++) {
				code.add(sc.next());
			}
			
			int M = sc.nextInt();
			
			for(int i=0 ; i<M ; i++) {
				String command = sc.next();
				
				if(command.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for(int j=x ; j<x+y ; j++) {
						code.add(j,sc.next());
					}
				} else if(command.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for(int j=0 ; j<y ; j++) {
						code.remove(x);
					}
				} else {
					int y = sc.nextInt();
					for(int j=0 ; j<y ; j++) {
						code.add(sc.next());
					}
				}		
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<10 ; i++) {
				System.out.print(code.get(i)+" ");
			}
			System.out.println();
		}
	}
}
