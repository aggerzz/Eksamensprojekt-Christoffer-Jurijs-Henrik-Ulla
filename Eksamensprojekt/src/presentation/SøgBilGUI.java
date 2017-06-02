package presentation;

import javax.swing.JOptionPane;

import data.GetBilDB;
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
			grid.add(stelnummerTextField, 1, 3);

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
				// public void handle(ActionEvent e) {
				// FFLogic logic = new FFLogic();
				// Bil findBil = new Billmpl();
				// findBil.setStelNummer(stelnummerTextField.getText());
				// try {
				// logic.findBil(findBil);
				// JOptionPane.showMessageDialog(null,"bilens pris er: " +
				// findBil.getPris(), "Godkendt",
				// JOptionPane.INFORMATION_MESSAGE, null);
				// } catch (Exception e1) {
				// JOptionPane.showMessageDialog(null, e1, "Noget gik galt",
				// JOptionPane.ERROR_MESSAGE, null);
				// }
				//
				// }
				// });
				public void handle(ActionEvent e) {
					Bil findBiler = new Billmpl();
					findBiler.setStelNummer(stelnummerTextField.getText());
					try {
						FFLogic.getBil(findBiler);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						// TableView matches
						TableView<Bil> BilTable = new TableView<Bil>();
						BilTable.setEditable(true);
						ObservableList<Bil> billiste;

						billiste = FXCollections.observableArrayList(FFLogic.getBil(findBiler));

						TableColumn<Bil, Integer> model = new TableColumn<Bil, Integer>("Model");
						model.setCellValueFactory(new PropertyValueFactory<Bil, Integer>("Model"));
						model.setMinWidth(100);

						TableColumn<Bil, Integer> stelnummer = new TableColumn<Bil, Integer>("Stelnummer");
						stelnummer.setCellValueFactory(new PropertyValueFactory<Bil, Integer>("StelNummer"));
						stelnummer.setMinWidth(100);

						TableColumn<Bil, Integer> årgang = new TableColumn<Bil, Integer>("Årgang");
						årgang.setCellValueFactory(new PropertyValueFactory<Bil, Integer>("Årgang"));
						årgang.setMinWidth(100);

						TableColumn<Bil, Integer> pris = new TableColumn<Bil, Integer>("Pris");
						pris.setCellValueFactory(new PropertyValueFactory<Bil, Integer>("Pris"));
						pris.setMinWidth(100);

						BilTable.setItems(billiste);
						BilTable.getColumns().addAll(model, stelnummer, årgang, pris);
						BilTable.setMinSize(500, 200);
						grid.add(BilTable, 0, 8, 5, 5);
					} catch (Exception e1) {
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