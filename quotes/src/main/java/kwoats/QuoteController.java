package kwoats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
	@Autowired
	private QuoteService quoteService;

	@GetMapping("/quotes")
	public List<Quote> getAllQuotes() {
		return quoteService.viewAllQuotes();
	}

	@GetMapping("/quotes/number")
	public int getNumberOfQuotes() {
		return quoteService.numberOfQuotes();
	}

	@GetMapping("/quotes/{index}")
	public Quote getQuoteAt(@PathVariable("index") int index) {
		return quoteService.getQuoteAt(index);
	}

	@PutMapping("/quotes/new")
	public void put(@RequestBody Quote newQuote) {
		quoteService.addNewQuote(newQuote);
	}
}
