package kwoats;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionState {
	private Integer previousRandomIndex;

	public Integer getPreviousRandomIndex() {
		return previousRandomIndex;
	}

	public void setPreviousRandomIndex(Integer previousRandomIndex) {
		this.previousRandomIndex = previousRandomIndex;
	}
}
