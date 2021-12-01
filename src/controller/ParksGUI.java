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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Alert.AlertType;
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
    private ListView<Atracction> listViewAtracction;

    @FXML
    private Label lblTitle;

    @FXML
    public void calculateStartEnd(ActionEvent event) {
    	ArrayList<Atracction> at = new ArrayList<>();
    	if(!listViewAtracction.getSelectionModel().getSelectedItems().isEmpty()) {
    		
    	}else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty fields");
			alertWarnings.setContentText("Please check the info.");
			alertWarnings.show();
    	}
    }

    private void initListView() {
    	ArrayList<Atracction> at = new ArrayList<>();
    	at=park.getAtracctionsList();
    	at.remove(17);
    	ObservableList <Atracction> atracction = FXCollections.observableArrayList(at);
    	listViewAtracction.setItems(atracction);
    	listViewAtracction.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
		initListView();
    }
}
