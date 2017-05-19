package presentation;

import javax.swing.JOptionPane;

import domain.Sælger;
import domain.Sælgerlmpl;
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
import logic.FFLogic;

public class SælgerGUI extends Application {
	public void start(Stage SælgerStage) {
		try {
			SælgerStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Opret Sælger");
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

			// TelefonNummer
			Label telefonNummer = new Label("Telefonnummer:");
			telefonNummer.setTextFill(Color.RED);
			grid.add(telefonNummer, 0, 3);
			TextField telefonNummerTextField = new TextField();
			grid.add(telefonNummerTextField, 1, 3);

			// Email
			Label email = new Label("Email:");
			email.setTextFill(Color.RED);
			grid.add(email, 0, 4);
			TextField emailTextField = new TextField();
			grid.add(emailTextField, 1, 4);
			
			// Login
			Label login = new Label("Login:");
			login.setTextFill(Color.RED);
			grid.add(login, 0, 5);
			TextField loginTextField = new TextField();
			grid.add(loginTextField, 1, 5);

			// Adgangskode
			Label adgangskode = new Label("Adgangskode:");
			adgangskode.setTextFill(Color.RED);
			grid.add(adgangskode, 0, 6);
			PasswordField adgangskodeTextField = new PasswordField();
			grid.add(adgangskodeTextField, 1, 6);
			
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


			Button btnOpretSælger = new Button("Opret sælger");
			HBox hbBtnOpretSælger = new HBox(10);
			hbBtnOpretSælger.setAlignment(Pos.TOP_LEFT);
			hbBtnOpretSælger.getChildren().add(btnOpretSælger);
			grid.add(hbBtnOpretSælger, 15, 15);
			btnOpretSælger.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					FFLogic logic = new FFLogic();
					Sælger nySælger = new Sælgerlmpl();
					nySælger.setLogin(loginTextField.getText());
					nySælger.setAdgangskode(adgangskodeTextField.getText());
					nySælger.setForNavn(forNavnTextField.getText());
					nySælger.setEfterNavn(efterNavnTextField.getText());
					nySælger.setTelefonNummer(telefonNummerTextField.getText());
					nySælger.setEmail(emailTextField.getText());
					
					try {
						logic.opretSælger(nySælger);
						JOptionPane.showMessageDialog(null, "Sælger er nu oprettet", "Godkendt", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Noget gik galt", JOptionPane.ERROR_MESSAGE, null);
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