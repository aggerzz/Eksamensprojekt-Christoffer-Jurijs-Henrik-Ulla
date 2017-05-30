package presentation;

import javax.swing.JOptionPane;

import data.GetBilDB;
import domain.Bil;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
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
import logic.FFLogic;
import data.LoginDB;

public class SøgBilGUI extends Application {
	public void start(Stage SøgBilStage) {
		try {
			SøgBilStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Søg Bil Pris");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Telefonnummer Bil
			Label stelnummerLabel = new Label("Stelnummer:");
			stelnummerLabel.setTextFill(Color.RED);
			grid.add(stelnummerLabel, 0, 1);
			TextField stelnummerTextField = new TextField();
			grid.add(stelnummerTextField, 1, 1);

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
					SøgBilStage.hide();
				}
			});

			Button btnSøgKunde = new Button("Søg bilens pris");
			HBox hbBtnSøgKunde = new HBox(10);
			hbBtnSøgKunde.setAlignment(Pos.TOP_LEFT);
			hbBtnSøgKunde.getChildren().add(btnSøgKunde);
			grid.add(hbBtnSøgKunde, 15, 15);
			btnSøgKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {					
					FFLogic logic = new FFLogic();
					Bil findBil = new Billmpl();
					findBil.setStelNummer(stelnummerTextField.getText());
					try {						
						logic.findBil(findBil);
						JOptionPane.showMessageDialog(null,"bilens pris er: " + findBil.getPris(), "Godkendt", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Noget gik galt", JOptionPane.ERROR_MESSAGE, null);
					}

				}
			});
			Scene scene = new Scene(grid, 640, 450);
			SøgBilStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			SøgBilStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}