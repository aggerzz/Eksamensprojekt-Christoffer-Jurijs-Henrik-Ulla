package presentation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KundeGUI extends Application {
	public void start(Stage menuStage) {
		try {
			menuStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			Text scenetitle = new Text("Opret kunde");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);
			
			//Fornavn
			Label forNavn = new Label("Fornavn:");
			forNavn.setTextFill(Color.RED);
			grid.add(forNavn, 0, 1);
			TextField forNavnTextField = new TextField();
			grid.add(forNavnTextField, 1, 1);
			
			//Efternavn
			Label efterNavn = new Label("Efternavn:");
			efterNavn.setTextFill(Color.RED);
			grid.add(efterNavn, 0, 2);
			TextField efterNavnTextField = new TextField();
			grid.add(efterNavnTextField, 1, 2);
			
			//Adresse
			Label adresse = new Label("Adresse:");
			adresse.setTextFill(Color.RED);
			grid.add(adresse, 0, 3);
			TextField adresseTextField = new TextField();
			grid.add(adresseTextField, 1, 3);
			
			//Postnummer
			Label postnummer = new Label("Postnummer:");
			postnummer.setTextFill(Color.RED);
			grid.add(postnummer, 0, 4);
			TextField postnummerTextField = new TextField();
			grid.add(postnummerTextField, 1, 4);
			
			//Fødselsdato
			Label fødselsdato = new Label("Fødselsdato:");
			fødselsdato.setTextFill(Color.RED);
			grid.add(fødselsdato, 0, 5);
			TextField fødselsdatoNavnTextField = new TextField();
			grid.add(fødselsdatoNavnTextField, 1, 5);
			
			//TelefonNummer
			Label telefonNummer = new Label("Telefonnummer:");
			telefonNummer.setTextFill(Color.RED);
			grid.add(telefonNummer, 0, 6);
			TextField telefonNummerTextField = new TextField();
			grid.add(telefonNummerTextField, 1, 6);
			
			//Email
			Label email = new Label("Email:");
			email.setTextFill(Color.RED);
			grid.add(email, 0, 7);
			TextField emailTextField = new TextField();
			grid.add(emailTextField, 1, 7);
			

			Scene scene = new Scene(grid, 640, 450);
			menuStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			menuStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

