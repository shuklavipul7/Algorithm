package stringrelated;

public class RemoveSpacesFromString {

	public static void main(String[] args) {
		String givenString = "This    string    contains      too many    random   spaces     ";
		boolean spaceAlreadyFound = false;
		StringBuilder result = new StringBuilder();
		int len = givenString.length();
		for (int i = 0; i < len; i++) {
			char c = givenString.charAt(i);
			if (c == ' ') {
				if (!spaceAlreadyFound) {
					result.append(c);
					spaceAlreadyFound = true;
				}
			}else{
				result.append(c);
				spaceAlreadyFound = false;
			}
		}
		System.out.println(result);
	}
}
