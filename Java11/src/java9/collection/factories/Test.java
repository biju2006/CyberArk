package java9.collection.factories;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		List<String> wordsList = List.of("a","b","c","d","a");
		Set<String> wordsSet = Set.of("a","b","c","d");
		Map<Integer,String> wordsMap = Map.of(1,"a",2,"b",3,"c",4,"d",5,"a");
		
		System.out.println(wordsList);
		System.out.println(wordsSet);
		System.out.println(wordsMap);
		
	}
}
