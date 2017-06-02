package logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hsqldb.types.Charset;

import domain.Bil;
import domain.Kunde;
import domain.Låneanmodning;
import domain.Sælger;
import exceptions.EfternavnIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.ModelIkkeOplystException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.PrisIkkeOplystException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import javafx.stage.FileChooser;

public class exportCSV {
	public void exportCsv(Bil findBil, Kunde findKunde, Låneanmodning findLån, Sælger findSælger)
			throws LøbetidIkkeUdfyldtException, FornavnIkkeOplystException, EfternavnIkkeOplystException,
			TelefonnummerIkkeOplystException, ModelIkkeOplystException, StelnummerIkkeOplystException,
			PrisIkkeOplystException, RentesatsIkkeUdfyldtException, PersonnummerIkkeUdfyldtException {

		try {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showSaveDialog(null);
			FileWriter fileWriter = new FileWriter(file + ".csv");
			

			fileWriter.write (
					"Fornavn, Efternavn, Telefonnummer, Stelnummer, bilensPris, Rentesats, PrisEfterRente, MånedligYdelse, løbetid, udbetaling, SælgerID, SælgerForNavn, SælgerEfterNavn\n");
			for (int i = 0; i < findLån.getLøbetid(); i++) {
				fileWriter.write('\ufeff');
				fileWriter.append(findKunde.getForNavn() + ", ");
				fileWriter.append(findKunde.getEfterNavn() + ", ");
				fileWriter.append(findKunde.getTelefonNummer() + ", ");
				fileWriter.append(findBil.getStelNummer() + ", ");
				fileWriter.append(findBil.getPris() + ", ");
				fileWriter.append(findLån.getRentesats() + ", ");
				fileWriter.append(findLån.getPrisEfterRente() + ", ");
				fileWriter.append(findLån.getMånedligYdelse() + ", ");
				fileWriter.append(findLån.getLøbetid() + ", ");
				fileWriter.append(findLån.getUdbetaling() + ", ");
				fileWriter.append(findSælger.getId() + ", ");
				fileWriter.append(findSælger.getForNavn() + ", ");
				fileWriter.append(findSælger.getEfterNavn() + ", ");
				fileWriter.append((findLån.getLøbetid()) + i + "\n");
			}
				fileWriter.flush();
				fileWriter.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
