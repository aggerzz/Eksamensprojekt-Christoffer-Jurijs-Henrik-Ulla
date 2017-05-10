package presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu {
	public void start(Stage menuStage) {
		try {
			menuStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Ferrari forhandler");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			// Opret kunde
			Button btnOpretKunde = new Button("Opret kunde");
			HBox hbBtnOpretkunde = new HBox(10);
			hbBtnOpretkunde.setAlignment(Pos.TOP_CENTER);
			hbBtnOpretkunde.getChildren().add(btnOpretKunde);
			grid.add(hbBtnOpretkunde, 1, 1);
			btnOpretKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
				}
			});

			// Opret sælger
			Button btnOpretSælger = new Button("Opret sælger");
			HBox hbBtnOpretSælger = new HBox(10);
			hbBtnOpretSælger.setAlignment(Pos.TOP_CENTER);
			hbBtnOpretSælger.getChildren().add(btnOpretSælger);
			grid.add(hbBtnOpretSælger, 1, 2);
			btnOpretSælger.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
				}
			});

			// Lån
			Button btnLån = new Button("Lån");
			HBox hbBtnLån = new HBox(10);
			hbBtnLån.setAlignment(Pos.TOP_CENTER);
			hbBtnLån.getChildren().add(btnLån);
			grid.add(hbBtnLån, 1, 3);
			btnLån.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
				}
			});

			Scene scene = new Scene(grid, 300, 275);
			menuStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			menuStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
