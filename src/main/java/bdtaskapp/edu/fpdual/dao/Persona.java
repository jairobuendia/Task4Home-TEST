package bdtaskapp.edu.fpdual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Tabla Persona.
 *
 * @author Jairo Buendia
 */
public class Persona {

	/** The cod usuario. */
	public String codUsuario;
	
	/** The nick. */
	String nick;
	
	/** The total puntos. */
	String totalPuntos;
	
	/** The edad. */
	String edad;
	
	/** The correo. */
	String correo;
	
	/** The contra. */
	String contra;


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Persona [codUsuario=" + codUsuario + ", nick=" + nick + ", totalPuntos=" + totalPuntos + ", edad="
				+ edad + ", correo=" + correo + ", contra=" + contra + "]";
	}

	/**
	 * Instantiates a new persona.
	 */
	public Persona() {
		super();
	}

	/**
	 * Constructor dao para la tabla Persona.
	 *
	 * @param result Entrada de tipo ResultSet
	 */
	public Persona(ResultSet result) {
		try {
			this.codUsuario = result.getString("CodUsuario");
			this.nick = result.getString("Nick");
			this.totalPuntos = result.getString("TotalPuntos");
			this.edad = result.getString("Edad");
			this.correo = result.getString("Correo");
			this.contra = result.getString("Contraseña");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	/**
	 * Gets the cod usuario.
	 *
	 * @return the cod usuario
	 */
	public String getCodUsuario() {
		return codUsuario;
	}

	/**
	 * Sets the cod usuario.
	 *
	 * @param codUsuario the new cod usuario
	 */
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	/**
	 * Gets the nick.
	 *
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * Sets the nick.
	 *
	 * @param nick the new nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * Gets the total puntos.
	 *
	 * @return the total puntos
	 */
	public String getTotalPuntos() {
		return totalPuntos;
	}

	/**
	 * Sets the total puntos.
	 *
	 * @param totalPuntos the new total puntos
	 */
	public void setTotalPuntos(String totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Gets the contra.
	 *
	 * @return the contra
	 */
	public String getContra() {
		return contra;
	}

	/**
	 * Sets the contra.
	 *
	 * @param contra the new contra
	 */
	public void setContra(String contra) {
		this.contra = contra;
	}

}
