public class SecurityLevel {
	static SecurityLevel LOW = new SecurityLevel(0);
	static SecurityLevel HIGH = new SecurityLevel(1);

	public SecurityLevel(int level) {
		this.getDomination(level);
	}

	int getDomination(int level) {
		return level;
	}

}
