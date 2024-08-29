import java.util.Scanner;

public class Solution {
	static int H, W, N, r, c ;
	static char[][] field ;
	static char[] command ;
	static char state;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T ; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			field = new char[H][W];
			
			r = 0;
			c = 0;
			state = ' ';
			for(int i=0 ; i<H ; i++) {
				field[i] = sc.next().toCharArray();
				for(int j=0 ; j<W ; j++) {
					if(field[i][j]=='<' || field[i][j]=='>' || field[i][j]=='^' || field[i][j]=='v') {
						r = i;
						c = j;
						state = field[i][j];
					}
				}
			}
			N = sc.nextInt();
			
			command = new char[N];
			command = sc.next().toCharArray();
			
			for(int i=0 ; i<N ; i++) {
				tankAct(command[i]);
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static void tankAct(char act) {
		if(act=='S') {
			if (state=='<') {
				for(int i=c-1 ; i>=0 ; i--) {
					if(field[r][i]=='#') break;
					else if(field[r][i]=='.' || field[r][i]=='-') continue;
					else if(field[r][i]=='*') {
						field[r][i] = '.';
						break;
					}
				}
			} else if (state=='>') {
				for(int i=c+1 ; i<W ; i++) {
					if(field[r][i]=='#') break;
					else if(field[r][i]=='.' || field[r][i]=='-') continue;
					else if(field[r][i]=='*') {
						field[r][i] = '.';
						break;
					}
				}
			} else if (state=='^') {
				for(int i=r-1 ; i>=0 ; i--) {
					if(field[i][c]=='#') break;
					else if(field[i][c]=='.' || field[i][c]=='-') continue;
					else if(field[i][c]=='*') {
						field[i][c] = '.';
						break;
					}
				}
			} else if (state=='v') {
				for(int i=r+1 ; i<H ; i++) {
					if(field[i][c]=='#') break;
					else if(field[i][c]=='.' || field[i][c]=='-') continue;
					else if(field[i][c]=='*') {
						field[i][c] = '.';
						break;
					}
				}
			}
		} else if(act=='U') {
			state = '^';
			if(r-1>=0 && field[r-1][c]=='.') {
				field[r--][c] = '.';
			}
			field[r][c] = state;
		} else if(act=='D') {
			state = 'v';
			if(r+1<H && field[r+1][c]=='.') {
				field[r++][c] = '.';
			}
			field[r][c] = state;
		} else if(act=='L') {
			state = '<';
			if(c-1>=0 && field[r][c-1]=='.') {
				field[r][c--] = '.';
			}
			field[r][c] = state;
		} else if(act=='R') {
			state = '>';
			if(c+1<W && field[r][c+1]=='.') {
				field[r][c++] = '.';
			}
			field[r][c] = state;
		}
	}
}
