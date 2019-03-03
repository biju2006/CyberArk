package java9.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		//iterate
		Stream<Integer> nums=Stream.iterate(1, n -> n<=10, n -> n+1);
		
		//takeWhile
		List<Integer> low =nums.takeWhile(n -> n<=5).collect(Collectors.toList());
		
		nums=Stream.iterate(1, n -> n<=10, n -> n+1);
		//dropWhile
		List<Integer> high=nums.dropWhile(n -> n<=5).collect(Collectors.toList());
		
		System.out.println(low);
		System.out.println(high);
		
	}

}
