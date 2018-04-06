package edu.westga.cs1302.wordGame.view;

import edu.westga.cs1302.wordGame.wordGameViewModel.WordGameViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;


/**
 * This class is structure of the UI.
 *
 * @author Junbin Kwon
 * @version 04-April-2018
 */
public class WordGameCodeBehind {

    /** The text area. */
    @FXML
    private TextArea textArea;

    /** The text score. */
    @FXML
    private Label textScore;

    /** The text six letter. */
    @FXML
    private Label textSixLetter;

    /** The text enter word. */
    @FXML
    private TextField textEnterWord;
    
    /** The hint check box. */
    @FXML
    private CheckBox hintCheckBox;

    /** The progress bar. */
    @FXML
    private ProgressBar progressBar;
    
    /** The view model. */
    private WordGameViewModel viewModel;
    
    /**
     * Instantiates a new word game code behind.
     */
    public WordGameCodeBehind() {
    	this.viewModel = new WordGameViewModel();
    }

    /**
     * Handle enter.
     *
     * @param event the event
     */
    @FXML
    void handleEnter(ActionEvent event) {
    	this.viewModel.enter();
    }

    /**
     * Handle shuffle.
     *
     * @param event the event
     */
    @FXML
    void handleShuffle(ActionEvent event) {
    	this.viewModel.shuffle();
    }

    /**
     * Handle start A new game.
     *
     * @param event the event
     */
    @FXML
    void handleStartANewGame(ActionEvent event) {
    	this.viewModel.startNewGame();
    }
    
    /**
     * Handle check selection.
     *
     * @param event the event
     */
    @FXML
    void handleCheckSelection(ActionEvent event) {
    	this.viewModel.makeHint();
    }

	/**
	 * Initialize.
	 */
	@FXML
	private void initialize() {
		this.textArea.textProperty().bindBidirectional(this.viewModel.getSummaryProperty());
		this.textEnterWord.textProperty().bindBidirectional(this.viewModel.getWordProperty());
		this.textSixLetter.textProperty().bindBidirectional(this.viewModel.getSixLetterProperty());
		this.textScore.textProperty().bindBidirectional(this.viewModel.getScoreProperty(), new NumberStringConverter());
		this.hintCheckBox.selectedProperty().bindBidirectional(this.viewModel.getSelectProperty());
		this.progressBar.progressProperty().bindBidirectional(this.viewModel.getProgressProperty());
		
		this.progressBar.setProgress(0);
		this.textArea.setEditable(false);
	}

}
