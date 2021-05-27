package bdtaskapp.edu.fpdual.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

/**
 * Tabla Tarea.
 *
 * @author Jairo Buendia
 */

public class Tarea {

	/** The Cod tarea. */
	String CodTarea;
	
	/** The nombre. */
	String nombre;
	
	/** The fecha realizar. */
	String fechaRealizar;
	
	/** The puntos. */
	String puntos;
	
	/** The cod usuario. */
	Persona codUsuario;

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Tarea [CodTarea=" + CodTarea + ", nombre=" + nombre + ", fechaRealizar=" + fechaRealizar + ", puntos="
				+ puntos + "]";
	}

	/**
	 * Instantiates a new tarea.
	 */
	// Constructor vacío
	public Tarea() {
		super();
	}

	/**
	 * Constructor dao para la tabla Tarea.
	 *
	 * @param result Entrada de tipo ResultSet
	 */
	public Tarea(ResultSet result) {
		try {
			this.CodTarea = result.getString("CodTarea");
			this.nombre = result.getString("Nombre");
			this.fechaRealizar = result.getString("FechaRealizar");
			this.puntos = result.getString("Puntos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the cod tarea.
	 *
	 * @return the cod tarea
	 */
	// Getters and setters
	public String getCodTarea() {
		return CodTarea;
	}

	/**
	 * Sets the cod tarea.
	 *
	 * @param codTarea the new cod tarea
	 */
	public void setCodTarea(String codTarea) {
		CodTarea = codTarea;
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
	 * Gets the fecha realizar.
	 *
	 * @return the fecha realizar
	 */
	public String getFechaRealizar() {
		return fechaRealizar;
	}

	/**
	 * Sets the fecha realizar.
	 *
	 * @param fechaRealizar the new fecha realizar
	 */
	public void setFechaRealizar(String fechaRealizar) {
		this.fechaRealizar = fechaRealizar;
	}

	/**
	 * Gets the puntos.
	 *
	 * @return the puntos
	 */
	public String getPuntos() {
		return puntos;
	}

	/**
	 * Sets the puntos.
	 *
	 * @param puntos the new puntos
	 */
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}

	/**
	 * Gets the cod usuario.
	 *
	 * @return the cod usuario
	 */
	public Persona getCodUsuario() {
		return codUsuario;
	}

	/**
	 * Sets the cod usuario.
	 *
	 * @param codUsuario the new cod usuario
	 */
	public void setCodUsuario(Persona codUsuario) {
		this.codUsuario = codUsuario;
	}

}
