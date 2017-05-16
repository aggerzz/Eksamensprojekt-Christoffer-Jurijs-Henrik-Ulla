package presentation;

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

public class KundeGUI extends Application {
	public void start(Stage KundeStage) {
		try {
			KundeStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Opret kunde");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Fornavn
			Label forNavn = new Label("Fornavn:");
			forNavn.setTextFill(Color.RED);
			grid.add(forNavn, 0, 1);
			TextField forNavnTextField = new TextField();
			grid.add(forNavnTextField, 1, 1);

			// Efternavn
			Label efterNavn = new Label("Efternavn:");
			efterNavn.setTextFill(Color.RED);
			grid.add(efterNavn, 0, 2);
			TextField efterNavnTextField = new TextField();
			grid.add(efterNavnTextField, 1, 2);

			// Adresse
			Label adresse = new Label("Adresse:");
			adresse.setTextFill(Color.RED);
			grid.add(adresse, 0, 3);
			TextField adresseTextField = new TextField();
			grid.add(adresseTextField, 1, 3);

			// Postnummer
			Label postnummer = new Label("Postnummer:");
			postnummer.setTextFill(Color.RED);
			grid.add(postnummer, 0, 4);
			TextField postnummerTextField = new TextField();
			grid.add(postnummerTextField, 1, 4);

			// By
			Label byen = new Label("By:");
			byen.setTextFill(Color.RED);
			grid.add(byen, 0, 5);
			TextField byenTextField = new TextField();
			grid.add(byenTextField, 1, 5);

			// Fødselsdato
			Label fødselsdato = new Label("Fødselsdato:");
			fødselsdato.setTextFill(Color.RED);
			grid.add(fødselsdato, 0, 6);
			TextField fødselsdatoTextField = new TextField();
			grid.add(fødselsdatoTextField, 1, 6);

			// TelefonNummer
			Label telefonNummer = new Label("Telefonnummer:");
			telefonNummer.setTextFill(Color.RED);
			grid.add(telefonNummer, 0, 7);
			TextField telefonNummerTextField = new TextField();
			grid.add(telefonNummerTextField, 1, 7);

			// Email
			Label email = new Label("Email:");
			email.setTextFill(Color.RED);
			grid.add(email, 0, 8);
			TextField emailTextField = new TextField();
			grid.add(emailTextField, 1, 8);
			
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
					KundeStage.hide();
				}
			});


			Button btnOpretKunde = new Button("Opret kunde");
			HBox hbBtnOpretkunde = new HBox(10);
			hbBtnOpretkunde.setAlignment(Pos.TOP_LEFT);
			hbBtnOpretkunde.getChildren().add(btnOpretKunde);
			grid.add(hbBtnOpretkunde, 15, 15);
			btnOpretKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					FFLogic logic = new FFLogic();
					Kunde nyKunde = new Kundelmpl();
					nyKunde.setForNavn(forNavnTextField.getText());
					nyKunde.setEfterNavn(efterNavnTextField.getText());
					nyKunde.setAdresse(adresseTextField.getText());
					nyKunde.setBy(byenTextField.getText());
					nyKunde.setPostNummer(postnummerTextField.getText());
					nyKunde.setFodselsdato(fødselsdatoTextField.getText());
					nyKunde.setTelefonNummer(telefonNummerTextField.getText());
					nyKunde.setEmail(emailTextField.getText());

					try {
						logic.opretKunde(nyKunde);
					} catch (Exception e1) {
						e1.printStackTrace();
					}


				}
			});
			Scene scene = new Scene(grid, 640, 450);
			KundeStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			KundeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}