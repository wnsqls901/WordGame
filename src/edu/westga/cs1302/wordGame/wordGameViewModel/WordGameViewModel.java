package edu.westga.cs1302.wordGame.wordGameViewModel;

import edu.westga.cs1302.wordGame.model.WordGame;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WordGameViewModel {
	
	private StringProperty sixLetterProperty;
	
	private IntegerProperty scoreProperty;
	
	private StringProperty summaryProperty;
	
	private StringProperty wordProperty;
	
	private WordGame game;
	
	private String output;
	
	public WordGameViewModel() {
		this.sixLetterProperty = new SimpleStringProperty();
		this.scoreProperty = new SimpleIntegerProperty();
		this.summaryProperty = new SimpleStringProperty();
		this.wordProperty = new SimpleStringProperty();
		this.game = new WordGame();
		this.output = "";
	}

	public StringProperty getSixLetterProperty() {
		return this.sixLetterProperty;
	}

	public IntegerProperty getScoreProperty() {
		return this.scoreProperty;
	}

	public StringProperty getSummaryProperty() {
		return this.summaryProperty;
	}

	public StringProperty getWordProperty() {
		return this.wordProperty;
	}

	public void Shuffle() {
		this.sixLetterProperty.setValue(this.game.setRandomLetter());
		
	}

	public void Enter() {
		if (this.game.validWord(this.wordProperty.getValue())) {
			this.output += this.wordProperty.getValue() + System.lineSeparator();
			this.summaryProperty.setValue(output);
		}
		
	}
	
}
