package bdtaskapp.edu.fpdual.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

/**
 * Tabla Premio.
 *
 * @author Jairo Buendia
 */
public class Premio {

	/** The Cod premio. */
	String CodPremio;
	
	/** The nombre. */
	String nombre;
	
	/** The Puntos coste. */
	String PuntosCoste;
	
	/** The fecha. */
	String fecha;
	
	/** The edad. */
	String edad;
	
	/** The Cod usuario. */
	Persona CodUsuario;

	// Metodo toString

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Premio [CodPremio=" + CodPremio + ", nombre=" + nombre + ", PuntosCoste=" + PuntosCoste + ", fecha="
				+ fecha + ", edad=" + edad + ", CodUsuario=" + CodUsuario + "]";
	}

	/**
	 * Instantiates a new premio.
	 */
	// Constructor vacío
	public Premio() {
		super();
	}

	/**
	 * Constructor dao para la tabla Premio.
	 *
	 * @param result Entrada de tipo ResultSet
	 */
	public Premio(ResultSet result) {
		try {
			this.CodPremio = result.getString("CodPremio");
			this.nombre = result.getString("Nombre");
			this.fecha = result.getString("FechaExpi");
			this.PuntosCoste = result.getString("PuntosCoste");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Getters and setters

	/**
	 * Gets the cod premio.
	 *
	 * @return the cod premio
	 */
	public String getCodPremio() {
		return CodPremio;
	}

	/**
	 * Sets the cod premio.
	 *
	 * @param codPremio the new cod premio
	 */
	public void setCodPremio(String codPremio) {
		CodPremio = codPremio;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the puntos coste.
	 *
	 * @return the puntos coste
	 */
	public String getPuntosCoste() {
		return PuntosCoste;
	}

	/**
	 * Sets the puntos coste.
	 *
	 * @param puntosCoste the new puntos coste
	 */
	public void setPuntosCoste(String puntosCoste) {
		PuntosCoste = puntosCoste;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	 * Gets the cod usuario.
	 *
	 * @return the cod usuario
	 */
	public Persona getCodUsuario() {
		return CodUsuario;
	}

	/**
	 * Sets the cod usuario.
	 *
	 * @param codUsuario the new cod usuario
	 */
	public void setCodUsuario(Persona codUsuario) {
		CodUsuario = codUsuario;
	}

}
