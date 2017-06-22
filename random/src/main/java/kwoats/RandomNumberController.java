package kwoats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {
	@Autowired
	private RandomNumberService randomNumberService;

	@GetMapping
	public int get(@RequestParam("bound") int bound,
			@RequestParam(name = "prev", required = false) Integer previousRandomNumber) {
		return randomNumberService.pickRandomNumber(bound, previousRandomNumber);
	}
}
