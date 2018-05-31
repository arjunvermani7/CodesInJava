import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);
		int n = pop.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = pop.nextInt();
		}
		BubbleSort(arr, 0, arr.length - 1);
		for(int val:arr) {
			System.out.println(val);
		}

	}

	public static void BubbleSort(int[] arr, int si, int ei) {
		if (ei == 0) {
			return;
		}
		if (si == ei) {
			BubbleSort(arr, 0, ei - 1);
			return;
		}
		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		BubbleSort(arr, si + 1, ei);
	}
}
