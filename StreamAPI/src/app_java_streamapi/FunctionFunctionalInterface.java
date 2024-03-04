package app_java_streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionFunctionalInterface {
	public static void main(String[] args) {
		Function<String, Integer> stringLength = str -> str.length();
        Integer result1 = stringLength.apply("mike");
        System.out.println(result1);

        Function<Integer, Integer> addingTen = i -> i + 10;
        Integer result2 = addingTen.apply(40);
        System.out.println(result2);

        List<Integer> data = Arrays.asList(10, 30, 20, 10, 25, 80, 70, 25);
        // adding 10 to each value
        List<Integer> result3 = data.stream().map(i -> i + 10).collect(Collectors.toList());
        System.out.println(result3);

        // sort the data
        List<Integer> result4 = data.stream().sorted().collect(Collectors.toList());
        System.out.println(result4);

        // remove duplicates
        List<Integer> result5 = data.stream().distinct().collect(Collectors.toList());
        System.out.println(result5);

        List<String> names = Arrays.asList("mike",  "stalin", "adam");
        // converting each names to uppercaes
        // List<String> result8 = names2.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        List<String> result6 = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result6);

        // sort the data
        List<String> result7 = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result7);
	}
}
