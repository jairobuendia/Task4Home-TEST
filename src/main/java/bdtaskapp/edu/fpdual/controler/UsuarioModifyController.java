package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.manager.PersonaManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//import javafx.scene.control.Alert.AlertType;

/**
 * Controlador Modificador de usuarios.
 *
 * @author Jairo Buendia
 */

public class UsuarioModifyController {

	/** The escena. */
	@FXML
	private SceneController escena = new SceneController();

	/** The codigo ID. */
	@FXML
	private TextField codigoID;

	/** The nick borrar. */
	@FXML
	private TextField nickBorrar;

	/** The borrar. */
	@FXML
	private Button borrar;

	/** The nuevo edad. */
	@FXML
	private TextField nuevoEdad;

	/** The aplicar. */
	@FXML
	private Button aplicar;

	/** The nuevo correo. */
	@FXML
	private TextField nuevoCorreo;

	/** The nuevo nick. */
	@FXML
	private TextField nuevoNick;

	/** The Exit. */
	@FXML
	private Button Exit;

	/**
	 * Nos devuelve a la escena Usuarios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleExit(ActionEvent event) throws IOException {
		if (event.getSource() == Exit) {
			escena.switchToSceneUsuarios(event);
		}
	}

	/**
	 * Borra un Usuario.
	 *
	 * @param event the event
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@FXML
	public void handleBorrar(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (nickBorrar.getText().length() != 0) {
			try {
				Connection con = new Conector().getMySQLConnection();
				new PersonaManager().deleteUsuario(con, nickBorrar.getText());
				con.close();
				// AlertType type = AlertType.CONFIRMATION;
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Borrado completado");
				alert.setContentText("El usuario se ha borrado correctamente.");
				alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			// AlertType type = AlertType.WARNING;
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Usuario Incorrecto");
			alert.setContentText("El usuario no es correcto , inserte un correcto.");
			alert.showAndWait();
		}
	}

	/**
	 * Modifica un usuario existente.
	 *
	 * @param event the event
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 * @throws noCaracteresException the no caracteres exception
	 */
	@FXML
	public void handleAplicar(ActionEvent event) throws ClassNotFoundException, SQLException, noCaracteresException {

		if (codigoID.getText().length() != 0) {
			try {
				Connection con = new Conector().getMySQLConnection();
				new PersonaManager().modifyUsuario(con, nuevoNick.getText(), nuevoEdad.getText(), nuevoCorreo.getText(),
						codigoID.getText());
				con.close();
				// AlertType type = AlertType.CONFIRMATION;
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Modificado completado");
				alert.setContentText("El usuario se ha modificado correctamente.");
				alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new noCaracteresException("NO HAS PUESTO NINGÚN CARÁCTER.");
//			AlertType type = AlertType.WARNING;
//			Alert alert = new Alert(Alert.AlertType.ERROR);
//			alert.setHeaderText(null);
//			alert.setTitle("Código Usuario Incorrecto");
//			alert.setContentText("El código de usuario no es correcto , inserte uno correcto.");
//			alert.showAndWait();
		}
	}

}
