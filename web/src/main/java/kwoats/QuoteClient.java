package kwoats;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteClient {
	@Value("${kwoats.quotes.url}")
	private String URL;

	private RestTemplate restTemplate = new RestTemplate();

	public int numberOfQuotes() {
		return restTemplate.getForObject(URL + "/quotes/number", Integer.class);
	}

	public Quote getQuoteAt(int randomIndex) {
		return restTemplate.getForObject(URL + "/quotes/{index}", Quote.class, randomIndex);
	}

	public void addNewQuote(Quote newQuote) {
		restTemplate.put(URL + "/quotes/new", newQuote);
	}

	public List<Quote> viewAllQuotes() {
		ParameterizedTypeReference<List<Quote>> listOfQuote = new ParameterizedTypeReference<List<Quote>>() {
		};
		return restTemplate.exchange(URL + "/quotes", HttpMethod.GET, null, listOfQuote).getBody();
	}
}
