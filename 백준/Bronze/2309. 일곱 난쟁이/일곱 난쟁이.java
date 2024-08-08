import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dwarf = new int[9];
		
		int total = 0;
		for(int i=0 ; i<9 ; i++) {
			dwarf[i] = sc.nextInt();
			total += dwarf[i];
		}
		Arrays.sort(dwarf);
		check :
		for(int i=0 ; i<9 ; i++) {
			for(int j=i+1 ; j<9 ; j++) {
				if(total-dwarf[i]-dwarf[j]==100) {
					dwarf[i] = -1;
					dwarf[j] = -1;
					break check;
				}
			}
		}
		for(int i=0 ; i<9 ; i++) {
			if(dwarf[i]!=-1) System.out.println(dwarf[i]);
		}
	}
}
