package edu.westga.cs1302.wordGame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	private String alphabet;
	private String sixLetter;
	
	public WordGame() {
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	public String setRandomLetter() {
		this.sixLetter = "";
		Random rand = new Random();
		for (int i = 0; i <= 5; i++) {
			this.sixLetter += this.alphabet.charAt(rand.nextInt(26));
		}
		return this.sixLetter;
	}
	
	public boolean validWord(String word) {
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
		for (int i = 0; i < word.length(); i++) {
			String alpha = "";
			alpha +=word.charAt(i);
			if (!this.sixLetter.toLowerCase().contains(alpha)) {
				return false;
			}
		} return true;
	}
}
