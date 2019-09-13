package de.tum.in.www1;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainViewController implements Initializable {

	@FXML private Button nextButton;

	//TODO: Task 1: Create a single javafx.scene.control.TextField
	
	//TODO: Task 2: Delete all existing ComboBoxes
	@FXML private ComboBox<Integer> n1;
	@FXML private ComboBox<Integer> n2;
	@FXML private ComboBox<Integer> n3;
	@FXML private ComboBox<Integer> n4;
	@FXML private ComboBox<Integer> n5;
	@FXML private ComboBox<Integer> n6;
	@FXML private ComboBox<Integer> n7;
	@FXML private ComboBox<Integer> n8;
	
	@FXML private ImageView feedbackImageView;

	private Image redxImage = new Image(getClass().getResourceAsStream("view/redx.png"));
	private Image greencheckImage = new Image(getClass().getResourceAsStream("view/greencheck.png"));
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//TODO: Task 2: Delete the setup of the combo boxes
		Integer[] options = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; 
		for (ComboBox<Integer> comboBox: Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8)) {
			comboBox.getItems().addAll(options);
		}
		
		//TODO: Task 1: Add a textProperty() listener to the new textField and Task 3: invoke the validate method with the new string value of the textField
		
		nextButton.setDisable(true);
		feedbackImageView.setImage(redxImage);
	}
	
	//TODO: Task 2: Delete the method comboBoxValueChanged()
	@FXML
	private void comboBoxValueChanged() {
		for (ComboBox<Integer> comboBox: Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8)) {
			if (comboBox.getValue() == null) {
				System.out.println("At least 1 number of matriculation number not yet filled");
				nextButton.setDisable(true);
				feedbackImageView.setImage(redxImage);
				return;
			}
		}
		
		System.out.println("All numbers of matriculation number are filled");
		nextButton.setDisable(false);
		feedbackImageView.setImage(greencheckImage);
	}
	
	public void validate(String matriculationNumber) {
		boolean isCorrect = isMatriculationNumber(matriculationNumber);
		nextButton.setDisable(!isCorrect);
		if (!isCorrect) {
			System.out.println("Validation fail");
			feedbackImageView.setImage(redxImage);
		}
		else {
			System.out.println("Validation success");
			feedbackImageView.setImage(greencheckImage);	
		}
	}

	@FXML
	private void next() {
		System.out.println("Next button clicked");
	}

	public boolean isMatriculationNumber(String matricalutionNumber) {
		return matricalutionNumber.matches("[0-9]+") && matricalutionNumber.length() == 8;
	}
}