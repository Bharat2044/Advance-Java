package app_java_streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunctionalInterface {
	public static void main(String[] args) {
		// It checks numbers is even or not
        Predicate<Integer> pr1 = x -> (x % 2 == 0);
        boolean result1 = pr1.test(10);
        System.out.println(result1);

        // returns true if str value is mike
        Predicate<String> pr2 = str -> str.equals("mike");
        boolean result2 = pr2.test("stalin");
        System.out.println(result2);

        // printing only even number from List
        List<Integer> numbers = Arrays.asList(10, 20, 15, 45, 46, 16);

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0 ).collect(Collectors.toList());
        System.out.println(evenNumbers);

        numbers.forEach((ele) -> {
            if(pr1.test(ele)) {
                System.out.print(ele + "  ");
            }
        });
        System.out.println();

        List<String> names = Arrays.asList("mike", "adam", "moon", "meena", "stalin", "john", "mike");
        // printing only names starts with letters m
        List<String> data1 = names.stream().filter(s -> s.startsWith("m")).collect(Collectors.toList());
        System.out.println(data1);

        // printing only names ends with letters n
        List<String> data2 = names.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
        System.out.println(data2);

        // printing only names that are equals to mike
        List<String> data3 = names.stream().filter(s -> s.equals("mike")).collect(Collectors.toList());
        System.out.println(data3);
	}
}
