package presentation;

import javax.swing.JOptionPane;

import domain.Bil;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.FFLogic;

public class SøgKundeGUI extends Application {
	public void start(Stage SøgKundeStage) {
		try {
			SøgKundeStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Text scenetitle = new Text("Søg kunde");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle.setFill(Color.RED);
			grid.add(scenetitle, 0, 0, 2, 1);

			// Telefonnummer
			Label telefonNummer = new Label("Telefonnummer:");
			telefonNummer.setTextFill(Color.RED);
			grid.add(telefonNummer, 0, 1);
			TextField telefonNummerTextField = new TextField();
			grid.add(telefonNummerTextField, 1, 3);

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
					SøgKundeStage.hide();
				}
			});

			Button btnSøgKunde = new Button("Søg");
			HBox hbBtnSøgKunde = new HBox(10);
			hbBtnSøgKunde.setAlignment(Pos.TOP_LEFT);
			hbBtnSøgKunde.getChildren().add(btnSøgKunde);
			grid.add(hbBtnSøgKunde, 15, 15);
			btnSøgKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Kunde findKunde = new Kundelmpl();
					findKunde.setTelefonNummer(telefonNummerTextField.getText());
					try {
						FFLogic.getKunde(findKunde);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						// TableView matches
						TableView<Kunde> kundeTable = new TableView<Kunde>();
						kundeTable.setEditable(true);
						ObservableList<Kunde> kundeliste;

						kundeliste = FXCollections.observableArrayList(FFLogic.getKunde(findKunde));

						TableColumn<Kunde, Integer> navn = new TableColumn<Kunde, Integer>("Fornavn");
						navn.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("ForNavn"));
						navn.setMinWidth(50);

						TableColumn<Kunde, Integer> efterNavn = new TableColumn<Kunde, Integer>("Efternavn");
						efterNavn.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("EfterNavn"));
						efterNavn.setMinWidth(50);

						TableColumn<Kunde, Integer> adresse = new TableColumn<Kunde, Integer>("Adresse");
						adresse.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("Adresse"));
						adresse.setMinWidth(50);

						TableColumn<Kunde, Integer> postnummer = new TableColumn<Kunde, Integer>("Postnummer");
						postnummer.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("PostNummer"));
						postnummer.setMinWidth(10);

						TableColumn<Kunde, Integer> by = new TableColumn<Kunde, Integer>("By");
						by.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("By"));
						by.setMinWidth(50);

						TableColumn<Kunde, Integer> tlfNummer = new TableColumn<Kunde, Integer>("Telefonnummer");
						tlfNummer.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("TelefonNummer"));
						tlfNummer.setMinWidth(50);

						TableColumn<Kunde, Integer> email = new TableColumn<Kunde, Integer>("Email");
						email.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("Email"));
						email.setMinWidth(50);

						kundeTable.setItems(kundeliste);
						kundeTable.getColumns().addAll(navn, efterNavn, adresse, postnummer, by, tlfNummer, email);
						kundeTable.setMinSize(700, 200);
						grid.add(kundeTable, 0, 8, 5, 5);
					} catch (Exception e1) {
					}

				}
			});

			Scene scene = new Scene(grid, 680, 450);
			SøgKundeStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			SøgKundeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}