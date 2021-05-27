package bdtaskapp.edu.fpdual.controler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main.
 *
 * @author Jairo Buendia
 */

public class Main extends Application {

	/**
	 * Inicia la pantalla principal.
	 *
	 * @param stage the stage
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogin.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Task4Home");
			stage.show();
			// Pone un icono a la ventana
			stage.getIcons().add(new Image("images/Logo.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}