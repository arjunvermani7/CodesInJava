package recursion2;

import java.util.Scanner;

public class split {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);

		int n = pop.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = pop.nextInt();
		}

		int ans = splitArray1(arr, 0, 0, 0, "", "");
		System.out.println(ans);
		 splitArray(arr,0,0,0,"","");

	}

	public static void splitArray(int[] arr, int s1, int s2, int vidx, String asf1, String asf2) {
		if (vidx == arr.length) {
			if (s1 == s2) {
				System.out.println(asf1 + "and" + " " + asf2);
			}
			return;
		}
		splitArray(arr, s1 + arr[vidx], s2, vidx + 1, asf1 + arr[vidx] + " ", asf2);
		splitArray(arr, s1, s2 + arr[vidx], vidx + 1, asf1, asf2 + arr[vidx] + " ");
	}

	public static int splitArray1(int[] arr, int s1, int s2, int vidx, String asf1, String asf2) {
		if (vidx == arr.length) {
			if (s1 == s2) {
				
                 return 1;
			}
            return 0;
		}
        int res=0;
		res+=splitArray1(arr, s1 + arr[vidx], s2, vidx + 1, asf1 + arr[vidx] + " ", asf2);
		res+=splitArray1(arr, s1, s2 + arr[vidx], vidx + 1, asf1, asf2 + arr[vidx] + " ");
      return res;
	}
}
