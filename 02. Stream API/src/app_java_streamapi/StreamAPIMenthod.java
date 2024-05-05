package app_java_streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIMenthod {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 2, 6, 2, 5, 7, 2);
		
		// forEach() -> printing all numbers
		numbers.stream().forEach(num -> System.out.print(num + "  "));
		System.out.println();
		
		// collect() -> collect all numbers into another List
		List<Integer> collectedNumbers = numbers.stream().collect(Collectors.toList());
        System.out.println(collectedNumbers);
		
		// filter() -> printing only even numbers
		List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
		
		// map() -> printing square of numbers
		List<Integer> squareOfNumbers = numbers.stream().map(num -> num * num).collect(Collectors.toList());
		System.out.println(squareOfNumbers);
		
		// filter() and map() -> printing only even number squares
		List<Integer> evenNumbersSquare = numbers.stream().filter(num -> num % 2 == 0).map(num -> num * num).collect(Collectors.toList());
		System.out.println(evenNumbersSquare);
		
		// reduce() -> using reduce to find the sum of numbers
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
		
        // sort() -> sort the numbers
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);
        
        // distinct() -> printing distinct or unique numbers
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);
        
        
        // anyMatch(), allMatch() and noneMatch()
        List<String> fruits = Arrays.asList("apple", "banana", "orange");
        boolean anyMatch = fruits.stream().anyMatch(fruit -> fruit.startsWith("b"));
        boolean allMatch = fruits.stream().allMatch(fruit -> fruit.startsWith("b"));
        boolean noneMatch = fruits.stream().noneMatch(fruit -> fruit.startsWith("b"));
		
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);
	}
}
