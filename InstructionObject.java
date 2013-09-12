public class InstructionObject {

	private String instruction;
	private String subject;
	private String object;
	private int value;

	public InstructionObject(String instr) {
		String[] myLine = instr.split(" ");
		if ((myLine.length != 4 && myLine[0].equals("write"))
				|| (myLine.length != 3 && myLine[0].equals("read"))) {
			System.out.println("Bad Instruction");
		}
		if (myLine[0].equals("read") == false
				&& myLine[0].equals("write") == false) {
			System.out.println("Bad Instruction");
		}
		if (myLine[1].equals("Hal") == false
				&& myLine[1].equals("Lyle") == false) {
			System.out.println("Bad Instruction");
		}
		if (myLine[2].equals("LObj") == false
				&& myLine[2].equals("HObj") == false) {
			System.out.println("Bad Instruction");
		}
		
		if (myLine[0].equals("read")) {
			this.instruction = myLine[0];
			this.subject = myLine[1];
			this.object = myLine[2];
		}
		else if (myLine[0].equals("write")) {
			this.instruction = myLine[0];
			this.subject = myLine[1];
			this.object = myLine[2];
			this.value = Integer.parseInt(myLine[3]);
		}

	}
	
	/*public BadInstructionObject() {
	
	}*/
	
	public String getInstruction() {
		return this.instruction;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getObject() {
		return this.object;
	}
	
	public int getValue() {
		return this.value;
	}

}
