package com.practice.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TrieTestMain {
	
	public static List<String> findPalindromes(String[] wordList){
		List<String> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < wordList.length; i++)
			map.put(wordList[i], i);
		for(int i = 0; i < wordList.length; i++){
			for(int j = 0; j < wordList[i].length(); j++){
				String prefix = wordList[i].substring(0, j);
				String suffix = wordList[i].substring(j);
				if(isPalindrome(prefix)){
					String reverseSuffix = new StringBuffer(suffix).reverse().toString();
					if(map.containsKey(reverseSuffix) && map.get(reverseSuffix) != i){
						result.add(reverseSuffix + wordList[i]); 
					}
				}
				if(isPalindrome(suffix)){
					String reversePrefix = new StringBuffer(prefix).reverse().toString();
					if(map.containsKey(reversePrefix) && map.get(reversePrefix) != i){
						result.add(wordList[i] + reversePrefix);
					}
				}
			}
		}
		return result;
	}
		
	private static boolean isPalindrome(String str){
		if(str == null || str.length() < 2) return false;
		int left = 0;
		int right = str.length() - 1;
		while(left < right)
			if(str.charAt(left++) != str.charAt(right--)) return false;
		return true;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		scan.nextInt();
		String[] list = {"abbadc","cd","malaya","lam","hell","eh"};
		List<String> result = findPalindromes(list);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
