package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import bdtaskapp.edu.fpdual.conector.*;
import bdtaskapp.edu.fpdual.manager.PersonaManager;

/**
 * Contralador Login.
 *
 * @author Jairo Buendia
 */
public class LoginController {

	/** The password. */
	@FXML
	private PasswordField password;

	/** The button login. */
	@FXML
	private Button buttonLogin;

	/** The button register. */
	@FXML
	private Button buttonRegister;

	/** The username. */
	@FXML
	private TextField username;

	/** The escena. */
	@FXML
	private SceneController escena = new SceneController();

	/**
	 * Comprueba en la base de datos que el usuario y la contraseña sean correctos.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@FXML
	void handleLogin(ActionEvent event) throws SQLException, ClassNotFoundException {
		Connection con = new Conector().getMySQLConnection();
		if (username.getText().equals(new PersonaManager().findLoginUser(con, username.getText()))
				&& password.getText().equals(new PersonaManager().findLoginPassword(con, username.getText()))) {
			try {
				escena.switchToSceneInicio(event);
				con.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// AlertType type = AlertType.WARNING;
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Login Error");
			alert.setContentText("Usuario o contraseña incorrectos, inténtelo de nuevo.");
			alert.showAndWait();
		}
	}

	/**
	 * Nos lleva a la escena de register.
	 *
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	void handleRegister(ActionEvent event) throws Exception {
		if (event.getSource() == buttonRegister) {
			escena.switchToSceneRegister(event);
		}
	}

}
