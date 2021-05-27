package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.dao.Tarea;
import bdtaskapp.edu.fpdual.manager.TareaManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controlador para la tabla tarea.
 *
 * @author Jairo Buendia
 */

public class TareaTablaController {

	/** The escena. */
	@FXML
	private SceneController escena = new SceneController();

	/** The modify. */
	@FXML
	private Button modify;

	/** The search bar. */
	@FXML
	private TextField searchBar;

	/** The tabla. */
	@FXML
	private TableView<Tarea> tabla;

	/** The nombre col. */
	@FXML
	private TableColumn<Tarea, String> nombreCol;

	/** The puntos col. */
	@FXML
	private TableColumn<Tarea, String> puntosCol;

	/** The usuario asoc col. */
	@FXML
	private TableColumn<Tarea, String> usuarioAsocCol;

	/** The box. */
	@FXML
	private ChoiceBox<String> box = new ChoiceBox<String>();

	/** The fecha realizar col. */
	@FXML
	private TableColumn<Tarea, String> fechaRealizarCol;

	/** The Exit. */
	@FXML
	private Button Exit;

	/** The cod tarea col. */
	@FXML
	private TableColumn<Tarea, String> codTareaCol;

	/**
	 * Nos lleva a la escena Inicio.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleExit(ActionEvent event) throws IOException {
		if (event.getSource() == Exit) {
			escena.switchToSceneInicio(event);
		}
	}

	/**
	 * Rellena los campos de la TableView.
	 *
	 * @param lista Lista a partir de la que rellenar los campos de la tabla
	 */
	public void makeTable(List<Tarea> lista) {
		ObservableList<Tarea> listaObservable = FXCollections.observableArrayList(lista);
		tabla.setItems(listaObservable);

		codTareaCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCodTarea()));
		nombreCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
		fechaRealizarCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFechaRealizar()));
		puntosCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPuntos()));
		//usuarioAsocCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCodUsuario()));
	}

	/**
	 * Método para que la tabla se inicie.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@FXML
	public void initialize() throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		List<Tarea> lista = new TareaManager().findAll(con);
		con.close();
		makeTable(lista);
		box.setItems(FXCollections.observableArrayList("All"));
		box.setValue("All");
	}

	/**
	 * Search by.
	 *
	 * @param event the event
	 */
	@FXML
	void searchBy(ActionEvent event) {

	}

	/**
	 * Handle modify.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleModify(ActionEvent event) throws IOException {
		if (event.getSource() == modify) {
			escena.switchToSceneModifyTarea(event);
		}
	}

}
