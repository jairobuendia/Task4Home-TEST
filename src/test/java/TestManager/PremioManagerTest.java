package TestManager;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.dao.Premio;
import bdtaskapp.edu.fpdual.manager.PremioManager;

/**
 * Manager Test para la tabla Premio
 * 
 * @author Jairo Buendia
 *
 */

public class PremioManagerTest {

	@Test
	void testFindAllPremio() throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		try {
			List<Premio> premio = new PremioManager().findAll(con);
			assertNotNull(premio);
			System.out.println("--- Correcto funcionamiento de findAll en PremioManager ---");

		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}