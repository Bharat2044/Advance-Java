package app_java_streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {
	public static void main(String[] args) {
		//Consumer<Integer> result10 = num -> System.out.println(num);
        Consumer<Integer> con1 = System.out::println;
        con1.accept(100);

        // Consumer<String> con2 = str -> System.out.println(str);
        Consumer<String> con2 = System.out::println;
        con2.accept("Hello");

        // forEach
        List<String> names = Arrays.asList("mike", "adam", "sam");
        // Consumer<String> val = name -> System.out.print(name + "  ");
        // names.forEach(val);
        names.forEach(name -> System.out.print(name + "  "));
        System.out.println();
	}
}
