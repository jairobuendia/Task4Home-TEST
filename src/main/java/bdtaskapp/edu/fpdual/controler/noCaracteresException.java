package bdtaskapp.edu.fpdual.controler;

/**
 * Excepci�n personalizada para cuando no se da ningun car�cter.
 *
 * @author Jairo Buendia
 */
public class noCaracteresException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new no caracteres exception.
	 *
	 * @param msg the msg
	 */
	public noCaracteresException(String msg) {
		super(msg);
	}

}
