package controller;

import view.*;

/**
 * The AgendaController built to invoke the application by embeding the view
 * that cointains it.
 * 
 * @author Diana Baltrusaitis
 *
 */
public class AgendaController {
	private static Agenda app;

	/**
	 * Invoke application and call basic procedure to populate contact list
	 * 
	 * @return Agenda
	 */
	public static Agenda run() {
		app = new Agenda();
		app.populateContactsList();
		return app;
	}
}
