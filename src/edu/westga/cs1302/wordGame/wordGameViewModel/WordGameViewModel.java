package edu.westga.cs1302.wordGame.wordGameViewModel;

import edu.westga.cs1302.wordGame.model.WordGame;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WordGameViewModel {
	
	private StringProperty sixLetterProperty;
	
	private IntegerProperty scoreProperty;
	
	private StringProperty summaryProperty;
	
	private StringProperty wordProperty;
	
	private BooleanProperty selectProperty;
	
	private DoubleProperty progressProperty;
	
	public BooleanProperty getSelectProperty() {
		return selectProperty;
	}
	public DoubleProperty getProgressProperty() {
		return this.progressProperty;
	}

	private WordGame game;
	
	private boolean gameOn;
	
	public WordGameViewModel() {
		this.sixLetterProperty = new SimpleStringProperty();
		this.scoreProperty = new SimpleIntegerProperty();
		this.summaryProperty = new SimpleStringProperty();
		this.wordProperty = new SimpleStringProperty();
		this.selectProperty = new SimpleBooleanProperty();
		this.selectProperty.setValue(false);
		this.progressProperty = new SimpleDoubleProperty();
		this.game = new WordGame();
		this.gameOn = false;
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

	public void shuffle() {
		this.sixLetterProperty.setValue(this.game.setRandomLetter());
		this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
		this.gameOn = true;
		this.progressProperty.setValue(this.game.progressValue());
	}

	public void enter() {
		
		if (this.gameOn == false) {
			this.summaryProperty.getValue();
		}
		else if (this.game.validWord(this.wordProperty.getValue())) {
			this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
			this.scoreProperty.setValue(this.scoreProperty.getValue() + this.wordProperty.getValue().toString().length());
			this.progressProperty.setValue(this.game.progressValue());
		}
		
	}

	public void startNewGame() {
		this.game = new WordGame();
		this.summaryProperty.setValue("");
		this.scoreProperty.setValue(0);
		this.sixLetterProperty.setValue("");
		this.wordProperty.setValue("");
		this.progressProperty.setValue(0);
		this.gameOn = false;
	}

	public void makeHint() {
		if (this.gameOn == false) {
			this.summaryProperty.getValue();
		} else {
			this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
		}
	}
	
}
