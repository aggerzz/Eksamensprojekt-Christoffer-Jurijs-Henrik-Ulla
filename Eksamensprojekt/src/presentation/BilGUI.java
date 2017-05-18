package presentation;

import javax.swing.JOptionPane;

import domain.Bil;
import domain.Billmpl;
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

public class BilGUI extends Application {
	public void start(Stage BilStage) {
		//Bil
		try {
			BilStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Opret bil");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Model
			Label model = new Label("Model:");
			model.setTextFill(Color.RED);
			grid.add(model, 0, 1);
			TextField modelTextField = new TextField();
			grid.add(modelTextField, 1, 1);

			// Stelnummer
			Label stelNummer = new Label("Stelnummer:");
			stelNummer.setTextFill(Color.RED);
			grid.add(stelNummer, 0, 2);
			TextField stelNummerTextField = new TextField();
			grid.add(stelNummerTextField, 1, 2);

			// Årgang
			Label årgang = new Label("Årgang:");
			årgang.setTextFill(Color.RED);
			grid.add(årgang, 0, 3);
			TextField årgangTextField = new TextField();
			grid.add(årgangTextField, 1, 3);
			
			// Pris
			Label pris = new Label("Pris:");
			pris.setTextFill(Color.RED);
			grid.add(pris, 0, 4);
			TextField prisTextField = new TextField();
			grid.add(prisTextField, 1, 4);

			
			
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
					BilStage.hide();
				}
			});


			Button btnOpretKunde1 = new Button("Opret bil");
			HBox hbBtnOpretkunde1 = new HBox(10);
			hbBtnOpretkunde1.setAlignment(Pos.TOP_LEFT);
			hbBtnOpretkunde1.getChildren().add(btnOpretKunde1);
			grid.add(hbBtnOpretkunde1, 15, 15);
			btnOpretKunde1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					FFLogic logic = new FFLogic();
					Bil nyBil = new Billmpl();
					nyBil.setModel(modelTextField.getText());
					nyBil.setStelNummer(stelNummerTextField.getText());
					nyBil.setÅrgang(årgangTextField.getText());
					nyBil.setPris(prisTextField.getText());

					
					try {
						logic.opretBil(nyBil);
						JOptionPane.showMessageDialog(null, "Bilen er nu oprettet", "Godkendt", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Noget gik galt", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			});
			Scene scene = new Scene(grid, 640, 450);
			BilStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			BilStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}