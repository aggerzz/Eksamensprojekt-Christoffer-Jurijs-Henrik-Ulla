package application;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.LoginGUI;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		LoginGUI login = new LoginGUI();
		login.start(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}