package app_java_streamapi;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierFunctionalIInterface {

	public static void main(String[] args) {
		System.out.println(new Random());
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt(100));
        System.out.println(new Random().nextInt(500));
        System.out.println(new Random().nextDouble());
        System.out.println(new Random().nextDouble(100));
        System.out.println(new Random().nextDouble(500));

        Supplier<Integer> sup1 = () -> new Random().nextInt(100);
        // Integer ans1 = sup1.get();
        // System.out.println(ans1);
        System.out.println(sup1.get());

        Supplier<Double> sup2 = () -> new Random().nextDouble(100);
        System.out.println(sup2.get());
	}
}
