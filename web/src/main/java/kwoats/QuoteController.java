package kwoats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuoteController {
	@Autowired
	private RandomNumberClient randomNumberClient;

	@Autowired
	private QuoteService quoteService;

	@Autowired
	private SessionState sessionState;

	@GetMapping
	public String get(Model model) {
		Integer previousRandomIndex = sessionState.getPreviousRandomIndex();

		int numberOfQuotes = quoteService.numberOfQuotes();
		int randomIndex = randomNumberClient.pickRandomNumber(numberOfQuotes, previousRandomIndex);
		String randomQuote = quoteService.getQuoteAt(randomIndex);

		sessionState.setPreviousRandomIndex(randomIndex);

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
