package lesson170828;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapsExamples {
	
	public static void main(String[] args) {
		
		ConcurrentMap<String, Integer> words = new ConcurrentHashMap<>();
		
		update(words, "one");
		
	}

	public static void update(Map<String, Integer> words, String word) {
		words.put(word, 1);
		
		Integer count = words.get(word);
		
		Integer newValue = count == null? 1 : count + 1;
		
		words.put(word, newValue);
	}

}
