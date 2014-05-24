package it.unibo.tw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Hashtable;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7437071575710203911L;
	public final static String LOGIN_OK = "login_ok";
	private static String LOGIN_NEXT = "/edit";
	private final String LOGIN_FORM = "/pages/login.jsp";

	@Override
	public void init() throws ServletException {
		Hashtable<String, String> users = new Hashtable<String, String>();
		users.put("user1", "pass1");
		users.put("user2", "pass2");
		this.getServletContext().setAttribute("users", users);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// next rewrite
		String next = (String) req.getParameter("next");
		if (next != null) { // on login success
			LOGIN_NEXT = next;
		} else {
			LOGIN_NEXT = "/edit"; // default
		}
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		Boolean logged = (Boolean) session.getAttribute(LOGIN_OK);

		if (logged != null && logged) { // already logged in
			// change url
			resp.sendRedirect(req.getContextPath() + LOGIN_NEXT);
			return;
		} else {
			session.setAttribute(LOGIN_OK, false);
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && password != null) {
			session.setAttribute(LOGIN_OK, check(username, password));
		}

		logged = (Boolean) session.getAttribute(LOGIN_OK);
		if (!logged) {
			resp.sendRedirect(req.getContextPath() + LOGIN_FORM
					+ "?failed=1&next=" + LOGIN_NEXT);
		} else { // change url
			resp.sendRedirect(req.getContextPath() + LOGIN_NEXT);
		}
	}

	private boolean check(String username, String password) {
		@SuppressWarnings("unchecked")
		Hashtable<String, String> users = (Hashtable<String, String>) this
				.getServletContext().getAttribute("users");
		String storedPassword = users.get(username);
		return storedPassword != null && storedPassword.equals(password);
	}
}