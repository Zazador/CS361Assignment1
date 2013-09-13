public class SecurityLevel {
	
	int domination;
	static SecurityLevel HIGH = new SecurityLevel(1);
	static SecurityLevel LOW = new SecurityLevel(0);

	public SecurityLevel(int level) {
		domination = level;
	}
	
	int getDomination() {
		return domination;
	}

}
