package bdtaskapp.edu.fpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bdtaskapp.edu.fpdual.dao.Premio;

/**
 * Manager para la tabla premio.
 *
 * @author Jairo Buendia
 */
public class PremioManager {

	/**
	 * Find all.
	 *
	 * @param con Conexion base de datos
	 * @return Todos los premios
	 */
	public List<Premio> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM premio");
			result.beforeFirst();

			List<Premio> premios = new ArrayList<>();

			while (result.next()) {
				premios.add(new Premio(result));
			}
			return premios;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Borra un registro de premio(buscamos por nombre).
	 *
	 * @param con  Conexion base de datos
	 * @param name nombre premio
	 */
	public void deletePremio(Connection con, String name) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM premio WHERE Nombre = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, name);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Modifica un premio existente.
	 *
	 * @param con        Conexion base de datos
	 * @param newName    Nuevo nombre
	 * @param fechaExpi  Modifica la fecha de expiracion
	 * @param Puntos     Modifica los puntos que cuesta el premio
	 * @param CodPremio  a modificar
	 */
	public void modifyPremio(Connection con, String newName, String fechaExpi, String Puntos, String CodPremio) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE premio SET Nombre=?, FechaExpi=?, PuntosCoste=? where CodPremio=?")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, newName);
			prepStmt.setString(2, fechaExpi);
			prepStmt.setString(3, Puntos);
			prepStmt.setString(4, CodPremio);

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
	 * Crea un nuevo premio.
	 *
	 * @param con       Conexion base de datos
	 * @param nombre    String nombre
	 * @param fechaExpi String FechaReali
	 * @param puntos    String puntos
	 */
	public void createPremio(Connection con, String nombre, String fechaExpi, String puntos) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO premio (Nombre, FechaExpi, PuntosCoste) VALUES (?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, nombre);
			prepStmt.setString(2, fechaExpi);
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
