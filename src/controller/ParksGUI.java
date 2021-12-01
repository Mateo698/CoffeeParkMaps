package controller;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Label lblTitle1;

    @FXML
    private Label lblEnd;

    @FXML
    private Label lblStart;

    @FXML
    private ChoiceBox<Atracction> choiceBoxStart;

    @FXML
    private ChoiceBox<Atracction> choiceBoxEnd;

    @FXML
    private Label lblTitle2;

    @FXML
    private TableView<Atracction> tableVewAttraction;

    @FXML
    private TableColumn<Atracction, String> columnStart;

    @FXML
    private TableColumn<Atracction, String> columnEnd;

    @FXML
    private TableColumn<Atracction, String> columnDistance;

    @FXML
    void calculateEachOne(ActionEvent event) {

    }

    @FXML
    void calculateStartEnd(ActionEvent event) {

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
    }
}
