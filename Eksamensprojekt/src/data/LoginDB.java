package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import domain.Sælger;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import javafx.stage.Stage;
import presentation.MenuGUI;

public class LoginDB {
	public String login, adgangskode;
	public int id;
	public boolean fåetadgang = false;

	public void CheckLoginInforamtion(Sælger sælger)
			throws BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {

		DataAccess access = new DataAccess();
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("select id from sælger where login=? and adgangskode=?");) {

			System.out.println("Controller: " + sælger.getLogin());
			System.out.println("Controller: " + sælger.getAdgangskode());

			statement.setString(1, sælger.getLogin());
			statement.setString(2, sælger.getAdgangskode());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Du har nu logget ind");
				fåetadgang = true;
				MenuGUI menuStage = new MenuGUI();
				menuStage.start(new Stage());

			} else {
				JOptionPane.showMessageDialog(null, "Forkert brugernavn eller adgangskode");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Fejl", e);
		}
	}
}