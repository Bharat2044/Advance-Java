package regular_expression;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.regex.*;

public class Match10DigitNumbers {

	public static void main(String[] args) {
		// Pattern p = Pattern.compile("[0-9]{3}");
		Pattern p = Pattern.compile("[0-9]{10}");
		Matcher m = p.matcher("6283107777");
		
		while(m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}
	}
}
