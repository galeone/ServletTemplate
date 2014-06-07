package it.unibo.tw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyServlet extends HttpServlet {

	private static final long serialVersionUID = 9103338856018467773L;

	@Override
	public void init() {
		/*
		 * Inizializza se non esiste già un elemento che dura per tutta la
		 * durata di vita dell'applicazione
		 */

		/*
		 * Esempio: DummyDb Db =
		 * (FDummyDb)this.getServletContext().getAttribute("db"); if ( feedDb ==
		 * null ){ Db = new DummyDb();
		 * this.getServletContext().setAttribute("db", Db); }
		 */

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}
}
