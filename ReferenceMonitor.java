import java.io.*;
import java.util.*;

public class ReferenceMonitor {
	
static HashMap<String, SecurityLevel> objectManager = new HashMap<String, SecurityLevel>();
static HashMap<String, Integer> valueManager = new HashMap<String, Integer>();
static HashMap<String, Integer> readManager = new HashMap<String, Integer>();

	public ReferenceMonitor() {
		HashMap<String, SecurityLevel> objectManager;
		HashMap<String, Integer> valueManager;
		readManager.put("Hal", 0);
		readManager.put("Lyle", 0);
	}
	
	void createNewObject(String name, SecurityLevel secLev) {
		objectManager.put(name, secLev);
		valueManager.put(name, 0);
	}
	
	public static HashMap<String, SecurityLevel> getObjectManager() {
		return objectManager;
	}
	
	public static HashMap<String, Integer> getValueManager() {
		return valueManager;
	}
	
	public static HashMap<String, Integer> getReadManager() {
		return readManager;
	}
	
	static void writeExecute(InstructionObject instr) {
		int val = instr.getValue();
		String subj = instr.getSubject();
		String obj = instr.getObject();
		
		SecurityLevel subjSec = SecureSystem.getSubjectManager().get(subj);
		int subjSecLevel = subjSec.getDomination();
		
		SecurityLevel objSec = objectManager.get(obj);
		int objSecLevel = objSec.getDomination();
		
		if (subjSecLevel <= objSecLevel) {
			valueManager.put(obj, val);
		}
	}
	
	static void readExecute(InstructionObject instr) {
		String subj = instr.getSubject();
		String obj = instr.getObject();
		
		SecurityLevel subjSec = SecureSystem.getSubjectManager().get(subj);
		int subjSecLevel = subjSec.getDomination();
		
		SecurityLevel objSec = objectManager.get(obj);
		int objSecLevel = objSec.getDomination();
		
		if (subjSecLevel >= objSecLevel) {
			readManager.put(subj, valueManager.get(obj));
		}
		else {
			readManager.put(subj, 0);
		}
	}
	
}
