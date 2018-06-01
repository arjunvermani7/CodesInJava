package recursion2;

import java.util.Scanner;

public class LexicoLarger {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);

		String str = pop.nextLine();

		boolean IsitLarge = false;

		LexicographicalLarger(str, "", IsitLarge);

	}

	public static void LexicographicalLarger(String str, String ans, boolean IsitLarge) {
		if (str.length() == 0 ) {
			   if(IsitLarge) {
				System.out.println(ans);
			   }
			return;
		}
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			char ch1 = str.charAt(0);

			String ros = str.substring(0, i) + str.substring(i + 1);
			if (str.length() > 1 && !IsitLarge) {
				if (ch > ch1) {
					//LexicographicalLarger(ros, ans + ch, true);
				} else if (ch < ch1) {
					LexicographicalLarger(ros, ans + ch, true);
				} else {
					LexicographicalLarger(ros, ans + ch, false);
				}
			} else {
				LexicographicalLarger(ros, ans+ch, IsitLarge);
			}
		}
	}
}
