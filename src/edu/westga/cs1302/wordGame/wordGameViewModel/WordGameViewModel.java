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

/**
 * The Class is viewModel for word game.
 * 
 * @author Junbin Kwon
 * @version 04-04-2018
 * 
 */
public class WordGameViewModel {
	
	/** The six letter property. */
	private StringProperty sixLetterProperty;
	
	/** The score property. */
	private IntegerProperty scoreProperty;
	
	/** The summary property. */
	private StringProperty summaryProperty;
	
	/** The word property. */
	private StringProperty wordProperty;
	
	/** The select property. */
	private BooleanProperty selectProperty;
	
	/** The progress property. */
	private DoubleProperty progressProperty;
	
	/** The game. */
	private WordGame game;
	
	
	/**
	 * Instantiates a new word game view model.
	 */
	public WordGameViewModel() {
		this.sixLetterProperty = new SimpleStringProperty();
		this.scoreProperty = new SimpleIntegerProperty();
		this.summaryProperty = new SimpleStringProperty();
		this.wordProperty = new SimpleStringProperty();
		this.selectProperty = new SimpleBooleanProperty();
		this.selectProperty.setValue(false);
		this.progressProperty = new SimpleDoubleProperty();
		this.wordProperty.setValue("");
		this.game = new WordGame();

		this.sixLetterProperty.setValue(this.game.setRandomLetter());
		this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
		
	}
	
	/**
	 * Gets the select property.
	 *
	 * @return the select property
	 */
	public BooleanProperty getSelectProperty() {
		return this.selectProperty;
	}
	
	/**
	 * Gets the progress property.
	 *
	 * @return the progress property
	 */
	public DoubleProperty getProgressProperty() {
		return this.progressProperty;
	}


	/**
	 * Gets the six letter property.
	 *
	 * @return the six letter property
	 */
	public StringProperty getSixLetterProperty() {
		return this.sixLetterProperty;
	}

	/**
	 * Gets the score property.
	 *
	 * @return the score property
	 */
	public IntegerProperty getScoreProperty() {
		return this.scoreProperty;
	}

	/**
	 * Gets the summary property.
	 *
	 * @return the summary property
	 */
	public StringProperty getSummaryProperty() {
		return this.summaryProperty;
	}

	/**
	 * Gets the word property.
	 *
	 * @return the word property
	 */
	public StringProperty getWordProperty() {
		return this.wordProperty;
	}

	/**
	 * Shuffle.
	 */
	public void shuffle() {
		this.sixLetterProperty.setValue(this.game.shuffle());
		this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
	}

	/**
	 * Enter.
	 */
	public void enter() {
		if (this.game.validWord(this.wordProperty.getValue())) {
			this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
			this.scoreProperty.setValue(this.scoreProperty.getValue() + this.wordProperty.getValue().toString().length());
			this.progressProperty.setValue(this.game.progressValue());
		}
		
	}

	/**
	 * Start new game.
	 */
	public void startNewGame() {
		this.game = new WordGame();
		this.summaryProperty.setValue("");
		this.scoreProperty.setValue(0);
		this.sixLetterProperty.setValue("");
		this.wordProperty.setValue("");
		this.progressProperty.setValue(0);

		this.sixLetterProperty.setValue(this.game.setRandomLetter());
		this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
		
	}

	/**
	 * Make hint.
	 */
	public void makeHint() {
		this.summaryProperty.setValue(this.game.allValidWords(this.selectProperty.getValue()));
	}
	
}
