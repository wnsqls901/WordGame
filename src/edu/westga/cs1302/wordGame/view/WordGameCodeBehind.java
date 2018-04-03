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

public class WordGameCodeBehind {

    @FXML
    private TextArea textArea;

    @FXML
    private Label textScore;

    @FXML
    private Label textSixLetter;

    @FXML
    private TextField textEnterWord;
    
    @FXML
    private CheckBox hintCheckBox;

    @FXML
    private ProgressBar progressBar;
    
    private WordGameViewModel viewModel;
    
    public WordGameCodeBehind() {
    		this.viewModel = new WordGameViewModel();
    }

    @FXML
    void handleEnter(ActionEvent event) {
    		this.viewModel.enter();
    }

    @FXML
    void handleShuffle(ActionEvent event) {
    		this.viewModel.shuffle();
    }

    @FXML
    void handleStartANewGame(ActionEvent event) {
    		this.viewModel.startNewGame();
    }
    
    @FXML
    void handleCheckSelection(ActionEvent event) {
    		this.viewModel.makeHint();
    }

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
