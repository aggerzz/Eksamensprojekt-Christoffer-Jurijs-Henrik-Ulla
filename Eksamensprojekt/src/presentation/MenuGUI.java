package presentation;

import javax.swing.JOptionPane;
import data.IdDB;
import domain.Sælger;
import domain.Sælgerlmpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.FFLogic;

public class MenuGUI {
	Sælger findID = new Sælgerlmpl();
	IdDB idc = new IdDB();
	FFLogic logic = new FFLogic();

	public void start(Stage menuStage) {

		try {
			menuStage.setTitle("Ferrari forhandler");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			// Opret kunde
			Button btnOpretKunde = new Button("Opret kunde");
			HBox hbBtnOpretkunde = new HBox(10);
			hbBtnOpretkunde.setAlignment(Pos.TOP_CENTER);
			hbBtnOpretkunde.getChildren().add(btnOpretKunde);
			grid.add(hbBtnOpretkunde, 1, 1);
			btnOpretKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					KundeGUI kundeStage = new KundeGUI();
					kundeStage.start(new Stage());
					menuStage.hide();
				}
			});

			// Opret sælger
			Button btnOpretSælger = new Button("Opret sælger");
			HBox hbBtnOpretSælger = new HBox(10);
			hbBtnOpretSælger.setAlignment(Pos.TOP_CENTER);
			hbBtnOpretSælger.getChildren().add(btnOpretSælger);
			grid.add(hbBtnOpretSælger, 1, 2);
			btnOpretSælger.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if (LoginGUI.id0 == false) {
						JOptionPane.showMessageDialog(null, "Du har ikke rettighed til dette, kontakt salgschef");
						hbBtnOpretSælger.setDisable(true);
					} else {
						SælgerGUI sælgerStage = new SælgerGUI();
						sælgerStage.start(new Stage());
						menuStage.hide();
					}
				}
			});
			// Disable opret sælger knap if id != 0

			// Lån
			Button btnLån = new Button("Opret Låneanmodning");
			HBox hbBtnLån = new HBox(10);
			hbBtnLån.setAlignment(Pos.TOP_CENTER);
			hbBtnLån.getChildren().add(btnLån);
			grid.add(hbBtnLån, 1, 4);
			btnLån.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					LåneanmodningGUI LåneanmodningStage = new LåneanmodningGUI();
					LåneanmodningStage.start(new Stage());
					menuStage.hide();
				}
			});

			// Opret bil
			Button btnBil = new Button("Opret Bil");
			HBox hbBtnBil = new HBox(10);
			hbBtnBil.setAlignment(Pos.TOP_CENTER);
			hbBtnBil.getChildren().add(btnBil);
			grid.add(hbBtnBil, 1, 3);
			btnBil.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					BilGUI bilStage = new BilGUI();
					bilStage.start(new Stage());
					menuStage.hide();
				}
			});
			// Søg Kunde
			Button btnSøgKunde = new Button("Søg Kunde");
			HBox hbBtnSøgKunde = new HBox(10);
			hbBtnSøgKunde.setAlignment(Pos.TOP_CENTER);
			hbBtnSøgKunde.getChildren().add(btnSøgKunde);
			grid.add(hbBtnSøgKunde, 1, 5);
			btnSøgKunde.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					SøgKundeGUI søgKundeStage = new SøgKundeGUI();
					søgKundeStage.start(new Stage());
					menuStage.hide();
				}
			});
			// Søg BIL
			Button btnSøgBil = new Button("Søg Bilens Pris");
			HBox hbBtnSøgBil = new HBox(10);
			hbBtnSøgBil.setAlignment(Pos.TOP_CENTER);
			hbBtnSøgBil.getChildren().add(btnSøgBil);
			grid.add(hbBtnSøgBil, 1, 7);
			btnSøgBil.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					SøgBilGUI søgBilStage = new SøgBilGUI();
					søgBilStage.start(new Stage());
					menuStage.hide();
				}
			});

			Scene scene = new Scene(grid, 640, 450);
			menuStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			menuStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
