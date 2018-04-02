package edu.westga.cs1302.wordGame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	private String alphabet;
	private String sixLetter;
	private List<String> validWords;
	
	public WordGame() {
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.validWords = new ArrayList<String>();
	}
	public String setRandomLetter() {
		this.sixLetter = "";
		Random rand = new Random();
		for (int i = 0; i <= 5; i++) {
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
				if (in.nextLine().equals(word.toLowerCase())) {
					return this.checkSixLetterContainsInWord(word);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	private boolean checkSixLetterContainsInWord(String word) {
		if (this.sixLetter.isEmpty() || this.sixLetter == null) {
			return false;
		}
		for (int i = 0; i < word.length(); i++) {
			String alpha = "";
			alpha +=word.charAt(i);
			if (!this.sixLetter.trim().toLowerCase().contains(alpha)) {
				return false;
			}
		}
		if(!this.checkContainedWord(word)) {
			return false;
		}
		this.validWords.add(word);
		return true;
		
	}
	
	public boolean checkContainedWord(String word) {
		for (String current : this.validWords) {
			if (current.equalsIgnoreCase(word.toLowerCase())) {
				return false;
			}
		} return true;
	}
}
