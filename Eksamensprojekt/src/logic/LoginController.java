package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.DataAccess;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import javafx.stage.Stage;
import presentation.MenuGUI;

public class LoginController {
	public String login, adgangskode;
	public boolean fåetadgang = false;

	public void CheckLoginInforamtion() throws BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {

		DataAccess access = new DataAccess();
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("select fornavn from sælger where login=? and adgangskode=?");) {

			System.out.println("Controller: " + login);

			System.out.println("Controller: " + adgangskode);

			statement.setString(1, login);
			statement.setString(2, adgangskode);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Du har nu logget ind");
				fåetadgang = true;
				MenuGUI menuStage = new MenuGUI();
				menuStage.start(new Stage());
				
			} else {
				JOptionPane.showMessageDialog(null, "Forkert brugernavn eller adgangskode, prøv igen");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Fejl", e);
		}
	}
}