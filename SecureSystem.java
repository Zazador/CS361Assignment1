import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SecureSystem {
	ReferenceMonitor refMon = new ReferenceMonitor();
	static InstructionObject instrobj;
	static HashMap<String, SecurityLevel> subjectManager = new HashMap<String, SecurityLevel>();

	public static void main(String[] args) throws FileNotFoundException {

		SecureSystem sys = new SecureSystem(args[0]);
		File file2 = new File(args[0]);

		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);

		sys.getReferenceMonitor().createNewObject("LObj", low);
		sys.getReferenceMonitor().createNewObject("HObj", high);

		Scanner scan = new Scanner(file2);
		while (scan.hasNextLine()) {
			String curLine = scan.nextLine();
			instrobj = new InstructionObject(curLine);
			printState();
		}
		scan.close();
	}

	public SecureSystem(String fileName) throws FileNotFoundException {
		File file1 = new File(fileName);
		System.out.println("Reading from file: " + file1);
		System.out.println();
	}

	void createSubject(String name, SecurityLevel secLev) {
		subjectManager.put(name, secLev);
	}
	
	public static HashMap<String, SecurityLevel> getSubjectManager() {
		return subjectManager;
	}

	public ReferenceMonitor getReferenceMonitor() {
		return refMon;
	}

	static void printState() {
		if (instrobj.getInstruction().equals("BAD")) {
			System.out.println("Bad Instruction");
			System.out.println("The current state is: ");
			System.out.println("   LObj has value: "
					+ ReferenceMonitor.getValueManager().get("LObj"));
			System.out.println("   HObj has value: "
					+ ReferenceMonitor.getValueManager().get("HObj"));
			System.out.println("   Lyle has recently read: "
					+ ReferenceMonitor.getReadManager().get("Lyle"));
			System.out.println("   Hal has recently read: "
					+ ReferenceMonitor.getReadManager().get("Hal"));
			System.out.println();
		}
		else if (instrobj.getInstruction().equals("READ")) {
			System.out.println(instrobj.getSubject() + " reads " + instrobj.getObject());
			System.out.println("The current state is: ");
			System.out.println("   LObj has value: "
					+ ReferenceMonitor.getValueManager().get("LObj"));
			System.out.println("   HObj has value: "
					+ ReferenceMonitor.getValueManager().get("HObj"));
			System.out.println("   Lyle has recently read: "
					+ ReferenceMonitor.getReadManager().get("Lyle"));
			System.out.println("   Hal has recently read: "
					+ ReferenceMonitor.getReadManager().get("Hal"));
			System.out.println();
		}
		else if (instrobj.getInstruction().equals("WRITE")) {
			System.out.println(instrobj.getSubject() + " writes value " + instrobj.getValue() +
					" to " + instrobj.getObject());
			System.out.println("The current state is: ");
			System.out.println("   LObj has value: "
					+ ReferenceMonitor.getValueManager().get("LObj"));
			System.out.println("   HObj has value: "
					+ ReferenceMonitor.getValueManager().get("HObj"));
			System.out.println("   Lyle has recently read: "
					+ ReferenceMonitor.getReadManager().get("Lyle"));
			System.out.println("   Hal has recently read: "
					+ ReferenceMonitor.getReadManager().get("Hal"));
			System.out.println();
		}
	}
	}

