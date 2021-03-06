package kwoats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	@Autowired
	private RandomNumberClient randomNumberClient;

	@Autowired
	private QuoteClient quoteClient;

	@Autowired
	private SessionState sessionState;

	@GetMapping
	public String get(Model model) {
		Integer previousRandomIndex = sessionState.getPreviousRandomIndex();

		int numberOfQuotes = quoteClient.numberOfQuotes();
		int randomIndex = randomNumberClient.pickRandomNumber(numberOfQuotes, previousRandomIndex);
		Quote randomQuote = quoteClient.getQuoteAt(randomIndex);

		sessionState.setPreviousRandomIndex(randomIndex);

		// fill the model
		model.addAttribute("randomQuote", randomQuote);
		model.addAttribute("randomIndex", randomIndex);
		model.addAttribute("numberOfQuotes", numberOfQuotes);

		// forward to the view
		return "RandomQuote";
	}

	@PostMapping
	public String post(@RequestParam("text") String text, @RequestParam("author") String author,
			@RequestParam("year") int year, Model model) {
		quoteClient.addNewQuote(new Quote(text, author, year));

		// fill the model
		model.addAttribute("allQuotes", quoteClient.viewAllQuotes());

		// forward to the view
		return "AllQuotes";
	}
}
