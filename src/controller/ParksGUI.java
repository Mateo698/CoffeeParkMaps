package controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Atracction;
import model.Maps;

public class ParksGUI {
	private static final String MAP_IMAGE_PATH = "images/Mapa-Parque-del-Cafe-Quindio.jpg";
	private Maps park;
	public ParksGUI(Maps p) {
		park=p;
	}

	@FXML
	private Pane mainPane;

	@FXML
	private ImageView mapImage;


	@FXML
	private ListView<Atracction> listViewAtracctionSelected;

	@FXML
	private Label lblTitle;
	
	@FXML
	private Label lblTitle1;
	
	@FXML
	private Label lblTitle2;
	
	@FXML
	private Label lblTitle3;
	
	@FXML
	private Label lblMessage;
	
	@FXML
	private ChoiceBox<Atracction> comboBoxSelection;

	@FXML
	private ListView<String> listViewAtracctionPath;

	private ArrayList<Atracction> atracc;
	
	private ArrayList<Atracction> at;
	
	private ArrayList<String> path;

	@FXML
	public void addAtracctionToList(ActionEvent event) {
		
		if(comboBoxSelection.getSelectionModel().getSelectedItem()!=null) {
			at.add(comboBoxSelection.getSelectionModel().getSelectedItem());
			initListView(at);
			atracc.remove(comboBoxSelection.getSelectionModel().getSelectedItem());
			initComboBox();
		}else {
			Alert alertWarnings = new Alert(AlertType.WARNING);
			alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty Selection");
			alertWarnings.setContentText("Please check the selected atracction.");
			alertWarnings.show();
		}
	}

	public void initComboBox() {
		ObservableList<Atracction> comBoxAt = FXCollections.observableArrayList(atracc);
		comboBoxSelection.setItems(comBoxAt);
	}

	@FXML
	public void calculateStartEnd(ActionEvent event) {
		if(!listViewAtracctionSelected.getItems().isEmpty()) {
			ArrayList<Atracction> at = new ArrayList<>();
			at.addAll(listViewAtracctionSelected.getItems());
			ObservableList<String> atracct = FXCollections.observableArrayList(park.getPath(park.getAtracctionsList().get(17), at));
			listViewAtracctionPath.setItems(atracct);
		}else {
			Alert alertWarnings = new Alert(AlertType.WARNING);
			alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty Selection");
			alertWarnings.setContentText("Please check the selected atracctions.");
			alertWarnings.show();
		}
	}

	private void initListView(ArrayList<Atracction> at) {
		ObservableList<Atracction> atracct = FXCollections.observableArrayList(at);
		listViewAtracctionSelected.setItems(atracct);
	}
	
	private void initListResultsView(ArrayList<String> at) {
		ObservableList<String> atracct = FXCollections.observableArrayList(at);
		listViewAtracctionPath.setItems(atracct);
	}
	
    @FXML
    public void resetAll(ActionEvent event) {
    	resetValues();
    }
    private void resetValues() {
    	path = new ArrayList<>();
    	atracc = new ArrayList<>();
		at = new ArrayList<>();
		atracc.addAll(park.getAtracctionsList());
		atracc.remove(17);
		initComboBox();
		initListView(at);
		initListResultsView(path);
    }


	public void startProgram() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/screens/mapWindow.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(MAP_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mapImage.setImage(img);
		lblTitle.setText("Select the atracctions that you want to visit");
		lblTitle1.setText("Selected atracctions");
		lblTitle2.setText("The shortest path to visit all the selected atracctions is");
		lblTitle3.setText("Just follow this list from start to finish");
		lblMessage.setText("The result is given following the order entered by the user");
		resetValues();
	}
}
