package edu.westga.cs1302.wordGame.view;

import edu.westga.cs1302.wordGame.wordGameViewModel.WordGameViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    
    private WordGameViewModel viewModel;
    
    public WordGameCodeBehind() {
    		this.viewModel = new WordGameViewModel();
    }

    @FXML
    void handleEnter(ActionEvent event) {

    }

    @FXML
    void handleShuffle(ActionEvent event) {
    		this.viewModel.Shuffle();
    }

    @FXML
    void handleStartANewGame(ActionEvent event) {

    }

	@FXML
	private void initialize() {
		this.textArea.textProperty().bindBidirectional(this.viewModel.getSummaryProperty());
		this.textEnterWord.textProperty().bindBidirectional(this.viewModel.getWordProperty());
		this.textSixLetter.textProperty().bindBidirectional(this.viewModel.getSixLetterProperty());
		this.textScore.textProperty().bindBidirectional(this.viewModel.getScoreProperty(), new NumberStringConverter());
		this.textArea.setText("");
		this.textArea.setEditable(false);
	}

}
