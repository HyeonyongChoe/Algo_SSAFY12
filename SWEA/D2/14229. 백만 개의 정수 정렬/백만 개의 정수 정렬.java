import java.util.Scanner;

public class Solution {
    // 병합 정렬
	static int[] arr = new int[1000000];
	static int[] sortedArr = new int[1000000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0 ; i<1000000 ; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0,999999);
		System.out.println(arr[500000]);
	}
	
	static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(left,mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left,int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L<=mid && R<=right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}
		
		if(L <= mid) {
			for(int i=L ; i<=mid ; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int i=R ; i<=right ; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		
		for(int i=left ; i<=right ; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
