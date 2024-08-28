import java.util.Scanner;

public class Solution {
    // 퀵 정렬
	static int[] arr = new int[1000000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0 ; i<1000000 ; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(0,999999);
		System.out.println(arr[500000]);
	}
	
	static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = lomutoPartition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	static int lomutoPartition(int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		
		for(int j=left ; j<=right-1 ; j++) {
			if(arr[j]<=pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		
		return i+1;
	}
}
