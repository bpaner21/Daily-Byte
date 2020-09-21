package dailyByte14;

import java.util.ArrayList;

/*
 * This question is asked by Amazon. 
 * Given two strings representing sentences, 
 * return the words that are not common to both strings 
 * (i.e. the words that only appear in one of the sentences). 
 * 
 * You may assume that each sentence is a sequence of words (without punctuation) correctly separated using space characters.
 * 
 * Ex: given the following strings...
 * 
 * sentence1 = "the quick", sentence2 = "brown fox", return ["the", "quick", "brown", "fox"]
 * sentence1 = "the tortoise beat the haire", sentence2 = "the tortoise lost to the haire", return ["beat", "to", "lost"]
 * sentence1 = "copper coffee pot", sentence2 = "hot coffee pot", return ["copper", "hot"]
 * 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UncommonWords {

	public static void main(String[] args) {
		
		UWDriver("the quick", "brown fox");
		UWDriver("the tortoise beat the haire", "the tortoise lost to the haire");
		UWDriver("copper coffee pot", "hot coffee pot");
		
		System.out.println();
		
		UWDriver("this apple is sweet", "this apple is sour");
		UWDriver("apple apple", "banana");
		
		return;
	}
	
	public static void UWDriver(String s1, String s2) {
		
		String[] uncommon = UW(s1, s2);
		
		System.out.println("sentence1 = \"" + s1 + "\", sentence2 = \"" + s2 + "\": " + Arrays.toString(uncommon));
		
		return;
	}
	
	private static String[] UW(String s1, String s2) {
		
		HashMap<String, Integer> uMap = new HashMap<String, Integer>();
		ArrayList<String> uList = new ArrayList<String>();
		
		// Count the occurrence of each word in both strings
		for (String s : (s1 + " " + s2).split(" ")) { 
			
			uMap.merge(s, 1, Integer::sum);
		}
		
		// Only return every word that occurs once
		for (Map.Entry<String, Integer> entry : uMap.entrySet()) {
			
			if (entry.getValue() == 1) { uList.add(entry.getKey()); }
			
		}
		
		return uList.toArray(new String[0]);
	}
}
