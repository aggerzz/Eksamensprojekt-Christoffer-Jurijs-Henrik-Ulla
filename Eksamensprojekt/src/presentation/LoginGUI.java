package presentation;

import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.LoginController;

public class LoginGUI extends Application {

	PasswordField pwBox = new PasswordField();
	TextField userTextField = new TextField();
	LoginController loginController = new LoginController();

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(5);
			grid.setVgap(5);

			Label brugernavn = new Label("Brugernavn:");
			brugernavn.setTextFill(Color.RED);
			grid.add(brugernavn, 0, 2);

			grid.add(userTextField, 1, 2);

			Label pw = new Label("Adgangskode:");
			pw.setTextFill(Color.RED);
			grid.add(pw, 0, 3);

			grid.add(pwBox, 1, 3);

			Button btn = new Button("Log ind");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);

			Text actiontarget = new Text();
			grid.add(actiontarget, 0, 6);
			GridPane.setColumnSpan(actiontarget, 2);
			GridPane.setHalignment(actiontarget, null);
			actiontarget.setId("actiontarget");

			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {

					try {
						visData();
						if(loginController.fåetadgang == true) {
							primaryStage.hide();
						}

					} catch (BrugernavnIkkeOplystException | AdgangskodeIkkeOplystException e1) {
						e1.printStackTrace();
					}

					// MenuGUI menuStage = new MenuGUI();
					// menuStage.start(new Stage());
					// primaryStage.hide();
				}
			});

			Scene scene = new Scene(grid, 300, 375);
			primaryStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void visData() throws BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		loginController.login = userTextField.getText();
		loginController.adgangskode = pwBox.getText();
		System.out.println(loginController.login + "\n" + loginController.adgangskode);

		loginController.CheckLoginInforamtion();
	}
}