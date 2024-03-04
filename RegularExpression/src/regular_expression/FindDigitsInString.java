package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDigitsInString {
	public static void main(String[] args) {

		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher("a6b @#9 D E!");
		
		while(m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}
	}
}
