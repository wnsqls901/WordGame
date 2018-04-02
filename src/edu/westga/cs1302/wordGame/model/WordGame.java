package edu.westga.cs1302.wordGame.model;

import java.util.Random;

public class WordGame {
	private String alphabet;
	private String sixLetter;
	
	public WordGame() {
		this.alphabet = "abcdefghijklmnopqrstuvwxyz";
	}
	public String setRandomLetter() {
		this.sixLetter = "";
		Random rand = new Random();
		for (int i = 0; i <= 5; i++) {
			this.sixLetter += this.alphabet.charAt(rand.nextInt(26));
		}
		return this.sixLetter;
	}
}
