public class InstructionObject {

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

	}

}
