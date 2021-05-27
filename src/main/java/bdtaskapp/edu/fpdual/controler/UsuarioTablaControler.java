package bdtaskapp.edu.fpdual.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.dao.Persona;
import bdtaskapp.edu.fpdual.manager.PersonaManager;
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
 * Controlador lista usuarios.
 *
 * @author Jairo Buendia
 */
public class UsuarioTablaControler {

	/** The Exit. */
	@FXML
	private Button Exit;
	
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
	// Columnas de la tabla
	@FXML
	private TableView<Persona> tabla;
	
	/** The edad col. */
	@FXML
	private TableColumn<Persona, String> edadCol;
	
	/** The correo col. */
	@FXML
	private TableColumn<Persona, String> correoCol;
	
	/** The nick col. */
	@FXML
	private TableColumn<Persona, String> nickCol;
	
	/** The total puntos col. */
	@FXML
	private TableColumn<Persona, String> totalPuntosCol;
	
	/** The cod usuario col. */
	@FXML
	private TableColumn<Persona, String> codUsuarioCol;

	/** The box. */
	@FXML
	private ChoiceBox<String> box = new ChoiceBox<String>();

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
	public void makeTable(List<Persona> lista) {
		ObservableList<Persona> listaObservable = FXCollections.observableArrayList(lista);
		tabla.setItems(listaObservable);

		codUsuarioCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCodUsuario()));
		nickCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNick()));
		totalPuntosCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTotalPuntos()));
		edadCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEdad()));
		correoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCorreo()));
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
		List<Persona> lista = new PersonaManager().findAll(con);
		con.close();
		makeTable(lista);
		box.setItems(FXCollections.observableArrayList("All", "Nick", "Edad"));
		box.setValue("All");
	}

	/**
	 * Busca en la barra de búsqueda.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@FXML
	public void searchBy() throws ClassNotFoundException, SQLException {
		if (box.getValue().equals("Nick")) {
			Connection con = new Conector().getMySQLConnection();
			List<Persona> lista = new PersonaManager().findByNick(con, searchBar.getText());
			con.close();
			makeTable(lista);
		} else if (box.getValue().equals("Edad")) {
			Connection con = new Conector().getMySQLConnection();
			List<Persona> lista = new PersonaManager().findByEdad(con, searchBar.getText());
			con.close();
			makeTable(lista);
		} else if (box.getValue().equals("All")) {
			Connection con = new Conector().getMySQLConnection();
			List<Persona> lista = new PersonaManager().findAll(con);
			con.close();
			makeTable(lista);
		}
	}

	/**
	 * Nos lleva a la escena Modificar usuario.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void handleModify(ActionEvent event) throws IOException {
		if (event.getSource() == modify) {
			escena.switchToSceneModifyUsuario(event);
		}
	}

}
