package it.unibo.tw.library.servlet;

import it.unibo.tw.library.beans.Request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Vector;
import java.util.regex.Pattern;

public class RequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		Vector<Request> requests = new Vector<Request>();
		this.getServletContext().setAttribute("comments", requests);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		HttpSession session = req.getSession(true);
		@SuppressWarnings("unchecked")
		Vector<Request> sessionReq = (Vector<Request>) session.getAttribute("requests");
		if(sessionReq == null) {
			sessionReq = new Vector<Request>();
		}
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Results</title></head><body><h1>");
		if ("request".equals(action)) {
			String cf = req.getParameter("cf"), surname = req.getParameter("surname"), title = req.getParameter("title"),
					collectionDate = req.getParameter("collectionDate"), returnDate = req.getParameter("returnDate");
			if(!Pattern.matches("[0-9]{2}[0-9]{2}", returnDate) || !Pattern.matches("[0-9]{2}[0-9]{2}", collectionDate)) {
				out.print("Invalid date format<br />");
				out.println("<a href=\"#\" onclick=\"history.back(); return false;\">Go back to insert page</a>");
				out.println("</body></html>");
				return;
			}
			Request newReq = new Request(cf, surname, title, returnDate, collectionDate);
			for(Request r : sessionReq) {
				if(r.equals(newReq)) {
					out.print("You can't request the same book more than once<br />");
					out.println("<a href=\"#\" onclick=\"history.back(); return false;\">Go back to insert page</a>");
					out.println("</body></html>");
					return;
				}
			}
			sessionReq.add(newReq);
			session.setAttribute("requests", sessionReq);
			out.println("Insert OK</h1><br />");
			out.println("<a href=\"#\" onclick=\"history.back(); return false;\">Go back to insert page</a>");
			out.println("</body></html>");
		} else if("finalize".equals(action)) {
			this.getServletContext().setAttribute("requests", sessionReq);
			out.println("Successfully added to servlet.</h1><br />");
			out.println("<a href=\"#\" onclick=\"history.back(); return false;\">Go back to insert page</a>");
			out.println("</body></html>");
		}
	}
}