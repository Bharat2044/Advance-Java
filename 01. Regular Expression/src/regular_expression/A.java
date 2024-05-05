package regular_expression;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.regex.*;

public class A {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[abc]");
		Matcher m = p.matcher("a6b#@z9DcYfX7");
		
		while(m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}
	}

}
