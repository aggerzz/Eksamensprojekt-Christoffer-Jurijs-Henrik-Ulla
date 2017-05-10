package application;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.Login;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		Login login = new Login();
		login.start(stage);
		
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}