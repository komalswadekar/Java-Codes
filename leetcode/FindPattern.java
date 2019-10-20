/*
 * Leetcode problem: 890 -  Find and replace pattern
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 *Output: ["mee","aqq"]
 *Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
 * Author: Komal Soham Wadekar
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class FindPattern {

	public List<String> findAndReplacePattern(String[] words, String pattern) {
        LinkedHashSet<String> patternSet = new LinkedHashSet<>();
        LinkedHashSet<String> wordSet;
        List<String> wordList = new ArrayList<String>();
        
        char patternArray[] = pattern.toCharArray();
        for(char c:patternArray){
        	patternSet.add(String.valueOf(c));
        	
        }
        System.out.println(patternSet.size());
       
        for(String word: words){
        	wordSet = new LinkedHashSet<>();
        	 String match = null;
        	char arr[] = word.toCharArray();
        	for(char c: arr){
        		wordSet.add(String.valueOf(c));
        	}
        	if(wordSet.size()==patternSet.size()){
        		match = replaceWord(word,pattern,patternSet,wordSet);
        	}
        	if(match!=null)
        		wordList.add(match);
        }
		return wordList;
    }
	
	private String replaceWord(String word, String pattern, LinkedHashSet<String> patternSet, LinkedHashSet<String> wordSet){
		String match = null;
		HashMap<String, String> map = new HashMap<>();
		Iterator<String> wordItr = wordSet.iterator();
		for(String temp : patternSet){
			map.put(temp, wordItr.next());
		}
		String newWord="";
		for(char temp : pattern.toCharArray()){
			newWord = newWord + map.get(String.valueOf(temp));
		}
		if(newWord.equals(word))
			return newWord;
		
		return match;
	}
	
	public static void main(String[] args) {

		String words[] = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		FindPattern p = new FindPattern();
		List<String> wordList = p.findAndReplacePattern(words, pattern);
		System.out.println(wordList.toString());

	}

}
