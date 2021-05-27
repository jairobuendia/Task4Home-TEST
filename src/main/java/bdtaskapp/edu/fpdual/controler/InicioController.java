package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * Contralador Inicio.
 *
 * @author Jairo Buendia
 */

public class InicioController {

	/** The exit. */
	@FXML
	private Button exit;

	/** The premios. */
	@FXML
	private Button premios;

	/** The tareas. */
	@FXML
	private Button tareas;

	/** The usuarios. */
	@FXML
	private Button usuarios;

	/** The users. */
	@FXML
	private ImageView users;

	/** The escena. */
	@FXML
	private SceneController escena = new SceneController();

	/**
	 * Nos devuelve a la escena de login.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	public void handleButtonExit(ActionEvent event) throws IOException {
		if (event.getSource() == exit) {
			escena.switchToSceneLogin(event);
		}
	}

	/**
	 * Nos lleva a la escena de Tareas.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	@FXML
	void handleButtonTareas(ActionEvent event) throws IOException {
		if (event.getSource() == tareas) {
			escena.switchToSceneTareas(event);
		}
	}

	/**
	 * Nos lleva a la escena de Usuarios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleButtonUsuarios(ActionEvent event) throws IOException {
		if (event.getSource() == usuarios) {
			escena.switchToSceneUsuarios(event);
		}
	}

	/**
	 * Nos lleva a la escena de Premios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleButtonPremios(ActionEvent event) throws IOException {
		if (event.getSource() == premios) {
			escena.switchToScenePremios(event);
		}
	}

}
