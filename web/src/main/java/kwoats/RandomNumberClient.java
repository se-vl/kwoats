package kwoats;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomNumberClient {
	private static final String URL = "http://localhost:8080/kwoats-random";

	private RestTemplate restTemplate = new RestTemplate();

	public int pickRandomNumber(int bound, Integer previousRandomNumber) {
		if (previousRandomNumber == null) {
			return restTemplate.getForObject(URL + "?bound={bound}", Integer.class, bound);
		} else {
			return restTemplate.getForObject(URL + "?bound={bound}&prev={prev}", Integer.class, bound,
					previousRandomNumber);
		}
	}
}
