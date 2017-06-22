package kwoats;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {
	private Random randomNumberGenerator = new Random();

	public int pickRandomNumber(int bound, Integer previousRandomNumber) {
		int randomNumber;
		if (previousRandomNumber == null) {
			randomNumber = randomNumberGenerator.nextInt(bound);
		} else {
			randomNumber = randomNumberGenerator.nextInt(bound - 1);
			if (randomNumber == previousRandomNumber) {
				randomNumber = bound - 1;
			}
		}
		return randomNumber;
	}
}
