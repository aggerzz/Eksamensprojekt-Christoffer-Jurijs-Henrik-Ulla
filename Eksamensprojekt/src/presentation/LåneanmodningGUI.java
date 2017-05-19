package presentation;

import data.RKIAccess;
import domain.Låneanmodninglmpl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
import logic.BeregnRente;
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
			grid.add(scenetitle, 0, 6, 5, 1);

			Text findKreditværdighed = new Text("Find kreditværdighed");
			findKreditværdighed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			findKreditværdighed.setFill(Color.RED);
			grid.add(findKreditværdighed, 0, 0, 2, 1);

			// Telefonnummer
			Label Telefonnummer = new Label("Telefonnummer:");
			Telefonnummer.setTextFill(Color.RED);
			grid.add(Telefonnummer, 0, 7);
			TextField TelefonnummerTextField = new TextField();
			grid.add(TelefonnummerTextField, 1, 7);

			// Personnummer
			Label cprNummer = new Label("Personnummer:");
			cprNummer.setTextFill(Color.RED);
			grid.add(cprNummer, 0, 1);
			TextField cprNummerTextField = new TextField();
			grid.add(cprNummerTextField, 1, 1);

			// kreditværdighed
			Label kreditværdighed = new Label("Kreditværdighed:");
			kreditværdighed.setTextFill(Color.RED);
			grid.add(kreditværdighed, 0, 9);
			TextField kreditværdighedTextField = new TextField();
			kreditværdighedTextField.setEditable(false);
			grid.add(kreditværdighedTextField, 1, 9);

			// Rentesats
			Label rentesats = new Label("Rentesats:");
			rentesats.setTextFill(Color.RED);
			grid.add(rentesats, 0, 11);
			TextField rentesatsTextField = new TextField();
			BeregnRente rente = new BeregnRente();
			rentesatsTextField.setText(String.valueOf(rente.todaysRate));
			rentesatsTextField.setEditable(false);
			grid.add(rentesatsTextField, 1, 11);

			// Bil
			Label stelNummer = new Label("Stelnummer:");
			stelNummer.setTextFill(Color.RED);
			grid.add(stelNummer, 0, 13);
			TextField stelNummerTextField = new TextField();
			grid.add(stelNummerTextField, 1, 13);

			// Løbetid
			Label løbetid = new Label("Løbetid:");
			løbetid.setTextFill(Color.RED);
			grid.add(løbetid, 0, 15);
			TextField løbetidTextField = new TextField();
			grid.add(løbetidTextField, 1, 15);
			
			// Udbetaling
						Label udbetaling = new Label("Udbetaling:");
						udbetaling.setTextFill(Color.RED);
						grid.add(udbetaling, 0, 17);
						TextField udbetalingTextField = new TextField();
						grid.add(udbetalingTextField, 1, 17);

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

			Button btnlåneanmodning1 = new Button("Opret");
			HBox hbBtnlåneanmodning1 = new HBox(10);
			hbBtnlåneanmodning1.setAlignment(Pos.TOP_LEFT);
			hbBtnlåneanmodning1.getChildren().add(btnlåneanmodning1);
			grid.add(hbBtnlåneanmodning1, 15, 15);
			btnlåneanmodning1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					try {

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});

			Button btnFindKreditværdighed = new Button("Find kreditværdihed");
			HBox hbBtnFindKreditværdighed = new HBox(10);
			hbBtnFindKreditværdighed.setAlignment(Pos.TOP_LEFT);
			hbBtnFindKreditværdighed.getChildren().add(btnFindKreditværdighed);
			grid.add(hbBtnFindKreditværdighed, 0, 4);
			
			btnFindKreditværdighed.disableProperty().bind(
				    Bindings.isEmpty(cprNummerTextField.textProperty())
				    .or(cprNummerTextField.lengthProperty().isNotEqualTo(10))
				);
			
			
			btnFindKreditværdighed.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.out.println("nummer 1");
//
					try {
						Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
						String personNummer = cprNummerTextField.getText();
						Runnable rkiAccess = new RKIAccess(låneanmodning, personNummer);
						((RKIAccess) rkiAccess).getKreditværdighed();
						kreditværdighedTextField.setText(String.valueOf(låneanmodning.getKreditværdighed()));


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