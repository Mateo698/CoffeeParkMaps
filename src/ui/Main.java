package ui;

import model.Maps;
import controller.ParksGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private Maps map;
	private ParksGUI pGUI;

	public Main() {
		map = new Maps();
		pGUI = new ParksGUI(map);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("screens/mainPane.fxml"));
		fxmlloader.setController(pGUI);
		Parent root = fxmlloader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		pGUI.startProgram();
	}

}