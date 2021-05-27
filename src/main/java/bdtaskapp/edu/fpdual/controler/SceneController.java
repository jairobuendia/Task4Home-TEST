package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 * Controlador de Escenas.
 *
 * @author Jairo Buendía
 */
public class SceneController {
	
	/** The stage. */
	private Stage stage;
	
	/** The scene. */
	private Scene scene;
	
	/** The root. */
	private Parent root;

	/**
	 * Nos lleva a la escena de login.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena de registro.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneRegister(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneRegister.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Inicio.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneInicio(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Inicio.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Usuarios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneUsuarios(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/UsuarioTabla.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Modificar Usuario.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneModifyUsuario(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/UsuarioModify.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Tareas.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneTareas(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/TareaTabla.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Modificar Tareas.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneModifyTarea(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/TareaModify.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Premios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToScenePremios(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/PremioTabla.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena Modificar Premios.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void switchToSceneModifyPremios(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/PremioModify.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
