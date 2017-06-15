package kwoats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {
	private static final String[] wordsOfWisdom = {
			"Multicore processors are just now [May 2006] becoming inexpensive enough for midrange desktop systems. Not coincidentally, many development teams are noticing more and more threading-related bug reports in their projects.",
			"In a recent post on the Netbeans developer site, one of the core maintainers observed that a single class had been patched over 14 times to fix threading-related problems.",
			"Dion Almaer, former editor of TheServerSide, recently blogged (after a painful debugging session that ultimately revealed a threading bug) that most Java programs are so rife with concurrency bugs that they work only 'by accident'.",
			"It is all too easy to create programs that compile and appear to work but are nevertheless broken.",
			"It would be nice to believe that concurrency is an 'optional' or 'advanced' language feature, but the reality is that nearly all Java applications are multithreaded and these frameworks do not insulate you from the need to properly coordinate access to application state.",
			"Whenever more than one thread accesses a given state variable, and one of them might write to it, they all must coordinate their access to it using synchronization. You should avoid the temptation to think that there are 'special' situations in which this rule does not apply.",
			"A program that omits needed synchronization might appear to work, passing its tests and performing well for years, but it is still broken and may fail at any moment.", };

	private List<String> allQuotes = new ArrayList<>(Arrays.asList(wordsOfWisdom));

	public int numberOfQuotes() {
		return allQuotes.size();
	}

	public String getQuoteAt(int randomIndex) {
		return allQuotes.get(randomIndex);
	}

	public void addNewQuote(String newQuote) {
		allQuotes.add(newQuote);
	}

	public List<String> viewAllQuotes() {
		return Collections.unmodifiableList(allQuotes);
	}
}
