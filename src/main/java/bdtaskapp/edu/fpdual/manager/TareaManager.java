package bdtaskapp.edu.fpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bdtaskapp.edu.fpdual.dao.Tarea;

/**
 * Manager para la tabla tarea.
 *
 * @author Jairo Buendia
 */
public class TareaManager {

	/**
	 * Find all.
	 *
	 * @param con Conexion base de datos
	 * @return Todas las tareas
	 */
	public List<Tarea> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM tarea");
			result.beforeFirst();

			List<Tarea> tareas = new ArrayList<>();

			while (result.next()) {
				tareas.add(new Tarea(result));
			}
			return tareas;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Borra un registro de tarea(buscamos por nombre).
	 *
	 * @param con  Conexion base de datos
	 * @param name nombre tarea
	 */
	public void deleteTarea(Connection con, String name) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM tarea WHERE Nombre = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, name);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Modifica una tarea existente.
	 *
	 * @param con        Conexion base de datos
	 * @param newName    Nuevo nombre
	 * @param FechaReali Modifica la fecha a realizar
	 * @param Puntos     Modifica los puntos que da la tarea
	 * @param CodTarea   a modificar
	 */
	public void modifyTarea(Connection con, String newName, String FechaReali, String Puntos, String CodTarea) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE tarea SET Nombre=?, FechaRealizar=?, Puntos=? where CodTarea=?")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, newName);
			prepStmt.setString(2, FechaReali);
			prepStmt.setString(3, Puntos);
			prepStmt.setString(4, CodTarea);

			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	/**
	 * Crea una nueva tarea.
	 *
	 * @param con        Conexion base de datos
	 * @param nombre     String nombre
	 * @param fechaReali String FechaReali
	 * @param puntos the puntos
	 */
	public void createTarea(Connection con, String nombre, String fechaReali, String puntos) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO tarea (Nombre, FechaRealizar, Puntos) VALUES (?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, nombre);
			prepStmt.setString(2, fechaReali);
			prepStmt.setString(3, puntos);

			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
