package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import presentation.Menu;

public class Login extends Application {
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			Text scenetitle = new Text("Ferrari forhandler");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			Label userName = new Label("Brugernavn:");
			userName.setTextFill(Color.RED);
			grid.add(userName, 0, 1);

			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);

			Label pw = new Label("Adgangskode:");
			pw.setTextFill(Color.RED);
			grid.add(pw, 0, 2);

			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);

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
					Menu menuStage = new Menu();
					menuStage.start(new Stage());
					primaryStage.hide();
				}
			});

			Scene scene = new Scene(grid, 400, 375);
			primaryStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}