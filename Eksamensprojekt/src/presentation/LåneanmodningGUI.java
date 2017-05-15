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

public class LåneanmodningGUI extends Application {
	public void start(Stage LåneanmodningStage) {
		try {
			LåneanmodningStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Opret Låneanmodning");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Telefonnummer
			Label Telefonnummer = new Label("Telefonnummer:");
			Telefonnummer.setTextFill(Color.RED);
			grid.add(Telefonnummer, 0, 1);
			TextField TelefonnummerTextField = new TextField();
			grid.add(TelefonnummerTextField, 1, 1);
			
			// Personnummer
			Label personNummer = new Label("Personnummer:");
			personNummer.setTextFill(Color.RED);
			grid.add(personNummer, 0, 2);
			TextField personNummerTextField = new TextField();
			grid.add(personNummerTextField, 1, 2);
			
			// kreditværdighed
			Label kreditværdighed = new Label("Kreditværdighed:");
			kreditværdighed.setTextFill(Color.RED);
			grid.add(kreditværdighed, 0, 3);
			TextField kreditværdighedTextField = new TextField();
			grid.add(kreditværdighedTextField, 1, 3);
			
			// Rentesats
			Label rentesats = new Label("Rentesats:");
			rentesats.setTextFill(Color.RED);
			grid.add(rentesats, 0, 4);
			TextField rentesatsTextField = new TextField();
			grid.add(rentesatsTextField, 1, 4);
			
			// Bil
			Label stelNummer = new Label("Stelnummer:");
			stelNummer.setTextFill(Color.RED);
			grid.add(stelNummer, 0, 5);
			TextField stelNummerTextField = new TextField();
			grid.add(stelNummerTextField, 1, 5);
			
			// Løbetid
			Label løbetid = new Label("Løbetid:");
			løbetid.setTextFill(Color.RED);
			grid.add(løbetid, 0, 6);
			TextField løbetidTextField = new TextField();
			grid.add(løbetidTextField, 1, 6);
			
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
					LåneanmodningStage.hide();
				}
			});


			Button btnOpretKunde1 = new Button("Opret");
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
			LåneanmodningStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			LåneanmodningStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}