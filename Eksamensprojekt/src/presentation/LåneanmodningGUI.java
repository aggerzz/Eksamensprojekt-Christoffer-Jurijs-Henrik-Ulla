package presentation;

import javax.swing.JOptionPane;

import access.BankAccess;
import access.RKIAccess;
import domain.Bil;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
import domain.Låneanmodning;
import domain.Låneanmodninglmpl;
import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
import logic.BeregnRente;
import logic.FFLogic;
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
			rentesatsTextField.setText(String.valueOf(rente.rente));
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

						
			// Sælger ID
			Label sælgerID = new Label("Sælger id:");
			sælgerID.setTextFill(Color.RED);
			grid.add(sælgerID, 0, 19);
			TextField sælgerIDTextField = new TextField();
			grid.add(sælgerIDTextField, 1, 19);
			
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

			Button btnlåneanmodning = new Button("Opret");
			HBox hbBtnlåneanmodning = new HBox(10);
			hbBtnlåneanmodning.setAlignment(Pos.TOP_LEFT);
			hbBtnlåneanmodning.getChildren().add(btnlåneanmodning);
			grid.add(hbBtnlåneanmodning, 15, 15);
			
			btnlåneanmodning.disableProperty().bind(
				    Bindings.isEmpty(TelefonnummerTextField.textProperty())
				    .or(TelefonnummerTextField.lengthProperty().isNotEqualTo(8))
				    .or(kreditværdighedTextField.textProperty().isEmpty())
				    .or(rentesatsTextField.textProperty().isEmpty())
				    .or(stelNummerTextField.textProperty().isEmpty())
				    .or(løbetidTextField.textProperty().isEmpty())
				    .or(udbetalingTextField.textProperty().isEmpty())
				    .or(sælgerIDTextField.textProperty().isEmpty())
				);
			
			btnlåneanmodning.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					FFLogic logic = new FFLogic();
					BeregnRente beregnrente = new BeregnRente();
					Bil findBil = new Billmpl();
					findBil.setStelNummer(stelNummerTextField.getText());
					try {
						logic.findBil(findBil);
					} catch (ModelIkkeOplystException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					} catch (StelnummerIkkeOplystException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					} catch (ÅrgangIkkeOplystException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					} catch (PrisIkkeOplystException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}

					
					try {
						
						beregnrente.beregnRente(kreditværdighedTextField.getText().charAt(0), Double.parseDouble(rentesatsTextField.getText()),Double.parseDouble(findBil.getPris()), Double.parseDouble(udbetalingTextField.getText()),Integer.parseInt(løbetidTextField.getText()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (PrisIkkeOplystException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println(beregnrente.rente + "renten");
					try {
						beregnrente.beregnPrisEfterRente(beregnrente.rente, Double.parseDouble(findBil.getPris()), Double.parseDouble(udbetalingTextField.getText()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (PrisIkkeOplystException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println(BeregnRente.beregnPrisEfterRente);
					beregnrente.beregnMånedligYdelse(BeregnRente.beregnPrisEfterRente, (Integer.parseInt(løbetidTextField.getText())));
					System.out.println(BeregnRente.beregnMånedligYdelse);
					Låneanmodning nylåneanmodning = new Låneanmodninglmpl();
					nylåneanmodning.setSælgerID(Integer.parseInt(sælgerIDTextField.getText()));
					nylåneanmodning.setPersonNummer(cprNummerTextField.getText());
					nylåneanmodning.setTelefonNummer(TelefonnummerTextField.getText());
					nylåneanmodning.setKreditværdighed((kreditværdighedTextField.getText().charAt(0)));
					nylåneanmodning.setRentesats((beregnrente.rente));
					nylåneanmodning.setMånedligYdelse((BeregnRente.beregnMånedligYdelse));
					nylåneanmodning.setPrisEfterRente(BeregnRente.beregnPrisEfterRente);
					nylåneanmodning.setStelNummer(stelNummerTextField.getText());
					try {
						nylåneanmodning.setPris(Double.parseDouble(findBil.getPris()));
					} catch (NumberFormatException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} catch (PrisIkkeOplystException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					nylåneanmodning.setLøbetid(Integer.parseInt(løbetidTextField.getText()));
					nylåneanmodning.setUdbetaling(Double.parseDouble(udbetalingTextField.getText()));
					
					
					try {
						logic.opretLåneanmodning(nylåneanmodning);
						JOptionPane.showMessageDialog(null, "Låneanmodning er blevet oprettet", "Godkendt", JOptionPane.INFORMATION_MESSAGE, null);
						LåneanmodningGodkendt LånGodkendt = new LåneanmodningGodkendt();
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Noget gik galt", JOptionPane.ERROR_MESSAGE, null);
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

					try {
						Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
						String personNummer = cprNummerTextField.getText();
						Runnable rkiAccess = new RKIAccess(låneanmodning, personNummer);
						((RKIAccess) rkiAccess).getKreditværdighed();
						kreditværdighedTextField.setText(String.valueOf(låneanmodning.getKreditværdighed()));
						BankAccess bank = new BankAccess(låneanmodning);
						((BankAccess) bank).run();
						double renteAfrunding = (double) Math.round(låneanmodning.getRentesats() * 100.0) / 100.0;
						rentesatsTextField.setText((Double.toString(renteAfrunding)));


					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});			


			Button btnOversigt = new Button("Se låneoversigt");
			HBox hbBtnOversigt = new HBox(7);
			hbBtnOversigt.setAlignment(Pos.TOP_LEFT);
			hbBtnOversigt.getChildren().add(btnOversigt);
			grid.add(hbBtnOversigt, 13, 18);
			btnOversigt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Kunde findKunde = new Kundelmpl();
					findKunde.setTelefonNummer(TelefonnummerTextField.getText());
					Bil findBiler = new Billmpl();
					findBiler.setStelNummer(stelNummerTextField.getText());
					Sælger findSælger = new Sælgerlmpl();
					findSælger.setId(Integer.parseInt(sælgerIDTextField.getText()));
					Låneanmodning findLån = new Låneanmodninglmpl();
					findLån.setTelefonNummer(TelefonnummerTextField.getText());
					
					try {
						FFLogic.getKunde(findKunde);
						FFLogic.getBil(findBiler);
						FFLogic.getSælger(findSælger);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {						
						// TableView matches låneoversigt
						
						TableView<Låneanmodning> lånTable = new TableView<Låneanmodning>();
						lånTable.setEditable(true);
						ObservableList<Låneanmodning> lånliste;

						lånliste = FXCollections.observableArrayList(FFLogic.getLån(findLån));

						TableColumn<Låneanmodning, Integer> sælgerID = new TableColumn<Låneanmodning, Integer>("Sælgerid");
						sælgerID.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("SælgerID"));
						sælgerID.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> personNummer = new TableColumn<Låneanmodning, Integer>("Personnummer");
						personNummer.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("PersonNummer"));
						personNummer.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> tlfNummer = new TableColumn<Låneanmodning, Integer>("Telefonnummer");
						tlfNummer.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("TelefonNummer"));
						tlfNummer.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> kreditværdighed = new TableColumn<Låneanmodning, Integer>("Kreditværdighed");
						kreditværdighed.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("Kreditværdighed"));
						kreditværdighed.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> rentesats = new TableColumn<Låneanmodning, Integer>("Rentesats");
						rentesats.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("Rentesats"));
						rentesats.setMinWidth(10);
						
						TableColumn<Låneanmodning, Integer> månedligYdelse = new TableColumn<Låneanmodning, Integer>("Månedlig ydelse");
						månedligYdelse.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("MånedligYdelse"));
						månedligYdelse.setMinWidth(50);
						
						
						TableColumn<Låneanmodning, Integer> PrisEfterRente = new TableColumn<Låneanmodning, Integer>("Pris efter rente");
						PrisEfterRente.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("PrisEfterRente"));
						PrisEfterRente.setMinWidth(50);
						 
						TableColumn<Låneanmodning, Integer> stelNummer = new TableColumn<Låneanmodning, Integer>("Stelnummer");
						stelNummer.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("StelNummer"));
						stelNummer.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> pris = new TableColumn<Låneanmodning, Integer>("Bilens pris");
						pris.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("Pris"));
						pris.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> løbeTid = new TableColumn<Låneanmodning, Integer>("Løbetid");
						løbeTid.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("Løbetid"));
						løbeTid.setMinWidth(50);
						
						TableColumn<Låneanmodning, Integer> udbetaling = new TableColumn<Låneanmodning, Integer>("Udbetaling");
						udbetaling.setCellValueFactory(new PropertyValueFactory<Låneanmodning, Integer>("Udbetaling"));
						udbetaling.setMinWidth(50);
						lånTable.setItems(lånliste);
						lånTable.getColumns().addAll(sælgerID, personNummer, tlfNummer, kreditværdighed, rentesats, månedligYdelse, PrisEfterRente, stelNummer, pris, løbeTid, udbetaling);
						lånTable.setMinSize(700, 0);
						lånTable.setMaxSize(700, 80);
						grid.add(lånTable, 10, 10, 10, 5);	
						
						} 
					catch (Exception e1) {
					}
					try {						
						// TableView matches kunde
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
						kundeTable.setMinSize(700, 0);
						kundeTable.setMaxSize(700, 45);
						grid.add(kundeTable, 10, 0, 10, 5);	
						
						} 
					catch (Exception e1) {
					}
					try {						
						// TableView matches bil
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
						BilTable.setMinSize(500, 0);
						BilTable.setMaxSize(500, 45);
						grid.add(BilTable, 10, 2,5,5);					
						} 
					catch (Exception e1) {
					}
					try {						
						// TableView matches Sælger
						TableView<Sælger> sælgerTable = new TableView<Sælger>();
						sælgerTable.setEditable(true);
						ObservableList<Sælger> sælgerliste;

						sælgerliste = FXCollections.observableArrayList(FFLogic.getSælger(findSælger));

						TableColumn<Sælger, Integer> navn = new TableColumn<Sælger, Integer>("Fornavn");
						navn.setCellValueFactory(new PropertyValueFactory<Sælger, Integer>("ForNavn"));
						navn.setMinWidth(50);
						
						TableColumn<Sælger, Integer> efterNavn = new TableColumn<Sælger, Integer>("Efternavn");
						efterNavn.setCellValueFactory(new PropertyValueFactory<Sælger, Integer>("EfterNavn"));
						efterNavn.setMinWidth(50);
						
						TableColumn<Sælger, Integer> telefonnummer = new TableColumn<Sælger, Integer>("Telefonnummer");
						telefonnummer.setCellValueFactory(new PropertyValueFactory<Sælger, Integer>("TelefonNummer"));
						telefonnummer.setMinWidth(50);
						
						TableColumn<Sælger, Integer> sælgerEmail = new TableColumn<Sælger, Integer>("Email");
						sælgerEmail.setCellValueFactory(new PropertyValueFactory<Sælger, Integer>("Email"));
						sælgerEmail.setMinWidth(10);
						
						
						 
						sælgerTable.setItems(sælgerliste);
						sælgerTable.getColumns().addAll(navn, efterNavn, telefonnummer, sælgerEmail);
						sælgerTable.setMinSize(700, 0);
						sælgerTable.setMaxSize(700, 45);
						grid.add(sælgerTable, 10, 6, 10, 5);	
						
						} 
					catch (Exception e1) {
					}
				}
			});
			
			// ---------------------------------------------- CSV -------------------------------------------
			Button btnOpretCSV = new Button("Eksporter CSV");
			HBox hbBtnOpretCSV = new HBox(7);
			hbBtnOpretCSV.setAlignment(Pos.TOP_LEFT);
			hbBtnOpretCSV.getChildren().add(btnOpretCSV);
			grid.add(hbBtnOpretCSV, 15, 18);
			btnOpretCSV.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					btnOpretCSV.disableProperty().bind(
						    Bindings.isEmpty(TelefonnummerTextField.textProperty())
						    .or(TelefonnummerTextField.lengthProperty().isNotEqualTo(8))
						    .or(kreditværdighedTextField.textProperty().isEmpty())
						    .or(rentesatsTextField.textProperty().isEmpty())
						    .or(stelNummerTextField.textProperty().isEmpty())
						    .or(løbetidTextField.textProperty().isEmpty())
						    .or(udbetalingTextField.textProperty().isEmpty())
						    .or(sælgerIDTextField.textProperty().isEmpty())
						);
				}
					//TODO CSV
					// set disable
				
			});
			Scene scene = new Scene(grid, 1240, 720);
			LåneanmodningStage.setScene(scene);
			scene.getStylesheets().addAll(this.getClass().getResource("/application/application.css").toExternalForm());

			LåneanmodningStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}