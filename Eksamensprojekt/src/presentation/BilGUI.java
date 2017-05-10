package presentation;

import domain.Kunde;
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
			Label forNavn = new Label("Model:");
			forNavn.setTextFill(Color.RED);
			grid.add(forNavn, 0, 1);
			TextField forNavnTextField = new TextField();
			grid.add(forNavnTextField, 1, 1);

			// Stelnummer
			Label efterNavn = new Label("Stelnummer:");
			efterNavn.setTextFill(Color.RED);
			grid.add(efterNavn, 0, 2);
			TextField efterNavnTextField = new TextField();
			grid.add(efterNavnTextField, 1, 2);

			// Årgang
			Label adresse = new Label("Årgang:");
			adresse.setTextFill(Color.RED);
			grid.add(adresse, 0, 3);
			TextField adresseTextField = new TextField();
			grid.add(adresseTextField, 1, 3);

			
			
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
//			btnOpretKunde1.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent e) {
//					FFLogic logic = new FFLogic();
//					Kunde nyKunde = new Kunde();
//					nyKunde.setForNavn(forNavnTextField.getText());
//					nyKunde.setEfterNavn(efterNavnTextField.getText());
//					nyKunde.setAdresse(adresseTextField.getText());
//					nyKunde.setBy(byenTextField.getText());
//					nyKunde.setPostNummer(postnummerTextField.getText());
//					nyKunde.setFodselsdato(fødselsdatoTextField.getText());
//					nyKunde.setTelefonNummer(telefonNummerTextField.getText());
//					nyKunde.setEmail(emailTextField.getText());
//
//					if (forNavn.getText().trim().isEmpty()) {
//						Label fejl = new Label("Insert a name");
//						fejl.setTextFill(Color.web("#fc1919"));
//						grid.add(fejl, 3, 2);
//					} else {
//						logic.opretKunde(nyKunde);
//					}
//
//				}
//			});
			Scene scene = new Scene(grid, 640, 450);
			BilStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			BilStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}