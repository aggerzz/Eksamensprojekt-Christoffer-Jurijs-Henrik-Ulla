package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class LåneanmodningGodkendt extends Application {
	public void start(Stage LånGodkendt) {
		try {
			LånGodkendt.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Låneanmodning Oversigt");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 1, 5, 1);

			Label kunde = new Label("Kundeoplysninger:");
			kunde.setTextFill(Color.RED);
			grid.add(kunde, 0, 2);
			
			
			Label bil = new Label("Biloplysninger:");
			bil.setTextFill(Color.RED);
			grid.add(bil, 0, 5);
			
			Label sælger = new Label("Sælgeroplysninger:");
			sælger.setTextFill(Color.RED);
			grid.add(sælger, 0, 8);
			
			Label aftale = new Label("Aftaleoplysninger:");
			aftale.setTextFill(Color.RED);
			grid.add(aftale, 0, 11);
			

			Button btnTilbage = new Button("Tilbage");
			HBox hbBtnTilbage = new HBox(7);
			hbBtnTilbage.setAlignment(Pos.TOP_LEFT);
			hbBtnTilbage.getChildren().add(btnTilbage);
			grid.add(hbBtnTilbage, 13, 15);
			btnTilbage.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					LåneanmodningGUI LåneanmodningStage = new LåneanmodningGUI();
					LåneanmodningStage.start(new Stage());
					LånGodkendt.hide();
				}
			});

			Button btnlåneanmodning1 = new Button("Eksporter CSV");
			HBox hbBtnlåneanmodning1 = new HBox(10);
			hbBtnlåneanmodning1.setAlignment(Pos.TOP_LEFT);
			hbBtnlåneanmodning1.getChildren().add(btnlåneanmodning1);
			grid.add(hbBtnlåneanmodning1, 15, 15);
			btnlåneanmodning1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					try {

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});


			Scene scene = new Scene(grid, 640, 450);
			LånGodkendt.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			LånGodkendt.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}