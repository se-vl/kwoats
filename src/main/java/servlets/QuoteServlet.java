package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

	private static final String[] wordsOfWisdom = {
			"Multicore processors are just now [May 2006] becoming inexpensive enough for midrange desktop systems. Not coincidentally, many development teams are noticing more and more threading-related bug reports in their projects.",
			"In a recent post on the Netbeans developer site, one of the core maintainers observed that a single class had been patched over 14 times to fix threading-related problems.",
			"Dion Almaer, former editor of TheServerSide, recently blogged (after a painful debugging session that ultimately revealed a threading bug) that most Java programs are so rife with concurrency bugs that they work only 'by accident'.",
			"It is all too easy to create programs that compile and appear to work but are nevertheless broken.",
			"It would be nice to believe that concurrency is an 'optional' or 'advanced' language feature, but the reality is that nearly all Java applications are multithreaded and these frameworks do not insulate you from the need to properly coordinate access to application state.",
			"Whenever more than one thread accesses a given state variable, and one of them might write to it, they all must coordinate their access to it using synchronization. You should avoid the temptation to think that there are 'special' situations in which this rule does not apply.",
			"A program that omits needed synchronization might appear to work, passing its tests and performing well for years, but it is still broken and may fail at any moment.", };

	private List<String> allQuotes = new ArrayList<>(Arrays.asList(wordsOfWisdom));

	private Random randomNumberGenerator = new Random();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numberOfQuotes = allQuotes.size();
		int randomIndex;
		HttpSession session = request.getSession();
		Integer previousRandomIndex = (Integer) session.getAttribute("previousRandomIndex");
		if (previousRandomIndex == null) {
			randomIndex = randomNumberGenerator.nextInt(numberOfQuotes);
		} else {
			randomIndex = randomNumberGenerator.nextInt(numberOfQuotes - 1);
			if (randomIndex == previousRandomIndex) {
				randomIndex = numberOfQuotes - 1;
			}
		}
		session.setAttribute("previousRandomIndex", randomIndex);
		String randomQuote = allQuotes.get(randomIndex);

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
		allQuotes.add(newQuote);

		// fill the model
		request.setAttribute("allQuotes", allQuotes);

		// forward to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllQuotes.jsp");
		dispatcher.forward(request, response);
	}
}
