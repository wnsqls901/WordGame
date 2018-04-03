package edu.westga.cs1302.wordGame.model;

import java.util.Comparator;

public class WordsComparator implements Comparator<String>{

	@Override
	public int compare(String word1, String word2) {
		if (word1.length() > word2.length()) {
			return 1;
		} else if (word1.length() < word2.length()) {
			return -1;
		}
		return 0;
	}

}
