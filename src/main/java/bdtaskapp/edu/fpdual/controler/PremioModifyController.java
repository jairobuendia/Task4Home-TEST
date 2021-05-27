package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.manager.PremioManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * Manager Para la tabla premio.
 *
 * @author Jairo Buendia
 */

public class PremioModifyController {

	/** The escena. */
	@FXML
	private SceneController escena = new SceneController();

	/** The codigo ID. */
	@FXML
	private TextField codigoID;

	/** The borrar. */
	@FXML
	private Button borrar;

	/** The crear puntos. */
	@FXML
	private TextField crearPuntos;

	/** The nombre borrar. */
	@FXML
	private TextField nombreBorrar;

	/** The aplicar. */
	@FXML
	private Button aplicar;

	/** The crear nombre. */
	@FXML
	private TextField crearNombre;

	/** The nuevo nombre. */
	@FXML
	private TextField nuevoNombre;

	/** The nuevo puntos. */
	@FXML
	private TextField nuevoPuntos;

	/** The Exit. */
	@FXML
	private Button Exit;

	/** The crear. */
	@FXML
	private Button crear;

	/** The nuevo fecha. */
	@FXML
	private DatePicker nuevoFecha;

	/** The crear fecha. */
	@FXML
	private DatePicker crearFecha;

	/**
	 * Borra un Premio.
	 *
	 * @param event the event
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@FXML
	public void handleBorrar(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (nombreBorrar.getText().length() != 0) {
			try {
				Connection con = new Conector().getMySQLConnection();
				new PremioManager().deletePremio(con, nombreBorrar.getText());
				con.close();
				// AlertType type = AlertType.CONFIRMATION;
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Borrado completado");
				alert.setContentText("El premio se ha borrado correctamente.");
				alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			// AlertType type = AlertType.WARNING;
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Premio Incorrecto");
			alert.setContentText("El premio no es correcto , inserte uno correcto.");
			alert.showAndWait();
		}
	}

	/**
	 * Modifica un premio existente.
	 *
	 * @param event the event
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@FXML
	public void handleAplicar(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (codigoID.getText().length() != 0) {
			try {
				Connection con = new Conector().getMySQLConnection();
				new PremioManager().modifyPremio(con, nuevoNombre.getText(),
						nuevoFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), nuevoPuntos.getText(),
						codigoID.getText());
				con.close();
				// AlertType type = AlertType.CONFIRMATION;
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Modificado completado");
				alert.setContentText("El premio se ha modificado correctamente.");
				alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			// AlertType type = AlertType.WARNING;
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Código Premio Incorrecto");
			alert.setContentText("El código de premio no es correcto , inserte uno correcto.");
			alert.showAndWait();
		}
	}

	/**
	 * Nos devuelve a la escena Premios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleExit(ActionEvent event) throws IOException {
		if (event.getSource() == Exit) {
			escena.switchToScenePremios(event);
		}
	}

	/**
	 * Nos crea el premio en la base de datos correctamente.
	 *
	 * @param event the event
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@FXML
	void handleCrear(ActionEvent event) throws SQLException, ClassNotFoundException {
		Connection con = new Conector().getMySQLConnection();
		if (crearNombre.getText().length() != 0) {
			if (crearPuntos.getText().length() != 0) {
				try {
					new PremioManager().createPremio(con, crearNombre.getText(),
							crearFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							crearPuntos.getText());
					escena.switchToScenePremios(event);
					con.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				// AlertType type = AlertType.WARNING;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Puntos incorrectos");
				alert.setContentText("Tienes que introducir un número de puntos.");
				alert.showAndWait();
			}
		} else {
			// AlertType type = AlertType.WARNING;
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Nombre vacío");
			alert.setContentText("El nombre para el premio no es correcto , inténtelo de nuevo.");
			alert.showAndWait();
		}
	}

}
