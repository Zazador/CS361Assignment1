import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SecureSystem {
	static ReferenceMonitor refMon = new ReferenceMonitor();
	static InstructionObject instrobj;

	public static void main(String[] args) throws FileNotFoundException {

		SecureSystem sys = new SecureSystem(args[0]);

		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);

		sys.getReferenceMonitor().createNewObject("Lobj", low);
		sys.getReferenceMonitor().createNewObject("Hobj", high);

		Scanner scan = new Scanner(args[0]);
		while (scan.hasNextLine()) {
			String curLine = scan.nextLine();
			instrobj = new InstructionObject(curLine);
			printState();
		}

		System.out.println("K DONE!");
	}

	public SecureSystem(String fileName) throws FileNotFoundException {
		File file1 = new File(fileName);
		System.out.println("Reading from file: " + file1);
		System.out.println();
	}

	void createSubject(String name, SecurityLevel secLev) {
		HashMap<String, SecurityLevel> subjectManager = new HashMap<String, SecurityLevel>();
		subjectManager.put(name, secLev);
	}

	public ReferenceMonitor getReferenceMonitor() {
		return refMon;
	}
	
	static void printState() {
		if (instrobj.getInstruction().equals("BAD")) {
			System.out.println("Bad Instruction");
			System.out.println("The current state is: ");
			System.out.println("LObj has value: ");
		}
	}

}