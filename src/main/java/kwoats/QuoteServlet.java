package kwoats;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuoteServlet")
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RandomNumberService randomNumberService = new RandomNumberService();
	private QuoteService quoteService = new QuoteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer previousRandomIndex = (Integer) session.getAttribute("previousRandomIndex");

		int numberOfQuotes = quoteService.numberOfQuotes();
		int randomIndex = randomNumberService.pickRandomNumber(numberOfQuotes, previousRandomIndex);
		String randomQuote = quoteService.getQuoteAt(randomIndex);

		session.setAttribute("previousRandomIndex", randomIndex);

		// fill the model
		request.setAttribute("randomQuote", randomQuote);
		request.setAttribute("randomIndex", randomIndex);
		request.setAttribute("numberOfQuotes", numberOfQuotes);

		// forward to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RandomQuote.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newQuote = request.getParameter("newQuote");
		quoteService.addNewQuote(newQuote);

		// fill the model
		request.setAttribute("allQuotes", quoteService.viewAllQuotes());

		// forward to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllQuotes.jsp");
		dispatcher.forward(request, response);
	}
}
