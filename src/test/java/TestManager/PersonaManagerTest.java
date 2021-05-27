package TestManager;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.dao.Persona;
import bdtaskapp.edu.fpdual.manager.PersonaManager;

/**
 * Manager Test para la tabla Persona
 * 
 * @author Jairo Buendia
 *
 */

public class PersonaManagerTest {

	@Test
	void testFindAllPersona() throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		try {
			List<Persona> persona = new PersonaManager().findAll(con);
			assertNotNull(persona);
			System.out.println("--- Correcto funcionamiento de findAll en PersonaManager ---");

		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
