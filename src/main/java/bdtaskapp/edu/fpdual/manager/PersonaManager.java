package bdtaskapp.edu.fpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bdtaskapp.edu.fpdual.dao.Persona;

/**
 * Administra la tabla Persona.
 *
 * @author Jairo Buendia
 */

public class PersonaManager {
	
	/**
	 * Find all.
	 *
	 * @param con Conexion base de datos
	 * @return Todos los usuarios
	 */
	public List<Persona> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM persona");
			result.beforeFirst();

			List<Persona> personas = new ArrayList<>();

			while (result.next()) {
				personas.add(new Persona(result));
			}
			return personas;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Find login user.
	 *
	 * @param con      Conexion base de datos
	 * @param username nombre usuario
	 * @return Nos devuelve el username
	 */
	public String findLoginUser(Connection con, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("select nick from persona where nick = ?")) {

			prepStmt.setString(1, username);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("nick");

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Find login password.
	 *
	 * @param con      Conexion base de datos
	 * @param username nombre usuario
	 * @return Nos devuelve la password
	 */
	public String findLoginPassword(Connection con, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("select contraseña from persona where nick = ?")) {

			prepStmt.setString(1, username);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("contraseña");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un nuevo usuario.
	 *
	 * @param con      Conexion base de datos
	 * @param email    String correo
	 * @param username String nick
	 * @param password String contraseña
	 * @param edad     int edad
	 */
	public void createUsuario(Connection con, String email, String username, String password, String edad) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO persona (Correo, Nick, Contraseña, Edad) VALUES (?, ?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, email);
			prepStmt.setString(2, username);
			prepStmt.setString(3, password);
			prepStmt.setString(4, edad);

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
	 * Modifica un usuario existente.
	 *
	 * @param con        Conexion base de datos
	 * @param newNick    Nuevo nombre de usuario (nick)
	 * @param Edad       Modificar la edad
	 * @param Correo     Modificar el correo
	 * @param CodUsuario a modificar
	 */
	public void modifyUsuario(Connection con, String newNick, String Edad, String Correo, String CodUsuario) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE persona SET Nick=?, Edad=?, Correo=? where CodUsuario=?")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, newNick);
			prepStmt.setString(2, Edad);
			prepStmt.setString(3, Correo);
			prepStmt.setString(4, CodUsuario);

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
	 * Borra un registro de usuario(buscamos por nombre).
	 *
	 * @param con      Conexion base de datos
	 * @param username nombre usuario
	 */
	public void deleteUsuario(Connection con, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM persona WHERE nick = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, username);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Busca usuarios por Nick.
	 *
	 * @param con    Conexion base de datos
	 * @param nombre String Nombre por el que busca
	 * @return Lista de todas los Usuarios por nick
	 */
	public List<Persona> findByNick(Connection con, String nombre) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM persona WHERE Nick LIKE ?")) {
			prepStmt.setString(1, "%" + nombre + "%");
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Persona> usuario = new ArrayList<>();

			while (result.next()) {
				usuario.add(new Persona(result));
			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Busca usuarios por Edad.
	 *
	 * @param con  Conexion base de datos
	 * @param edad String Edad por la que busca
	 * @return Lista de todas los Usuarios por edad
	 */
	public List<Persona> findByEdad(Connection con, String edad) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM persona WHERE Edad LIKE ?")) {
			prepStmt.setString(1, "%" + edad + "%");
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Persona> usuario = new ArrayList<>();

			while (result.next()) {
				usuario.add(new Persona(result));
			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Busca usuarios por Codigo.
	 *
	 * @param con    Conexion base de datos
	 * @param codigo String Codigo por el que busca
	 * @return Usuario con ese codigo
	 */
	public List<Persona> findByCodigo(Connection con, String codigo) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM persona WHERE CodUsuario LIKE ?")) {
			prepStmt.setString(1, codigo);
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Persona> usuario = new ArrayList<>();

			while (result.next()) {
				usuario.add(new Persona(result));
			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Te da el nombre del usuario.
	 *
	 * @param con        Conexion base de datos
	 * @param CodUsuario String Codigo de usuario a buscar
	 * @return Nick con ese codigo
	 * @throws SQLException the SQL exception
	 */
	public String searchNickId(Connection con, String CodUsuario) throws SQLException {
		Statement orden = con.createStatement();
		ResultSet res;
		String tuVariable;

		res = orden.executeQuery("SELECT Nick FROM persona WHERE CodUsuario = " + CodUsuario);

		res.next();
		tuVariable = res.getString("Nick");
		return tuVariable;
	}

}
