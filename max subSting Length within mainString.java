import java.util.ArrayList;

public class TestAlibaba {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		String qyery = "aacaa";
		String text = "acaccbaaabb";

		String s1 = qyery;
		String s2 = text;

		System.out.println("s1 = " + s1);
		System.out.println("s1 = " + s1.substring(2, 4));
		System.out.println("s2 = " + s2);
		System.out.println("-----");

		// String s3 = null;
		for (int j = 0; j < s1.length() - 1; j++) {
			for (int i = s1.length() - 1; i > 1; i--) {

				String ss1 = s1.substring(j, i);
				// System.out.print("ss1 = " + ss1);

				if (s2.indexOf(ss1) != -1) {
					System.out.println("---find---");
					System.out.println("ss1 = " + ss1);
					// System.out.println("s1 of s2");
					System.out.println("matchLength = " + ss1.length());
					System.out.println("---findEnd---");
					System.out.println();
					result.add(ss1.length());
					break;
				}
			}
		}

		result.sort(null);
		System.out.println("max = " + result.get(result.size() - 1));
	}

}
