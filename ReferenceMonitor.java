import java.io.*;
import java.util.*;

public class ReferenceMonitor {

	public ReferenceMonitor() {

	}

	void createNewObject(String name, SecurityLevel secLev) {
		HashMap<String, SecurityLevel> objectManager = new HashMap<String, SecurityLevel>();
		objectManager.put(name, secLev);
	}
	
}
