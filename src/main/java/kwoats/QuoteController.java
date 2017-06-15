package kwoats;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuoteController {
	private RandomNumberService randomNumberService = new RandomNumberService();
	private QuoteService quoteService = new QuoteService();

	@GetMapping
	public String get(HttpSession session, Model model) {
		Integer previousRandomIndex = (Integer) session.getAttribute("previousRandomIndex");

		int numberOfQuotes = quoteService.numberOfQuotes();
		int randomIndex = randomNumberService.pickRandomNumber(numberOfQuotes, previousRandomIndex);
		String randomQuote = quoteService.getQuoteAt(randomIndex);

		session.setAttribute("previousRandomIndex", randomIndex);

		// fill the model
		model.addAttribute("randomQuote", randomQuote);
		model.addAttribute("randomIndex", randomIndex);
		model.addAttribute("numberOfQuotes", numberOfQuotes);

		// forward to the view
		return "RandomQuote";
	}

	@PostMapping
	public String post(@RequestParam("newQuote") String newQuote, Model model) {
		quoteService.addNewQuote(newQuote);

		// fill the model
		model.addAttribute("allQuotes", quoteService.viewAllQuotes());

		// forward to the view
		return "AllQuotes";
	}
}
