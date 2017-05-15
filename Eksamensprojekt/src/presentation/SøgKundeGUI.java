package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SøgKundeGUI extends Application {
	public void start(Stage SælgerStage) {
		try {
			SælgerStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Søg kunde");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Fornavn
			Label forNavn = new Label("Telefonnummer:");
			forNavn.setTextFill(Color.RED);
			grid.add(forNavn, 0, 1);
			TextField forNavnTextField = new TextField();
			grid.add(forNavnTextField, 1, 1);

			
			
			Button btnTilbage = new Button("Tilbage");
			HBox hbBtnTilbage = new HBox(7);
			hbBtnTilbage.setAlignment(Pos.TOP_LEFT);
			hbBtnTilbage.getChildren().add(btnTilbage);
			grid.add(hbBtnTilbage, 13, 15);
			btnTilbage.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					MenuGUI menuStage = new MenuGUI();
					menuStage.start(new Stage());
					SælgerStage.hide();
				}
			});


			Button btnOpretKunde1 = new Button("Søg");
			HBox hbBtnOpretkunde1 = new HBox(10);
			hbBtnOpretkunde1.setAlignment(Pos.TOP_LEFT);
			hbBtnOpretkunde1.getChildren().add(btnOpretKunde1);
			grid.add(hbBtnOpretkunde1, 15, 15);
			btnOpretKunde1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					
					try {
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});
			Scene scene = new Scene(grid, 640, 450);
			SælgerStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			SælgerStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}