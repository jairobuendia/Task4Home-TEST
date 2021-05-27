package TestManager;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bdtaskapp.edu.fpdual.conector.Conector;
import bdtaskapp.edu.fpdual.dao.Tarea;
import bdtaskapp.edu.fpdual.manager.TareaManager;

/**
 * Manager Test para la tabla Tarea
 * 
 * @author Jairo Buendia
 *
 */

public class TareaManagerTest {

	@Test
	void testFindAllTarea() throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		try {
			List<Tarea> tarea = new TareaManager().findAll(con);
			assertNotNull(tarea);
			System.out.println("--- Correcto funcionamiento de findAll en TareaManager ---");

		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}