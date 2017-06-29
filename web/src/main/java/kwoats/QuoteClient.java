package kwoats;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteClient {
	private static final String URL = "http://localhost:8080/kwoats-quotes";

	private RestTemplate restTemplate = new RestTemplate();

	public int numberOfQuotes() {
		return restTemplate.getForObject(URL + "/quotes/number", Integer.class);
	}

	public String getQuoteAt(int randomIndex) {
		return restTemplate.getForObject(URL + "/quotes/{index}", String.class, randomIndex);
	}

	public void addNewQuote(String newQuote) {
		restTemplate.put(URL + "/quotes/new", newQuote);
	}

	public List<String> viewAllQuotes() {
		ParameterizedTypeReference<List<String>> listOfString = new ParameterizedTypeReference<List<String>>() {
		};
		return restTemplate.exchange(URL + "/quotes", HttpMethod.GET, null, listOfString).getBody();
	}
}