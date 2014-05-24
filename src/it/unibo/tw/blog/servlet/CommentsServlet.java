package it.unibo.tw.blog.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Vector;

public class CommentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		Vector<String> comments = new Vector<String>();
		this.getServletContext().setAttribute("comments", comments);
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
		if (action != null) {
			@SuppressWarnings("unchecked")
			Vector<String> comments = (Vector<String>) this.getServletContext()
					.getAttribute("comments");
			if (action.equals("view")) {
				req.setAttribute("comments", comments);
			} else if (action.equals("add")) {
				String newComment = req.getParameter("comment");
				if (newComment != null && newComment.length() != 0) {
					comments.add(newComment);
				}
			}
		}

		// Servlet side redirect (forward)
		RequestDispatcher dispatcher = getServletContext()
				// When redirecting servlet-side, use RELATIVE PATH
				.getRequestDispatcher("/blog/view");
		dispatcher.forward(req, resp);
	}
}