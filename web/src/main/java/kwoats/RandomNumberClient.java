package kwoats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomNumberClient {
	@Value("${kwoats.random.url}")
	private String URL;

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
