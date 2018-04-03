package edu.westga.cs1302.wordGame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	private String alphabet;
	private String sixLetter;
	private List<String> validWords;
	private List<String> allValidWords;
	
	public WordGame() {
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.validWords = new ArrayList<String>();
	}
	public String setRandomLetter() {
		this.sixLetter = "";
		Random rand = new Random();
		for (int index = 0; index <= 5; index++) {
			this.sixLetter += this.alphabet.charAt(rand.nextInt(26));
			this.sixLetter += " ";
		}
		return this.sixLetter;
	}
	
	public boolean validWord(String word) {

		if (word.isEmpty() || word == null) {
			return false;
		}
		File file = new File("dictionary.txt");
		try (Scanner in = new Scanner(file)) {
			while(in.hasNextLine()) {
				String currentWord = in.nextLine();
				if (this.checkContainedWord(currentWord)) {
					return false;
				}
				if (currentWord.length() <= 6 && currentWord.length() >= 3) {
					if (currentWord.equals(word.toLowerCase())) {
						if (this.checkSixLetterContainsInWord(word)) {
							this.validWords.add(currentWord);
							return true;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	public String allValidWords() {
		this.allValidWords = new ArrayList<String>();
		String output = "";
		File file = new File("dictionary.txt");
		try (Scanner in = new Scanner(file)) {
			while (in.hasNextLine()) {
				String currentWord = in.nextLine();
				if (currentWord.length() <= 6 && currentWord.length() >= 3) {
					if (this.checkSixLetterContainsInWord(currentWord)) {
						this.allValidWords.add(currentWord);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		Collections.sort(this.allValidWords);
		Collections.sort(this.allValidWords, new WordsComparator());
		for (String current : this.allValidWords) {
			int count = 0;
			String underScore = "";
			for (String valid : this.validWords) {
				if (current.equals(valid)) {
					count++;
				}
			}
			if (count == 0) {
	 			underScore = current.replaceAll("[a-zA-Z]", "_");
				output += underScore + System.lineSeparator();
			} else {

				output += current + System.lineSeparator();
			}
		}
		
		return output;
	}
	
	private boolean checkSixLetterContainsInWord(String word) {
		if (this.sixLetter.isEmpty() || this.sixLetter == null) {
			return false;
		}
		for (int index = 0; index < word.length(); index++) {
			String alpha = "";
			alpha += word.charAt(index);
			if (!this.sixLetter.trim().toLowerCase().contains(alpha)) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean checkContainedWord(String word) {
		for (String current : this.validWords) {
			if (word.toLowerCase().equals(current.toLowerCase())) {
				return true;
			}
		} return false;
	}

}
