package regular_expression;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.regex.*;

public class MatchBothUpperAndLowerCaseAplhabets {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher("a6b#@z9Dcd7efX");
		
		while(m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}
	}
}
